package com.devsuperior.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	@Autowired
	private SellerRepository sellerRepository;
	public List<SellerDTO> findAll(){
		//Criando uma variável do tipo lista de seller para receber o resultado da busca no banco.
		List<Seller> result = sellerRepository.findAll();
		//O map converte uma coleção para uma nova coleção que pode ser de outro tipo. Neste caso
		//vai ser uma nova lista de sellerDTO. Então será convertido o tipo seller para sellerDTO.
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
}
