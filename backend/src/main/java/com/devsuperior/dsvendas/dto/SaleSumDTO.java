package com.devsuperior.dsvendas.dto;

import java.io.Serializable;

import com.devsuperior.dsvendas.entities.Seller;

public class SaleSumDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	//DTO para fazer um método que retorna uma lista com as informações agrupadas pra preencher
	//o gráfico.
	private String sellerName;
	private Double sum;
	
	public SaleSumDTO() {
	
	}

	public SaleSumDTO(String sellerName, Double sum) {
		this.sellerName = sellerName;
		this.sum = sum;
	}
	
	public SaleSumDTO(Seller seller, Double sum) {
		this.sellerName = seller.getName();
		this.sum = sum;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}
	
	
	
	
}
