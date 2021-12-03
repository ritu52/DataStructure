package HashMapLinearProbing;

public class AppTesting {

  /**
   * The Linear Probing of HashMap.
     * Insertion at array index::: 0
     * Index available at::: 0
     * Insertion at array index::: 0
     * Considering next available index::: 1
     * Index available at::: 1
     * Insertion at array index::: 0
     * Considering next available index::: 1
     * Considering next available index::: 2
     * Index available at::: 2
     * Get the item at index 1::: 10
   */
  public static void main(String[] args) {
    HashTableLinearProbing hashTableLinearProbing = new HashTableLinearProbing();
    hashTableLinearProbing.put(1,10);
    hashTableLinearProbing.put(2,100);
    hashTableLinearProbing.put(3,100);
    System.out.println("Get the item at index 1::: "+ hashTableLinearProbing.get(1));

  }
}
