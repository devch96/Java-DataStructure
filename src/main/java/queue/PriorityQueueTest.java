package queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    static class Task {
        int priority;
        String title;

        public Task(int priority, String title) {
            this.priority = priority;
            this.title = title;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Task> pq = new PriorityQueue<>((t1, t2) -> {
            return t1.priority - t2.priority;   // t1, t2 를 바꿀 경우 역순 가능
        });

        pq.add(new Task(1, "알고리즘 문제 풀기"));
        pq.add(new Task(2, "포트폴리오 정리하기"));
        pq.add(new Task(3, "공고 칮이보기"));
        pq.add(new Task(4, "키보드 청소하기"));

        while (!pq.isEmpty()) {
            Task task = pq.poll();
            System.out.println("[중요도: " + task.priority + "] " + task.title);
        }
    }
}
