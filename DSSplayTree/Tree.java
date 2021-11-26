package DSSplayTree;

public interface Tree<T> {

    void insert(T data);
    void traverse();
    T find(T data);
    T getRoot();
}
