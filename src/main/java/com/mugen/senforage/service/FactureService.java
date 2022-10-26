package com.mugen.senforage.service;

import com.mugen.senforage.dao.IFactureRepository;
import com.mugen.senforage.dto.Facture;
import com.mugen.senforage.exception.EntityNotFoundException;
import com.mugen.senforage.exception.RequestException;
import com.mugen.senforage.mapping.FactureMapper;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FactureService {

    private IFactureRepository iFactureRepository;
    private FactureMapper factureMapper;
    MessageSource messageSource;


    public FactureService(IFactureRepository iFactureRepository, FactureMapper factureMapper, MessageSource messageSource) {
        this.iFactureRepository = iFactureRepository;
        this.factureMapper = factureMapper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<Facture> getFactures() {
        return StreamSupport.stream(iFactureRepository.findAll().spliterator(), false)
                .map(factureMapper::toFacture)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Facture getFacture(int id) {
        return factureMapper.toFacture(iFactureRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("facture.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Transactional
    public Facture createFacture(Facture facture) {
        return factureMapper.toFacture(iFactureRepository.save(factureMapper.fromFacture(facture)));
    }

    @Transactional
    public Facture updateFacture(int id, Facture facture) {
        return iFactureRepository.findById(id)
                .map(entity -> {
                    facture.setIdFacture(id);
                    return factureMapper.toFacture(
                            iFactureRepository.save(factureMapper.fromFacture(facture)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("facture.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteFacture(int id) {
        try {
            iFactureRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("facture.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
