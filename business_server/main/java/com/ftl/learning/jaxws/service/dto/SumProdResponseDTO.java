package com.ftl.learning.jaxws.service.dto;

/**
 * SumProd response DTO
 * 
 */
public class SumProdResponseDTO {
	double sum;
	double prod;

	public SumProdResponseDTO(double sum, double prod) {
		super();
		this.sum = sum;
		this.prod = prod;
	}

	public SumProdResponseDTO() {
		super();
	}

	// GETTERS SETTERS
	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public double getProd() {
		return prod;
	}

	public void setProd(double prod) {
		this.prod = prod;
	}

}
