package enchandedSchmidtSamoaCryptoNumberProcess;

import java.math.BigInteger;

public class EnchSchmidtSamoCipherPhase {
	
	private BigInteger message ;
	private BigInteger cipherMessage;
	private BigInteger publicKey ;
	

	public EnchSchmidtSamoCipherPhase() {
		super();
	}
	
	
	public BigInteger getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(BigInteger publicKey) {
		this.publicKey = publicKey;
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
	
	
	public BigInteger cipherPhase(BigInteger message,BigInteger publicKey)
	{
		return  message.modPow(publicKey, publicKey);
		
	}
	

}
