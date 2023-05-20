package com.spectramd.portal.tax.strategy;

import com.spectramd.portal.Entity.Deductions;
import com.spectramd.portal.Entity.Earnings;
import com.spectramd.portal.model.Savings;

public interface TaxRegimeStrategy {
	Integer calculateTax(Earnings earnings,Deductions deductions, Savings savings);
}
