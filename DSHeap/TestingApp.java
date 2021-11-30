package DSHeap;

/**
 * The implementation of Binary heap. This is a Max_heap. Below is console output:
     The size of heap::: 7
     The root element in a MAX heap is its maximum item::: 89
     Polling the root node::: 89
     Heap Sort:::
     43 10 9 7 -2 -10
     ----------------------Min Heap Validation------------
     Is below array a valid min heap?
     1 2 3 4 5 true
     10 -1 30 4 5 false
 */
public class TestingApp {

  public static void main(String[] args) {
    Heap heap = new Heap();
    heap.insert(7);
    heap.insert(9);
    heap.insert(10);
    heap.insert(-2);
    heap.insert(43);
    heap.insert(89);
    heap.insert(-10);
    System.out.println("The size of heap::: "+heap.getHeapSize());
    System.out.println("The root element in a MAX heap is its maximum item::: "+heap.getMax());
    System.out.println("Polling the root node::: "+heap.poll());
    System.out.println("Heap Sort::: ");
    heap.heapSort();
    System.out.println(" ");
    System.out.println("----------------------Min Heap Validation------------");
    System.out.println("Is below array a valid min heap?");
    int[] arr = {1,2,3,4,5};
    for (int x: arr) {
      System.out.print(x + " ");
    }
    System.out.println(heap.isMinHeap(arr));
    int[] arr1 = {10,-1,30,4,5};
    for (int x: arr1) {
      System.out.print(x + " ");
    }
    System.out.println(heap.isMinHeap(arr1));
    System.out.println("----------------------Max to Min Heap transformation------------");
    System.out.println("Max heap");
    int[] arr2 = {5,4,3,2,1};
    for (int x: arr2) {
      System.out.print(x + " ");
    }
    System.out.println(" ");
    int[] result = heap.transformMaxToMin(arr);
    for (int x: result) {
      System.out.print(x + " ");
    }
  }
}
