package DSLinkedList.BasicImplementation;

public class TestingApp {

    /**
     * Showing console output on testing the code below
         Testing adding strings to Linked List
         Size of List is::: 3
         Actual representation of Linked List::: StarBucks ->Nescafe ->Listen ->null
         Testing deleting from Linked List
         Size of List is::: 2
         Actual representation of Linked List::: StarBucks ->Listen ->null
         Testing adding integers to Linked List
         Size of List is::: 5
         Actual representation of Linked List::: 12121212 ->4545454 ->343 ->999999 ->1000000 ->null
     * @param args: not in use
     */
    public static void main(String[] args) {
        LinkedList<String> l1 = new LinkedList<>();

        System.out.println("Testing adding strings to Linked List");
        l1.addIntoLinkedList("Listen");
        l1.addIntoLinkedList("Nescafe");
        l1.addIntoLinkedList("StarBucks");
        showOutput(l1);
        System.out.println("Testing deleting from Linked List");
        l1.deleteNode("Nescafe");
        showOutput(l1);

        LinkedList<Integer> l2 = new LinkedList<>();
        System.out.println("Testing adding integers to Linked List");
        l2.addIntoLinkedList(1000000);
        l2.addIntoLinkedList(999999);
        l2.addIntoLinkedList(343);
        l2.addIntoLinkedList(4545454);
        l2.addIntoLinkedList(12121212);
        showOutput(l2);

    }

    private static void showOutput(LinkedList<?> linkedList) {
        System.out.println("Size of List is::: "+ linkedList.getCount());
        linkedList.traverseIntoLinkedList();
    }
}
