package DSRedBalckTree;

public class TestingApp {

    /**
     * RedBlack Tree Implementation
         * Recoloring root node::: 5
         * Inserting node with data::: 2
         * Inserting node with data::: 3
         * case 2
         * Left rotation on when its right heavy situation::: 2
         * Right rotation on, when its left heavy situation::: 5
         * recoloring case 3::: 5 + 5
         * Recoloring root node::: 3
         * Inserting node with data::: 4
         * 2 -> 3 -> 4 -> 5 ->
     */
    public static void main(String[] args) {
        Tree<Integer> redBlackTree = new RedBlackTree<>();
        redBlackTree.insert(5);
        redBlackTree.insert(2);
        redBlackTree.insert(3);
        redBlackTree.insert(4);
        redBlackTree.traverse();

    }
}
