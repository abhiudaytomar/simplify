package com.simplify.services;

import com.simplify.dto.FashionistaDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


public interface FashionistaService {
    boolean createFashionista(FashionistaDTO fashionistaDTO);
}
