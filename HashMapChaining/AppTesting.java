package HashMapChaining;

public class AppTesting {

  /**
   * The Chaining of Hashmap to avoid collision
     * Insertion without collision, the key is::: 1
     * Insertion without collision, the key is::: 2
     * Insertion without collision, the key is::: 3
     * Insertion without collision, the key is::: 4
     * Insertion without collision, the key is::: 5
     * Insertion without collision, the key is::: 6
     * Insertion without collision, the key is::: 7
     * Insertion without collision, the key is::: 8
     * Insertion without collision, the key is::: 10
     * Insertion without collision, the key is::: 9
     * Insertion with collision, the key is::: 11
     * Inserting the item, the key is:::11
     * Get the item at index 7::: 23
   */
  public static void main(String[] args) {
    HashTableChaining hashTable = new HashTableChaining();
    hashTable.put(1,10);
    hashTable.put(2,100);
    hashTable.put(3,1000);
    hashTable.put(4,10000);
    hashTable.put(5,45);
    hashTable.put(6,565);
    hashTable.put(7,23);
    hashTable.put(8,11);
    hashTable.put(10,343);
    hashTable.put(9,56);
    hashTable.put(11, 459);

    System.out.println("Get the item at index 7::: "+hashTable.get(7));

  }
}
