package cs1302.p2;

import cs1302.adt.Node;
import cs1302.adt.StringList;
import cs1302.adt.FancyStringList;

/**
 * This class represents a linked list implementation of the {@code StringList} ADT.
 */
public class LinkedStringList extends BaseStringList {

    private Node head;

    /**
     * Default constructor, sets size to 0.
     */
    public LinkedStringList() {
        this.size = 0;
    } // LinkedStringList

    /**
     * Copy constructor, creates a deep copy from {@code other}.
     *
     * @param other the StringList used to create a deepy copy
     */
    public LinkedStringList(StringList other) {
        this.size = 0;
        this.add(0, other);
    } // LinkedStringList

    /**
     * This method goes through the linked list of nodes to access the node at {@code index}.
     * Loops through the nodes utilizing {@code getNext()}.
     *
     * @param index the index of the node to be retrieved
     * @return the node that was accessed
     */
    private Node getNode(int index) {
        Node target = head;
        for (int i = 0; i < index; i++) {
            target = target.getNext();
        } // for i
        return target;
    } // getNode

    /**
     * Inserts a new node using a slightly different method depending on where the node is inserted.
     *
     * {@inheritDoc}
     */
    @Override
    public boolean add(int index, String item) {
        if (item == null) {
            throw new NullPointerException("Item is null.");
        } else if (item.equals("")) {
            throw new IllegalArgumentException("Item is empty.");
        } else if (index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        } // if

        size ++;
        if (index == 0 && size == 1) {
            head = new Node(item);
        } else if (index == 0 && size != 1) {
            head = new Node(item, head);
        } else if (index == size - 1) {
            Node addedNode = new Node(item);
            this.getNode(index - 1).setNext(addedNode);
        } else {
            Node currentNode = this.getNode(index - 1);
            Node addedNode = new Node(item, currentNode.getNext());
            currentNode.setNext(addedNode);
        } // if else conditional tree
        return true;
    } // add

    /**
     * Clears the {@code StringList} by setting the head to {@code null}.
     *
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        head = null;
        this.size = 0;
    } // clear

    /**
     * Retrieves the String at {@code index} by utilizing the
     * {@code getNode} method.
     *
     * {@inheritDoc}
     */
    @Override
    public String get(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        } // if
        return this.getNode(index).getItem();
    } // get

    /**
     * Removes the node at {@code index} by setting the {@code next} value of the
     * previous node to the node after the {@code index} node.
     * If the node at {@code index} is the head, then head is set to reference the next node.
     *
     * {@inheritDoc}
     */
    @Override
    public String remove(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        } // if
        String removedItem = this.getNode(index).getItem();

        if (this.getNode(index) == head) {
            head = this.getNode(index).getNext();
        } else {
            this.getNode(index - 1).setNext(this.getNode(index).getNext());
        } // if else
        size --;
        return removedItem;
    } // remove

    /**
     * Uses the {@code add} method to return a sliced LinkedList between the
     * {@code start} and {@code stop} indices by {@code step}.
     *
     * {@inheritDoc}
     */
    @Override
    public FancyStringList slice(int start, int stop, int step) {
        if (start < 0 || stop > this.size() || start > stop) {
            throw new IndexOutOfBoundsException("Illegal endpoint index value.");
        } // if
        FancyStringList slicedLinkedList = new LinkedStringList();
        for (int i = start; i < stop; i = i + step) {
            slicedLinkedList.append(this.getNode(i).getItem());
        } // for i
        return slicedLinkedList;
    } // slice

    /**
     * {@inheritDoc}.
     */
    public StringList slice(int start, int stop) {
        if (start < 0 || stop > this.size() || start > stop) {
            throw new IndexOutOfBoundsException("Illegal endpoint index value.");
        } // if
        StringList slicedLinkedList = new LinkedStringList();
        for (int i = start; i < stop; i++) {
            slicedLinkedList.append(this.getNode(i).getItem());
        } // for i
        return slicedLinkedList;
    } // slice

    /**
     * {@inheritDoc}.
     */
    @Override
    public FancyStringList reverse() {
        FancyStringList rev = new LinkedStringList();
        for (int i = 0; i < this.size(); i++) {
            rev.prepend(this.getNode(i).getItem());
        } // for i
        return rev;
    } // reverse

} // LinkedStringList
