package Q2_01_Remove_Dups;

public class MySol2 {
    public static void main(String[] args) {

        //* Your MyLinkedList object will be instantiated and called as such:
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(5);
        obj.addAtTail(4);
        obj.addAtHead(3);
        obj.addAtHead(2);

        int param_1 = obj.get(3);
        obj.addAtHead(8);
        obj.addAtTail(10);
        obj.addAtIndex(5, 100);
        obj.deleteAtIndex(8);

    }

}

class MyLinkedList {


    /**
     * Initialize your data structure here.
     */
    int size;
    Node head;

    public MyLinkedList() {
        size = 0;
        head = null;
    }

    private static class Node {
        private int val;
        private Node next = null;

        public Node(int val) {
            this.val = val;
        }
    }


    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index > size) return -1;
        Node c = head;
        for (int i = 0; i <= index; i++) {
            c = c.next;
        }
        return c.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);

    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {

        if (index > size) return;
        if (index < 0) index = 0;

        ++size;
        Node add = new Node(val);
        if(index ==0) {
            add.next = head;
            head = add;
        }
        Node c = head;

        for (int i = 0; i < index; ++i) {
            c = c.next;
        }
        add.next = c.next;
        c.next = add;

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index > size) return;
              size--;
        if(index==0) {
            head = head.next;
            return;
        }
        Node c = head;
        for (int i = 0; i < index; i++) {
            c = c.next;
        }
        c.next = c.next.next;
    }
}