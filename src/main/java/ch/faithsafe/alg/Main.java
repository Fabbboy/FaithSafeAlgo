package ch.faithsafe.alg;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    try {
      FaithSafeEncryption encryption = new FaithSafeEncryption();

      // Password to use for encryption and decryption
      String password = "securePassword";

      // Original data to encrypt
      String originalData = "Hello, World!";
      String encryptedData = encryption.encrypt(originalData, password);

      // Decrypt data
      String decryptedData = encryption.decrypt(encryptedData, password);

      System.out.println("Original data: " + originalData);
      System.out.println("Encrypted data: " + encryptedData);
      System.out.println("Decrypted data: " + decryptedData);

      // Additional test with byte data
      byte[] originalBytes = originalData.getBytes();
      byte[] encryptedBytes = encryption.encrypt(originalBytes, password);
      byte[] decryptedBytes = encryption.decrypt(encryptedBytes, password);
      String decryptedStringFromBytes = new String(decryptedBytes);

      System.out.println("Original bytes: " + Arrays.toString(originalBytes));
      System.out.println("Encrypted bytes: " + Arrays.toString(encryptedBytes));
      System.out.println("Decrypted bytes: " + Arrays.toString(decryptedBytes));
      System.out.println("Decrypted string from bytes: " + decryptedStringFromBytes);
    } catch (FaithSafeEncryption.EncryptionException | FaithSafeEncryption.DecryptionException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
