package TernarySearchTrees;

public class App {
  /**
   * The implementation of Ternary Search Trees, having features of an associative arrays(Key-value pair)
       * Inserting key::: 'AIR' with value::: 10
       * I am (A) middle child of node and not last character::: A
       * I am (I) middle child of node and not last character::: I
       * I am the last character::: R
       * ------Insertion complete----------
       * Inserting key::: 'CAR' with value::: 20
       * I am (C) right child of node::: A
       * I am (C) middle child of node and not last character::: C
       * I am (A) middle child of node and not last character::: A
       * I am the last character::: R
       * ------Insertion complete----------
       * Inserting key::: 'BALL' with value::: 30
       * I am (B) right child of node::: A
       * I am (B) left child of node::: C
       * I am (B) middle child of node and not last character::: B
       * I am (A) middle child of node and not last character::: A
       * I am (L) middle child of node and not last character::: L
       * I am the last character::: L
       * ------Insertion complete----------
       * Inserting key::: 'DRAKE' with value::: 40
       * I am (D) right child of node::: A
       * I am (D) right child of node::: C
       * I am (D) middle child of node and not last character::: D
       * I am (R) middle child of node and not last character::: R
       * I am (A) middle child of node and not last character::: A
       * I am (K) middle child of node and not last character::: K
       * I am the last character::: E
       * ------Insertion complete----------
       * Inserting key::: 'ZOO' with value::: 50
       * I am (Z) right child of node::: A
       * I am (Z) right child of node::: C
       * I am (Z) right child of node::: D
       * I am (Z) middle child of node and not last character::: Z
       * I am (O) middle child of node and not last character::: O
       * I am the last character::: O
       * ------Insertion complete----------
       * Find value of key 'AIR' in my tst::: 10
       * Find value of key 'CA' in my tst::: null
       * Find value of key 'BALL' in my tst::: 30
       * ----In order Traversal over tst---------
       * AIR:10->BALL:30->CAR:20->DRAKE:40->ZOO:50->
   */
  public static void main(String[] args) {
    TernarySearchTree tst = new TernarySearchTree();
    tst.put("AIR", 10);
    tst.put("CAR", 20);
    tst.put("BALL", 30);
    tst.put("DRAKE", 40);
    tst.put("ZOO", 50);

    System.out.println("Find value of key 'AIR' in my tst::: "+tst.get("AIR"));
    System.out.println("Find value of key 'CA' in my tst::: "+tst.get("CA"));
    System.out.println("Find value of key 'BALL' in my tst::: "+tst.get("BALL"));
    System.out.println("----In order Traversal over tst---------");
    tst.traverse();
  }
}
