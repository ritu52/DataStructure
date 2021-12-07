package LRUCache;

public class App {
  /**
   * The LRU Cache implementation using doubly linked list and hashmap
     * Doubly linked list LRU Cache Representation::: H(7) <-> G(6) <-> F(5) <-> E(4) <-> D(3) <-> C(2) <-> B(1) <-> A(0) <->
     * On getting index 2nd element::: C
     * After searching, item searched becomes head node::: C(2) <-> H(7) <-> G(6) <-> F(5) <-> E(4) <-> D(3) <-> B(1) <-> A(0) <->
     * On getting index 3rd element::: D
     * After searching, item searched becomes head node::: D(3) <-> C(2) <-> H(7) <-> G(6) <-> F(5) <-> E(4) <-> B(1) <-> A(0) <->
     * On getting index 1st element::: B
     * After searching, item searched becomes head node::: B(1) <-> D(3) <-> C(2) <-> H(7) <-> G(6) <-> F(5) <-> E(4) <-> A(0) <->
     * On adding item, when cache is full
     * Setting new tail, on cache full::: E
     * LRU Cache Representation::: I(9) <-> B(1) <-> D(3) <-> C(2) <-> H(7) <-> G(6) <-> F(5) <-> E(4) <->
   */
  public static void main(String[] args) {
    LRUCache lru = new LRUCache();

    lru.put(0, "A");
    lru.put(1, "B");
    lru.put(2, "C");
    lru.put(3, "D");
    lru.put(4, "E");
    lru.put(5, "F");
    lru.put(6, "G");
    lru.put(7, "H");
    System.out.print("Doubly linked list LRU Cache Representation::: ");
    lru.show();
    System.out.println(" ");
    System.out.println("On getting index 2nd element::: "+lru.get(2));
    System.out.print("After searching, item searched becomes head node::: ");
    lru.show();
    System.out.println();

    System.out.println("On getting index 3rd element::: "+lru.get(3));
    System.out.print("After searching, item searched becomes head node::: ");
    lru.show();
    System.out.println();

    System.out.println("On getting index 1st element::: "+lru.get(1));
    System.out.print("After searching, item searched becomes head node::: ");
    lru.show();
    System.out.println();

    System.out.println("On adding item, when cache is full");
    lru.put(9,"I");
    System.out.print("LRU Cache Representation::: ");
    lru.show();
    System.out.println();

  }
}
