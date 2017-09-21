package com.simplify.configuration;

import com.simplify.dto.FashionistaDTO;
import com.simplify.entity.FashionistaEntity;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.converter.builtin.PassThroughConverter;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Currency;

@Configuration
public class BeanMapperConfig {

    @Bean
    public MapperFactory mapperFactory() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        registerPassThroughConverters(mapperFactory.getConverterFactory());
        registerMappings(mapperFactory);

        return mapperFactory;
    }

    @Bean
    public MapperFacade mapperFacade() {
        return mapperFactory().getMapperFacade();
    }

    private void registerPassThroughConverters(final ConverterFactory converterFactory) {
        converterFactory.registerConverter(new PassThroughConverter(Instant.class));
        converterFactory.registerConverter(new PassThroughConverter(LocalDate.class));
        converterFactory.registerConverter(new PassThroughConverter(Currency.class));
    }

    private void registerMappings(final MapperFactory mapperFactory) {
        mapperFactory.classMap(FashionistaEntity.class, FashionistaDTO.class).byDefault().register();
        registerMappingFashionistaDto(mapperFactory);
    }

    //TODO Need to fix the Enums
    private void registerMappingFashionistaDto(MapperFactory mapperFactory) {
//        mapperFactory.classMap(FashionistaDTO.class, FashionistaEntity.class)
//                     .field("accountCountry", "accountCountry.countryCode")
//                     .field("accountHolderCountry", "accountHolderCountry.countryCode")
//                     .byDefault().register();
    }

}
