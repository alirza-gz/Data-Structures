import java.util.Arrays;

public class DynamicArray<T> implements List<T> {
    private Object[] Array;
    private int occupied = 0;

    public DynamicArray() {
            Array = new Object[0];
    }

    @Override
    public int size() {
        return occupied;
    }

    @Override
    public T get(int index) {
        return (T) Array[index];
    }

    @Override
    public List<T> set(int index, T value) {
        Array[index] = value;
        return this;
    }

    //For assuring that the array always has some space for adding a new element
    private void assureCapacity(){
        if (Array.length == occupied)
            Array = Arrays.copyOf(Array,Array.length+1);
    }

    @Override
    public List<T> add(T value) {
        assureCapacity();
        set(occupied, value);
        occupied++;
        return this;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(Array,occupied));
    }

    public static void main(String[] args) {
        DynamicArray<String> a = new DynamicArray<>();
        DynamicArray<Double> b = new DynamicArray<>();
        a.add("ali").add("reza").add("meysam");
        b.add(34.5).add(56.3).add(21.32);
        System.out.println(a);
        //System.out.println(a.get(0));
        //System.out.println(a.size());
        a.set(2,"hahaha");
        System.out.println(a);
        System.out.println(b);
    }
}
