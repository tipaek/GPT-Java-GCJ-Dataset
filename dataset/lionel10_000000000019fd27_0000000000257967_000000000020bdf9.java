import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    static PriorityQueue<Node> pq;
    static Node[] arr;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = scan.nextInt();
            arr = new Node[n];
            pq = new PriorityQueue<>((a, b) -> a.s - b.s);
            for (int i = 0; i < n; i++) {
                int s = scan.nextInt(), e = scan.nextInt();
                Node temp = new Node(s, e);
                arr[i] = temp;
                pq.add(temp);
            }
            System.out.println("Case " + t + ": " + solve(n));
        }
    }
    static String solve (int n) {
        int j = -1, c = -1;
        boolean imp = false;
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (curr.s >= j) {
                j = curr.e;
                curr.str = "J";
            }else if (curr.s >= c) {
                c = curr.e;
                curr.str = "C";
            }else {
                return "IMPOSSIBLE";
            }
        }
        String res = "";
        for (Node job: arr) {
            res += job.str;
        }
        return res;
    }
}
class Node {
    int s, e;
    String str = "";
    public Node(int s, int e) {
        this.s = s;
        this.e = e;
    }
}