package DSLinkedList.ReverseTheLinkedList;

import DSLinkedList.BasicImplementation.LinkedList;

public class ReverseTheLinkedList {

    /**
     * Implementation of algorithm for reversing a linked list
     * Console output of below program
         * Actual representation of Linked List::: airplane ->ship ->train ->truck ->car ->scooter ->Bike ->Bicycle ->null
         * On reversing the linked list:::
         * Actual representation of Linked List::: Bicycle ->Bike ->scooter ->car ->truck ->train ->ship ->airplane ->null
     *
     * @param args: not in use
     */
    public static void main(String[] args) {
        LinkedList<String> linkedListToReverse = new LinkedList<>();
        linkedListToReverse.addIntoLinkedList("Bicycle");
        linkedListToReverse.addIntoLinkedList("Bike");
        linkedListToReverse.addIntoLinkedList("scooter");
        linkedListToReverse.addIntoLinkedList("car");
        linkedListToReverse.addIntoLinkedList("truck");
        linkedListToReverse.addIntoLinkedList("train");
        linkedListToReverse.addIntoLinkedList("ship");
        linkedListToReverse.addIntoLinkedList("airplane");

        linkedListToReverse.traverseIntoLinkedList();
        System.out.println("On reversing the linked list::: ");
        linkedListToReverse.reverseLinkedList();

    }
}
