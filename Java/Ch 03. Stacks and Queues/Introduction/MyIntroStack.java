package Introduction;

import java.util.EmptyStackException;

public class MyIntroStack {

    public static void main(String[] args) {
        MyStack2<Integer> s1 = new MyStack2<Integer>();
        s1.push(10);
        s1.push(20);
        System.out.println(s1.peek());
        s1.push(30);
        System.out.println(s1.peek());
        s1.pop();
        System.out.println(s1.isEmpty());
    }

}

class MyStack2<T>{
    private static class Stack<T>{
        private T data;
        private Stack<T> next;

        public Stack(T data){
            this.data = data;
        }
    }

    private Stack<T> Top;

    public T pop(){
        if(Top == null) throw new EmptyStackException();
        T item = Top.data;
        Top = Top.next;
        return item;
    }

    public void push(T item){
        Stack<T> temp = new Stack<>(item);
        temp.next = Top;
        Top = temp;
    }

    public T peek(){
        if(Top == null) throw new EmptyStackException();
        return Top.data;
    }

    public boolean isEmpty(){
        return Top == null;
    }
}