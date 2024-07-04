import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SquareDance {
    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            sb.append("Case #").append(i + 1).append(": ");

            int R = sc.nextInt();
            int C = sc.nextInt();
            int skillVal = 0;

            int[][] arr = new int[R][C];
            Queue<Node> store = new LinkedList<>();

            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    arr[j][k] = sc.nextInt();
                    skillVal += arr[j][k];
                    store.add(new Node(j, k));
                }
            }

            while (!store.isEmpty()) {
                Queue<Node> temp = new LinkedList<>();
                List<Node> remove = new ArrayList<>();
                int val = 0;

                while (!store.isEmpty()) {
                    Node n = store.poll();
                    if (eliminate(n, arr)) {
                        remove.add(n);
                    } else {
                        val += arr[n.r][n.c];
                        temp.add(n);
                    }
                }

                if (remove.isEmpty()) {
                    break;
                } else {
                    for (Node n : remove) {
                        arr[n.r][n.c] = -1;
                    }
                }
                skillVal += val;
                store = temp;
            }

            sb.append(skillVal + "\n");
        }
        System.out.println(sb.toString());
    }

    private static boolean eliminate(Node n, int[][] arr) {
        int a = 0;
        int b = 0;
        int r = n.r;
        int c = n.c;

        while (--r > -1) {
            if (arr[r][c] != -1) {
                a += arr[r][c];
                b++;
                break;
            }
        }

        r = n.r;
        c = n.c;
        while (--c > -1) {
            if (arr[r][c] != -1) {
                a += arr[r][c];
                b++;
                break;
            }
        }

        r = n.r;
        c = n.c;
        while (++r < arr.length) {
            if (arr[r][c] != -1) {
                a += arr[r][c];
                b++;
                break;
            }
        }

        r = n.r;
        c = n.c;
        while (++c < arr[0].length) {
            if (arr[r][c] != -1) {
                a += arr[r][c];
                b++;
                break;
            }
        }
        if (b == 0)
            return false;
        return a / (double) b > arr[n.r][n.c];
    }
}
