package DSHeap;

public class Heap {

  // 1-D representation
  private final int[] heap;
  private int heapSize;

  public Heap() {
    this.heap = new int[Constants.POOL_SIZE];
  }

  public int getHeapSize() {
    return heapSize;
  }

  public int getMax() {
    return heap[0];
  }
  private boolean isFull() {
    return heapSize == heap.length;
  }

  public void insert(int data) {

    if(isFull()) throw new RuntimeException("Heap is full");

    heap[heapSize] = data;
    heapSize++;

    fixUp(heapSize-1);
  }

  private void fixUp(int index) {

    int parentIndex = (index-1)/2;

    if(index>0 && heap[index] > heap[parentIndex]) {
      swap(parentIndex, index);
      fixUp(parentIndex);
    }
  }

  private void swap(int parentIndex, int index) {
    int temp = heap[index];
    heap[index] = heap[parentIndex];
    heap[parentIndex] = temp;
  }

  public void heapSort() {
    int max = heapSize;
    for (int i=0;i<max;i++) {
      int polled = poll();
      System.out.print(polled+" ");
    }
  }
  public int poll() {
    int max = getMax();

    swap(0, heapSize-1);
    heapSize--;
    fixDown(0);
    return  max;
  }

  private void fixDown(int index) {

    int leftChildIndex = (2*index)+1;
    int rightChildIndex = (2*index)+2;
    int largestIndex = index;

    if(leftChildIndex < heapSize && heap[leftChildIndex] > heap[index])
      largestIndex = leftChildIndex;

    if(rightChildIndex < heapSize && heap[rightChildIndex] > heap[largestIndex])
      largestIndex = rightChildIndex;

    if(index != largestIndex) {
      swap(largestIndex, index);
      fixDown(largestIndex);
    }
  }

  public boolean isMinHeap(int[] arrayToBeChecked) {
    // 2*i+2 <=N
    for(int i=0; i<(arrayToBeChecked.length-2)/2;i++) {
      if(arrayToBeChecked[i] > arrayToBeChecked[2*i+1] || arrayToBeChecked[i] > arrayToBeChecked[2*i+2])
        return false;
    }
    return true;
  }

  public int[] transformMaxToMin(int[] arrayMaxToBeTransformed) {

    for (int i= (arrayMaxToBeTransformed.length-2)/2; i>=0;i--) {
      transform(i, arrayMaxToBeTransformed.length);
    }
    return arrayMaxToBeTransformed;
  }

  private void transform(int index, int length) {
    int leftChildIndex = (2*index)+1;
    int rightChildIndex = (2*index)+2;
    int smallestIndex = index;

    if(leftChildIndex < length && heap[leftChildIndex] > heap[index])
      smallestIndex = leftChildIndex;

    if(rightChildIndex < length && heap[rightChildIndex] > heap[smallestIndex])
      smallestIndex = rightChildIndex;

    if(index != smallestIndex) {
      swap(smallestIndex, index);
      transform(smallestIndex, length);
    }
  }
}
