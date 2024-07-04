import java.util.*;
public class Solution {
    public static class pair implements Comparator<pair>{
        int num;
        int start;
        int time;
        pair(){}
        pair(int num, int time, int start) {
            this.num = num;
            this.start = start;
            this.time = time;
        }
        public int compare(pair one, pair two) {
            if(one.time < two.time) {
                return -1;
            } else if(one.time > two.time) {
                return 1;
            } else {
                return one.start - two.start;
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for(int i = 0; i < t; i++) {
            int n = input.nextInt();
            PriorityQueue<pair> pq = new PriorityQueue<pair>(new pair());
            for(int k = 0; k < n; k++) {
                int start = input.nextInt();
                int end = input.nextInt();
                pq.add(new pair(k, start, start));
                pq.add(new pair(k, end, start));
            }
            int tasks = 0;
            boolean works = true;
            boolean taken1 = false;
            boolean taken2 = false;
            String[] result = new String[n];
            int[] cur = new int[n];
            Arrays.fill(cur, 0);
            while(!pq.isEmpty()) {
                pair temp = pq.remove();
                if(cur[temp.num] == 0) {
                    tasks++;
                    if(tasks >= 3) {
                        works = false;
                        break;
                    }
                    if(!taken1) {
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
                    if(cur[temp.num] == 1) {
                        cur[temp.num] = 0;
                        taken1 = false;
                    } else if(cur[temp.num] == 2) {
                        cur[temp.num] = 0;
                        taken2 = false;
                    }
                }
            }
            System.out.print("Case #" + (i + 1) + ": ");
            if(works) {
                for(int k = 0; k < n; k++) {
                    System.out.print(result[k]);
                }
                System.out.println();
            } else System.out.println("IMPOSSIBLE");
        }
    }
}
