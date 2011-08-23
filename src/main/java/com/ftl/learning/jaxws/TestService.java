package com.ftl.learning.jaxws;

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
	String invert(String text);

	/**
	 * Returns an array containing sum and prod of paramaters.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	double[] sumProd(double x, double y);

}
