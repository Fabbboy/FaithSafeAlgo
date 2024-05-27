package ch.faithsafe.alg;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import javax.crypto.Cipher;

public class FaithSafeEncryption {
    private KeyPair keyPair;

    // Hardcoded seed
    private static final byte[] HARDCODED_SEED = new byte[] {
        (byte)0x01, (byte)0x23, (byte)0x45, (byte)0x67,
        (byte)0x89, (byte)0xab, (byte)0xcd, (byte)0xef,
        (byte)0x12, (byte)0x34, (byte)0x56, (byte)0x78,
        (byte)0x9a, (byte)0xbc, (byte)0xde, (byte)0xf0,
        (byte)0x21, (byte)0x43, (byte)0x65, (byte)0x87,
        (byte)0xa9, (byte)0xcb, (byte)0xed, (byte)0x0f,
        (byte)0x31, (byte)0x53, (byte)0x75, (byte)0x97,
        (byte)0xb9, (byte)0xdb, (byte)0xfd, (byte)0x10
    };

    // Constructor that initializes the KeyPair with the hardcoded seed
    public FaithSafeEncryption() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            SecureRandom seed = new SecureRandom(HARDCODED_SEED);
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
