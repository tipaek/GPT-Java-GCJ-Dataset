import java.util.*;

public class Solution {
    static class Node implements Comparable<Node>{
        int start;
        int end;
        int index;
        Node(int s, int e, int i){
            start = s;
            end = e;
            index = i;
        }
        @Override
        public int compareTo(Node node) {
            return this.end >= node.end ? 1 : -1;
        }

    }
    public static void main(String[] args) {
        Scanner x =new Scanner(System.in);
        int T = x.nextInt();
        int TN = 0;
        while (TN++ < T) {
            int M = x.nextInt();
            Node[] nodes = new Node[M];
            for (int i = 0; i < M; i++) {
                int start = x.nextInt();
                int end = x.nextInt();
                nodes[i] = new Node(start, end, i);
            }
            String answer = help(nodes);
            System.out.println(String.format("Case #%d: %s", TN, answer));
        }
    }

    public static String help(Node[] nodes) {
        if (nodes == null)
            return "";
        int size = nodes.length;
        if (size == 0)
            return "";
        if (size == 1)
            return "C";
        char[] res = new char[size];
        Arrays.sort(nodes);
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (nodes[i].start >= max1) {
                res[nodes[i].index] = 'C';
                max1 = Math.max(max1, nodes[i].end);
            } else if (nodes[i].start >= max2) {
                res[nodes[i].index] = 'J';
                max2 = Math.max(max2, nodes[i].end);
            } else {
                return "IMPOSSIBLE";
            }
        }
        return String.valueOf(res).replace(",","").replace("[","").replace("]","");
    }
}