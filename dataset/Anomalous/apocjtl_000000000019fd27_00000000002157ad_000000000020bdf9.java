import java.util.*;

public class Solution {

    public static class Pair implements Comparator<Pair> {
        int num;
        int start;
        int time;

        Pair() {}

        Pair(int num, int time, int start) {
            this.num = num;
            this.start = start;
            this.time = time;
        }

        @Override
        public int compare(Pair one, Pair two) {
            if (one.time != two.time) {
                return Integer.compare(one.time, two.time);
            }
            return Integer.compare(one.start, two.start);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for (int i = 0; i < t; i++) {
            int n = input.nextInt();
            PriorityQueue<Pair> pq = new PriorityQueue<>(new Pair());
            
            for (int k = 0; k < n; k++) {
                int start = input.nextInt();
                int end = input.nextInt();
                pq.add(new Pair(k, start, start));
                pq.add(new Pair(k, end, start));
            }

            int tasks = 0;
            boolean works = true;
            boolean taken1 = false;
            boolean taken2 = false;
            String[] result = new String[n];
            int[] cur = new int[n];
            Arrays.fill(cur, 0);

            while (!pq.isEmpty()) {
                Pair temp = pq.poll();
                if (cur[temp.num] == 0) {
                    tasks++;
                    if (tasks >= 3) {
                        works = false;
                        break;
                    }
                    if (!taken1) {
                        result[temp.num] = "C";
                        taken1 = true;
                        cur[temp.num] = 1;
                    } else {
                        result[temp.num] = "J";
                        taken2 = true;
                        cur[temp.num] = 2;
                    }
                } else {
                    tasks--;
                    if (cur[temp.num] == 1) {
                        cur[temp.num] = 0;
                        taken1 = false;
                    } else if (cur[temp.num] == 2) {
                        cur[temp.num] = 0;
                        taken2 = false;
                    }
                }
            }

            System.out.print("Case #" + (i + 1) + ": ");
            if (works) {
                for (String res : result) {
                    System.out.print(res);
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }

        input.close();
    }
}