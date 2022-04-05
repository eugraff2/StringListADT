package cs1302.p2;

import cs1302.adt.StringList;
import cs1302.adt.FancyStringList;

/**
 * This class represents an Array implementation of the {@code StringList} ADT.
 */
public class ArrayStringList extends BaseStringList {

    private String[] items;

    /**
     * Default constructor, sets size to 0, and {@code items.length} to 4.
     */
    public ArrayStringList() {
        this.size = 0;
        items = new String[4];
    } // ArrayStringList

    /**
     * Copy constructor, creates a new ArrayStringList object
     * by creating a deep copy of {@code other}.
     *
     * @param other the StringList which will be used to create a deep copy
     */
    public ArrayStringList(StringList other) {
        this.size = 0;
        items = new String[4];
        this.append(other);
    } // ArrayStringList

    /**
     * This method checks to ensure that the size of the array is adequate to store all
     * of its elements. If the array length is too small, then it increases the size by a magnitude
     * of 1.5
     * Checks the hypothetical size before actually increasing the {@code size} instance variable
     */
    private void adjustSize() {
        if (items.length < size + 1) {
            String[] newItems = new String[(int)(items.length * 1.5)];
            for (int i = 0; i < size; i++) {
                newItems[i] = items[i];
            } // for i
            items = newItems;
        } // if
    } // checkSize

    /**
     * Inserts an item at {@code index} and shifts subsequent elements to the right.
     * Does so by creating a new modified array that {@code items} will then refer to.
     *
     * {@inheritDoc}
     */
    @Override
    public boolean add(int index, String item) {
        if (item == null) {
            throw new NullPointerException("Item is null.");
        } else if (item.equals("")) {
            throw new IllegalArgumentException("Item is empty.");
        } else if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        } // if
        this.adjustSize();
        this.size ++;
        for (int i = size - 1; i > index; i--) {
            items[i] = items[i - 1];
        } // for i
        items[index] = item;
        return true;
    } // add

    /**
     * Points {@code items} to a new empty String array and sets size to 0.
     *
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        String[] newItems = new String[4];
        items =  newItems;
        this.size = 0;
    } // clear

    /**
     * This method retrieves the String item at {@code index}.
     *
     * {@inheritDoc}
     */
    @Override
    public String get(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        } // if
        return items[index];
    } // get

    /**
     * Removes the element at {@code index} and shifts subsequent elements left.
     * Does this by creating a new array and pointing {@code items} towards it.
     *
     * {@inheritDoc}
     */
    @Override
    public String remove(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        } // if
        String removedString = this.get(index);
        String[] newItems = new String[items.length - 1];
        for (int i = 0; i < index; i++) {
            newItems[i] = items[i];
        } // for i
        for (int j = index; j < this.size - 1; j++) {
            newItems[j] = items[j + 1];
        } // for j
        items = newItems;
        this.size --;
        return removedString;
    } // remove

    /**
     * {@inheritDoc}
     */
    @Override
    public FancyStringList slice(int start, int stop, int step) {
        if (start < 0 || stop > this.size() || start > stop) {
            throw new IndexOutOfBoundsException("Illegal endpoint index value.");
        } // if
        FancyStringList newArrayList = new ArrayStringList();
        for (int i = start; i <= stop - 1; i = i + step) {
            newArrayList.append(this.get(i));
        } // for i
        return newArrayList;
    } // slice

    /**
     * {@inheritDoc}
     */
    @Override
    public StringList slice(int start, int stop) {
        if (start < 0 || stop > this.size() || start > stop) {
            throw new IndexOutOfBoundsException("Illegal endpoint index value.");
        } // if
        StringList newArrayList = new ArrayStringList();
        for (int i = start; i <= stop - 1; i++) {
            newArrayList.append(this.get(i));
        } // for i
        return newArrayList;
    } // slice

    /**
     * {@inheritDoc}.
     */
    public FancyStringList reverse() {
        FancyStringList rev = new ArrayStringList();
        for (int i = 0; i < this.size(); i++) {
            rev.prepend(this.get(i));
        } // for i
        return rev;
    } // reverse

} // ArrayStringList
