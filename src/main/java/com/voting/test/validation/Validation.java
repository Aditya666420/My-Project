package com.voting.test.validation;

public class Validation {
	
	public static boolean isValid1(String k) {
		
			if(k.length()==2) {
				if(k.charAt(0)=='3' && k.charAt(1)>='0' && k.charAt(1)<='1' ) {
					return true;
				}
				else if(k.charAt(0)>='1' && k.charAt(0)<='2' && k.charAt(1)>='0' && k.charAt(0)<='9'){
					return true;
				}
				else if(k.charAt(0)=='0' && k.charAt(1)>'0' && k.charAt(1)<='9') {
					return true;
				}
				else {
					return false;
				}
			}
			return false;
		
	}
	public static boolean isValid2(String k) {
		
		if(k.length()==2) {
				if(k.charAt(0)=='0'  && k.charAt(1)>'0' && k.charAt(1)<='9') {
					return true;
				}
				else if(k.charAt(0)=='1' && k.charAt(1)>='0' && k.charAt(1)<='2') {
					return true;
				}
				else {
					return false;
				}	
		}
		return false;
	}
	
	public static boolean isValid3(String k) {
		
		
		if(k.length()==4){
			int m = Integer.valueOf(k);
			if(m>=2000) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
		
	}

}
