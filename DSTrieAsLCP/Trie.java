package DSTrieAsLCP;

import java.util.ArrayList;
import java.util.List;

public class Trie {

  private Node root;
  private int lcpIndex;

  public Trie() {
    root = new Node("");
  }

  public void insert(String s) {

    Node tempNode = root;
    for (int i=0; i<s.length();++i) {
      char c = s.charAt(i);

      if(tempNode.getChild(c) == null) {
        Node newNode = new Node(String.valueOf(c));
        tempNode.setChild(newNode, c);
        tempNode = newNode;
      } else {
        tempNode = tempNode.getChild(c);
      }
    }
    tempNode.setLeaf(true);
  }

  public String longestCommonPrefix() {

    Node node = root;
    StringBuilder lcp = new StringBuilder();

    while(numberOfChildren(node) == 1 && !node.isLeaf()) {
      node = node.getChild(lcpIndex);
      lcp.append((char) (lcpIndex));
    }
    return lcp.toString();
  }

  private int numberOfChildren(Node node) {

    int noOfChildren = 0;
    for(int i=0; i<node.getChildren().length;++i) {
      if(node.getChild(i)!=null) {
        ++noOfChildren;
        lcpIndex = i;
      }
    }
    return noOfChildren;
  }

  public List<String> autocomplete(String prefix) {

    Node tempNode = root;
    List<String> result = new ArrayList<>();

    for(int i=0; i<prefix.length();++i) {
      char c = prefix.charAt(i);
      int index = c - 'a';
      if(tempNode.getChild(index) == null)
        return  result;

      tempNode = tempNode.getChild(index);
    }
    collect(tempNode, prefix, result);

    return result;
  }

  private void collect(Node node, String prefix, List<String> result) {

    if(node == null) return;

    if(node.isLeaf())
      result.add(prefix);

    for(Node child: node.getChildren()) {
      if(child==null) continue;

      String character = child.getCharacter();
      collect(child, prefix+character, result);
    }
  }
}
