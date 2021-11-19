package DSAVLTree;

public interface Tree<T> {

    void insert(T data);
    void remove(T data);
    void traverse();
    Node<T> getRoot();
}
