package util;

import java.util.Map;

import android.content.Context;

import barchallenges.ima.ulaval.ca.barchallenge.R;

public class Util {
	public static String getFormatedLoveCalcURL(Context inContext,String inMethod,Map<String, String> inParams){
		String API_BASE = inContext.getResources().getString(R.string.LOVECALCULATOR_BASE);
		String API_format = inContext.getResources().getString(R.string.LOVECALCULATOR_FORMAT);
		if(inParams==null){
			return API_BASE+API_format+inMethod;
		}else{
			return API_BASE+API_format+inMethod+inParams;
		}
	}
	public static String getFormatedLoveCalcURL(Context inContext,String inMethod){
		return Util.getFormatedLoveCalcURL(inContext, inMethod,null);
	}
	public static String getFormatedEmailURL(Context inContext,String inMethod,Map<String, String> inParams){
		String EMAIL_BASE = inContext.getResources().getString(R.string.EMAIL_BASE);
		String EMAIL_format = inContext.getResources().getString(R.string.EMAIL_FORMAT);
		if(inParams==null){
			return EMAIL_BASE+EMAIL_format+inMethod;
		}else{
			return EMAIL_BASE+EMAIL_format+inMethod+inParams;
		}
	}
	public static String getFormatedEmailURL(Context inContext){
		return Util.getFormatedLoveCalcURL(inContext, null);
	}
}
