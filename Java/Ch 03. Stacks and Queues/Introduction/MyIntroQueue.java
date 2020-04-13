package Introduction;

import java.util.NoSuchElementException;

public class MyIntroQueue {

    public static void main(String[] args) {

        MyQueue2<Integer> myq = new MyQueue2<Integer>();
        try {
            System.out.println(myq.isEmpty());
            myq.add(10);
            myq.add(20);
            myq.add(30);
            myq.remove();
            System.out.println(myq.peek());
            myq.remove();
            myq.remove();
            myq.remove();
            myq.remove();
            myq.remove();
            myq.remove();

            myq.add(40);
            myq.add(50);
        System.out.println(myq.peek());

        }catch(NoSuchElementException e){
            System.out.println("oops");
        }
    }
}

class MyQueue2<T> {
    private static class Queue<T> {

        private T data;
        private Queue next;

        public Queue(T data) {
            this.data = data;
        }
    }

    private Queue<T> first;
    private Queue<T> last;

    public void add(T item) {
        Queue<T> t = new Queue<>(item);
        if (last != null) {
            last.next = t;
        }
        last = t;
        if (first == null) {
            first = last;
        }
    }

    public T remove() {
        if (first == null) throw new NoSuchElementException();
        T item = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return item;
    }

    public T peek(){
        if(first == null) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty(){
        return first == null;
    }
}
