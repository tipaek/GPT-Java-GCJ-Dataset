package codejam2020quali.a;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountCases = scanner.nextInt();

        for(int currentCase = 1; currentCase <= amountCases; currentCase ++){
            System.out.print("Case #" + currentCase + ": ");
            solve(scanner);
        }
    }

    public static void solve(Scanner scanner){
        int n = scanner.nextInt();
        boolean[][] m = new boolean[n+1][n+1];

        int rows = 0;
        int cols = 0;
        int trace = 0;

        for (int i = 0; i < n; i++) {
            boolean[] line = new boolean[n+1];
            for (int j = 0; j < n; j++) {
                int val = scanner.nextInt();
                if(line[val] && !line[0]){
                    rows++;
                    line[0] = true;
                }else{
                    line[val] = true;
                }

                if(m[j][val] && !m[j][0]){
                    cols++;
                    m[j][0] = true;
                }else{
                    m[j][val] = true;
                }

                if(i == j){
                    trace += val;
                }
            }
        }

        System.out.println(trace + " " + rows + " " + cols);
    }
}