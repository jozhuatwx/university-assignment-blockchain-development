package tutormanagementsystem;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Payment extends BlockData implements Serializable {
  // Constant fields
  private static final long serialVersionUID = 1L;

  // Payment fields
  private final double id, attendedHours, amount, tutorId;
  private final String title;
  private final LocalDateTime paymentDateTime;

  // Constructor
  public Payment(double id, double attendedHours, double amount, String title, LocalDateTime paymentDateTime, double tutorId) {
    this.id = id;
    this.attendedHours = attendedHours;
    this.amount = amount;
    this.title = title;
    this.paymentDateTime = paymentDateTime;
    this.tutorId = tutorId;
  }

  // Getters
  @Override
  public double getId() {
    return id;
  }

  @Override
  public String getName() {
    return title;
  }

  public double getAttendedHours() {
    return attendedHours;
  }

  public double getAmount() {
    return amount;
  }

  public String getTitle() {
    return title;
  }

  public LocalDateTime getPaymentDateTime() {
    return paymentDateTime;
  }

  public double getTutorId() {
    return tutorId;
  }

  @Override
  public String toString() {
    return String.join("", Double.toString(id), Double.toString(attendedHours), Double.toString(amount), title, paymentDateTime.toString(), Double.toString(tutorId));
  }
}
