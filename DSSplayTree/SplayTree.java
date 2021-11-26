package DSSplayTree;

public class SplayTree<T extends Comparable<T>> implements Tree<T> {

    Node<T> root;

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
                Node<T> newNode = new Node<>(data, node);
                node.setLeftNode(newNode);
                //splay(newNode); -- splaying should be done when we find any element so removing it
            }
        } else {//for bigger values
            if (node.getRightNode() != null) { // when right child node exist
                insert(data, node.getRightNode());
            } else { // otherwise, create right child
                Node<T> newNode = new Node<>(data, node);
                node.setRightNode(newNode);
                //splay(newNode); -- splaying should be done when we find any element so removing it
            }
        }
    }

    private void splay(Node<T> node) {
        while(node.getParentNode() != null) {
            //Case ZIG
            if (node.getParentNode().getParentNode() == null) {
                System.out.println("ZIG Situation::: "+ node);
                if (node.getParentNode().getLeftNode() == node) {
                    rightRotation(node.getParentNode());
                } else {
                    leftRotation(node.getParentNode());
                }
            } else if(node.getParentNode().getLeftNode() == node
                    && node.getParentNode().getParentNode().getLeftNode() == node.getParentNode()){
                System.out.println("ZIG-ZIG Situation left symmetry::: "+ node);
                rightRotation(node.getParentNode().getParentNode());
                rightRotation(node.getParentNode());
            }else if(node.getParentNode().getRightNode() == node
                    && node.getParentNode().getParentNode().getRightNode() == node.getParentNode()){
                System.out.println("ZIG-ZIG Situation right symmetry::: "+ node);
                leftRotation(node.getParentNode().getParentNode());
                leftRotation(node.getParentNode());
            } else if(node.getParentNode().getLeftNode() == node
                    && node.getParentNode().getParentNode().getRightNode() == node.getParentNode()){
                System.out.println("ZIG-ZAG Situation right symmetry::: "+ node);
                rightRotation(node.getParentNode());
                leftRotation(node.getParentNode());
            } else {
                System.out.println("ZIG-ZAG Situation left symmetry::: "+ node);
                leftRotation(node.getParentNode());
                rightRotation(node.getParentNode());
            }
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
    @Override
    public void traverse() {
        if(root != null)
            traverse(root);
    }

    private void traverse(Node<T> node) {
        if(node.getLeftNode()!=null)
            traverse(node.getLeftNode());

        System.out.print(node + " -> ");

        if(node.getRightNode()!=null)
            traverse(node.getRightNode());
    }

    @Override
    public T find(T data) {
        if(root == null) return null;

        return find(data, root);
    }

    @Override
    public T getRoot() {
        if(root == null) return null;

        return  root.getData();
    }

    private T find(T data, Node<T> node) {
        if(node == null) return null;

        if(node.getData().compareTo(data)>0) {
            find(data, node.getLeftNode());
        } else if(node.getData().compareTo(data)<0) {
            find(data, node.getRightNode());
        } else {
            splay(node);
            return node.getData();
        }
        return null;
    }

}
