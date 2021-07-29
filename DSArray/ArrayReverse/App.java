package DSArray.ArrayReverse;


public class App {

    /**
     * Console output of below program
         * Kevin Su Bob Arun Mano Susi Egg
         * A reversed String array
         * Egg Susi Mano Arun Bob Su Kevin
         * -------------------
         * 1 2 3 4 5 6 7
         * A reversed Int array
         * 7 6 5 4 3 2 1
     * @param args: not in use
     */
    public static void main(String[] args) {
        Object[] arrayToReverse = {"Kevin","Su","Bob","Arun","Mano", "Susi", "Egg"};
        for(Object element: arrayToReverse) System.out.print(element+ " ");
        Object[] reversedArray = ReverseTheArray.arrayToReverse(arrayToReverse);
        System.out.println(" ");
        System.out.println("A reversed String array");
        for(Object element: reversedArray) System.out.print(element+" ");
        System.out.println(" ");
        System.out.println("-------------------");
        Object[] intArrayToReverse = {1,2,3,4,5,6,7};
        for(Object element: intArrayToReverse) System.out.print(element+ " ");
        Object[] reversedIntArray = ReverseTheArray.arrayToReverse(intArrayToReverse);
        System.out.println(" ");
        System.out.println("A reversed Int array");
        for(Object element: reversedIntArray) System.out.print(element+" ");

    }
}
