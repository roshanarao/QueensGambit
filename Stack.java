public class Stack<T> {
    private Node first = null;

    private class Node{
        T object;
        Node next;
    }

    public Stack(int capacity){
        
    }

    public void push(T item){
        Node oldfirst = first;
        first = new Node();
        first.object = item;
        first.next = oldfirst;
    }

    public T pop(){
        T item = first.object;
        first = first.next;
         return item;
    }

    public boolean isEmpty(){
        return first == null;
    }
    



















}