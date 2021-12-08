public class Queue<T>{
    private Object[] s = new Object[10];
    private int N = 0;
    T content;

    private class Node{
        Object object;
        Node next;
    }

    public Queue(int capacity){

    }

    public void enqueue(Object item){
        s[N++] = item;
    }

    public Object dequeue(){
        Object item = s[--N];
        s[N] = null;
        return item;

    }

    public boolean isEmpty(){
        return N == 0;
    }



}