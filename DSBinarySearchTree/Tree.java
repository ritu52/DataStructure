package DSBinarySearchTree;

public interface Tree<T> {

    void insert(T data);
    void remove(T data);
    T findMax();
    T findMin();
    void traverse();
    Node<T> getRoot();
    Node<T> getKthSmallestItem(Node<T> node, int k);

}
