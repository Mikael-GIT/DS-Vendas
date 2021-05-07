package com.devsuperior.dsvendas.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	//Busca paginada de vendas
	@Autowired
	private SaleRepository saleRepository;
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true) 
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll(); //Resolvendo problema de fazer uma consulta pra cada vendedor, deixando na memória os 5 com uma consulta.
		//Criando uma variável do tipo lista de sale para receber o resultado da busca no banco.
		Page<Sale> result = saleRepository.findAll(pageable); //O repository tem um método findall que recebe um pageable
		//O map converte uma coleção para uma nova coleção que pode ser de outro tipo. Neste caso
		//vai ser uma nova lista de saleDTO. Então será convertido o tipo sale para saleDTO.
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true) 
	public List<SaleSumDTO> amountGroupedBySeller() {
		return saleRepository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true) 
	public List<SaleSuccessDTO> successGroupedBySeller() {
		return saleRepository.successGroupedBySeller();
	}
	
}
