package com.simplify.services;

import com.simplify.dto.FashionistaDTO;
import com.simplify.entity.FashionistaEntity;
import com.simplify.repository.FashionistaRepository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class FashionistaServiceImpl implements FashionistaService {

    protected final FashionistaRepository fashionistaRepository;
    protected final MapperFacade mapper;

    public FashionistaServiceImpl(FashionistaRepository fashionistaRepository, MapperFacade mapper) {
        this.fashionistaRepository = fashionistaRepository;
        this.mapper = mapper;
    }

    public boolean createFashionista(FashionistaDTO fashionistaDTO) {
        FashionistaEntity fashionistaEntity = mapper.map(fashionistaDTO, FashionistaEntity.class);
        fashionistaRepository.save(fashionistaEntity);
        return true;
    }

}
