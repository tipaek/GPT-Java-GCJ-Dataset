import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {

            boolean possible = true;
            int tasks = sc.nextInt();
            int [][] jamie = new int [2][tasks];
            int [][] cameroon = new int [2][tasks];

            for( int n =0; n < tasks; n++){
                jamie[0][n] = -1;
                jamie[1][n] = -1;
                cameroon[0][n] = -1;
                cameroon[1][n] = -1;
            }

            int [] result = new int [tasks];

            for (int n =0; n < tasks; n++){
                int start = sc.nextInt();
                int end = sc.nextInt();

                boolean jFlag = true;      //true if jamie can accommodate the task n, false otherwise
                boolean cFlag = true;

                for(int m = 0; m < tasks; m++){
                    if((start >= jamie[0][m] && start < jamie[1][m]) || (start < jamie[0][m] && end > jamie[0][m]))
                        jFlag = false;
                    if((start >= cameroon[0][m] && start < cameroon[1][m]) || (start < cameroon[0][m] && end > cameroon[0][m]))
                        cFlag = false;
                }

                if(jFlag){
                    result[n] = 1;
                    jamie[0][n] = start;
                    jamie[1][n] = end;
                }
                else if (cFlag){
                    result[n] = -1;
                    cameroon[0][n] = start;
                    cameroon[1][n] = end;
                }
                else possible = false;
            }

            if(possible){
                StringBuilder solution = new StringBuilder();

                for(int c =0; c< tasks; c++){
                    if(result[c] == -1) solution.append('C');
                    else if (result[c] == 1) solution.append('J');
                }
                System.out.println("Case #" + (i + 1) + ": " + solution.toString());
            }
            else System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");

        }
    }
}