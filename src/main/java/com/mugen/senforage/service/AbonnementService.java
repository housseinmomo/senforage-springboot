package com.mugen.senforage.service;

import com.mugen.senforage.dao.IAbonnementRepository;
import com.mugen.senforage.exception.EntityNotFoundException;
import com.mugen.senforage.exception.RequestException;
import com.mugen.senforage.mapping.AbonnementMapper;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.mugen.senforage.dto.Abonnement;

@Service
public class AbonnementService {

    private IAbonnementRepository iAbonnementRepository;
    private AbonnementMapper abonnementMapper;
    MessageSource messageSource;

    public AbonnementService(IAbonnementRepository iAbonnementRepository, AbonnementMapper abonnementMapper, MessageSource messageSource) {
        this.iAbonnementRepository = iAbonnementRepository;
        this.abonnementMapper = abonnementMapper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<Abonnement> getAbonnments() {
        return StreamSupport.stream(iAbonnementRepository.findAll().spliterator(), false)
                .map(abonnementMapper::toAbonnement)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Abonnement getAbonnment(int id) {
        return abonnementMapper.toAbonnement(iAbonnementRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("abonnement.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Transactional
    public Abonnement createAbonnement(Abonnement abonnement) {
        return abonnementMapper.toAbonnement(iAbonnementRepository.save(abonnementMapper.fromAbonnement(abonnement)));
    }

    @Transactional
    public Abonnement updateAbonnement(int id, Abonnement abonnement) {
        return iAbonnementRepository.findById(id)
                .map(entity -> {
                    abonnement.setIdAbonnement(id);
                    return abonnementMapper.toAbonnement(
                            iAbonnementRepository.save(abonnementMapper.fromAbonnement(abonnement)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("abonnement.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteAbonnement(int id) {
        try {
            iAbonnementRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("abonnement.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }


}
