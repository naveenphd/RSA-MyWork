package enchandedSchmidtSamoaCryptoNumberProcess;

import java.math.BigInteger;

public class EnchSchmidtSamoDecipherPhase {
	
	
	private BigInteger message ;
	private BigInteger cipherMessage;
	private BigInteger privateKey ;
	private BigInteger privatePQ;
	
	public EnchSchmidtSamoDecipherPhase() {
		super();
	}

	public BigInteger getMessage() {
		return message;
	}

	public void setMessage(BigInteger message) {
		this.message = message;
	}

	public BigInteger getCipherMessage() {
		return cipherMessage;
	}

	public void setCipherMessage(BigInteger cipherMessage) {
		this.cipherMessage = cipherMessage;
	}

	public BigInteger getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(BigInteger privateKey) {
		this.privateKey = privateKey;
	}

	public BigInteger getPrivatePQ() {
		return privatePQ;
	}

	public void setPrivatePQ(BigInteger privatePQ) {
		this.privatePQ = privatePQ;
	}
	
	public BigInteger decipherPhase(BigInteger cipher,BigInteger privateKey,BigInteger pq)
	{
		return cipher.modPow(privateKey, pq);
	}

}
