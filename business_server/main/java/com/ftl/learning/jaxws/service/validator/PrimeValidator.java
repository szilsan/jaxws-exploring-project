package com.ftl.learning.jaxws.service.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ftl.learning.jaxws.manager.PrimeUtil;

/**
 * Check whether the number is prime
 */
public class PrimeValidator implements ConstraintValidator<Prime, Long> {

	@Override
	public void initialize(Prime constraintAnnotation) {
		// nothing to do
	}

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		if (value == null) {
			return false;
		}
		return PrimeUtil.isPrime(value);
	}
}
