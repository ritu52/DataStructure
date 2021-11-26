package DSSplayTree;

public class AppTesting {

    /**
     * The Splay tree implementation. The console output is below:::
         *  Tree Traversal in-order
         * -2 -> 1 -> 4 -> 5 -> 10 -> ------
         * ZIG-ZAG Situation left symmetry::: 5
         * Left rotation on when its right heavy situation::: 4
         * Right rotation on, when its left heavy situation::: 10
         * ZIG Situation::: 5
         * Left rotation on when its right heavy situation::: 1
         * Finding the node::: 5 The new root node::: 5
         * ZIG-ZIG Situation left symmetry::: -2
         * Right rotation on, when its left heavy situation::: 5
         * Right rotation on, when its left heavy situation::: 1
         * Finding the node::: -2 The new root node::: -2
         * Finding the node::: 15 The new root node::: -2
     */
    public static void main(String[] args) {
        Tree<Integer> splayTree = new SplayTree<>();
        splayTree.insert(1);
        splayTree.insert(10);
        splayTree.insert(4);
        splayTree.insert(5);
        splayTree.insert(-2);
        System.out.println("Tree Traversal in-order");
        splayTree.traverse();
        System.out.println("------");
        splayTree.find(5);
        System.out.println("Finding the node::: 5"+" The new root node::: "+splayTree.getRoot());
        splayTree.find(-2);
        System.out.println("Finding the node::: -2"+" The new root node::: "+splayTree.getRoot());
        splayTree.find(15);
        System.out.println("Finding the node::: 15"+" The new root node::: "+splayTree.getRoot());
    }
}
