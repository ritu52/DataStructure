package ADTStack.StackUsingLinkedList;

public class AppTesting {

    /**
     * Stack is type of Abstract data type which supports 3 methods i.e, push, peek, pop
     * It is based on Last-In-First-Out
     * Console output of below program is shown below for enhanced understanding
         * Being a LIFO, stack pushes element on top!
         * After pushing -> Stack elements::: Winter Fall Summer Spring
         * -----------------------------
         * Peek is used to see last element pushed i.e, head element
         * Winter
         * -----------------------------
         * Pop removes the last element and shifts head to next node
         * The pop deletes the node which was head element::: Winter
         * After popping -> Stack elements::: Fall Summer Spring
         * -----------------------------
     * @param args not in use
     */
    public static void main(String[] args) {
        StackUsingLinkedList<String> stackOfString = new StackUsingLinkedList<>();
        System.out.println("Being a LIFO, stack pushes element on top!");
        stackOfString.push("Spring");
        stackOfString.push("Summer");
        stackOfString.push("Fall");
        stackOfString.push("Winter");
        System.out.print("After pushing -> ");
        stackOfString.showAllStackElements();
        System.out.println("-----------------------------");
        System.out.println("Peek is used to see last element pushed i.e, head element");
        System.out.println(stackOfString.peek());
        System.out.println("-----------------------------");
        System.out.println("Pop removes the last element and shifts head to next node");
        Node<String> deletedNode = stackOfString.pop();
        System.out.println("The pop deletes the node which was head element::: "+deletedNode);
        System.out.print("After popping -> ");
        stackOfString.showAllStackElements();
        System.out.println("-----------------------------");
    }
}
