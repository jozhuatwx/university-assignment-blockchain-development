package tutormanagementsystem;

import java.util.ArrayList;

public class Database<T extends Findable> {
  // Database fields
  protected final String fileName;
  protected ArrayList<T> database;
  protected Cryptography cryptography;
  protected boolean readSuccessful;

  // Constructor
  public Database(String fileName) {
    this.fileName = fileName;

    // Read existing database
    fromObject(ReaderWriter.read(fileName));

    // Create new database
    if (database == null) {
      database = new ArrayList<>();
    }
  }

  protected Database(String fileName, Cryptography cryptography) {
    this.fileName = fileName;
    this.cryptography = cryptography;

    // Read existing database
    readSuccessful = fromObject(ReaderWriter.read(fileName));

    // Create new database
    if (database == null) {
      database = new ArrayList<>();
    }
  }

  // Generate id
  public double generateId() {
    if (!database.isEmpty()) {
      return getLast().getId() + 1;
    }
    return 1;
  }

  // Save database
  public void save() {
    ReaderWriter.write(database, fileName);
  }

  // Add data
  public void add(T data) {
    // Add data to database
    database.add(data);

    // Save database
    save();
  }

  // Get index based on data
  public int getIndex(T data) {
    return database.indexOf(data);
  }

  // Get data based on index
  public T getData(int index) {
    return database.get(index);
  }

  // Find data based on id
  public T findData(double id) {
    for (int i = 0; i < getSize(); i++) {
      if (database.get(i).getId() == id) {
        return database.get(i);
      }
    }
    return null;
  }

  // Find data based on name
  public T findData(String name) {
    for (int i = 0; i < getSize(); i++) {
      if (database.get(i).getName().equalsIgnoreCase(name)) {
        return database.get(i);
      }
    }
    return null;
  }

  // Get first data
  public T getFirst() {
    return database.get(0);
  }

  // Get last data
  public T getLast() {
    return database.get(database.size() - 1);
  }

  // Get database size
  public int getSize() {
    return database.size();
  }

  // Get database read status
  public boolean getReadSuccessful() {
    return readSuccessful;
  }

  // Check if empty
  public boolean isEmpty() {
    return database.isEmpty();
  }

  // Update data
  public void updateData(int index, T data) {
    database.set(index, data);

    // Save database
    save();
  }

  // Remove data based on index
  public void removeData(int index) {
    database.remove(index);

    // Save database
    save();
  }

  // Remove data based on id
  public void removeData(double id) {
    for (int i = 0; i < getSize(); i++) {
      if (database.get(i).getId() == id) {
        database.remove(i);
      }
    }

    // Save database
    save();
  }

  // Cast object to class
  protected boolean fromObject(Object object) {
    if (object != null) {
      database = (ArrayList<T>) object;
    }
    return true;
  }
}
