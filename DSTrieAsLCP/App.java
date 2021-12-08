package DSTrieAsLCP;

public class App {

  /**
   * The implementation of the Longest Common Prefix for IP Routing, considering all characters(126) in ASCII table as keys in below.
       *Tree traversal in sorted order:::
       * 243.145.111.173->243.189.123.763->243.189.345.123->243.189.345.127->243.189.562.173->
       * ----The longest Common Prefix among all the IP address-------
       * 243.1
   */
  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("243.189.345.123");
    trie.insert("243.189.562.173");
    trie.insert("243.145.111.173");
    trie.insert("243.189.123.763");
    trie.insert("243.189.345.127");
    System.out.println("Tree traversal in sorted order::: ");
    for (String s:
        trie.autocomplete("")) {
      System.out.print(s+"->");
    }
    System.out.println(" ");
    System.out.println("----The longest Common Prefix among all the IP address-------");
    System.out.println(trie.longestCommonPrefix());
  }
}
