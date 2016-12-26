package com.phd.rules;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RulesSetMain {
	
	 public static ArrayList<Integer> generateRadmonSequence(int randomLength){

	    	ArrayList<Integer> nonSesistiyList = new ArrayList<>();
	        Random rnd = new Random(randomLength);

	        for(int i=0;i<2;i++){
	            //System.out.println(rnd.nextInt(randomLength));
	            nonSesistiyList.add(rnd.nextInt(randomLength));
	        }
			return nonSesistiyList;

	    }  
	 
	public static void main(String args[]) throws IOException
	{
		RulesSet relesSet = null;
		String inputSetValue ;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Rules Set Data Sensitivity Classification programming Starts .......... ");
		
		System.out.println("Please select the approriate rule set classification ");
		
		System.out.println("1. Health Information/Patient Medical ");
		System.out.println("2. Students Record");
		System.out.println("3. Employee Record");
		
		System.out.println("Please enter your input: ");
		
		inputSetValue = br.readLine().trim();
		
		if(inputSetValue.equalsIgnoreCase("1"))
		{
			relesSet = new RulesSet("PHIPA");
		}
		else if(inputSetValue.equalsIgnoreCase("2"))
		{
			relesSet = new RulesSet("SIPPA");
		}
		else if(inputSetValue.equalsIgnoreCase("3"))
		{
			relesSet = new RulesSet("EIPPA");
		}
		
		System.out.println("Rules Set Data Sensitivity Classification processing started ........ ");
		
		
		List<String> SesnitiyHeaderData = new ArrayList<>();
		List<String> RandomSesnitiyHeaderData = new ArrayList<>();
		List<String> NonSesnitiyHeaderData = new ArrayList<>();
		List<String> tempHeaderData = new ArrayList<>();
		List<String> HeaderData = new ArrayList<>();
		List<String> FinialSesnitiyHeaderData = new ArrayList<>();
		
		HeaderData.add("Name");
		HeaderData.add("Age");
		HeaderData.add("DOB");
		HeaderData.add("Address");
		HeaderData.add("CreditCard");
		HeaderData.add("PAN");
		HeaderData.add("CVV");
		HeaderData.add("ExDate");
		HeaderData.add("Phone");
		HeaderData.add("Email");
		HeaderData.add("ADDHAR");
		HeaderData.add("Reference");
		HeaderData.add("Comments");
		
		tempHeaderData.addAll(HeaderData);
		
		String temp="DOB";
		
		/*
		
		// Header of the List 
		System.out.print("Header in the list :- [ ");
		for(String tempHead : HeaderData)
		{
			System.out.print(tempHead+" , ");
		}
		
		System.out.print("]");
		
		System.out.println(" ");
		*/
		
		
		List<String> commons = new ArrayList<String>();

		for (String igr : HeaderData) {
		    if (relesSet.getRuleSetList().contains(igr)) {
		        commons.add(igr);
		    }
		}

		
		//System.out.println("Below are the Sensitivity elements needs to encryptied or secured  :: -");
		//System.out.println(" ");
		for (String igr : commons) {
		    //System.out.print(" "+igr+" ");
		    HeaderData.remove(igr);
		    SesnitiyHeaderData.add(igr);
		}
		
		//System.out.println();
		//Randomly selecting the non-sesitivity 
		
		ArrayList<Integer> nonSesistiyList = generateRadmonSequence(HeaderData.size());
        for (Integer integerTemp : nonSesistiyList) {
			RandomSesnitiyHeaderData.add(HeaderData.get(integerTemp.intValue()));
        	 HeaderData.remove(integerTemp.intValue());
		}
        
        FinialSesnitiyHeaderData.addAll(SesnitiyHeaderData);
        FinialSesnitiyHeaderData.addAll(RandomSesnitiyHeaderData);
        
        
        System.out.println("===================================");
        
        
        System.out.println(" Header Data                  "+tempHeaderData);
        
        System.out.println(" Policy Sensitive Data        "+SesnitiyHeaderData);
		
        System.out.println(" Random Sensitive Data        "+RandomSesnitiyHeaderData);
        
        System.out.println("==================================="); 
        
        System.out.println(" Final Sensitive Data          "+FinialSesnitiyHeaderData);
        
        System.out.println(" Non-Sensitive Data           "+HeaderData);
	}

}
