package tutormanagementsystem;

import java.time.format.DateTimeFormatter;

public class Main {
  // Algorithm
  public static final String SIGNATURE_ALGORITHM = "SHA256withRSA";
  public static final String ENCRYPTION_ALGRORITHM = "RSA";
  public static final String HASHING_ALGORITHM = "SHA-1";

  // Key
  public static final String PUBLIC_KEY_FILE = "public.pub";
  public static final String PRIVATE_KEY_FILE = "private.key";

  // Blockchain
  public static final String PAYMENT_FILE = "payment.dat";
  public static final String ATTENDANCE_FILE = "attendance.dat";
  public static final String PAYMENT_LEDGER = "payment.txt";
  public static final String ATTENDANCE_LEDGER = "attendance.txt";

  // Database
  public static final String TUTOR_FILE = "tutor.dat";
  public static final String BRANCH_FILE = "branch.dat";
  public static final String SUBJECT_FILE = "subject.dat";

  // Pattern
  public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

  // Password
  public static final String DEFAULT_PASSWORD = "12345";

  // Data
  public static Cryptography cryptography = new Cryptography(PUBLIC_KEY_FILE, PRIVATE_KEY_FILE);
  public static SecureDatabase<Tutor> tutorDatabase = new SecureDatabase<>(TUTOR_FILE, cryptography);
  public static Database<Branch> branchDatabase = new Database<>(BRANCH_FILE);
  public static Database<Subject> subjectDatabase = new Database<>(SUBJECT_FILE);
  public static Blockchain<Attendance> attendanceBlockchain = new Blockchain<>(ATTENDANCE_FILE, ATTENDANCE_LEDGER, cryptography);
  public static Blockchain<Payment> paymentBlockchain = new Blockchain<>(PAYMENT_FILE, PAYMENT_LEDGER, cryptography);
}
