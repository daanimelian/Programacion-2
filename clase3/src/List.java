package clase3.src;

public interface List<T> {

        void addFirst(T o);
        void addLast(T o);
        void removeFirst();
        void removeLast();
        void removeElement(T o);
        T getFirst();
        T getLast();
        int getSize();

        boolean contains(T o);
}
