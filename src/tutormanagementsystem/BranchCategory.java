package tutormanagementsystem;

public enum BranchCategory {
  HEADQUARTER(0), BRANCH(1);

  // Enum value
  private final int value;

  // Constructor
  private BranchCategory(int value) {
    this.value = value;
  }

  // Get enum value
  public int getValue() {
    return value;
  }
}
