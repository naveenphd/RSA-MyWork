package mywork;
import java.io.*;
import java.math.BigInteger;  
import java.util.Random;
public class PNRSAworking { 
       int bitlength = 1024;  
       // int blocksize = 1024; 
       //blocksize in byte   
       private BigInteger p1;
       private BigInteger p2; 
       //private BigInteger q;  
       private BigInteger N;  
       private BigInteger phi;  
       private BigInteger e;  
       private BigInteger d;  
       private Random r;  
        /** 
        * Init public and private keys 
        */  
       	public PNRSAworking() {  
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
           		
           		// N = P1 * P2
 	            N = p1.multiply(p2);
 	            
 	            //Phi = ( (p1 ^ i) -1 * (P2-1)  )
 	            int i=0;
 	           
 	            System.out.println("Please enter the number of power required"); 
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
 	           
 	           
		        phi = p1.pow(i).subtract(BigInteger.ONE).multiply(p2.subtract(BigInteger.ONE));
     	       
		        //phi = p1.subtract(BigInteger.ONE).multiply(p2.subtract(BigInteger.ONE));
               
		        // compute the exponent necessary for encryption (private key)  
	           e = BigInteger.probablePrime(bitlength/2, r);  
	           while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0 ) {  
               e.add(BigInteger.ONE);  
	           }  
	           // compute public key  
	           d = e.modInverse(phi);  
	           
	           System.out.println("The P Value                        = "+p1);
	           System.out.println("The q Value                        = "+p2);
	           System.out.println("The N Value P*Q                    = "+N);
	           System.out.println("The Phi value (P^"+i+"-1)*(q-1)    = "+phi);
	           System.out.println("The Public key [E,N]               = ["+e+","+N+"]");
	           System.out.println("The Private key [D,N]              = ["+d+","+N+"]");
	           
       }  
       public PNRSAworking(BigInteger e, BigInteger d, BigInteger N) {  
           this.e = e;  
           this.d = d;  
           this.N = N;  
       }  
       public static void main (String[] args) { 
	   long startTime = System.currentTimeMillis();
	   //Generating Public and Private Key
	   PNRSAworking pnObj = new PNRSAworking();  
	   System.out.println("The bitlength "+ pnObj.bitlength);
	   long endTime = System.currentTimeMillis();
	  //System.out.println(" Key Generation Time :"+ (endTime-startTime));
	 
	   //Reading the input message or string 
	   String teststring=new String();
           try{ 

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   System.out.println("Please provide the testing String\\Message... Please enter button after message finish");
	   teststring = br.readLine();  //teststring = "SVUNIVERSITY";
           System.out.println("String Provided for Encryption \t::"+teststring);  
           System.out.println("String in Bytes\t\t\t\t::"+bytesToString(teststring.getBytes()));  
	      }catch(Exception ex){}
          
           
           
           // encrypt or cipher process
           long startEncyTime = System.currentTimeMillis();  
           byte[] encrypted = pnObj.encrypt(teststring.getBytes());                    
           System.out.println("Cipher String\\Message in Bytes\t\t::"+bytesToString(encrypted));  
           long endEncyTime = System.currentTimeMillis();
           
           
           
           // decrypt  or decipher process
           long startDecyTime = System.currentTimeMillis();  
           byte[] decrypted = pnObj.decrypt(encrypted);        
           System.out.println("Decrypted String\\Message \t\t\t::"+new String(decrypted));  
           long endDecyTime = System.currentTimeMillis();  
	      
	       
	       //Summary details for user
	       System.out.println("\nSummary details of time in millsecond(ms)");
	       System.out.println("Key Generation Time\t\t::\t"+(endTime-startTime) +"\tms");
	       System.out.println("Encryption Time\t\t\t::\t"+(endEncyTime-startEncyTime)+"\tms");
	       System.out.println("Decryption Time\t\t\t::\t"+(endDecyTime-startDecyTime)+"\tms");
       }  
            /** 
        * Converts a byte array into its String representations 
        * @param encrypted 
        * @return 
        */  
       private  static String bytesToString(byte[] encrypted) {  
           String test = "";  
           for (byte b : encrypted) {  
               test += Byte.toString(b);  
           }  
           return test;  
       }   
       /** 
        * encrypt byte array 
        * @param message 
        * @return 
        */  
       public byte[] encrypt(byte[] message) {       
           return (new BigInteger(message)).modPow(e, N).toByteArray();  
       }   
       /** 
        * decrypt byte array 
        * @param message 
        * @return 
        */  
       public byte[] decrypt(byte[] message) {  
           return (new BigInteger(message)).modPow(d, N).toByteArray();  
       }        
       
       
       public static BigInteger lcd(BigInteger m, BigInteger n) {
   		
   		m = m.abs();
   		n = n.abs();
   		if (m.equals(BigInteger.ZERO) || n.equals(BigInteger.ZERO)) {
   			return BigInteger.ZERO;
   		} else {
   			BigInteger gcd = gcd(m,n);
   			return m.divide(gcd).multiply(n);
   		}
   	}
       
       public static BigInteger gcd(BigInteger m, BigInteger n) {

   		m = m.abs();
   		n = n.abs();
   		if (m.equals(BigInteger.ZERO)) {
   			return n;
   		} else if (n.equals(BigInteger.ZERO)) {
   			return m;
   		} else if (m.compareTo(n) > 0) {
   			return gcd(n, m.remainder(n));
   		} else if (m.compareTo(n) < 0) {
   			return gcd(m, n.remainder(m));
   		} else {
   			return m;
   		}
   	}
   	
       
       
  }  
