import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            ArrayList<Pair> ar = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                ar.add(new Pair(scanner.nextInt(), 1, j));
                ar.add(new Pair(scanner.nextInt(), -1, j));
            }

            Collections.sort(ar);

            int countC = 0;
            int countJ = 0;
            boolean[] ans = new boolean[n];
            boolean impossible = false;

            for(Pair cur: ar) {
                if(cur.factor == 1) {
                    if(countC == 0 && countJ == 0) {
                        countC++;
                    }
                    else if(countC == 1 && countJ == 0) {
                        ans[cur.num] = true;
                        countJ++;
                    }
                    else if(countC == 0 && countJ == 1) {
                        countC++;
                    }
                    else {
                        System.out.println("Case #" + (i + 1) + ": " + "IMPOSSIBLE");
                        impossible = true;
                        break;
                    }
                }
                else {
                    if(ans[cur.num]) {
                        countJ--;
                    }
                    else {
                        countC--;
                    }
                }

            }

            String answer = "";

            for (int j = 0; j < ans.length; j++) {
                if(ans[j]) {
                    answer += "J";
                }
                else {
                    answer += "C";
                }
            }


            if(!impossible) {
                System.out.println("Case #" + (i + 1) + ": " + answer);
            }
        }
    }
}
class Pair implements Comparable<Pair>{
    public int time;
    public int factor;
    public int num;

    public Pair(int time, int factor, int num) {
        this.time = time;
        this.factor = factor;
        this.num = num;
    }

    @Override
    public int compareTo(Pair o) {
        if(this.time == o.time) {
            return this.factor - o.factor;
        }
        return this.time - o.time;
    }
}