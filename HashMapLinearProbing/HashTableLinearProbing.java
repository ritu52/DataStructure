package HashMapLinearProbing;

public class HashTableLinearProbing {

  private final HashMapItem[] hashTable;

  public HashTableLinearProbing() {
    hashTable = new HashMapItem[Constant.TABLE_SIZE];
  }
  private int hash(int key) {
    //return key % Constant.TABLE_SIZE;
    return 0; // to show the linear probing, hash function returning only one index
  }

  public void put(int key, int value) {
    int arrayIndex = hash(key);
    System.out.println("Insertion at array index::: " + arrayIndex);
    while(hashTable[arrayIndex] != null) {
      arrayIndex = (arrayIndex+1) % Constant.TABLE_SIZE;
      System.out.println("Considering next available index::: " + arrayIndex);
    }
    System.out.println("Index available at::: " + arrayIndex);
    hashTable[arrayIndex] = new HashMapItem(key, value);
    }

  public int get(int key) {
    int arrayIndex = hash(key);

    while(hashTable[arrayIndex] != null && hashTable[arrayIndex].getKey() != key) {
      arrayIndex = (arrayIndex+1) % Constant.TABLE_SIZE;
    }
    if(hashTable[arrayIndex] == null) {
      return -1;
    } else {
      return hashTable[arrayIndex].getValue();
    }
  }
}
