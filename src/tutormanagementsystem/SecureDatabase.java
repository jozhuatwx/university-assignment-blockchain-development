package tutormanagementsystem;

import java.util.ArrayList;

public class SecureDatabase<T extends SecureData<T>> extends Database<T> {
  // SecureDatabase fields
  private ArrayList<T> secureDatabase;

  // Constructor
  public SecureDatabase(String fileName, Cryptography cryptography) {
    super(fileName, cryptography);

    // Create new database
    if (secureDatabase == null) {
      secureDatabase = new ArrayList<>();
    }
  }

  @Override
  public void save() {
    ReaderWriter.write(secureDatabase, fileName);
  }

  @Override
  public void add(T data) {
    // Add data to database
    database.add(data);
    // Encrypt data
    secureDatabase.add(data.encrypt(cryptography));

    // Save secure database
    save();
  }

  @Override
  public void updateData(int index, T data) {
    database.set(index, data);
    // Encrypt data
    secureDatabase.set(index, data.encrypt(cryptography));

    // Save secure database
    save();
  }

  @Override
  public void removeData(int index) {
    database.remove(index);
    secureDatabase.remove(index);

    // Save secure database
    save();
  }

  @Override
  protected boolean fromObject(Object object) {
    if (object != null) {
      secureDatabase = (ArrayList<T>) object;
      database = new ArrayList<>();

      for (int i = 0; i < secureDatabase.size(); i++) {
        T data = secureDatabase.get(i).decrypt(cryptography);
        if (data != null) {
          database.add(data);
        } else {
          return false;
        }
      }
    }
    return true;
  }
}
