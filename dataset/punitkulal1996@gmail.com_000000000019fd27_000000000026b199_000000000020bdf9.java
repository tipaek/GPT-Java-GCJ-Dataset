import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int N = s.nextInt();
            List<Node> order = new LinkedList<>();
            Queue<Node> priorityQueue = new PriorityQueue<>(N);
            boolean isImpossible = false;
            int C=0,J=0;
            for (int j = 0; j < N; j++) {
                int startTime = s.nextInt();
                int endTime = s.nextInt();
                Node node = new Node(startTime,endTime);
                order.add(node);
                priorityQueue.add(node);

            }
            for (int j = 0; j < N; j++) {
                Node node = priorityQueue.poll();
                assert node != null;
                if (node.startTime >= C){
                    C = node.endTime;
                    node.assigned = 'C';
                }else if (node.startTime >= J){
                    J = node.endTime;
                    node.assigned = 'J';
                }else {
                    isImpossible = true;
                    break;
                }

            }
            if (isImpossible){
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            }else{
                StringBuilder sb = new StringBuilder();
                for (Node node:order) {
                    sb.append(node.assigned);
                }
                System.out.println("Case #"+(i+1)+": "+sb.toString());
            }

        }
    }
}

class Node implements Comparable<Node> {
    int startTime;
    int endTime;
    Character assigned;


    Node(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }


    @Override
    public int compareTo(Node o) {
        if (this.startTime == o.startTime){
            return  this.endTime - o.endTime;
        }else{
            return  this.startTime - o.startTime;
        }
    }
}
