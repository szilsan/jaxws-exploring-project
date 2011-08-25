package com.ftl.learning.jaxws.manager;

import org.apache.commons.lang.ArrayUtils;

/**
 * Make a decision whether a number is prime or not.
 */
public class PrimeUtil {

	private static final int growWeight = 100;
	private static int sizeOf = growWeight;
	private static long[] foundPrimes = new long[sizeOf];
	private static int lastPos = 0;
	private static long checkedLimit = 2;

	/**
	 * Check
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isPrime(long number) {
		return isPrimeRoot(number);
	}

	/**
	 * Check til root
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isPrimeRoot(long number) {

		if (number < 4) {
			return true;
		}

		double rootD = Math.sqrt(number);
		long root = (long) rootD;

		if (Math.floor(rootD) != rootD && root >= 2) {
			root++;
		}

		for (long l = 2; l < root; l++) {
			if (number % l == 0) {
				return false;
			}
		}

		return true;

	}

	/**
	 * Check recursively
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isPrimeRecursive(long number) {

		if (ArrayUtils.contains(foundPrimes, number)) {
			return true;
		}

		for (int pos = 0; pos < lastPos; pos++) {
			long l = foundPrimes[pos];
			if (l != 0 && number % l == 0) {
				return false;
			}
		}

		double rootD = Math.sqrt(number);
		long root = (long) rootD;

		if (Math.floor(rootD) != rootD && root >= 2) {
			root++;
		}

		for (long l = checkedLimit; l <= root; l++) {
			if (isPrimeRecursive(l) && number % l == 0) {
				if (root > checkedLimit) {
					checkedLimit = root;
				}
				return false;
			}
		}

		foundPrimes[lastPos++] = number;
		if (sizeOf == lastPos) {
			sizeOf += growWeight;
			long[] temp = foundPrimes;
			foundPrimes = new long[sizeOf];
			System.arraycopy(temp, 0, foundPrimes, 0, temp.length);
		}

		if (root > checkedLimit) {
			checkedLimit = root;
		}

		return true;
	}
}
