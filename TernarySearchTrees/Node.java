package TernarySearchTrees;

public class Node {

  private char character;
  private Integer value;
  private Node leftNode;
  private Node middleNode;
  private Node rightNode;
  private boolean leaf;

  public Node(char character) {
    this.character = character;
  }

  public char getCharacter() {
    return character;
  }

  public void setCharacter(char character) {
    this.character = character;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public Node getLeftNode() {
    return leftNode;
  }

  public void setLeftNode(Node leftNode) {
    this.leftNode = leftNode;
  }

  public Node getMiddleNode() {
    return middleNode;
  }

  public void setMiddleNode(Node middleNode) {
    this.middleNode = middleNode;
  }

  public Node getRightNode() {
    return rightNode;
  }

  public void setRightNode(Node rightNode) {
    this.rightNode = rightNode;
  }

  public boolean isLeaf() {
    return leaf;
  }

  public void setLeaf(boolean leaf) {
    this.leaf = leaf;
  }

  @Override
  public String toString() {
    return "" + character;
  }
}
