package ADTStack.StackUsingArray;

public class AppTesting {
    /**
     * Below is the implementation of stack using array.
     * Since the array is static type so, the overhead of implementing using array is to resize the array during push and pop.
     * We cannot push when array is full, and we should not have an array which is just 25% filled.
     * Below is console output of program:
         * Element pushed::: 'Sun'. Array Size is::: 1
         * Change array size::: Old size: 1 New size: 2
         * Element pushed::: 'Air'. Array Size is::: 2
         * Change array size::: Old size: 2 New size: 4
         * Element pushed::: 'water'. Array Size is::: 3
         * Element pushed::: 'Earth'. Array Size is::: 4
         * 4
         * Sun Air water Earth
         * Array size: 4 Count: 3
         * Earth
         * Sun Air water null
         * 3
         * Array size: 4 Count: 2
         * water
         * Array size: 4 Count: 1
         * Change array size::: Old size: 1 New size: 2
         * air
         * Light null
         * 1
     * @param args: not in use
     */
    public static void main(String[] args) {
        StackUsingArray<String> stack = new StackUsingArray<>();
        stack.push("Sun");
        stack.push("Air");
        stack.push("water");
        stack.push("Earth");
        System.out.println(stack.getCount());
        stack.printAllElements();
        System.out.println(stack.pop());
        stack.printAllElements();
        System.out.println(stack.getCount());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.printAllElements();
        System.out.println(stack.getCount());
    }
}
