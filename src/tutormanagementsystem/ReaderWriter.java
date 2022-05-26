package tutormanagementsystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ReaderWriter {
  // Save the object
  public static boolean write(Object object, String fileName) {
    try (
      FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName));
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    ) {
      // Writes the object
      objectOutputStream.writeObject(object);
      return true;      
    } catch (Exception e) {
      // Displays the error message
      JOptionPane.showMessageDialog(new JFrame(), "Error Saving", "Error", JOptionPane.ERROR_MESSAGE);
    }
    return false;
  }

  // Read the object
  public static Object read(String fileName) {
    // Check if file exists
    File file = new File(fileName);
    if (file.exists()) {
      try (
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
      ) {
        // Read the object
        return objectInputStream.readObject();
      } catch (Exception e) {
        // Displays the error message
        JOptionPane.showMessageDialog(new JFrame(), "Error Reading", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
    return null;
  }
}
