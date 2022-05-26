package tutormanagementsystem;

import java.io.Serializable;

public class Subject implements Findable, Serializable {
  // Constant fields
  private static final long serialVersionUID = 1L;

  // Subject fields
  private final double id;
  private String name, description;
  private SubjectCategory category;

  // Constructor
  public Subject(double id, String name, String description, SubjectCategory category) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.category = category;
  }

  // Getters and setters
  @Override
  public double getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public SubjectCategory getCategory() {
    return category;
  }

  public void setCategory(SubjectCategory category) {
    this.category = category;
  }
}
