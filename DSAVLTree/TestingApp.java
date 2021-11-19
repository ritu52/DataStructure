package DSAVLTree;

public class TestingApp {

    /**
     * The implementation of AVL tree
         Traversing over the AVL tree, it's similar to BST
         1 -> 4 -> 5 -> 12 -> 20 -> 23 -> ----My root Node here is::: 12

         Removing the leaf node '23' 1 -> 4 -> 5 -> 12 -> 20 -> ----My root Node here is::: 12

         Removing the leaf node '20' Left rotation on when its right heavy situation::: 4
         Right rotation on, when its left heavy situation::: 12
         1 -> 4 -> 5 -> 12 -> ----My root Node here is::: 5
         ---Remove all--
         Removing the with 2 children '5' Removing the node with single left child '5' Removing the leaf node '12' Removing the leaf node '1' Removing the leaf node '4'
     */
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();

        avl.insert(12);
        avl.insert(4);
        avl.insert(20);
        avl.insert(1);
        avl.insert(5);
        avl.insert(23);
        System.out.println("Traversing over the AVL tree, its similar to BST");
        avl.traverse();
        System.out.println("----My root Node here is::: "+ avl.getRoot());
        System.out.println(" ");
        avl.remove(23);
        avl.traverse();
        System.out.println("----My root Node here is::: "+ avl.getRoot());
        System.out.println(" ");
        avl.remove(20);
        avl.traverse();
        System.out.println("----My root Node here is::: "+ avl.getRoot());
        System.out.println("---Remove all--");
        avl.remove(5);
        avl.remove(12);
        avl.remove(1);
        avl.remove(4);

    }

}
