package ADTStack.StackUsingArray;

@SuppressWarnings("unchecked")
public class StackUsingArray<T> {
    T[] arrayOfStackElements;

    int count;

    StackUsingArray() {
        arrayOfStackElements = (T[]) new Object[1];
    }

    public void push(T newData) {
        if(arrayOfStackElements.length==count)
            resizeArray(2 * arrayOfStackElements.length);

        arrayOfStackElements[count] = newData;
        count++;
        System.out.println("Element pushed::: '"+ newData +"'. Array Size is::: "+count);

    }
    public int getCount() {
        return count;
    }

    public void printAllElements(){
        for(T element:arrayOfStackElements) System.out.print(element+ " ");
        System.out.println(" ");
    }

    public T pop() {
        --count;
        T elementRemoved = arrayOfStackElements[count];
        arrayOfStackElements[count] = null;
        System.out.println("Array size: "+ arrayOfStackElements.length+ " Count: "+count);
        if(arrayOfStackElements.length/4 ==count) resizeArray(arrayOfStackElements.length/2);
        return elementRemoved;
    }

    private void resizeArray(int newSize) {
        System.out.println("Change array size::: Old size: "+ count+ " New size: "+newSize);
        T[] newArray = (T[]) new Object[newSize];
        if (count >= 0) System.arraycopy(arrayOfStackElements, 0, newArray, 0, count);
        arrayOfStackElements = newArray;
    }
}
