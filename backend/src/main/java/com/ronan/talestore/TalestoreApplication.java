package com.ronan.talestore;

import java.util.Arrays;

import com.ronan.talestore.domain.Categoria;
import com.ronan.talestore.domain.Conto;
import com.ronan.talestore.repository.CategoriaRepository;
import com.ronan.talestore.repository.ContoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TalestoreApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ContoRepository contoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TalestoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria("Suspense", "Contos de Suspense");

		Conto conto1 = new Conto("Perseguição", "Paulo André T.M.Gomes", "Lorem Ipsum", cat1);
		
		cat1.getContos().addAll(Arrays.asList(conto1));

		categoriaRepository.saveAll(Arrays.asList(cat1));
		contoRepository.saveAll(Arrays.asList(conto1));
	}

}
