import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    static class Node {
        int r;
        int k;

        public Node(int r, int k) {
            this.r = r;
            this.k = k;
        }

        @Override
        public int hashCode() {
            return (r * k) + k;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return r == node.r &&
                    k == node.k;
        }
    }

    private static Set<Node> set;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            sb.append("Case #").append(i + 1).append(": \n");

            int N = sc.nextInt();
            ArrayList<Node> output = new ArrayList<>();
            set = new HashSet<>();
            traverse(1, 1, 0, N, output, 0);

            for (int j = 0; j < output.size(); j++) {
                sb.append(output.get(j).r + " " + output.get(j).k + "\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static boolean traverse(int r, int k, int sum, int N, List<Node> output, int cnt) {
        if (cnt > 500)
            return false;

        if (sum == N)
            return true;
        else if (sum > N)
            return false;

        if (r < 1 || k < 1 || k > r)
            return false;

        Node n = new Node(r, k);
        if (set.contains(n))
            return false;

        output.add(n);
        set.add(n);
        cnt++;

        int val = fact(r, k);
        sum += val;
        if (traverse(r - 1, k - 1, sum, N, output, cnt)
                || traverse(r, k - 1, sum, N, output, cnt)
                || traverse(r - 1, k, sum, N, output, cnt)
                || traverse(r + 1, k + 1, sum, N, output, cnt)
                || traverse(r, k + 1, sum, N, output, cnt)
                || traverse(r + 1, k, sum, N, output, cnt))
            return true;

        output.remove(output.size() - 1);
        return false;
    }

    private static int fact(int n, int k) {
        if (k == 0 || k == n)
            return 1;
        return fact(n - 1, k - 1) +
                fact(n - 1, k);
    }
}
