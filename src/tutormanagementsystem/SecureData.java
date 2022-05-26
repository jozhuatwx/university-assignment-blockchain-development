package tutormanagementsystem;

import java.io.Serializable;

public abstract class SecureData<T> implements Findable, Serializable {
  private static final long serialVersionUID = 1L;
  protected String encrypted;

  public abstract T encrypt(Cryptography cryptography);
  public abstract T decrypt(Cryptography cryptography);
}
