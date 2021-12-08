package DSTrie;

import java.util.ArrayList;
import java.util.List;

public class Trie {

  private Node root;

  public Trie() {
    root = new Node("");
  }

  public List<String> sort() {
    return autocomplete("");
  }
  public void insert(String s) {

    Node tempNode = root;
    for (int i=0; i<s.length();++i) {
      char c = s.charAt(i);
      int index = c - 'a';

      if(tempNode.getChild(index) == null) {
        Node newNode = new Node(String.valueOf(c));
        tempNode.setChild(newNode, index);
        tempNode = newNode;
      } else {
        tempNode = tempNode.getChild(index);
      }
    }
    tempNode.setLeaf(true);
  }

  public boolean search(String key) {
    Node tempNode = root;
    for (int i=0; i<key.length();++i) {
      char c = key.charAt(i);
      int index = c - 'a';

      if(tempNode.getChild(index) == null) {
        return false;
      } else {
        tempNode = tempNode.getChild(index);
      }
    }
    if(!tempNode.isLeaf()) return false;

    return true;
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
