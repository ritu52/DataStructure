package LRUCache;

public class Node {

  private int id;
  private String data;
  private Node prevNode;
  private Node nextNode;

  public Node(int id, String data) {
    this.id = id;
    this.data = data;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public Node getPrevNode() {
    return prevNode;
  }

  public void setPrevNode(Node prevNode) {
    this.prevNode = prevNode;
  }

  public Node getNextNode() {
    return nextNode;
  }

  public void setNextNode(Node nextNode) {
    this.nextNode = nextNode;
  }

  @Override
  public String toString() {
    return "" + data ;
  }
}
