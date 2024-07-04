import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        int id = 1;
        while (t != 0) {
            int n = sc.nextInt();
            int[] board = new int[24 * 60 + 10];
            boolean impossible = false;
            List<Line> elms = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int a, b;
                a = sc.nextInt();
                b = sc.nextInt();
                elms.add(new Line(a, b, i));
                for (int j = a; j < b; j++) {
                    board[j]++;
                    if (board[j] > 2) {
                        impossible = true;
                    }
                }
            }
            elms.sort(Comparator.comparingInt(v -> v.b));
            int[] mx = new int[n];
            int[] path = new int[n + 1];
            int mx1 = -1;
            int idToTake = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (elms.get(j).b <= elms.get(i).a) {
                        if (mx[j] + 1 > mx[i]) {
                            mx[i] = mx[j] + 1;
                            path[i + 1] = j + 1;
                        }
                    }
                }
                if (mx[i] > mx1) {
                    mx1 = mx[i];
                    idToTake = i + 1;
                }
                sb.append('C');
            }

            do {
                sb.setCharAt(elms.get(idToTake - 1).id, 'J');
                idToTake = path[idToTake];
            } while (idToTake != 0);


            if (impossible)
                sb = new StringBuilder("IMPOSSIBLE");
            System.out.println("Case #" + id + ": " + sb.toString());
            id++;
            t--;
        }
    }

    static class Line {
        int a, b;
        int id;

        public Line(int a, int b, int id) {
            this.a = a;
            this.b = b;
            this.id = id;
        }
    }
}
