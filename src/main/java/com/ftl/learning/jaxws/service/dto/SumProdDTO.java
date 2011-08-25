package com.ftl.learning.jaxws.service.dto;

import java.io.Serializable;

import javax.validation.constraints.Max;

import com.ftl.learning.jaxws.service.validator.Prime;

/**
 * Input DTO for sumprod webmethod.
 * 
 */
public class SumProdDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Max(value = 0)
	private double x;

	@Prime
	private long y;

	// GETTERS SETTERS
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public long getY() {
		return y;
	}

	public void setY(long y) {
		this.y = y;
	}
}
