package tutormanagementsystem;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Attendance extends BlockData implements Serializable {
  // Constant fields
  private static final long serialVersionUID = 1L;

  // Attendance fields
  private final double id, totalHours;
  private final LocalDateTime dateTime;
  private final double tutorId;

  // Constructor
  public Attendance(double id, double totalHours, LocalDateTime dateTime, double tutorId) {
    this.id = id;
    this.totalHours = totalHours;
    this.dateTime = dateTime;
    this.tutorId = tutorId;
  }

  // Getters
  @Override
  public double getId() {
    return id;
  }

  @Override
  public String getName() {
    return null;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public double getTotalHours() {
    return totalHours;
  }

  public double getTutorId() {
    return tutorId;
  }

  @Override
  public String toString() {
    return String.join("", Double.toString(id), Double.toString(totalHours), dateTime.toString(), Double.toString(tutorId));
  }
}
