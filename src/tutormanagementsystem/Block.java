package tutormanagementsystem;

import java.io.Serializable;
import java.sql.Timestamp;

public class Block<T extends BlockData> implements Serializable {
  // Constant fields
  private static final long serialVersionUID = 1L;

  // Block fields
  private final long timestamp;
  private final T data;
  private final String previousHash, hash;

  // Constructor
  Block(Cryptography cryptography, T data, String previousHash) {
    // Get current timestamp
    this.timestamp = new Timestamp(System.currentTimeMillis()).getTime();
    this.data = data;
    this.previousHash = previousHash;

    // Sign block
    this.hash = cryptography.sign(getVerifyString());
  }

  // Verify block
  public boolean verify(Cryptography cryptography) {
    return cryptography.verify(hash, getVerifyString());
  }

  // Getters
  public long getTimestamp() {
    return timestamp;
  }

  public T getData() {
    return data;
  }

  public String getPreviousHash() {
    return previousHash;
  }

  public String getHash() {
    return hash;
  }

  private String getVerifyString() {
    return String.join("", Long.toString(timestamp), data.toString(), previousHash);
  }
}
