import java.util.*;

public class Solution {

    public static class Pair implements Comparator<Pair> {
        int num;
        int time;

        Pair() {}

        Pair(int num, int time) {
            this.num = num;
            this.time = time;
        }

        @Override
        public int compare(Pair one, Pair two) {
            if (one.time != two.time) {
                return Integer.compare(one.time, two.time);
            }
            return Integer.compare(one.num, two.num);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for (int i = 0; i < t; i++) {
            int n = input.nextInt();
            PriorityQueue<Pair> pq = new PriorityQueue<>(new Pair());

            for (int k = 0; k < n; k++) {
                pq.add(new Pair(k, input.nextInt()));
                pq.add(new Pair(k, input.nextInt()));
            }

            int tasks = 0;
            boolean isPossible = true;
            boolean takenC = false;
            boolean takenJ = false;
            String[] result = new String[n];
            int[] cur = new int[n];
            Arrays.fill(cur, 0);

            while (!pq.isEmpty()) {
                Pair temp = pq.poll();

                if (cur[temp.num] == 0) {
                    tasks++;
                    if (tasks >= 3) {
                        isPossible = false;
                        break;
                    }
                    if (!takenC) {
                        result[temp.num] = "C";
                        takenC = true;
                        cur[temp.num] = 1;
                    } else {
                        result[temp.num] = "J";
                        takenJ = true;
                        cur[temp.num] = 2;
                    }
                } else {
                    tasks--;
                    if (cur[temp.num] == 1) {
                        cur[temp.num] = 0;
                        takenC = false;
                    } else if (cur[temp.num] == 2) {
                        cur[temp.num] = 0;
                        takenJ = false;
                    }
                }
            }

            System.out.print("Case #" + (i + 1) + ": ");
            if (isPossible) {
                for (String res : result) {
                    System.out.print(res);
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}