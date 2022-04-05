
import cs1302.adt.StringList;
import cs1302.adt.FancyStringList;

/**
 * This is an abstract class that implements StringList.
 * This class contains methods that will be inherited by two children
 * {@link ArrayStringList} and {@link LinkedStringList}.
 *
 */

abstract class BaseStringList implements FancyStringList {

    protected int size;

    /**
     * Default constructor.
     */
    public BaseStringList() {

    } // BaseStringList

    /**
     * Creates and returns a new fancy string list that contains the items from this list
     * in reverse order.
     *
     * @return the reversed fancy string list
     * {@inheritDoc}
     */
    @Override
    public abstract FancyStringList reverse();

    /**
     * Adds an item to the string list.
     *
     * @param index the index of the string to be inserted
     * @param item the string to be inserted
     * @return whether or not the operation was successful
     * {@inheritDoc}
     */
    public abstract boolean add(int index, String item);

    /**
     * Adds a the contens of a {@code StringList} object to the list ADT.
     *
     * @param index the index where the {@code StringList} will be inserted
     * @param items the list of items to be inserted
     * @return boolean whether or not the operation was successuful
     * {@inheritDoc}
     */
    @Override
    public boolean add (int index, StringList items) {
        if (items == null) {
            throw new NullPointerException("Item is null.");
        } // if, exception handling
        if (index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        } // if, exception handling

        for (int i = items.size() - 1; i >= 0; i--) {
            this.add(index, items.get(i));
        } // for
        return true;
    } // add

    /**
     * Removes all items from the string list.
     *
     * {@inheritDoc}
     */
    public abstract void clear();

    /**
     * Returns the item at the specified index of this string list.
     *
     * @param index the index of the string to be retrieved
     * @return the string item at {@code index}
     * {@inheritDoc}
     */
    public abstract String get(int index);

    /**
     * Removes the item at the specified index of this string list.
     * Items ater the removed string are then shifted to the left.
     *
     * @param index the index of the string to be removed
     * @return the removed string from {@code index}
     * {@inheritDoc}
     */
    public abstract String remove(int index);

    /**
     * Returns a new string list that contains items between the specified
     * {@code start} and {@code stop} indices by {@code step}.
     * If start and stop are in bounds and equal, the returned string list is empty.
     *
     * @param start the beginning bound of the splice
     * @param stop the ending bound of the splice
     * @param step the distance between retrieved elements
     * @return the new {@link FancyStringList}
     * {@inheritDoc}
     */
    public abstract FancyStringList slice(int start, int stop, int step);

    /**
     * Returns a new string list that contains items between the specified
     * {@code start} and {@code stop}.
     * If start and stop are in bounds and equal, the returned string list is empty.
     *
     * @param start the beginning bound of the splice
     * @param stop the ending bound of the splice
     * @return the new {@link FancyStringList}
     * {@inheritDoc}
     */
    public abstract StringList slice(int start, int stop);


    /**
     * Used to determine if a {@code String} exists within the list ADT.
     *
     * @param start the index from which to start the search
     * @param target the String that is being searched for
     * @return true if the {@code target} was found
     * {@inheritDoc}
     */
    @Override
    public boolean contains(int start, String target) {
        for (int i = start; i < this.size(); i++) {
            if (this.get(i).equals(target)) {
                return true;
            } // if
            // else do nothing
        } // for i
        return false;
    } // contains

    /**
     * Determines the index of the {@code String} {@code target}.
     *
     * @param start the index from which to start the search
     * @param target the String that is being searched for
     * @return the index of the first occurence of {@code target} or -1 if there
     * is no such occurence
     * {@inheritDoc}
     */
    @Override
    public int indexOf(int start, String target) {
        int index = -1;
        for (int i = start; i < this.size(); i++) {
            if (this.get(i).equals(target)) {
                index = i;
            } // if
        } // for i
        return index;
    } // indexOf

    /**
     * Adds a string item to the end of the list by inserting at size().
     * Utilizes the {@code add} method.
     *
     * @param item the String element to be added to the list.
     * @return returns true if the operation was successful, or throws an error.
     * {@inheritDoc}
     */
    @Override
    public boolean append(String item) {
        return this.add(size, item); // method implementation dependent on child
    } // append

    /**
     * Adds a StringList item to the end of the list by inserting at size().
     *
     * @param items the StringList list to be appended to the list
     * @return returns true if the operation was successful or throws an error
     * {@inheritDoc}
     */
    @Override
    public boolean append(StringList items) {
        return this.add(size, items);
    } // append

    /**
     * Adds a string item to the start of the list by inserting at index 0.
     *
     * @param item the string to be added to the list.
     * @return true if the operation was successful, or throws an error.
     * {@inheritDoc}
     */
    @Override
    public boolean prepend(String item) {
        return this.add(0, item);
    } // prepend

    /**
     * Adds a StringList item to the start of the list by inserting at index 0.
     *
     * @param items the StringList to be added to the list
     * @return boolean true if the operation was succesful or throws an error
     * {@inheritDoc}
     */
    @Override
    public boolean prepend(StringList items) {
        return this.add(0, items);
    } // prepend

    /**
     * Returns true if the string list has no items.
     *
     * @return whether or not the list is empty.
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        } // if else

    } // isEmpty

    /**
     * Returns a string representation of this string list that begins with {@code start}
     * and ends with {@code end}, separating each string
     * within the list by {@code sep}.
     *
     * @param start starting string
     * @param sep separating string
     * @param end ending string
     *
     * @return a string representation with the specified modifications.
     * {@inheritDoc}
     */
    @Override
    public String makeString(String start, String sep, String end) {
        String newString = "";
        newString = newString + start;
        for (int i = 0; i < this.size(); i++) {
            newString = newString + this.get(i);
            if (i < this.size() - 1) {
                newString = newString + sep;
            } // if
        } // for i
        newString = newString + end;
        return newString;
    } // makeString

    /**
     * Returns the number of items in this string list.
     *
     * @return int the size of the string list.
     *
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return this.size;
    } // size

    /**
     * Creates and returns a string representation of the string list.
     *
     * @return a string made by utilzing {@code makeString} with
     * "[" "," "]" parameters.
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return this.makeString("[", ", ", "]");
    } // toString


} // BaseStringList
