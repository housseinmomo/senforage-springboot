package com.mugen.senforage.service;

import com.mugen.senforage.dao.IRolesRepository;
import com.mugen.senforage.dto.Roles;
import com.mugen.senforage.exception.EntityNotFoundException;
import com.mugen.senforage.exception.RequestException;
import com.mugen.senforage.mapping.RolesMapper;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RolesService {

    private IRolesRepository iRolesRepository;
    private RolesMapper rolesMapper;
    MessageSource messageSource;

    public RolesService(IRolesRepository iRolesRepository, RolesMapper rolesMapper, MessageSource messageSource) {
        this.iRolesRepository = iRolesRepository;
        this.rolesMapper = rolesMapper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<Roles> getRoles() {
        return StreamSupport.stream(iRolesRepository.findAll().spliterator(), false)
                .map(rolesMapper::toRoles)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Roles getRole(int id) {
        return rolesMapper.toRoles(iRolesRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("roles.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Transactional
    public Roles createRoles(Roles roles) {
        return rolesMapper.toRoles(iRolesRepository.save(rolesMapper.fromRoles(roles)));
    }

    @Transactional
    public Roles updateRole(int id, Roles roles) {
        return iRolesRepository.findById(id)
                .map(entity -> {
                    roles.setIdRole(id);
                    return rolesMapper.toRoles(
                            iRolesRepository.save(rolesMapper.fromRoles(roles)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("roles.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteRole(int id) {
        try {
            iRolesRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("roles.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}

