package tutormanagementsystem;

import java.io.Serializable;

public class Branch implements Findable, Serializable {
  // Constant fields
  private static final long serialVersionUID = 1L;

  // Branch fields
  private final double id;
  private String name, address, phoneNumber, password;
  private BranchCategory category;

  // Constructor
  public Branch(double id, String name, String address, String phoneNumber, String password, BranchCategory category) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.password = password;
    this.category = category;
  }

  // Verify password
  public boolean verify(Cryptography cryptography, String input) {
    return password.equals(cryptography.hash(input));
  }

  // Getters and setters
  @Override
  public double getId() {
    return id;
  }

  @Override
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setPassword(String password, Cryptography cryptography) {
    this.password = cryptography.hash(password);
  }

  public BranchCategory getCategory() {
    return category;
  }

  public void setCategory(BranchCategory category) {
    this.category = category;
  }
}
