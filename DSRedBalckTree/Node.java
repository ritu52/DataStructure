package DSRedBalckTree;

public class Node<T> {

    private T data;
    private Node<T> leftNode;
    private Node<T> rightNode;
    private Node<T> parentNode;
    private NodeColor color;

    public Node(T data, Node<T> parentNode) {
        this.data = data;
        this.parentNode = parentNode;
        this.color = NodeColor.RED;// default color of a node
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node<T> leftNode) {
        this.leftNode = leftNode;
    }

    public Node<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node<T> rightNode) {
        this.rightNode = rightNode;
    }

    public Node<T> getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node<T> parentNode) {
        this.parentNode = parentNode;
    }

    public NodeColor getColor() {
        return color;
    }

    public void setColor(NodeColor color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return ""+ data;
    }
}
