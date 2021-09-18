package com.ronan.talestore.service;

import java.util.Arrays;

import com.ronan.talestore.domain.Categoria;
import com.ronan.talestore.domain.Conto;
import com.ronan.talestore.repository.CategoriaRepository;
import com.ronan.talestore.repository.ContoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ContoRepository contoRepository;

    public void instanciaBaseDeDados() {
        Categoria cat1 = new Categoria("Suspense", "Contos de Suspense");
        Categoria cat2 = new Categoria("Terror", "Contos de Terror");
        Categoria cat3 = new Categoria("Fábulas", "Contos de Fábulas");

        Conto conto1 = new Conto("Perseguição", "Paulo André T.M.Gomes", "Lorem Ipsum", cat1);
        Conto conto2 = new Conto("Conto de mistério", "Stanislaw Ponte Preta", "Lorem Ipsum", cat1);
        Conto conto3 = new Conto("A QUEDA DA CASA USHER", "EDGAR ALLAN POE", "Lorem Ipsum", cat1);
        Conto conto4 = new Conto("O DEPOIMENTO DE RANDOLPH CARTER", "H. P. LOVECRAFT", "Lorem Ipsum", cat2);
        Conto conto5 = new Conto("A MÃO DO MACACO", "W. W. JACOBS", "Lorem Ipsum", cat2);
        Conto conto6 = new Conto("A INDISPOSTA", "STEPHEN KING", "Lorem Ipsum", cat2);

        cat1.getContos().addAll(Arrays.asList(conto1, conto2, conto3));
        cat2.getContos().addAll(Arrays.asList(conto4, conto5, conto6));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        contoRepository.saveAll(Arrays.asList(conto1, conto2, conto3, conto4, conto5, conto6));
    }
}
