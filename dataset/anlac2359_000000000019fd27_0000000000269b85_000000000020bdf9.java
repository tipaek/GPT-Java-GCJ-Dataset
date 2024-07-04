import java.util.*;

public class Solution {

    static class Node {
        int point;
        int value;
        int index;

        Node(int p, int v, int i) {
            this.point = p;
            this.value = v;
            this.index = i;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder result;
        boolean flag;
        int T = sc.nextInt();
        int N, s, e, total;
        ArrayList<Node> M = new ArrayList<>();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            for (int i = 1; i <= N; i++) {
                s = sc.nextInt();
                e = sc.nextInt();
                M.add(new Node(s, 1, i));
                M.add(new Node(e, -1, -i));
            }
            M.sort(Comparator.comparingInt(n -> n.point));

            total = 0;

            flag = true;
            for (Node n : M) {
                total += n.value;
                if (total > 2) {
                    flag = false;
                    break;
                }
            }

            if (!flag) {
                result = new StringBuilder("IMPOSSIBLE");
            } else {
                result = new StringBuilder();
                for (int k = 0; k < N; k++) {
                    result.append("o");
                }
                boolean cOk = true;
                char current;
                for (int n = 0; n < 2 * N; n++) {
                    if (M.get(n).index > 0) {
                        if (cOk) {
                            current = 'C';
                            cOk = false;
                        } else {
                            current = 'J';
                        }
                        result.setCharAt(M.get(n).index - 1, current);
                    } else {
                        if (result.charAt(-M.get(n).index - 1) == 'C')
                            cOk = true;
                    }

                }
            }

            System.out.println("Case #" + t + ": " + result);
            M.clear();
        }
    }
}