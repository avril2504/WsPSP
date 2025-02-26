package gestor;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class GestorCriptografia {
	 private SecretKey aesKey;
	    private String encryptedAesMessage;
	    private PublicKey rsaPublicKey;
	    private PrivateKey rsaPrivateKey;
	    private String encryptedConfidentialMessage;
	    private String encryptedAuthenticityMessage;

	    public void GestorCifrado() throws Exception {
	        generarClaveAES();
	        generarClavesRSA();
	    }

	    // Genera una clave AES de 128 bits
	    private void generarClaveAES() throws Exception {
	        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
	        keyGenerator.init(128);
	        aesKey = keyGenerator.generateKey();
	    }

	    // Genera claves RSA (pública y privada)
	    private void generarClavesRSA() throws Exception {
	        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
	        keyPairGenerator.initialize(2048);
	        KeyPair keyPair = keyPairGenerator.generateKeyPair();
	        rsaPublicKey = keyPair.getPublic();
	        rsaPrivateKey = keyPair.getPrivate();
	    }

	    // Cifra un texto usando AES
	    public void encriptarAES(String data) throws Exception {
	        Cipher cipher = Cipher.getInstance("AES");
	        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
	        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
	        encryptedAesMessage = Base64.getEncoder().encodeToString(encryptedBytes);
	    }

	    // Descifra un texto usando AES
	    public String desencriptarAES() throws Exception {
	        if (encryptedAesMessage == null) return "No hay frase encriptada.";
	        Cipher cipher = Cipher.getInstance("AES");
	        cipher.init(Cipher.DECRYPT_MODE, aesKey);
	        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedAesMessage));
	        return new String(decryptedBytes);
	    }

	    // Obtiene la frase encriptada AES
	    public String obtenerFraseEncriptadaAES() {
	        return (encryptedAesMessage != null) ? encryptedAesMessage : "No hay frase encriptada.";
	    }

	    // Cifra un texto usando RSA
	    private String encriptarRSA(String data, Key key) throws Exception {
	        Cipher cipher = Cipher.getInstance("RSA");
	        cipher.init(Cipher.ENCRYPT_MODE, key);
	        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
	        return Base64.getEncoder().encodeToString(encryptedBytes);
	    }

	    // Descifra un texto usando RSA
	    private String desencriptarRSA(String encryptedData, Key key) throws Exception {
	        Cipher cipher = Cipher.getInstance("RSA");
	        cipher.init(Cipher.DECRYPT_MODE, key);
	        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
	        return new String(decryptedBytes);
	    }

	    // Encripta para confidencialidad usando clave pública
	    public void encriptarConfidencialidad(String data) throws Exception {
	        encryptedConfidentialMessage = encriptarRSA(data, rsaPublicKey);
	    }

	    // Encripta para autenticidad usando clave privada
	    public void encriptarAutenticidad(String data) throws Exception {
	        encryptedAuthenticityMessage = encriptarRSA(data, rsaPrivateKey);
	    }

	    // Descifra mensaje confidencial con clave privada
	    public String desencriptarConfidencialidad() throws Exception {
	        return (encryptedConfidentialMessage != null) ? desencriptarRSA(encryptedConfidentialMessage, rsaPrivateKey) : "No hay mensaje encriptado.";
	    }

	    // Descifra mensaje autenticado con clave pública
	    public String desencriptarAutenticidad() throws Exception {
	        return (encryptedAuthenticityMessage != null) ? desencriptarRSA(encryptedAuthenticityMessage, rsaPublicKey) : "No hay mensaje encriptado.";
	    }
	}