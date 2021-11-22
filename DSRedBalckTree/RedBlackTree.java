package DSRedBalckTree;

public class RedBlackTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public void insert(T data) {
        if(root==null) {
            root = new Node<>(data, null);
            settleViolations(root);
        } else {
            System.out.println("Inserting node with data:::"+data);
            insert(data, root);
        }
    }

    private void insert(T data, Node<T> node) {

        if(node.getData().compareTo(data) > 0) {//for smaller values
            if (node.getLeftNode() != null) { // when left child node exist
                insert(data, node.getLeftNode());
            } else { // otherwise, create new node
                Node<T> newNode = new Node<>(data, node);
                node.setLeftNode(newNode);
                settleViolations(newNode);
            }
        } else {//for bigger values
            if (node.getRightNode() != null) { // when right child node exist
                insert(data, node.getRightNode());
            } else { // otherwise, create right child
                Node<T> newNode = new Node<>(data, node);
                node.setRightNode(newNode);
                settleViolations(newNode);
            }
        }
    }

    @Override
    public void remove(T data) {
        if(root != null)
            remove(data, root);
    }

    private void remove(T data, Node<T> node) {
        if(node == null) return;

        // first search for the item
        if(data.compareTo(node.getData()) < 0) {
            remove(data, node.getLeftNode());
        } else if(data.compareTo(node.getData()) > 0) {
            remove(data, node.getRightNode());
        } else {
            //we found the node
            // case 1 when node is leaf node
            if(node.getRightNode() == null && node.getLeftNode() == null) {
                System.out.print("Removing the leaf node '"+ node.getData()+"' ");
                Node<T> parentOfNode = node.getParentNode();
                // This is left node
                if(parentOfNode != null && parentOfNode.getLeftNode() == node) {
                    parentOfNode.setLeftNode(null);
                    // This is right node
                } else if(parentOfNode != null && parentOfNode.getRightNode() == node) {
                    parentOfNode.setRightNode(null);
                }
                // when it is the root node
                if(parentOfNode == null)
                    root = null;
            }
            // case 2: node with single child
            else if(node.getRightNode() != null && node.getLeftNode() == null) {
                System.out.print("Removing the with single right child '"+ node.getData()+"' ");
                Node<T> parentOfNode = node.getParentNode();
                if(parentOfNode != null && parentOfNode.getLeftNode() == node) {
                    parentOfNode.setLeftNode(node.getRightNode());
                    // This is right node
                } else if(parentOfNode != null && parentOfNode.getRightNode() == node) {
                    parentOfNode.setRightNode(node.getRightNode());
                }

                if(parentOfNode == null)
                    root = node.getRightNode();

                node.getRightNode().setParentNode(parentOfNode);
            }
            // case 2a: node with single child
            else if(node.getRightNode() == null && node.getLeftNode() != null) {
                System.out.print("Removing the node with single left child '"+ node.getData()+"' ");
                Node<T> parentOfNode = node.getParentNode();
                if(parentOfNode != null && parentOfNode.getLeftNode() == node) {
                    parentOfNode.setLeftNode(node.getLeftNode());
                    // This is right node
                } else if(parentOfNode != null && parentOfNode.getRightNode() == node) {
                    parentOfNode.setRightNode(node.getLeftNode());
                }

                if(parentOfNode == null)
                    root = node.getLeftNode();

                node.getLeftNode().setParentNode(parentOfNode);
            }
            else {
                //Case 3: node with 2 nodes
                System.out.print("Removing the with 2 children '"+ node.getData()+"' ");
                Node<T> predecessor =  getPredecessor(node.getLeftNode());

                T temp = predecessor.getData();
                predecessor.setData(node.getData());
                node.setData(temp);

                remove(data, predecessor);
            }

        }
    }

    private void settleViolations(Node<T> node) {

        while(node!=root && isRed(node) && isRed(node.getParentNode())) {

            Node<T> parentNode = node.getParentNode();
            Node<T> grandParentNode = node.getParentNode().getParentNode();
            //Parent is left child
            if(parentNode == grandParentNode.getLeftNode()) {
                Node<T> uncle = grandParentNode.getRightNode();
                //Case 1 and 4 Recoloring
                if(uncle != null && isRed(uncle)) {
                    System.out.println("case 1 and 4");
                    grandParentNode.setColor(NodeColor.RED);
                    parentNode.setColor(NodeColor.BLACK);
                    uncle.setColor(NodeColor.BLACK);
                    node = grandParentNode;
                } else {
                    // uncle is null or it's black
                    //case 2
                    if(node == parentNode.getRightNode()) {
                        System.out.println("case 2");
                        leftRotation(parentNode);
                        node = parentNode;
                        parentNode = grandParentNode;
                    }
                    //case 3
                    rightRotation(grandParentNode);
                    System.out.println("recoloring case 3::: "+parentNode+" + "+grandParentNode);
                    //swap the color of parent and grandparent
                    NodeColor tempColor = parentNode.getColor();
                    parentNode.setColor(grandParentNode.getColor());
                    grandParentNode.setColor(tempColor);
                    node = parentNode;
                }
            } else {
                // Parent is Right Child of his parent
                //Case 1 and 4 Recoloring symmetric partner
                Node<T> uncle = grandParentNode.getLeftNode();
                if(uncle != null && isRed(uncle)) {
                    System.out.println("case 1 and 4 symmetric");
                    grandParentNode.setColor(NodeColor.RED);
                    parentNode.setColor(NodeColor.BLACK);
                    uncle.setColor(NodeColor.BLACK);
                    node = grandParentNode;
                } else {
                    //case 2 symmetric partner
                    if(node == parentNode.getLeftNode()) {
                        System.out.println("case 2 symmetric");
                        rightRotation(parentNode);
                        node = parentNode;
                        parentNode = grandParentNode;
                    }
                    //case 3 symmetric partner
                    leftRotation(grandParentNode);
                    System.out.println("Recoloring symmetry"+parentNode+" + "+grandParentNode);
                    //swap the color of parent and grandparent
                    NodeColor tempColor = parentNode.getColor();
                    parentNode.setColor(grandParentNode.getColor());
                    grandParentNode.setColor(tempColor);
                    node = parentNode;
                }
            }
        }
        //root node can't be red, we need to recolor if necessary
        if(isRed(root)) {
            System.out.println("Recoloring root node::: "+ root);
            root.setColor(NodeColor.BLACK);
        }
    }
    private Node<T> getPredecessor(Node<T> node) {
        if(node.getRightNode()!=null)
            return getPredecessor(node.getRightNode());

        return  node;
    }

    private boolean isRed(Node<T> node) {
        if(node == null)
            return false;

        return node.getColor() == NodeColor.RED;
    }
    private void rightRotation (Node<T> node) {
        System.out.println("Right rotation on, when its left heavy situation::: "+ node);
        Node<T> tempLeftChild = node.getLeftNode();
        Node<T> grandRightChild = tempLeftChild.getRightNode();

        tempLeftChild.setRightNode(node);
        node.setLeftNode(grandRightChild);

        if(grandRightChild != null)
            grandRightChild.setParentNode(node);

        Node<T> tempParent = node.getParentNode();
        node.setParentNode(tempLeftChild);
        tempLeftChild.setParentNode(tempParent);

        if(tempLeftChild.getParentNode() != null && tempLeftChild.getParentNode().getLeftNode() == node)
            tempLeftChild.getParentNode().setLeftNode(tempLeftChild);

        if(tempLeftChild.getParentNode() != null && tempLeftChild.getParentNode().getRightNode() == node)
            tempLeftChild.getParentNode().setRightNode(tempLeftChild);

        //in case of root node
        if(node == root)
            root = tempLeftChild;

    }
    private void leftRotation (Node<T> node) {
        System.out.println("Left rotation on when its right heavy situation::: "+ node);
        Node<T> tempRightChild = node.getRightNode();
        Node<T> grandLeftChild = tempRightChild.getRightNode();

        tempRightChild.setLeftNode(node);
        node.setRightNode(grandLeftChild);

        if(grandLeftChild != null)
            grandLeftChild.setParentNode(node);

        Node<T> tempParent = node.getParentNode();
        node.setParentNode(tempRightChild);
        tempRightChild.setParentNode(tempParent);

        if(tempRightChild.getParentNode() != null && tempRightChild.getParentNode().getLeftNode() == node)
            tempRightChild.getParentNode().setLeftNode(tempRightChild);

        if(tempRightChild.getParentNode() != null && tempRightChild.getParentNode().getRightNode() == node)
            tempRightChild.getParentNode().setRightNode(tempRightChild);

        //in case of root node
        if(node == root)
            root = tempRightChild;

    }

    @Override
    public void traverse() {
        if(root!= null)
        traverse(root);
    }
    private void traverse(Node<T> node) {
        if (node.getLeftNode()!=null)
            traverse(node.getLeftNode());

        System.out.print(node + " -> ");

        if(node.getRightNode()!=null)
            traverse(node.getRightNode());
    }
}
