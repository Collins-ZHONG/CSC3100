import java.util.LinkedList;
import java.util.Queue;

public class PracticeQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(5);
        q.offer(10);
        System.out.println(q.poll());
        q.add(15);
        q.remove();
        q.offer(20);
        System.out.println(q.remove());
    }
}