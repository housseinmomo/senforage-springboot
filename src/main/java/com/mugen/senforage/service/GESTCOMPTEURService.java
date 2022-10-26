package com.mugen.senforage.service;

import com.mugen.senforage.dao.IGESTCLIENTELERepository;
import com.mugen.senforage.dao.IGESTCOMPTEURRepository;
import com.mugen.senforage.dto.GESTCOMPTEUR;
import com.mugen.senforage.exception.EntityNotFoundException;
import com.mugen.senforage.exception.RequestException;
import com.mugen.senforage.mapping.GESTCOMPTEURMapper;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GESTCOMPTEURService {


    private IGESTCOMPTEURRepository igestcompteurRepository;
    private GESTCOMPTEURMapper gestcompteurMapper;
    MessageSource messageSource;

    public GESTCOMPTEURService(IGESTCOMPTEURRepository igestcompteurRepository, GESTCOMPTEURMapper gestcompteurMapper, MessageSource messageSource) {
        this.igestcompteurRepository = igestcompteurRepository;
        this.gestcompteurMapper = gestcompteurMapper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<GESTCOMPTEUR> getGestCompteurs() {
        return StreamSupport.stream(igestcompteurRepository.findAll().spliterator(), false)
                .map(gestcompteurMapper::toGESTCOMPTEUR)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public GESTCOMPTEUR getGestCompteur(int id) {
        return gestcompteurMapper.toGESTCOMPTEUR(igestcompteurRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("gestCompteur.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Transactional
    public GESTCOMPTEUR createGestCompteur(GESTCOMPTEUR gestcompteur) {
        return gestcompteurMapper.toGESTCOMPTEUR(igestcompteurRepository.save(gestcompteurMapper.fromGESTCOMPTEUR(gestcompteur)));
    }

    @Transactional
    public GESTCOMPTEUR updateGestCompteur(int id, GESTCOMPTEUR gestcompteur) {
        return igestcompteurRepository.findById(id)
                .map(entity -> {
                    gestcompteur.setIdGestCompteur(id);
                    return gestcompteurMapper.toGESTCOMPTEUR(
                            igestcompteurRepository.save(gestcompteurMapper.fromGESTCOMPTEUR(gestcompteur)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("gestCompteur.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteGestCompteur(int id) {
        try {
            igestcompteurRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("gestCompteur.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

}
