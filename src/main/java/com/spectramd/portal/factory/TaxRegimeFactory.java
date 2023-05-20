package com.spectramd.portal.factory;

import com.spectramd.portal.tax.strategy.NewTaxRegime;
import com.spectramd.portal.tax.strategy.OldTaxRegime;
import com.spectramd.portal.tax.strategy.TaxRegimeStrategy;

public class TaxRegimeFactory {
	
	public static TaxRegimeStrategy createTaxRegime(String taxRegimeCode) {
		 if (taxRegimeCode == null || taxRegimeCode.isEmpty())
	            return null;
	        switch (taxRegimeCode) {
	        case "old":
	        	return new OldTaxRegime();
	        case "new":
	        	return new NewTaxRegime();
	        default:
	            throw new IllegalArgumentException("Unknown taxRegimeCode "+taxRegimeCode);
	        }
	}
}
