package DSLinkedList.FindMiddleNode;

import DSLinkedList.BasicImplementation.LinkedList;
import DSLinkedList.BasicImplementation.Node;

public class FindMiddleNode<T extends Comparable<T>> extends LinkedList<T> {

    /**
     * Implementation of finding the middle node in a linked list
     * Console output of below program is shown below:
         * Actual representation of Linked List::: bush ->cactus ->grass ->pine ->herbs ->Shrubs ->Trees ->null
         * The middle node is::: pine
     * @param args: not in use
     */
    public static void main(String[] args) {
        FindMiddleNode<String> l1 = new FindMiddleNode<>();
        l1.addIntoLinkedList("Trees");
        l1.addIntoLinkedList("Shrubs");
        l1.addIntoLinkedList("herbs");
        l1.addIntoLinkedList("pine");
        l1.addIntoLinkedList("grass");
        l1.addIntoLinkedList("cactus");
        l1.addIntoLinkedList("bush");
        l1.traverseIntoLinkedList();
        System.out.println("The middle node is::: "+l1.findMiddleNode(l1.getRoot()).getData());
    }

    /**
     * Method to find middle node of a linked lit
     * @param head: root of the linkedList
     * @return middle node
     */
    public Node<T> findMiddleNode(Node<T> head) {
        Node<T> slowPointer = head;
        Node<T> fastPointer = head;

        while(fastPointer.getNextNode() != null && fastPointer.getNextNode().getNextNode() != null) {
            fastPointer = fastPointer.getNextNode().getNextNode();
            slowPointer = slowPointer.getNextNode();
        }
        return slowPointer;
    }
}
