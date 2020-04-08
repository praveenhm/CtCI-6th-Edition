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

//        listImpl.addNode(40);
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

        public Node(int data) {
            this.data = data;
        }
    }


    /*
     * Adds node at the end of the current list
     */
    public void addNode(int data) {
        if (head == null) {
            Node tmp = new Node(data);
            head = tmp;
            tail = tmp;
        } else {
            tail.next = new Node(data);
            tail = tail.next;
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
    public void addNodeAtCertainIndex(int data, int index) {
        Node tmp = head;
        int count = 0;
        while (tmp != null && ++count != index)
            tmp = tmp.next;
        Node node = new Node(data);
        node.next = tmp.next;
        tmp.next = node;
    }

    /*
     * Removes the last node in the given list and updates tail node
     */
    public void removeNode() {
        Node tmp = head;
        while (tmp.next != null && tmp.next.next != null) {
            tmp = tmp.next;
        }
        tmp.next = null;
        tail = tmp;
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
        Node tmp = head;
        int count = 0;
        while (tmp != null && ++count != index)
            tmp = tmp.next;
        tmp.data = tmp.next.data;
        tmp.next = tmp.next.next;
    }

    /*
     * Checks if a node with the given dataue exist in the list, returns true or false.
     * Alternatively you can return the index too.
     */
    public boolean search(int target) {
        Node tmp = head;
        while (tmp != null) {
            if (tmp.data == target)
                return true;
        }
        return false;

    }

    /*
     * Checks if a node with the given dataue exist in the list, returns the index of the given dataue in the list.
     */
    public int searchAndReturnIndex(int target) {
        Node tmp = head;
        int count = 0;
        while (tmp != null) {
            count++;
            if (tmp.data == target) return count;
        }
        return -1;
    }

    /*
     * Prints the current list
     */

    public void printLinkedList() {
        System.out.println();
        Node tmp = head;
        while (tmp != null) {
            System.out.print(" " + tmp.data);
            tmp = tmp.next;
        }
    }


}