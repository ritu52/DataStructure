package HashMapChaining;

public class HashTableChaining {

  private final HashMapItem[] hashTable;

  public HashTableChaining() {
    hashTable = new HashMapItem[Constant.TABLE_SIZE];
  }
  private int hash(int key) {
    return key % Constant.TABLE_SIZE;
  }

  public void put(int key, int value) {
    int arrayIndex = hash(key);

    if (hashTable[arrayIndex] == null) {
      System.out.println("Insertion without collision, the key is::: " + key);
      hashTable[arrayIndex] = new HashMapItem(key, value);
    } else {
      System.out.println("Insertion with collision, the key is::: " + key);
      HashMapItem temp = hashTable[arrayIndex];
      while(temp.getNextHashItem() != null) {
        temp = temp.getNextHashItem();
        System.out.println("Next item to consider for insertion, the next value is:::" + temp.getValue());
      }
      System.out.println("Inserting the item, the key is:::" + key);
      temp.setNextHashItem(new HashMapItem(key, value));
    }
  }

  public int get(int key) {
    int arrayIndex = hash(key);
    if(hashTable[arrayIndex] == null) return -1;

    HashMapItem itemToSearch = hashTable[arrayIndex];
     while(itemToSearch != null && itemToSearch.getKey() != key) {
       itemToSearch = itemToSearch.getNextHashItem();
     }
     if(itemToSearch == null) {
       return  -1;
     } else {
       return  itemToSearch.getValue();
     }
  }
}
