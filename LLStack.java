// package CSC3100;

public class LLStack {
    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top = null;
    private int size = 0;

    public boolean isEmpty() {
        return size==0;
    }

    public void push(int e) {
        if (!isEmpty()) {
            top.next = top;
        }
        top = new Node(e);
    }

    public int pop() {
        int ans = top.data;
        top = top.next;
        return ans;
    }

}