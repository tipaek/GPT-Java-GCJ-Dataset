import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static class Pair {
        int x,y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int t = 1; t <= tests; t++) {
            ArrayList<Pair> sol = new ArrayList<>();
            int sum = sc.nextInt();
            sol.add(new Pair(1,1));
            System.out.println("Case #" + t + ": ");
            if(sum <= 500) {
                for(int i=1; i<=sum;i++) {
                    System.out.println(i + " 1");
                }
            } else {
                sol.add(new Pair(2,1));
                int currX = 2;
                int currY = 2;
                    int actual = 2;
                    sum -= 2;
                    while(sum - actual >= 1) {
                        sum -= actual;
                        actual++;
                        currX++;
                        sol.add(new Pair(currX, currY));
                    }
                    currY--;
                    while(sum > 0) {
                        sum--;
                        sol.add(new Pair(currX, currY));
                        currX++;
                    }
                    for(Pair pair : sol) {
                        System.out.println(pair.x + " " + pair.y);
                    }
            }
        }
    }

    public static int sum (int x, int y) {
        return x + y;
    }

}
