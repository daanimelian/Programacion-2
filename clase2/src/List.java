package clase2.src;

public interface List {

    void addFirst(Float o);
    void addLast(Float o);
    void removeFirst();
    void removeLast();
    void removeElement(Float o);
    Float getFirst();
    Float getLast();
    Float getCurrent();
    int getSize();

}
