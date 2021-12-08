package DSTrie;

public class App {

  /**
   * The implementation of Trie data structure, considering only (a-z) as keys in below.
       * Tree traversal in sorted order::: air->apple->approve->aptitude->bee->beetle->boss->course->
       * ----Searching any key in Trie Data structure-------
       * Does 'bee' exist in this::: true
       * Does 'be' exist in this::: false
       * Does 'air' exist in this::: true
       * ----Get list of strings starting with 'b' in Trie Data structure-------
       * bee
       * beetle
       * boss
       * ----Get list of strings starting with 'ap' in Trie Data structure-------
       * apple
       * approve
       * aptitude
   *
   *
   */
  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("apple");
    trie.insert("air");
    trie.insert("bee");
    trie.insert("beetle");
    trie.insert("boss");
    trie.insert("approve");
    trie.insert("aptitude");
    trie.insert("course");
    System.out.print("Tree traversal in sorted order::: ");
    for (String s:
        trie.sort()) {
      System.out.print(s+"->");
    }
    System.out.println(" ");
    System.out.println("----Searching any key in Trie Data structure-------");
    System.out.println("Does 'bee' exist in this::: "+trie.search("bee"));
    System.out.println("Does 'be' exist in this::: "+trie.search("be"));
    System.out.println("Does 'air' exist in this::: "+trie.search("air"));
    System.out.println("----Get list of strings starting with 'b' in Trie Data structure-------");
    for (String s:
         trie.autocomplete("b")) {
      System.out.println(s);
    }
    System.out.println("----Get list of strings starting with 'ap' in Trie Data structure-------");
    for (String s:
        trie.autocomplete("ap")) {
      System.out.println(s);
    }
  }
}
