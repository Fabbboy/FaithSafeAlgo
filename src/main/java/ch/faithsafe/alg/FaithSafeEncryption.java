package ch.faithsafe.alg;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import javax.crypto.Cipher;

public class FaithSafeEncryption {
    private KeyPair keyPair;

    // Constructor that initializes the KeyPair
    public FaithSafeEncryption(byte[] initialSeed) {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            SecureRandom seed = new SecureRandom(initialSeed);
            keyGen.initialize(2048, seed);
            this.keyPair = keyGen.generateKeyPair();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to encrypt data
    public byte[] encrypt(byte[] data) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, this.keyPair.getPublic());
            return cipher.doFinal(data);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to decrypt data
    public byte[] decrypt(byte[] data) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, this.keyPair.getPrivate());
            return cipher.doFinal(data);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to get the encoded public key
    public byte[] getPublicKey() {
        return this.keyPair.getPublic().getEncoded();
    }
}
