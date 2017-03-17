package com.wenxing.commons.helper;

import java.math.BigDecimal;
public class NumericHelper {

	private NumericHelper(){
	}
	
	public static double formatGPS(double gpsValue){
		BigDecimal b1 = BigDecimal.valueOf(gpsValue).movePointLeft(2);
		int gpsInt = b1.intValue();
		double dd = b1.doubleValue() - b1.intValue();
		BigDecimal temp = BigDecimal.valueOf(dd).movePointRight(2);
		dd = temp.divide(new BigDecimal(60),6).doubleValue();
		String ddStr = Double.valueOf(dd).toString();
		int length = ddStr.length();
		if(length > 8){
			length = 8;
		}
		gpsValue = gpsInt + Double.valueOf(ddStr.substring(0, length));
		return gpsValue;
	}
      
    public static void main(String[] args) {  
        System.out.println(formatGPS(12002.7031));  
        System.out.println(formatGPS(3015.0006));  
        
          
    }  
}
