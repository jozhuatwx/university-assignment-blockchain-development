package tutormanagementsystem;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Cryptography {
  // Cryptography properties
  private Signature signature;
  private KeyPair keyPair;
  private Cipher cipher;
  private String publicFileName;
  private String privateFileName;

  // Constructor
  public Cryptography(String publicFileName, String privateFileName) {
    try {
      // Set signature algorithm
      signature = Signature.getInstance(Main.SIGNATURE_ALGORITHM);
      this.publicFileName = publicFileName;
      this.privateFileName = privateFileName;

      // Set cipher algorithm
      cipher = Cipher.getInstance(Main.ENCRYPTION_ALGRORITHM);

      // Read existing keypair
      fromObject(ReaderWriter.read(publicFileName), ReaderWriter.read(privateFileName));

      // Create new keypair
      if (keyPair == null) {
        // Get keypair generator instance
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(Main.ENCRYPTION_ALGRORITHM);
        // Set keypair size
        keyPairGenerator.initialize(4096);
        // Generate keypair
        keyPair = keyPairGenerator.generateKeyPair();
        // Save keypair separately
        ReaderWriter.write(keyPair.getPublic(), Main.PUBLIC_KEY_FILE);
        ReaderWriter.write(keyPair.getPrivate(), Main.PRIVATE_KEY_FILE);
      }
    } catch (Exception e) {
      // Displays the error message
      JOptionPane.showMessageDialog(new JFrame(), "Error Loading", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  // Hash data
  public String hash(String input) {
    try {
      // Get message digest instance
      MessageDigest messageDigest = MessageDigest.getInstance(Main.HASHING_ALGORITHM);
      // Hash input
      messageDigest.update(input.getBytes());
      byte[] hashBytes = messageDigest.digest();
      // Convert byte array to String
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < hashBytes.length; i++) {
        sb.append(Integer.toHexString(0xFF & hashBytes[i]));
      }
      return sb.toString();
    } catch (Exception e) {
      // Displays the error message
      JOptionPane.showMessageDialog(new JFrame(), "Error Hashing", "Error", JOptionPane.ERROR_MESSAGE);
    }
    return null;
  }

  // Sign input data
  public String sign(String input) {
    try {
      // Get private key
      signature.initSign(keyPair.getPrivate());
      // Add input data
      signature.update(input.getBytes());
      // Sign input data and convert byte array to String
      return Base64.getEncoder().encodeToString(signature.sign());
    } catch (Exception e) {
      // Displays the error message
      JOptionPane.showMessageDialog(new JFrame(), "Error Signing", "Error", JOptionPane.ERROR_MESSAGE);
    }
    return null;
  }

  // Verify input data with hash
  public boolean verify(String hash, String input) {
    try {
      // Get public key
      signature.initVerify(keyPair.getPublic());
      // Add input data
      signature.update(input.getBytes());
      // Verify input data and convert byte array to String
      return signature.verify(Base64.getDecoder().decode(hash));
    } catch (Exception e) {
      // Displays the error message
      JOptionPane.showMessageDialog(new JFrame(), "Error Verifying", "Error", JOptionPane.ERROR_MESSAGE);
    }
    return false;
  }

  // Encrypt data
  public String encrypt(String input) {
    try {
      // Input public key
      cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
      byte[] cipherBytes = cipher.doFinal(input.getBytes());
      // Convert byte array to String
      return Base64.getEncoder().encodeToString(cipherBytes);
    } catch (Exception e) {
      // Displays the error message
      JOptionPane.showMessageDialog(new JFrame(), "Error Encrypting", "Error", JOptionPane.ERROR_MESSAGE);
    }
    return null;
  }

  // Decrypt data
  public String decrypt(String input) {
    try {
      // Input private key
      cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
      byte[] cipherBytes = cipher.doFinal(Base64.getDecoder().decode(input));
      // Convert byte array to String
      return new String (cipherBytes);
    } catch (Exception e) {
      // Displays the error message
      JOptionPane.showMessageDialog(new JFrame(), "Error Decrypting", "Error", JOptionPane.ERROR_MESSAGE);
    }
    return null;
  }

  // Cast object to class
  private void fromObject(Object publicKey, Object privateKey) {
    if (publicKey != null && privateKey != null) {
      keyPair = new KeyPair((PublicKey) ReaderWriter.read(publicFileName), (PrivateKey) ReaderWriter.read(privateFileName));
    }
  }
}
