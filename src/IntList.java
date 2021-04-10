import java.util.Arrays;

public class IntList {
    private int[] Array;
    private int occupied = 0;

    /*
     * creates an empty IntList
     */
    public IntList(){
        occupied = 0;
        Array = new int[0];
    }

    /*
     * Creates an IntList of given size.All members are set to zero initially.
     *
     * @param size size of list
     */
    public IntList(int size) {
        occupied = size;
        Array = new int[size];
    }

    /**
     * Creates an IntList of given array.
     * @param input an array representing the elements that the IntList will be created of.
     */
    public IntList(int[] input){
        occupied = input.length;
        Array = Arrays.copyOf(input,input.length);
    }

    /**
     * Factory method for creating an IntList of given elements.
     * @param members an array of elements that the IntList will be created of.
     * @return the IntList.
     */
    public static IntList of(int... members){
        return new IntList(members);
    }

    /**
     * To convert the IntList to string representation of it.
     * @return the string representation of the IntList.
     */
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(Array,occupied));
    }

    /**
     * Returns an element from the IntList stored in the given position.
     * @param index index of the element that will be returned.
     * @return the element in the given position.
     */
    public int get(int index){
        return Array[index];
    }

    /**
     * Sets the element of a given index to a given value.
     * @param index the index of the IntList that will be set to given value.
     * @param value the value that will be set in the given index.
     * @return the IntList. For having fluent method chaining.
     */
    public IntList set(int index,int value){
        Array[index] = value;
        return this;
    }

    /**
     * To return the size of the IntList.
     * @return size of the IntList.
     */
    public int size(){
        return occupied;
    }

    /**
     * To determine if the list is empty.
     * @return true, if the list is empty.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    //Checks the given index and yields an exception if the index is out of bounds.
    private void checkIndex(int index) {
        if(index < 0 || index > occupied) {
            throw new IllegalArgumentException("Index is out of bounds: " + index);
        }
    }

    /**
     * Clears the list. Removes all elements.
     */
    public void clear() {
        Array = new int[2];
        occupied = 0;
    }

    //For assuring that the array always has some space for adding a new element
    private void assureCapacity(){
        if (Array.length == occupied)
            Array = Arrays.copyOf(Array,Array.length+1);
    }

    /**
     * Inserting an element inside of the IntList. The following elements will be pushed.
     * @param index the index in which the element will be inserted in.
     * @param value the value that will be inserted in the given index
     * @return the IntList. For having fluent method chaining.
     */
    public IntList insert(int index,int value){
        if (index<0 || index>occupied)
            throw new IllegalArgumentException("index is out of bounds"+ index);

        assureCapacity();

        //If the index == occupied, it means we are adding the element to the end of the IntList, so we don't need to push any elements.
        if (index != occupied)
            System.arraycopy(Array, index, Array, index + 1, occupied - index);
        set(index,value);
        occupied++;
        return this;
    }

    /**
     * Inserts an element to the beginning of the IntList.
     * @param value the value that will be inserted in the beginning of the IntList.
     * @return the IntList. For having fluent method chaining.
     */
    public IntList pushFront(int value){
        return insert(0,value);
    }

    /**
     * Inserts an element to the end of the IntList.
     * @param value the value that will be inserted in the end of the IntList.
     * @return the IntList. For having fluent method chaining.
     */
    public IntList pushBack(int value){
        return insert(occupied,value);
    }

    /**
     * Removes the element from the IntList stored in the given index.
     * @param index the index of the element to be removed.
     * @return the removed element.
     */
    public int remove(int index) {
        if (index < 0 || index > occupied - 1)
            throw new IllegalArgumentException("index is out of bounds" + index);

        int value = Array[index];

        //If the index is pointing to the last element, then we don't need to shift elements.
        if (occupied - 1 - index >= 0)
            System.arraycopy(Array, index + 1, Array, index, occupied - 1 - index);
        occupied--;

        return value;
    }

    /**
     * Removes the first element of the IntList.
     * @return the removed element.
     */
    public int removeFront(){
        return remove(0);
    }

    /**
     * Removes the last element of the IntList.
     * @return the removed element.
     */
    public int removeBack(){
        return remove(occupied-1);
    }


    /**
     * Sorts the list using bubble sort algorithm.
     */
    public void sort(){
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < occupied - 1; i++) {
                if (Array[i] > Array[i+1]) {
                    int temp = Array[i];
                    Array[i] = Array[i + 1];
                    Array[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }

    /**
     * Merge two IntLists. The result will be a sorted array.
     * @param list2 the second IntList.
     * @return a sorted and merged IntList.
     */
    public IntList merge(IntList list2) {
        int iA = 0, iB = 0;
        this.sort();
        list2.sort();
        IntList list3 = new IntList();
        while (iA < this.size() && iB < list2.size()) {
            list3.pushBack(this.get(iA) < list2.get(iB) ? this.get(iA++) : list2.get(iB++));
        }

        if (iA < this.size()) {
            while (iA < this.size()) {
                list3.pushBack(this.get(iA++));
            }
        } else {
            while (iB < list2.size()) {
                list3.pushBack(list2.get(iB++));
            }
        }
        return list3;
    }

    /**
     * This method gets a value and inserts that value to an index in which the list always stays sorted.
     * @param value the value to be stored.
     * @return the IntList.
     */
    public IntList addToAppropriateIndex(int value) {
        for (int i = 0; i < this.size(); i++) {
            if (value < this.get(i)) {
                this.insert(i, value);
                return this;
            }
        }
        this.insert(this.size(), value);

        return this;
    }


    public static void main(String[] args) {
        IntList list = IntList.of(12,78,43,21,13,9,1,64);
        IntList list2 = IntList.of(91,3,54,98);
        //list.insert(0,6).insert(3,8);
        //list.pushBack(10).pushFront(69);
        list.remove(0);
        System.out.println(list);
        System.out.println(list.merge(list2));
        list2.sort();
        list2.addToAppropriateIndex(95);
        System.out.println(list2);
    }
}
