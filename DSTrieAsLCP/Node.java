package DSTrieAsLCP;

public class Node {

  private String character;
  private Node[] children;
  private boolean leaf;

  public Node(String character) {
    this.character = character;
    this.children = new Node[Constants.ALPHABET_SIZE];
  }

  public String getCharacter() {
    return character;
  }

  public void setCharacter(String character) {
    this.character = character;
  }

  public Node[] getChildren() {
    return children;
  }

  public void setChildren(Node[] children) {
    this.children = children;
  }

  public boolean isLeaf() {
    return leaf;
  }

  public void setLeaf(boolean leaf) {
    this.leaf = leaf;
  }

  @Override
  public String toString() {
    return character;
  }

  public Node getChild(int index) {
      return this.children[index];
  }

  public void setChild(Node newNode, int index) {
    this.children[index] = newNode;
  }
}
