package DSBinarySearchTree;

public class TestingApp {

    /**
     * The Binary Search tree testing. The console output of various methods like insert, traverse, delete, find min, find max etc.
     *
     * The minimum of the tree::: 2
     * The maximum of the tree::: 21
     * The tree traversal::: 2 -> 5 -> 6 -> 9 -> 10 -> 14 -> 21 ->
     * Removing items from tree:::
     * Removing the leaf node '5' 2 -> 6 -> 9 -> 10 -> 14 -> 21 ->
     *
     * Removing the node with single left child '21' 2 -> 6 -> 9 -> 10 -> 14 ->
     *
     * Removing the with single right child '2' 6 -> 9 -> 10 -> 14 ->
     *
     * Removing the with 2 children '10' Removing the node with single left child '10' 6 -> 9 -> 14 ->
     * Comparing 2 trees for same topology and values of all nodes:::
     * 2 -> 11 -> 12 -> 50 -> 67 ->
     *
     * 2 -> 11 -> 12 -> 55 -> 67 ->
     *
     * Comparing the above 2 trees::false
     * Finding the 2nd smallest item::: 11
     * Finding the 3rd largest item::: 12
     */
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(9);
        bst.insert(21);
        bst.insert(14);
        bst.insert(2);
        bst.insert(6);
        bst.insert(5);

        System.out.println("The minimum of the tree::: "+bst.findMin());
        System.out.println("The maximum of the tree::: "+bst.findMax());
        System.out.print("The tree traversal::: ");
        bst.traverse();
        System.out.println("\n"+"Removing items from tree::: ");
        bst.remove(5);
        bst.traverse();
        System.out.println("\n");
        bst.remove(21);
        bst.traverse();
        System.out.println("\n");
        bst.remove(2);
        bst.traverse();
        System.out.println("\n");
        bst.remove(10);
        bst.traverse();

        System.out.println("\n"+"Comparing 2 trees for same topology and values of all nodes::: ");
        BinarySearchTree<Integer> tree1 = new BinarySearchTree<>();
        tree1.insert(2);
        tree1.insert(55);
        tree1.insert(67);
        tree1.insert(12);
        tree1.insert(11);
        tree1.traverse();
        System.out.println("\n");
        BinarySearchTree<Integer> tree2 = new BinarySearchTree<>();
        tree2.insert(2);
        tree2.insert(55);
        tree2.insert(67);
        tree2.insert(12);
        tree2.insert(11);
        tree2.traverse();
        System.out.println("\n");
        CompareTreeHelper<Integer> cpt = new CompareTreeHelper<>();
        System.out.println("Comparing the above 2 trees::" + cpt.compareTrees(tree1.getRoot(),tree2.getRoot()));
        System.out.println("Finding the 2nd smallest item::: " + tree1.getKthSmallestItem(tree1.getRoot(), 2));
        System.out.println("Finding the 3rd largest item::: " + tree1.getKthLargestItem(tree1.getRoot(), 3));
    }
}
