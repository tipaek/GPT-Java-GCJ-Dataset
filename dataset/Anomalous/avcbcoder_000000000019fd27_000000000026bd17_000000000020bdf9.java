import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            System.out.print("Case #" + i + ": ");
            solve(sc);
        }
    }

    public static void solve(Scanner sc) throws Exception {
        int n = sc.nextInt();
        Pair[] pairs = new Pair[n];
        
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            pairs[i] = new Pair(a, b, i);
        }

        Arrays.sort(pairs);
        int c = 0, j = 0;
        
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i].start >= c) {
                c = pairs[i].end;
                pairs[i].work = 0;
            } else if (pairs[i].start >= j) {
                j = pairs[i].end;
                pairs[i].work = 1;
            } else {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }

        char[] result = new char[n];
        for (Pair pair : pairs) {
            result[pair.id] = pair.work == 0 ? 'C' : 'J';
        }
        System.out.println(new String(result));
    }

    public static class Pair implements Comparable<Pair> {
        int start, end, id, work;

        Pair(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
            this.work = -1;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.start != other.start) {
                return this.start - other.start;
            }
            return this.end - other.end;
        }

        @Override
        public String toString() {
            return "{" + this.start + " " + this.end + "}";
        }
    }
}