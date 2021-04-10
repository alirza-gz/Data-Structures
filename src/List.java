public interface List<T> {

    int size();

    T get (int index);

    List<T> set(int index,T value);

    List<T> add(T value);

}
