package Q2_01_Remove_Dups;

/**
 * Linked list implementations
 */
public class MySol {
    public static void main(String[] args) {
        System.out.println("linked list");

        LinkedListImpl listImpl = new LinkedListImpl();
        listImpl.addNode2(10);
        listImpl.addNode2(20);
        listImpl.addNode2(30);
        listImpl.deleteNode(30);

        listImpl.addNode(40);
//        listImpl.printLinkedList();
//        listImpl.addNode(50);
//        listImpl.printLinkedList();
//        listImpl.removeNode();
//        listImpl.printLinkedList();
//        listImpl.removeNodeAtCertainIndex(3);
        listImpl.printLinkedList();
    }
}

class LinkedListImpl {
    Node head = null, tail = null;

    static class Node {
        int data;
        Node next = null;

        public Node(int d) {
            this.data = d;
        }
    }


    /*
     * Adds node at the end of the current list
     */
    public void addNode(int d) {
        Node n = new Node(d);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            n.next = head;
            head = n;
        }
    }

    /*
     * Just using head, no tail
     * append to tail
     */
    public void addNode2(int d) {
        Node end = new Node(d);
        if (head == null) {
            head = end;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        }
    }

    /*
     * Adds node at the certain index.
     */
    public void addNodeAtCertainIndex(int d, int index) {
        Node n = head;
        int count = 0;
        while (n != null && ++count != index)
            n = n.next;
        Node node = new Node(d);
        node.next = n.next;
        n.next = node;
    }

    /*
     * Removes the last node in the given list and updates tail node
     */
    public void removeNode() {
        Node n = head;
        while (n.next != null && n.next.next != null) {
            n = n.next;
        }
        n.next = null;
        tail = n;
    }

    public void deleteNode(int d) {
        Node n = head;
        if (n.data == d) {
            head = head.next; // carefull head.next = head is totally wrong
        } else {
            while (n.next != null) {
                if (n.next.data == d) {
                    n.next = n.next.next;
                } else {
                    n = n.next;
                }
            }
        }
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
        Node n = head;
        int count = 0;
        while (n != null && ++count != index)
            n = n.next;
        n.data = n.next.data;
        n.next = n.next.next;
    }

    /*
     * Checks if a node with the given due exist in the list, returns true or false.
     * Alternatively you can return the index too.
     */
    public boolean search(int target) {
        Node n = head;
        while (n != null) {
            if (n.data == target)
                return true;
        }
        return false;

    }

    /*
     * Checks if a node with the given due exist in the list, returns the index of the given due in the list.
     */
    public int searchAndReturnIndex(int target) {
        Node n = head;
        int count = 0;
        while (n != null) {
            count++;
            if (n.data == target) return count;
        }
        return -1;
    }

    /*
     * Prints the current list
     */

    public void printLinkedList() {
        System.out.println();
        Node n = head;
        while (n != null) {
            System.out.print(" " + n.data);
            n = n.next;
        }
    }


}