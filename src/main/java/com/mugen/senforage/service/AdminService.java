package com.mugen.senforage.service;

import com.mugen.senforage.dao.IAdminRepository;
import com.mugen.senforage.dto.Admin;
import com.mugen.senforage.exception.EntityNotFoundException;
import com.mugen.senforage.exception.RequestException;
import com.mugen.senforage.mapping.AdminMappper;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AdminService {

    private IAdminRepository iAdminRepository;
    private AdminMappper adminMappper;
    MessageSource messageSource;

    public AdminService(IAdminRepository iAdminRepository, AdminMappper adminMappper, MessageSource messageSource) {
        this.iAdminRepository = iAdminRepository;
        this.adminMappper = adminMappper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<Admin> getAdmins() {
        return StreamSupport.stream(iAdminRepository.findAll().spliterator(), false)
                .map(adminMappper::toAdmin)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Admin getAdmin(int id) {
        return adminMappper.toAdmin(iAdminRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("admin.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Transactional
    public Admin createAdmin(Admin admin) {
        return adminMappper.toAdmin(iAdminRepository.save(adminMappper.fromAdmin(admin)));
    }

    @Transactional
    public Admin updateAdmin(int id, Admin admin) {
        return iAdminRepository.findById(id)
                .map(entity -> {
                    admin.setIdAdmin(id);
                    return adminMappper.toAdmin(
                            iAdminRepository.save(adminMappper.fromAdmin(admin)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("admin.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteAdmin(int id) {
        try {
            iAdminRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("admin.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
