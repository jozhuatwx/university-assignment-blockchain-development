package tutormanagementsystem;

import java.io.Serializable;
import java.util.LinkedList;

import com.google.gson.GsonBuilder;

public class Blockchain<T extends BlockData> implements Serializable {
  // Constant fields
  private static final long serialVersionUID = 1L;

  // Blockchain fields
  private final Cryptography cryptography;
  private final String fileName;
  private final String ledgerName;
  private LinkedList<Block<T>> blockchain;

  public Blockchain(String fileName, String ledgerName, Cryptography cryptography) {
    this.fileName = fileName;
    this.ledgerName = ledgerName;
    this.cryptography = cryptography;

    // Read existing chain
    fromObject(ReaderWriter.read(fileName));

    // Create new chain
    if (blockchain == null) {
      blockchain = new LinkedList<>();
    }
  }

  // Generate id
  public double generateId() {
    if (!blockchain.isEmpty()) {
      return getLast().getData().getId() + 1;
    }
    return 1;
  }

  // Add block
  public void add(T blockData) {
    // Empty previous hash for genesis block
    String previousHash = "";

    if (!blockchain.isEmpty()) {
      // Get previous block's hash
      previousHash = blockchain.getLast().getHash();
    }

    // Add new block to blockchain
    Block<T> block = new Block<>(cryptography, blockData, previousHash);
    blockchain.add(block);

    // Save blockchain
    ReaderWriter.write(blockchain, fileName);
    distribute();
  }

  // Get index based on data
  public int getIndex(Block<T> block) {
    return blockchain.indexOf(block);
  }

  // Get block based on index
  public Block<T> getBlock(int index) {
    return blockchain.get(index);
  }

  // Find data based on id
  public Block<T> findData(double id) {
    for (int i = 0; i < getSize(); i++) {
      if (blockchain.get(i).getData().getId() == id) {
        return blockchain.get(i);
      }
    }
    return null;
  }

  // Find data based on name
  public Block<T> findData(String name) {
    for (int i = 0; i < getSize(); i++) {
      if (blockchain.get(i).getData().getName().equalsIgnoreCase(name)) {
        return blockchain.get(i);
      }
    }
    return null;
  }

  // Get first block
  public Block<T> getFirst() {
    return blockchain.getFirst();
  }

  // Get last block
  public Block<T> getLast() {
    return blockchain.getLast();
  }

  // Get database size
  public int getSize() {
    return blockchain.size();
  }

  // Verify entire blockchain
  public boolean verify() {
    // Skip if blockchain has no block
    if (blockchain.isEmpty()) {
      return true;
    }

    // Verify from last block to genesis block
    for (int i = blockchain.size() - 1; i >= 0; i--) {
      Block<T> block = blockchain.get(i);

      // Verify block
      if (!block.verify(cryptography)) {
        return false;
      }

      // Stop when genesis block
      if (block.getPreviousHash().equals("")) {
        return true;
      }

      // Verify previous hash
      if (!block.getPreviousHash().equals(blockchain.get(i - 1).getHash())) {
        return false;
      }
    }
    return false;
  }

  // Distribute ledger
  public void distribute() {
    String chain = new GsonBuilder()
      .setPrettyPrinting()
      .create()
      .toJson(blockchain);

    ReaderWriter.write(chain, ledgerName);
  }

  // Cast object to class
  private void fromObject(Object object) {
    if (object != null) {
      blockchain = (LinkedList<Block<T>>) object;
    }
  }
}
