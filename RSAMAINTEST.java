package mywork;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class RSAMAINTEST {

 
    public static void main(String[] args) throws NumberFormatException, IOException{
    	
    	
    // Variable for message	
    String asciiVal ="5" ;

    // Variables for passcount , fail count , total , p power of ivalue ,q power of qvalue 
    int passcount=0,failcount=0,total=0,ivalue = 0,jvalue=0;
    
    //Temp varaibles 
    int tempp =1, tempq=1;

    //Varaibles of   p,q, phi, N 
    int N,phipower , p ,q ;
    int pubKey ;   
 
    // Reading the system input values 
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    

    // Reading the input message\plain message so please enter the numerical values
    System.out.println("Please enter the Message(In numerical value) :");
    asciiVal  = br.readLine();
    
    // P value it should be prime values
    System.out.println("Please enter the p value in prime number :");
    p  = Integer.parseInt(br.readLine());

    // q value it should be prime value
    System.out.println("Please enter the q value in prime number :");
    q  = Integer.parseInt(br.readLine());
    
    if(p==q)
    {
    	System.out.println("Both values p and q are equal"+p+"=="+"q");
    	System.out.println(p+","+q+" both should be distnict value");
    	System.exit(0);
    }
    
    //Reading the power value 
    System.out.println("Please enter the i value which is the power of number:--> "+p+"^");
    ivalue = Integer.parseInt(br.readLine());
    
   //Calculating p prime power value 
    tempp = p;
    for(int i=1; i< ivalue;i++)
    {
    	tempp = p*tempp ;
    }
     
    // phi value calculation   
   // phipower = ((p*p)-1) * (q-1) ; 
    phipower = (tempp-1) * (q-1) ;
   // phipower = (p-1) * (q-1);
   // RSA calculate phi is -- > // phipower = (p-1) * (q-1) ;
   
    //Calculate N value 
   N =  p*q ;
  
    //Converting N and phi value in BigInteger 
    //N is converting to BigB_N
    BigInteger bigB_N = BigInteger.valueOf(N);
    //phi is converting to BigB_phi
    BigInteger bigB_phi = BigInteger.valueOf(phipower);
    int  bestSoul = 0 ;
    System.out.println(" p value : "+p);
    System.out.println(" q value : "+q);
    System.out.println(" N value : "+bigB_N);
    System.out.println(" phi value phi("+p+"^"+ivalue+"  -1,"+q+"-1) :"+ bigB_phi);
    
    for (pubKey = 3 ; pubKey<bigB_phi.intValue();pubKey++ )
    {
     while (true){
        BigInteger BigB_GCD = bigB_phi.gcd(new BigInteger(""+pubKey));
        if (BigB_GCD.equals(BigInteger.ONE)){
        break;
        }
        pubKey++;
        }

    BigInteger bigB_pubKey = new BigInteger(""+pubKey);
    BigInteger bigB_prvKey = bigB_pubKey.modInverse(bigB_phi);

   
   System.out.println(" public key : ["+bigB_pubKey+" , "+bigB_N+"]");
   System.out.println(" private key: ["+bigB_prvKey+" , "+bigB_N+"]");
    
    BigInteger bigB_val = new BigInteger(asciiVal);
    BigInteger bigB_cipherVal = bigB_val.modPow(bigB_pubKey, bigB_N);
    
    
    
    BigInteger bigB_plainVal = bigB_cipherVal.modPow(bigB_prvKey, bigB_N);
    int plainVal = bigB_plainVal.intValue();
    
    /*System.out.println("Actual Text   :==== "+asciiVal);
    System.out.println("Cipher Text   :**** "+bigB_cipherVal);
    System.out.println("Plain Text    :==== "+plainVal);
    */
    
    if(plainVal==  Integer.parseInt(asciiVal))
    {
         System.out.println("VALIDATION PASSED:*********The plainVal and message are same*******");    
         passcount=passcount+1;
    }
    else
    {
        System.out.println("----FAILED-----------");
        failcount=failcount+1;

    }
    if(plainVal==Integer.parseInt(asciiVal) && Integer.parseInt(asciiVal)==bigB_cipherVal.intValue())
    {
            System.out.println("It's Not the best soultion ");
            bestSoul = bestSoul +1;
    }
    total=total+1;
    }
    
    System.out.println("********************************************************************");
    System.out.println(" p value \t\t\t\t\t=:\t"+p);
    System.out.println(" q value \t\t\t\t\t=:\t"+q);
    System.out.println(" N value \t\t\t\t\t=:\t"+bigB_N);
    System.out.println(" phi value phi( ["+p+"^"+ivalue+"] -1,"+q+"-1) \t\t\t=:\t"+ bigB_phi);
   
    System.out.println("********************************************************************");
    System.out.println("The Number of times Validation Success\t\t::\t"+(passcount));
    System.out.println("The Number of times Validation Failed\t\t::\t"+(failcount));
    System.out.println("Total Number of Soultion for these values\t::\t"+(total));
   // System.out.println("The Number of times Not a best soultion  "+(bestSoul));
    System.out.println("********************************************************************");
    }
}
