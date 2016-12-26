package enchandedSchmidtSamoaCryptoStringProcess;


import java.io.*;
import java.math.BigInteger;  
import java.util.Random;
public class enchandedSchmidtSamoa { 
       int bitlength = 1024;  
       // int blocksize = 1024; 
       //blocksize in byte   
      
       private BigInteger p1;
       private BigInteger p2; 
       
       private BigInteger pq;
       
       
       //private BigInteger q;  
       private BigInteger N;  
       private BigInteger phi;  
       //private BigInteger e;  
       private BigInteger d;  
       private Random r;  
       int i=0;
        /** 
        * Init public and private keys 
        */  
       	public enchandedSchmidtSamoa() {  
	            //Random Number Generation using the JavaAPI
       		    r = new Random();  
       		    
       		    //Randomly selecting two prime number's using the JAVA API
                // get two big primes  
           		p1 = BigInteger.probablePrime(bitlength, r); 
           		p2 = BigInteger.probablePrime(bitlength, r);
           		
           		if(p1.equals(p2))
           		{
           			System.out.println("Prime P1 and P2 are same , but it should be distinict");
           			System.exit(1);
           		}
           		
           		pq = p1.multiply(p2);
 	            
 	   
 	          
 	           
 	           System.out.println("Please enter the p value power in number value more than 2 "); 
 	           BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 	           try {
				i= Integer.parseInt(br.readLine().toString());
 	           } catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
 	           } catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
 	           }
 	           
 	           //Calculating N value
 	          N = p1.pow(i).multiply(p2);
 	            
 	         
 	          
 	         BigInteger lcmpq= lcm(p1,p2);
 	         //Calculating d values 
 	         d = N.modInverse(lcmpq);
		
 	           
	           System.out.println("The P Value                        = "+p1);
	           System.out.println("The q Value                        = "+p2);
	           System.out.println("The N Value P^"+i+"*Q                    = "+N);
	           System.out.println("The Public key [N,N]               = ["+N+","+N+"]");
	           System.out.println("The Private key [D,PQ]              = ["+d+","+pq+"]");
	           
       }  
       	
       	
        public static BigInteger lcm(BigInteger... values) {
       		if (values.length == 0) { 
       			return BigInteger.ONE;
       		}
       		BigInteger lcm = values[0].subtract(BigInteger.ONE);
       		for (int i = 1; i < values.length; i++) {
       			if (values[i].signum() != 0) {
       				final BigInteger gcd = lcm.gcd(values[i].subtract(BigInteger.ONE));
       				if (gcd.equals(BigInteger.ONE)) {
       					lcm = lcm.multiply(values[i].subtract(BigInteger.ONE));
       				}
       				else {
       					if (!values[i].subtract(BigInteger.ONE).equals(gcd)) {
       						lcm = lcm.multiply(values[i].subtract(BigInteger.ONE).divide(gcd));
       					}
       				}
       			}
       		}
       		return lcm;
       	}
       	
           private  static String bytesToString(byte[] encrypted) {  
               String test = "";  
               for (byte b : encrypted) {  
                   test += Byte.toString(b);  
               }  
               return test;  
           }   
           //encrypt byte array 
            public byte[] encrypt(byte[] message) {       
               return (new BigInteger(message)).modPow(N, N).toByteArray();  
           }   
            
            // decrypt byte array 
           public byte[] decrypt(byte[] message) {  
               return (new BigInteger(message)).modPow(d, pq).toByteArray();  
           }        
               	
      
       public static void main (String[] args) { 
	   
    	   long startTime = System.currentTimeMillis();
    	   //Generating Public and Private Key
	   
    	   enchandedSchmidtSamoa enchSSpnObj = new enchandedSchmidtSamoa();  
	   
    	   System.out.println("The bitlength "+ enchSSpnObj.bitlength);
	   
    	   long endTime = System.currentTimeMillis();
	      System.out.println(" Key Generation Time :"+ (endTime-startTime));
	 
	   //Reading the input message or string 
	   String teststring=new String();
           try{ 

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   System.out.println("Please provide the Message by the End press enter");
	   teststring = br.readLine();  //teststring = "SVUNIVERSITY";
           System.out.println("String Provided for Encryption \t::"+teststring);  
           System.out.println("String in Bytes\t\t\t\t::"+bytesToString(teststring.getBytes()));  
	      }catch(Exception ex){}
          
           
           
           // encrypt or cipher process
           long startEncyTime = System.currentTimeMillis();  
           byte[] encrypted = enchSSpnObj.encrypt(teststring.getBytes());                    
           System.out.println("Cipher String\\Message in Bytes\t\t::"+bytesToString(encrypted));  
           long endEncyTime = System.currentTimeMillis();
           
           
           
           // decrypt  or decipher process
           long startDecyTime = System.currentTimeMillis();  
           byte[] decrypted = enchSSpnObj.decrypt(encrypted);        
           System.out.println("Decrypted String\\Message \t\t\t::"+new String(decrypted));  
           long endDecyTime = System.currentTimeMillis();  
	      
	       
	       //Summary details for user
	       System.out.println("\nSummary details of time in millsecond(ms)");
	       System.out.println("Key Generation Time\t\t::\t"+(endTime-startTime) +"\tms");
	       System.out.println("Encryption Time\t\t\t::\t"+(endEncyTime-startEncyTime)+"\tms");
	       System.out.println("Decryption Time\t\t\t::\t"+(endDecyTime-startDecyTime)+"\tms");
       }  
  
      
          
      
       
       
  }  
