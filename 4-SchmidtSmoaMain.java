package enchandedSchmidtSamoaCryptoNumberProcess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SchmidtSmoaMain {
	
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		EnchancdedSchmidtSamoa enchancdedSchmidtSamoa =new EnchancdedSchmidtSamoa();
		EnchSchmidtSamoCipherPhase enchSSCipher = new EnchSchmidtSamoCipherPhase();
		EnchSchmidtSamoDecipherPhase enchSSDecipher = new EnchSchmidtSamoDecipherPhase();
		
		
		int tempP = 0,tempQ = 0,powerValue = 0, message = 0 ;
		Boolean flag = false ;
		
		BigInteger cipher,plainMessage, deCipher ;
		
		System.out.println("Enchancded Schmidt Samoa Starts ====================");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while (!flag)
		{
		System.out.println("Please Enter the Prime Number ");
		tempP = Integer.parseInt(br.readLine());
		
		
		System.out.println("Please Enter the Prime Number ");
		tempQ = Integer.parseInt(br.readLine());
		
		if(tempP == tempQ)
		{
			System.out.println(" Both P and Q should be distinct prime number please try again ");
		    continue;    
		}
		flag = true ;
		
		System.out.println("Please Enter the Power p value ");
		powerValue = Integer.parseInt(br.readLine());
		
		System.out.println("Please Enter the message ");
		message = Integer.parseInt(br.readLine());
		
		System.out.println("Thanks for providing the details please wait while Kegeneration phase is staring...");
		
		}
		
		enchancdedSchmidtSamoa.setParameter(tempP, tempQ, powerValue, message);
		
		enchancdedSchmidtSamoa.schmidtSamoaKeygenerationphase();
		
		System.out.println("=====================================");
		System.out.println("Entered Values of P  are "+enchancdedSchmidtSamoa.primeP);
		System.out.println("Entered Values of Q  are "+enchancdedSchmidtSamoa.primeQ);
		System.out.println("Entered Values of power value  are "+enchancdedSchmidtSamoa.powerValue);
		
		System.out.println("Public Key "+enchancdedSchmidtSamoa.publicKey);
		System.out.println("Private Key ["+enchancdedSchmidtSamoa.privateKey +","+enchancdedSchmidtSamoa.pq+"]");
		
		plainMessage = BigInteger.valueOf(message) ;
		
	    cipher = enchSSCipher.cipherPhase(plainMessage,enchancdedSchmidtSamoa.publicKey);	
	    System.out.println("cipher Key "+cipher);
	    deCipher = enchSSDecipher.decipherPhase(cipher, enchancdedSchmidtSamoa.privateKey, enchancdedSchmidtSamoa.pq);
	    System.out.println("deCipher Key "+deCipher);
	 
	    if(plainMessage.equals(deCipher))
	    {
	    	System.out.println("PlainMessage and Decipher are same ");
	    }
	    else
	    {
	    	System.out.println("CryptoSystme failed to cipher and de-cipher ");
	    }
	}

}
