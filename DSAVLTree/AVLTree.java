package DSAVLTree;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public Node<T> getRoot() {
        return this.root;
    }
    @Override
    public void insert(T data) {
        if(root==null) {
            root = new Node<>(data, null);
        } else {
            insert(data, root);
        }
    }

    private void insert(T data, Node<T> node) {

        if(node.getData().compareTo(data) > 0) {//for smaller values
            if (node.getLeftNode() != null) { // when left child node exist
                insert(data, node.getLeftNode());
            } else { // otherwise, create new node
                node.setLeftNode(new Node<>(data, node));
            }
        } else {//for bigger values
            if (node.getRightNode() != null) { // when right child node exist
                insert(data, node.getRightNode());
            } else { // otherwise, create right child
                node.setRightNode(new Node<>(data, node));
            }
        }
        updateHeight(node);
        //settle violation
        settleViolation(node);
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
                if(parentOfNode == null) {
                    root = null;
                }

                if (parentOfNode != null) {
                    updateHeight(parentOfNode);
                }
                settleViolation(parentOfNode);
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
                if (parentOfNode != null) {
                    updateHeight(parentOfNode);
                }
                settleViolation(parentOfNode);
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
                if (parentOfNode != null) {
                    updateHeight(parentOfNode);
                }
                settleViolation(parentOfNode);
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

    private Node<T> getPredecessor(Node<T> node) {
        if(node.getRightNode()!=null)
            return getPredecessor(node.getRightNode());

        return  node;
    }


    @Override
    public void traverse() { //in-order traversal

        if(root== null) return;

        traverse(root);
    }

    private void traverse(Node<T> node) {
        if(node.getLeftNode()!=null)
            traverse(node.getLeftNode());

        System.out.print(node + " -> ");

        if(node.getRightNode()!=null)
            traverse(node.getRightNode());
    }

    private void settleViolation(Node<T> node) {
        while(node != null) {
            updateHeight(node);
            settleViolationHelper(node);
            node = node.getParentNode();
        }
    }

    private void settleViolationHelper(Node<T> node) {

        int balanceFactor = getBalance(node);

        //positive meaning its left heavy, but it can be left-left or left-right heavy situation
        if(balanceFactor>1) {
            if(getBalance(node.getLeftNode()) <1) {
                leftRotation(node.getLeftNode());
            }
            rightRotation(node);
        }
        //negative meaning its right heavy, but it can be right-right or right-left heavy situation
        if(balanceFactor<-1) {
            if(getBalance(node.getRightNode()) >1) {
                rightRotation(node.getRightNode());
            }
            leftRotation(node);
        }
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

        updateHeight(node);
        updateHeight(tempRightChild);
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

        updateHeight(node);
        updateHeight(tempLeftChild);
    }
    private void updateHeight(Node<T> node) {
        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode()))+1);
    }
    //return height
    private int height(Node<T> node) {
        if (node == null) return -1;

        return node.getHeight();
    }

    private int getBalance(Node<T> node) {

        if(node == null) return 0;

        return height(node.getLeftNode()) - height(node.getRightNode());
    }
}
