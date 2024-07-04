import java.util.*;
public class Solution {
    
    private static class Node implements Comparable<Node>{
        int ind;
        int time;
        boolean isStart;
        public Node(int ind, int time, boolean isStart) {
            this.ind=ind;
            this.time=time;
            this.isStart=isStart;
        }
        
        public int compareTo(Node that) {
            if (this.time == that.time) {
                if (!this.isStart) {
                    return -1;
                } else if (!that.isStart) {
                    return 1;
                }
                return 0;
            }
            return this.time - that.time;
        }
    }
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            PriorityQueue<Node> pq = new PriorityQueue<>(2*N);
            for (int j = 0; j < N; j++) {
                int S, E;
                S = sc.nextInt();
                E = sc.nextInt();
                pq.add(new Node(j, S, true));
                pq.add(new Node(j, E, false));
            }
            int nbStarting = 0;
            boolean impossible = false;
            char str[] = new char[N];
            boolean Cbusy = false, Jbusy = false;
            while (!pq.isEmpty() && !impossible) {
                Node n = pq.poll();
                if (n.isStart) {
                    nbStarting++;
                    if (nbStarting > 2) {
                        impossible = true;
                        break;
                    } else {
                        if (!Cbusy) {
                            str[n.ind] = 'C';
                            Cbusy = true;
                        } else {
                            str[n.ind] = 'J';
                            Jbusy = true;
                        }
                    }
                } else {
                    nbStarting--;
                    if (str[n.ind] == 'C') {
                        Cbusy = false;
                    } else {
                        Jbusy = false;
                    }
                }
            }
            if (impossible) {
                System.out.println(String.format("Case #%d: %s", i, "IMPOSSIBLE"));
            } else {
                System.out.println(String.format("Case #%d: %s", i, new String(str)));
            }
            
        }
    }
}
