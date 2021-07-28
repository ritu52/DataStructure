package DSArray.ArrayReverse;


public class ReverseTheArray {

    public static Object[] arrayToReverse(Object[] a) {
        int lastIndex = a.length - 1;
        int firstIndex = 0;
        //Iterate only to half of the array
        for (int i = 0; i < a.length / 2; i++) {
            if (firstIndex != lastIndex) {
                Object temp = a[firstIndex];
                a[firstIndex] = a[lastIndex];
                a[lastIndex] = temp;
                firstIndex++;
                lastIndex--;
            }
        }
        return a;
    }
}
