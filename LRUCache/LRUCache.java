package LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

  private int actualSize;
  private Map<Integer, Node> map;
  private DoublyLinkedList linkedList;

  public LRUCache() {
    this.map = new HashMap<>();
    this.linkedList = new DoublyLinkedList();
  }

  public void put(int id, String data) {

    //when the data is already in the cache
    if(map.containsKey(id)) {
      Node newNode = map.get(id);
      newNode.setData(data);
      update(newNode);
      return;
    }

    Node node = new Node(id, data);
    if(this.actualSize<Constants.SIZE){
      add(node);
      actualSize++;
    } else {
      removeTail();
      add(node);
    }
  }

  public Node get(int id) {
    if(!map.containsKey(id)) return null;

    Node node = map.get(id);
    update(node);
    return node;
  }
  private void update(Node newNode) {

    Node previous =  newNode.getPrevNode();
    Node next = newNode.getNextNode();

    if(previous != null) {//it's not head
      previous.setNextNode(next);
    } else {
      this.linkedList.setHead(newNode);
    }

    if(next != null) {// not tail node
      next.setPrevNode(previous);
    } else {
      this.linkedList.setTail(previous);
    }
    add(newNode);
  }

  private void removeTail() {

    Node tailNode = this.map.get(this.linkedList.getTail().getId());
    this.linkedList.setTail(this.linkedList.getTail().getPrevNode());

    if(this.linkedList.getTail() != null)
      this.linkedList.getTail().setNextNode(null);
    System.out.println("Setting new tail, on cache full::: "+ this.linkedList.getTail().getData());
    this.map.remove(tailNode.getId());
  }

  private void add(Node node) {
      node.setNextNode(this.linkedList.getHead());
      node.setPrevNode(null);
      
      if(this.linkedList.getHead() != null)
        this.linkedList.getHead().setPrevNode(node);
      
      this.linkedList.setHead(node);
      
      if(linkedList.getTail() == null)
        this.linkedList.setTail(node);
      
      this.map.put(node.getId(), node);
  }

  public void show() {
    Node headNode = this.linkedList.getHead();
    while(headNode != null) {
      System.out.print(headNode+ "("+ headNode.getId()+")"+" <-> ");
      headNode = headNode.getNextNode();
    }
  }
}
