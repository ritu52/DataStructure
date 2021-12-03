package DSBinarySearchTree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

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

    private Node<T> getPredecessor(Node<T> node) {
        if(node.getRightNode()!=null)
            return getPredecessor(node.getRightNode());

        return  node;
    }

    @Override
    public T findMax() { // the rightmost element is maximum value
        if(root== null) return null;

        return findMax(root);
    }

    private T findMax(Node<T> node) {
        if(node.getRightNode() != null)
            return findMax(node.getRightNode());

        return node.getData();
    }

    @Override
    public T findMin() { // the leftmost element is minimum value
        if(root== null) return null;

        return findMin(root);
    }

    private T findMin(Node<T> node) {
        if(node.getLeftNode() != null)
            return findMin(node.getLeftNode());

        return node.getData();
    }

    @Override
    public void traverse() { //in-order traversal

        if(root== null) return;

        traverse(root);

    }

    @Override
    public Node<T> getRoot() {
        return this.root;
    }

    @Override
    public Node<T> getKthSmallestItem(Node<T> node, int k) {
        int nodeTotalSizeOfLefTree = treeSize(node.getLeftNode())+1;

        if(nodeTotalSizeOfLefTree == k ) return  node;

        if(nodeTotalSizeOfLefTree > k) {
            return getKthSmallestItem(node.getLeftNode(), k);
        } else {
            return getKthSmallestItem(node.getRightNode(), k-nodeTotalSizeOfLefTree);
        }
    }

    private int treeSize(Node<T> node) {
        if(node == null) return 0;

        return treeSize(node.getLeftNode())+ treeSize(node.getRightNode()) +1;
    }

    public Node<T> getKthLargestItem(Node<T> node, int k) {
        int nodeTotalSizeOfRightTree = treeSize(node.getRightNode())+1;

        if(nodeTotalSizeOfRightTree == k ) return  node;

        if(nodeTotalSizeOfRightTree > k) {
            return getKthLargestItem(node.getRightNode(), k);
        } else {
            return getKthLargestItem(node.getLeftNode(), k - nodeTotalSizeOfRightTree);
        }
    }

    private void traverse(Node<T> node) {
        if(node.getLeftNode()!=null)
            traverse(node.getLeftNode());

        System.out.print(node + " -> ");

        if(node.getRightNode()!=null)
            traverse(node.getRightNode());
    }
}
