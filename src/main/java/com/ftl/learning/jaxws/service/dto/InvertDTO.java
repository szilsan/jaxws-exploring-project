package com.ftl.learning.jaxws.service.dto;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

/**
 * Input DTO for Invert webmethod.
 */
public class InvertDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Pattern(regexp = "^.*")
	private String inputString;

	// GETTERS SETTERS
	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

}
