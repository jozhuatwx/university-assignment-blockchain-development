package tutormanagementsystem;

public enum SubjectCategory {
  FORM1(0), FORM2(1), FORM3(2), FORM4(3), FORM5(4);

  // Enum value
  private final int value;

  // Constructor
  private SubjectCategory(int value) {
    this.value = value;
  }

  // Get enum value
  public int getValue() {
    return value;
  }
}
