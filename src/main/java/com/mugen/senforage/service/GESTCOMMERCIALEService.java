package com.mugen.senforage.service;

import com.mugen.senforage.dao.IGESTCOMMERCIALERepository;
import com.mugen.senforage.dto.GESTCOMMERCIALE;
import com.mugen.senforage.exception.EntityNotFoundException;
import com.mugen.senforage.exception.RequestException;
import com.mugen.senforage.mapping.GESTCOMMERCIALEMapper;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GESTCOMMERCIALEService {

    private IGESTCOMMERCIALERepository igestcommercialeRepository;
    private GESTCOMMERCIALEMapper gestcommercialeMapper;
    MessageSource messageSource;

    public GESTCOMMERCIALEService(IGESTCOMMERCIALERepository igestcommercialeRepository, GESTCOMMERCIALEMapper gestcommercialeMapper, MessageSource messageSource) {
        this.igestcommercialeRepository = igestcommercialeRepository;
        this.gestcommercialeMapper = gestcommercialeMapper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<GESTCOMMERCIALE> getGestCommerciales() {
        return StreamSupport.stream(igestcommercialeRepository.findAll().spliterator(), false)
                .map(gestcommercialeMapper::toGESTCOMMERCIALE)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public GESTCOMMERCIALE getGestCommerciale(int id) {
        return gestcommercialeMapper.toGESTCOMMERCIALE(igestcommercialeRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("gestCommerciale.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Transactional
    public GESTCOMMERCIALE createGestCommerciale(GESTCOMMERCIALE gestcommerciale) {
        return gestcommercialeMapper.toGESTCOMMERCIALE(igestcommercialeRepository.save(gestcommercialeMapper.fromGESTCOMMERCIALE(gestcommerciale)));
    }

    @Transactional
    public GESTCOMMERCIALE updateGestCommerciale(int id, GESTCOMMERCIALE gestcommerciale) {
        return igestcommercialeRepository.findById(id)
                .map(entity -> {
                    gestcommerciale.setIdGestCommerciale(id);
                    return gestcommercialeMapper.toGESTCOMMERCIALE(
                            igestcommercialeRepository.save(gestcommercialeMapper.fromGESTCOMMERCIALE(gestcommerciale)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("gestCommerciale.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteGestCommerciale(int id) {
        try {
            igestcommercialeRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("gestCommerciale.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
