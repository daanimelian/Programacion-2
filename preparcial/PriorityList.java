package preparcial;

import clase2.src.MyException;

public interface PriorityList <P,E>{

    public void addFirst(E newElement, P priority );
    public void addLast(E newElement, P priority );
    public void removeFirst() throws MyException;
    public void removeLast() throws MyException;
    public void remove(E element) throws MyException;
    public void First();
    public void advance();
    public E getCurrent();
    public boolean atEnd();
    public int getSize();
    public void removeAllPriority(P priority);
    public E[] sortedByPriority();

}
