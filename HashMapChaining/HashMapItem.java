package HashMapChaining;

public class HashMapItem {

  private int key;
  private int value;
  private HashMapItem nextHashItem;

  public HashMapItem(int key, int value) {
    this.key = key;
    this.value = value;
  }

  public int getKey() {
    return key;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public HashMapItem getNextHashItem() {
    return nextHashItem;
  }

  public void setNextHashItem(HashMapItem nextHashItem) {
    this.nextHashItem = nextHashItem;
  }
}
