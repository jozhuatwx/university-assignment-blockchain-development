package tutormanagementsystem;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Tutor extends SecureData<Tutor> {
  // Constant fields
  private static final long serialVersionUID = 1L;

  // Tutor fields
  private final double id;
  private double payRate, branchId;
  private String name, identityNumber, phoneNumber, email, password, bankName, accountName, bankNumber;
  private double[] subjectIds;
  private LocalDate joinDate, terminationDate;

  // Constructor
  Tutor(String encrypted) {
    this.encrypted = encrypted;
    this.id = -1;
    this.payRate = -1;
    this.branchId = -1;
  }

  public Tutor(double id, String name, String identityNumber, String phoneNumber, String email, String password, double[] subjectIds, LocalDate joinDate, String bankName, String accountName, String bankNumber, double branchId, double payRate, LocalDate terminationDate) {
    this.id = id;
    this.name = name;
    this.identityNumber = identityNumber;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.password = password;
    this.subjectIds = subjectIds;
    this.joinDate = joinDate;
    this.bankName = bankName;
    this.accountName = accountName;
    this.bankNumber = bankNumber;
    this.branchId = branchId;
    this.payRate = payRate;
    this.terminationDate = terminationDate;
  }

  // Verify password
  public boolean verify(Cryptography cryptography, String input) {
    return password.equals(cryptography.hash(input));
  }

  // Terminate tutor
  public void terminate() {
    this.terminationDate = LocalDate.now();
  }

  @Override
  // Encrypt fields
  public Tutor encrypt(Cryptography cryptography) {
    // Convert double array to String
    String subjectId = Arrays.stream(subjectIds)
      .mapToObj(String::valueOf)
      .collect(Collectors.joining("-"));

    // Instantiate new encrypted tutor
    return new Tutor(cryptography.encrypt(String.join(";", Double.toString(id), name, identityNumber, phoneNumber, email, password, subjectId, joinDate.toString(), bankName, accountName, bankNumber, Double.toString(branchId), Double.toString(payRate), (terminationDate != null ? terminationDate.toString() : ""))));
  }

  @Override
  // Decrypt fields
  public Tutor decrypt(Cryptography cryptography) {
    // Split decrypted String
    String decrypted = cryptography.decrypt(encrypted);
    if (decrypted != null) {
      String[] fields = decrypted.split(";");

      // Convert String to double array
      double[] tempSubjectIds = Arrays.stream(fields[6].split("-"))
        .mapToDouble(Double::parseDouble)
        .toArray();

      // Instantiate new tutor
      return new Tutor(Double.parseDouble(fields[0]), fields[1], fields[2], fields[3], fields[4], fields[5], tempSubjectIds, LocalDate.parse(fields[7]), fields[8], fields[9], fields[10], Double.parseDouble(fields[11]), Double.parseDouble(fields[12]), LocalDate.parse(fields[13]));
    }
    return null;
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

  public String getIdentityNumber() {
    return identityNumber;
  }
  
  public void setIdentityNumber(String identityNumber) {
    this.identityNumber = identityNumber;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password, Cryptography cryptography) {
    this.password = cryptography.hash(password);
  }

  public double[] getSubjectIds() {
    return subjectIds;
  }

  public void setSubjectIds(double[] subjectIds) {
    this.subjectIds = subjectIds;
  }

  public LocalDate getJoinDate() {
    return joinDate;
  }

  public void setJoinDate(LocalDate joinDate) {
    this.joinDate = joinDate;
  }

  public String getBankName() {
    return bankName;
  }
  
  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public String getBankNumber() {
    return bankNumber;
  }

  public void setBankNumber(String bankNumber) {
    this.bankNumber = bankNumber;
  }
  
  public double getBranchId() {
    return branchId;
  }

  public void setBranchId(double branchId) {
    this.branchId = branchId;
  }

  public double getPayRate() {
    return payRate;
  }

  public void setPayRate(double payRate) {
    this.payRate = payRate;
  }

  public LocalDate getTerminationDate() {
    return terminationDate;
  }

  public void setTerminationDate(LocalDate terminationDate) {
    this.terminationDate = terminationDate;
  }
}
