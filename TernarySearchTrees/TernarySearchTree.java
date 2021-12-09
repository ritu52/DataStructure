package TernarySearchTrees;

public class TernarySearchTree {

  private Node root;

  public void put(String key, Integer value) {
    System.out.println("Inserting key::: '"+key +"' with value::: "+ value);
    root = insert(root, key, value, 0);
    System.out.println("------Insertion complete----------");
  }

  private Node insert(Node node, String key, Integer value, int index) {
    char c = key.charAt(index);

    if(node == null)
      node = new Node(c);

    if(c<node.getCharacter()) {
      System.out.println("I am ("+c+") left child of node::: "+node.getCharacter());
      node.setLeftNode(insert(node.getLeftNode(), key, value, index));
    } else if(c>node.getCharacter()) {
      System.out.println("I am ("+c+") right child of node::: "+node.getCharacter());
      node.setRightNode(insert(node.getRightNode(), key, value, index));
    } else if(index < key.length()-1) {// this is not the last letter and is middle child
      System.out.println("I am ("+c+") middle child of node and not last character::: "+node.getCharacter());
      node.setMiddleNode(insert(node.getMiddleNode(), key, value, index + 1));
    } else {
      System.out.println("I am the last character::: "+node.getCharacter());
      node.setLeaf(true);
      node.setValue(value);
    }
    return  node;
  }

  public Integer get(String key) {
    Node node = get(root, key, 0);

    if (node== null) return null;

    return node.getValue();
  }

  private Node get(Node node, String key, int index) {
    if(node == null) return null;

    char c = key.charAt(index);
    if(c<node.getCharacter()) {
      return get(node.getLeftNode(), key, index);
    } else if(c>node.getCharacter()) {
      return get(node.getRightNode(), key, index);
    }else if(index < key.length()-1) {
      return get(node.getMiddleNode(), key, index+1);
    } else {
      if(!node.isLeaf()) return null;
      return node;
    }
  }

  public void traverse (){
    traverse(root, "");
  }

  private void traverse(Node node, String key) {
    if(node.getMiddleNode() == null || node.getValue() != null)
      System.out.print(key+node.getCharacter() + ":"+node.getValue() +"->");

    if(node.getLeftNode() != null)
      traverse(node.getLeftNode(), key);

    if(node.getMiddleNode() != null) {
      traverse(node.getMiddleNode(),
          key+node.getCharacter());
    }

    if(node.getRightNode() != null) {
      traverse(node.getRightNode(), key);
    }
  }
}
