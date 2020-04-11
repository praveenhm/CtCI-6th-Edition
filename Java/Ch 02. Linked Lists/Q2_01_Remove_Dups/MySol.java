package Q2_01_Remove_Dups;

import java.util.HashSet;

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
        listImpl.addNode2(10);
        listImpl.addNode2(20);
        listImpl.addNode2(40);
        listImpl.printLinkedList();

        //listImpl.removeDupsBuffer();
        listImpl.removeDups();
        //listImpl.deleteNode(20);
//        listImpl.deleteNode(20);


        //       listImpl.addNode(40);
        //      listImpl.printLinkedList();
//        listImpl.addNode(50);
//        listImpl.printLinkedList();
        //      listImpl.removeNode();
//        listImpl.printLinkedList();
//        listImpl.removeNodeAtCertainIndex(3);
        listImpl.printLinkedList();
    }
}

/*
 *   Linked list
 *
 */
class LinkedListImpl {

    Node head = null, tail = null;

    static class Node {
        int data;
        Node next = null;

        public Node(int d) {
            this.data = d;
        }
    }

    /* remove duplicates without buffer
       page 94, problem 2.1
       use two pointers p1 and p2
       keep one pointer and iterate rest of the loop
     */
    public void removeDups() {
        Node current = null, runner = null;
        current = head;
        while (current != null && current.next != null) {
            runner = current;
            while (runner.next != null) {
                if (current.data == runner.next.data) {
                    runner.next = runner.next.next;   // skip the duplicate/remove
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    /*
    Remove dups using buffer
    This is tricky one, after deleting the pointer should not advance
    10->20->30->10->20->40 // after skipping 10,now 20 is the next node
    10->20->30->X->20->40  // don't advance the pointer, since 20 needs to checked
     */
    public void removeDupsBuffer() {
        Node p1 = null;
        if (head == null) return;
        p1 = head;
        HashSet<Integer> hs = new HashSet<>();
        hs.add(p1.data);
        while (p1 != null && p1.next != null) {
            if (hs.contains(p1.next.data)) {
                p1.next = p1.next.next;
            } else {
                hs.add(p1.next.data);
                p1 = p1.next; // tricky: this should be inside else
            }
        }
    }


    void remove_duplicates() {
        Node ptr1 = null, ptr2 = null, dup = null;
        ptr1 = head;

        /* Pick elements one by one */
        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;

            /* Compare the picked element with rest
                of the elements */
            while (ptr2.next != null) {

                /* If duplicate then delete it */
                if (ptr1.data == ptr2.next.data) {

                    /* sequence of steps is important here */
                    dup = ptr2.next;
                    ptr2.next = ptr2.next.next;
                    System.gc();
                } else /* This is tricky */ {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }

    /*
     * Adds node at the end of the current list
     *  begining ->10 ->20->null end
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
            return;
        }
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
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
            return;
        }
        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next; // skip the node
                return;
            }
            n = n.next;
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