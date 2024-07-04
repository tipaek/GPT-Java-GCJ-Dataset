import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        for (int cases = 1; cases <= T; cases++) {
            int counter = 0;
            LinkedList<Pair> same = new LinkedList<>();
            LinkedList<Pair> different = new LinkedList<>();

            for (int i = 1; i <= 5; i++) {
                System.out.println(i);
                int x = Integer.parseInt(br.readLine());
                System.out.println(B - i + 1);
                int y = Integer.parseInt(br.readLine());

                if (x == y) {
                    same.add(new Pair(x, y, i));
                } else {
                    different.add(new Pair(x, y, i));
                }
                counter += 2;
            }

            if (counter >= B) {
                printAnswer(same, different, B);
                continue;
            }

            for (int i = 6; i <= B / 2; i++) {
                if ((i - 2) % 4 == 0) {
                    handleQuery(same, different);
                }

                System.out.println(i);
                int x = Integer.parseInt(br.readLine());
                System.out.println(B - i + 1);
                int y = Integer.parseInt(br.readLine());

                if (x == y) {
                    same.add(new Pair(x, y, i));
                } else {
                    different.add(new Pair(x, y, i));
                }
                counter += 2;

                if (counter >= B) {
                    break;
                }
            }

            printAnswer(same, different, B);
        }
    }

    private static void handleQuery(LinkedList<Pair> same, LinkedList<Pair> different) throws IOException {
        if (!same.isEmpty()) {
            System.out.println(same.peek().index);
            int temp = Integer.parseInt(br.readLine());
            if (temp != same.peek().first) {
                for (Pair p : same) {
                    p.update();
                }
            }
        } else {
            System.out.println(different.peek().index);
            int temp = Integer.parseInt(br.readLine());
        }

        if (!different.isEmpty()) {
            System.out.println(different.peek().index);
            int temp = Integer.parseInt(br.readLine());
            if (temp != different.peek().first) {
                for (Pair p : different) {
                    p.update();
                }
            }
        } else {
            System.out.println(same.peek().index);
            int temp = Integer.parseInt(br.readLine());
        }
    }

    private static void printAnswer(LinkedList<Pair> same, LinkedList<Pair> different, int B) throws IOException {
        int[] ans = new int[B + 1];
        for (Pair p : same) {
            ans[p.index] = p.first;
            ans[B - p.index + 1] = p.second;
        }
        for (Pair p : different) {
            ans[p.index] = p.first;
            ans[B - p.index + 1] = p.second;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= B; i++) {
            answer.append(ans[i]);
        }

        System.out.println(answer);
        char result = br.readLine().charAt(0);

        if (result != 'Y') {
            System.exit(0);
        }
    }

    static class Pair {
        int first;
        int second;
        int index;

        Pair(int first, int second, int index) {
            this.first = first;
            this.second = second;
            this.index = index;
        }

        void update() {
            if (first == second) {
                first = 1 - first;
                second = first;
            } else {
                first = second;
                second = 1 - first;
            }
        }
    }
}