package Q2_01_Remove_Dups;

/**
 * Linked list implementations
 */
public class MySol {
    public static void main(String[] args) {
        System.out.println("linked list");

        LinkedListImpl listImpl = new LinkedListImpl();
        listImpl.addNode(10);
        listImpl.addNode(20);
        listImpl.addNode(30);
        listImpl.addNode(40);
        listImpl.printLinkedList();
        listImpl.addNode(50);
        listImpl.printLinkedList();
        listImpl.removeNode();
        listImpl.printLinkedList();
        listImpl.removeNodeAtCertainIndex(3);
        listImpl.printLinkedList();
    }

}

class LinkedListImpl {
    Node head = null, tail = null;

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    /*
     * Adds node at the end of the current list
     */
    public void addNode(int data) {
        if (head == null) {
            Node temp = new Node(data);
            head = temp;
            tail = temp;
        } else {
            tail.next = new Node(data);
            tail = tail.next;
        }
    }

    /*
     * Adds node at the certain index.
     */
    public void addNodeAtCertainIndex(int data, int index) {
        Node temp = head;
        int count = 0;
        while (temp != null && ++count != index)
            temp = temp.next;
        Node node = new Node(data);
        node.next = temp.next;
        temp.next = node;
    }

    /*
     * Removes the last node in the given list and updates tail node
     */
    public void removeNode() {
        Node temp = head;
        while (temp.next != null && temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
    }

    /*
     * Removes the first node in the given list and updates head node
     *
     */
    public void removeNodeAtStart() {
        //The first node would become zombie and should be garbage collected after the below operation
        head = head.next;
    }

    /*
     * Removes the node at the given index in the given list and updates head node
     *
     */
    public void removeNodeAtCertainIndex(int index) {
        Node temp = head;
        int count = 0;
        while (temp != null && ++count != index)
            temp = temp.next;
        temp.data = temp.next.data;
        temp.next = temp.next.next;
    }

    /*
     * Checks if a node with the given dataue exist in the list, returns true or false.
     * Alternatively you can return the index too.
     */
    public boolean search(int target) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == target)
                return true;
        }
        return false;

    }

    /*
     * Checks if a node with the given dataue exist in the list, returns the index of the given dataue in the list.
     */
    public int searchAndReturnIndex(int target) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            if (temp.data == target) return count;
        }
        return -1;
    }

    /*
     * Prints the current list
     */

    public void printLinkedList() {
        System.out.println();
        Node temp = head;
        while (temp != null) {
            System.out.print(" " + temp.data);
            temp = temp.next;
        }
    }


}