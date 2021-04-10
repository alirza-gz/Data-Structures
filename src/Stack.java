import java.util.NoSuchElementException;

public class Stack {
    private IntList list = new IntList();

    public int size(){
        return list.size();
    }

    public Stack push(int v){
        list.pushBack(v);
        return this;
    }

    public void assureNotEmpty(){
        if (size() == 0)
            throw new NoSuchElementException("The Stack is empty.");
    }

    public int pop(){
        assureNotEmpty();
        return list.removeBack();
    }

    public int top(){
        if (isEmpty()) assureNotEmpty();
        return list.get(size() - 1);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(4).push(8).push(9);
        System.out.println(s);
        System.out.println(s.isEmpty());
        //System.out.println(s.top());
        //System.out.println(s.size());
        //System.out.println(s.top());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s);
        System.out.println(s.isEmpty());
        System.out.println(s.top());
    }
}
