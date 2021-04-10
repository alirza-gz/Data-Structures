import java.util.NoSuchElementException;

public class IntLinkedList {
    /**
     * This class is an abstract data structure for storing each entity of the linked list. Each Node contains a value and
     * another Node reference. The goal is to chain these nodes together and make a whole data structure called LinkedList.
     */
    private static class Node {
        private int value;
        private Node next; //Reference of the Node in which this Node must be connected to and that node comes after this node.

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    /**
     * Store the first Node of the list as the head.
     */
    private Node head = null;

    /**
     * Store the last Node of the list as the tail.
     */
    private Node tail = null;

    /**
     * Store the size of the list.
     */
    private int size = 0;

    /**
     * To return the size of list.
     * @return size of the list.
     */
    public int size() {
        return size;
    }

    /**
     * Check to see if the list is empty or not.
     * @return true if the list is empty.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * To add a value to the beginning of the list.
     * @param value the value to be added.
     * @return the list itself.
     */
    public IntLinkedList addFront(int value) {
        head = new Node(value, head);

        if (isEmpty()) {
            tail = head;
        }

        size++;

        return this;
    }

    /**
     * To add a value to the end of the list.
     * @param value the value to be added.
     * @return the list itself.
     */
    public IntLinkedList addLast(int value) {
        Node node = new Node(value, null);

        if (isEmpty()) {
            head = node;
        } else {
            tail.setNext(node);
        }

        tail = node;

        size++;

        return this;
    }

    /**
     * To return the value stored in the given index.(The value of the node in the given position)
     * @param index the index of the value to be returned.
     * @return the value.
     */
    public int get(int index) {
        if (isEmpty() || index < 0) {
            throw new NoSuchElementException("Index is out of bounds: " + index);
        }

        Node current = findTheRightNode(index, 1);

        return current.getValue();
    }

    /**
     * A helper method for finding the right node that we are looking for based on the index. There is a difference
     * between the operation in which we need this method. In the get() method, we need the exact Node in the given
     * position, but in the insert() method we need the previous Node of the given position. So, for making this difference
     * we get a second argument called operation.
     * @param index the position in which we are looking for the node at that position.
     * @param operation determines that if we want to return the exact node in the given position, or the previous node of
     *                  that position. 1 means the exact node. 2 means the previous node.
     * @return the found Node.
     */
    private Node findTheRightNode(int index, int operation) {
        Node current = head;
        int i = 0;
        if (operation == 1) {
            while (i != index) {
                current = current.getNext();
                i++;

                if (current == null) {
                    throw new NoSuchElementException("Index is out of bounds: " + index);
                }
            }
        } else if (operation == 2) {
            while (i != index - 1) {
                current = current.getNext();
                i++;

                if (current == null) {
                    throw new NoSuchElementException("Index is out of bounds: " + index);
                }
            }
        }


        return current;
    }

    /**
     * To insert a value into the LinkedList into the given position.
     * @param index the position in which the value will be stored.
     * @param value the value to be stored.
     * @return the list itself.
     */
    public IntLinkedList insert(int index, int value) {
        if (index == 0) {
            return addFront(value);
        } else if (index == size) {
            return addLast(value);
        }

        Node nodeInIndex = findTheRightNode(index, 2);

        Node newNode = new Node(value, nodeInIndex.getNext());

        nodeInIndex.setNext(newNode);

        return this;
    }

    /**
     * To delete the first value from the list.
     * @return the deleted value.
     */
    public int deleteFront() {
        Node exactNode = findTheRightNode(0, 1);
        int value = exactNode.getValue();

        head = head.getNext();

        return value;
    }

    /**
     * To delete the last value of the list.
     * @return the deleted value.
     */
    public int deleteLast() {
        Node previousNode= findTheRightNode(size -1, 2);;
        Node exactNode = findTheRightNode(size - 1, 1);
        int value = exactNode.getValue();

        previousNode.setNext(null);
        tail = previousNode;

        return value;
    }

    /**
     * To remove a value from the list.
     * @param index the index of the value to be removed.
     * @return the removed value.
     */
    public int delete(int index) {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException("Index is out of bounds: " + index);
        }

        if (index == 0) {
            return deleteFront();
        } else if (index == size - 1) {
            return deleteLast();
        }

        Node previousNode = findTheRightNode(index, 2);
        Node exactNode = findTheRightNode(index, 1);

        int value = exactNode.getValue();

        previousNode.setNext(exactNode.getNext());

        return value;
    }

    // Method to print the LinkedList.
    public static void printList(IntLinkedList list) {
        Node currNode = list.head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.value + " ");

            // Go to next node
            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {
        IntLinkedList list = new IntLinkedList();

        list.addLast(1).addLast(9).addLast(7).addLast(2);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println("---------------------------------");



        list.deleteFront();
        list.insert(1,6);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        printList(list);


    }
}

