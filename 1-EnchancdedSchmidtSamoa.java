package enchandedSchmidtSamoaCryptoNumberProcess;

import java.math.BigInteger;

public class EnchancdedSchmidtSamoa {
	
	EnchancdedSchmidtSamoa(){}
	
	

	int p,q,powerValue ; 
	BigInteger primeP,primeQ;
	BigInteger pq,N,lcm ;
	BigInteger publicKey,privateKey;
	BigInteger cipher,decipher ,plainmessage;
	
	public BigInteger computeN(int i)
	{
		//System.out.println("Computing the N value"+primeP+"   "+primeQ);
		return primeP.pow(i).multiply(primeQ); 
	}
	
	public BigInteger computePQ()
	{
		//System.out.println("Computing the PQ value");
		return primeP.multiply(primeQ); 
	}
	
	public BigInteger lcmofpq(int x,int y)
	{
		 x = x-1;
		 y = y-1;
		 
		 int a;
	        a = (x > y) ? x : y; // a is greater number
	     //   System.out.println("A vlaue"+a + "x "+x +" y  "+y);
	        while(true)
	        {
	            if(a % x == 0 && a % y == 0)
	              {
	            	lcm = BigInteger.valueOf(a);
	            	return BigInteger.valueOf(a);
	              }
	            	
	            ++a;
	        }	
	}
	
	public BigInteger privateKeyMethod()
	{
		  privateKey = N.modInverse(lcmofpq(p,q));
		  return privateKey;
	}
	
	public BigInteger cipherProcess(BigInteger message)
	{
		cipher = message.modPow(N, N);
		return cipher;
	}
	
	public BigInteger DecipherProcess(BigInteger message)
	{
		decipher = cipher.modPow(privateKey, pq);
		
		return decipher;
	}
	
	public void setParameter(int p, int q, int powevalue,int message)
	{
		this.p  =p;
		this.q = q;
		this.primeP = BigInteger.valueOf(p);
		this.primeQ = BigInteger.valueOf(q);
		this.powerValue = powevalue ; //BigInteger.valueOf(powevalue);
		this.plainmessage = BigInteger.valueOf(message) ;
		//System.out.println("Ended the initization phase");
	}
	
	public void schmidtSamoaKeygenerationphase()
	{
		//System.out.println("Started key genertion phase");
		//calculating public key value
		this.N =  computeN(powerValue);
		this.pq = computePQ();
		this.publicKey = N ;
		this.privateKey = privateKeyMethod();
		//System.out.println("Ended key genertion phase");
	}
	
	
}
