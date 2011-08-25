package com.ftl.learning.jaxws.service;

import com.ftl.learning.jaxws.service.dto.InvertDTO;
import com.ftl.learning.jaxws.service.dto.SumProdDTO;

/**
 * TestService interface
 * 
 */
public interface TestService {
	/**
	 * Inverts string's alphabetchical characters.
	 * 
	 * @param text
	 * @return
	 */
	String invert(InvertDTO invertDTO);

	/**
	 * Returns an array containing sum and prod of paramaters.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	double[] sumProd(SumProdDTO sumProdDTO);

}
