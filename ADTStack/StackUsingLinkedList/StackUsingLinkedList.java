package ADTStack.StackUsingLinkedList;

public class StackUsingLinkedList<T extends Comparable<T>> {

    private Node<T> head;

    /**
     * Method to insert elements into stack
     * @param data: to be inserted
     */
    public void push(T data) {
        if(head==null) {
            head = new Node<>(data);
        } else {
            Node<T> newHead = new Node<>(data);
            newHead.setNextNode(head);
            head = newHead;
        }
    }

    /**
     * Method to see the head element
     * @return Head node
     */
    public Node<T> peek() {
        if (head==null) return null;
        return head;
    }

    /**
     * Method to delete the last element
     * @return the deleted node
     */
    public Node<T> pop() {
        if (head==null) return null;
        Node<T> deletedNode = head;
        head = head.getNextNode();
        return deletedNode;
    }

    /**
     * A utility method to show all the elements present in the stack
     */
    public void showAllStackElements() {
        if(head == null) return;
        Node<T> actualNode = head;
        System.out.print("Stack elements::: ");
        while(actualNode != null) {
            System.out.print(actualNode.getData()+ " ");
            actualNode = actualNode.getNextNode();
        }
        System.out.println(" ");
    }
}
