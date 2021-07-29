package DSLinkedList.BasicImplementation;

public class TestingApp {

    /**
     * Basic implementation of a linked List
     * Console output of below program is shown here for more understanding:
         On adding element to Linked List, root gets updated!
         Actual representation of Linked List::: Bulldog coffee ->Rooster coffee house ->second cup ->StarBucks ->Nescafe ->tim hortons ->null
         Size of List is::: 6
         --------------------------------------------------------
         On deleting 'Nescafe' from Linked List, references get updated!
         Actual representation of Linked List::: Bulldog coffee ->Rooster coffee house ->second cup ->StarBucks ->tim hortons ->null
         Size of List is::: 5
         --------------------------------------------------------
         On adding integers to Linked List
         Actual representation of Linked List::: 12121212 ->4545454 ->343 ->999999 ->1000000 ->null
         Size of List is::: 5
         --------------------------------------------------------
     * @param args: not in use
     */
    public static void main(String[] args) {
        LinkedList<String> l1 = new LinkedList<>();

        System.out.println("On adding element to Linked List, root gets updated!");
        l1.addIntoLinkedList("tim hortons");
        l1.addIntoLinkedList("Nescafe");
        l1.addIntoLinkedList("StarBucks");
        l1.addIntoLinkedList("second cup");
        l1.addIntoLinkedList("Rooster coffee house");
        l1.addIntoLinkedList("Bulldog coffee");
        showOutput(l1);
        System.out.println("On deleting 'Nescafe' from Linked List, references get updated!");
        l1.deleteNode("Nescafe");
        showOutput(l1);

        LinkedList<Integer> l2 = new LinkedList<>();
        System.out.println("On adding integers to Linked List");
        l2.addIntoLinkedList(1000000);
        l2.addIntoLinkedList(999999);
        l2.addIntoLinkedList(343);
        l2.addIntoLinkedList(4545454);
        l2.addIntoLinkedList(12121212);
        showOutput(l2);

    }

    private static void showOutput(LinkedList<?> linkedList) {
        linkedList.traverseIntoLinkedList();
        System.out.println("Size of List is::: "+ linkedList.getCount());
        System.out.println("--------------------------------------------------------");
    }
}
