public class MyHashSet {

    private final int size = 809; //prime number
    private final Bucket<Integer>[] buckets;

    public MyHashSet() {
        buckets = new Bucket[size];
        for (int i = 0; i < size; ++i) {
            buckets[i] = new Bucket<>();
        }
    }

    private int hashKey(int key) {
        return key % size;
    }

    public void add(int key) {
        buckets[hashKey(key)].insertIntoBucket(key);
    }

    public void remove(int key) {
        buckets[hashKey(key)].removeFromBucket(key);
    }

    public boolean contains(int key) {
        return buckets[hashKey(key)].isInBucket(key);
    }

}

class Bucket<T> {

    private final LinkedList<T> bucketValues;

    public Bucket() {
        bucketValues = new LinkedList<>();
    }

    protected void insertIntoBucket(T value) {
        if (!bucketValues.contains(value)) {
            bucketValues.addFirst(value);
        }
    }

    protected void removeFromBucket(T value) {
        bucketValues.remove(value);
    }

    protected boolean isInBucket(T value) {
        return bucketValues.contains(value);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */