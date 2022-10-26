package com.mugen.senforage.service;

import com.mugen.senforage.dao.IAdminRepository;
import com.mugen.senforage.dao.IGESTCLIENTELERepository;
import com.mugen.senforage.dto.GESTCLIENTELE;
import com.mugen.senforage.exception.EntityNotFoundException;
import com.mugen.senforage.exception.RequestException;
import com.mugen.senforage.mapping.GESTCLIENTELEMapper;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GESTCLIENTELEService {


    private IGESTCLIENTELERepository igestclienteleRepository;
    private GESTCLIENTELEMapper gestclienteleMapper;
    MessageSource messageSource;

    public GESTCLIENTELEService(IGESTCLIENTELERepository igestclienteleRepository, GESTCLIENTELEMapper gestclienteleMapper, MessageSource messageSource) {
        this.igestclienteleRepository = igestclienteleRepository;
        this.gestclienteleMapper = gestclienteleMapper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<GESTCLIENTELE> getGestClienteles() {
        return StreamSupport.stream(igestclienteleRepository.findAll().spliterator(), false)
                .map(gestclienteleMapper::toGESTCLIENTELE)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public GESTCLIENTELE getGestClientele(int id) {
        return gestclienteleMapper.toGESTCLIENTELE(igestclienteleRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("gestClientelle.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Transactional
    public GESTCLIENTELE createGestClientele(GESTCLIENTELE gestclientele) {
        return gestclienteleMapper.toGESTCLIENTELE(igestclienteleRepository.save(gestclienteleMapper.fromGESTCLIENTELE(gestclientele)));
    }

    @Transactional
    public GESTCLIENTELE updateGestClientele(int id, GESTCLIENTELE gestclientele) {
        return igestclienteleRepository.findById(id)
                .map(entity -> {
                    gestclientele.setIdGestClient(id);
                    return gestclienteleMapper.toGESTCLIENTELE(
                            igestclienteleRepository.save(gestclienteleMapper.fromGESTCLIENTELE(gestclientele)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("gestClientelle.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteGestClientele(int id) {
        try {
            igestclienteleRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("gestClientelle.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

}
