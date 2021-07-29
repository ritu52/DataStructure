package DSLinkedList.BasicImplementation;

public class LinkedList<T extends Comparable<T>> {

    private Node<T> root;
    private int count =0;

    public int getCount() {
        return count;
    }
    public Node<T> getRoot() {
        return root;
    }

    /**
     * Method to traverse and print the elements of linked list
     */
    public void traverseIntoLinkedList() {
        if(root == null) return;
        Node<T> actualNode = root;
        System.out.print("Actual representation of Linked List::: ");
        while(actualNode != null) {
            System.out.print(actualNode.getData()+ " ->");
            actualNode = actualNode.getNextNode();
        }
        System.out.print("null");
        System.out.println(" ");
    }

    /**
     * Method to insert element
     * @param data: to be inserted
     */
    public void addIntoLinkedList(T data) {
        if(root == null) {
            root = new Node<>(data);
        } else {
            addInBeginning(data);
        }
        count++;
    }
    private void addInBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(root);
        this.root = newNode;
    }

    /**
     * Method to delete node when node with data is present
     * @param data: data to be deleted
     */
    public void deleteNode(T data) {
        Node<T> headNode = root;
        if(headNode.getData().compareTo(data)==0) {
            root = root.getNextNode();
            count--;
        } else {
            deleteNode(data, root, root.getNextNode());
        }
    }

    private void deleteNode(T data, Node<T> previousNode, Node<T> nodeToCheck) {
        if(nodeToCheck != null) {
            if (nodeToCheck.getData().compareTo(data) == 0) {
                previousNode.setNextNode(nodeToCheck.getNextNode());
                count--;
            } else {
                deleteNode(data, nodeToCheck, nodeToCheck.getNextNode());
            }
        }
    }

    /**
     * Method will reverse the linked list and print all elements
     */
    public void reverseLinkedList() {
        Node<T> next = null;
        Node<T> present = root;

        while(present != null) {
            Node<T> temp = present.getNextNode();
            present.setNextNode(next);

            next = present;
            present = temp;
        }
        root = next;
        traverseIntoLinkedList();
    }

}
