import java.util.NoSuchElementException;

public class Queue {
    private IntList list = new IntList();


    public int size(){
        return list.size();
    }

    public Queue add(int v){
        list.pushBack(v);
        return this;
    }

    public void assureNotEmpty(){
        if (size() == 0)
            throw new NoSuchElementException("Queue is empty");
    }

    public int take(){
        assureNotEmpty();
        return list.removeFront();
    }

    public int head(){
        assureNotEmpty();
        return list.get(0);
    }

    public int tail(){
        assureNotEmpty();
        return list.get(size() - 1);
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(7).add(8).add(9);
        System.out.println(q);
        System.out.println(q.size());
        System.out.println(q.head());
        System.out.println(q.tail());
        System.out.println(q.take());
        System.out.println(q.take());
        System.out.println(q.take());
        System.out.println(q);
    }
}
