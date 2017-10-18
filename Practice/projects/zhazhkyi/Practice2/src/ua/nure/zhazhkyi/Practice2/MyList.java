package ua.nure.zhazhkyi.Practice2;

/**
 * Created by Igor Zhazhky on 08.07.2017.
 */
public interface MyList extends Iterable<Object> {
    void add(Object e);

    void clear();

    boolean remove(Object o);

    Object[] toArray();

    int size();

    boolean contains(Object o);

    boolean containsAll(MyList c);
}
