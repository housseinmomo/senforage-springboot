package com.mugen.senforage.service;

import com.mugen.senforage.dao.IGESTCLIENTELERepository;
import com.mugen.senforage.dao.IVillageRepository;
import com.mugen.senforage.dto.Village;
import com.mugen.senforage.exception.EntityNotFoundException;
import com.mugen.senforage.exception.RequestException;
import com.mugen.senforage.mapping.GESTCLIENTELEMapper;
import com.mugen.senforage.mapping.VillageMapper;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class VillageService {

    private IVillageRepository iVillageRepository;
    private VillageMapper villageMapper;
    MessageSource messageSource;

    public VillageService(IVillageRepository iVillageRepository, VillageMapper villageMapper, MessageSource messageSource) {
        this.iVillageRepository = iVillageRepository;
        this.villageMapper = villageMapper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<Village> getVillages() {
        return StreamSupport.stream(iVillageRepository.findAll().spliterator(), false)
                .map(villageMapper::toVillage)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Village getVillage(int id) {
        return villageMapper.toVillage(iVillageRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("village.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Transactional
    public Village createVillage(Village village) {
        return villageMapper.toVillage(iVillageRepository.save(villageMapper.fromVIllage(village)));
    }

    @Transactional
    public Village updateVillage(int id, Village village) {
        return iVillageRepository.findById(id)
                .map(entity -> {
                    village.setIdVillage(id);
                    return villageMapper.toVillage(
                            iVillageRepository.save(villageMapper.fromVIllage(village)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("village.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteVillage(int id) {
        try {
            iVillageRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("village.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
