import java.util.Scanner;

public class Solution {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            int trace = 0, rows = 0, cols = 0, n = sc.nextInt();
            int [][] arr = new int [n][n];

            // input and trace count
            for(int i = 0; i < n; i++){
                for(int j = 0; j < i; j++){
                    arr[i][j] = sc.nextInt();
                }

                arr[i][i] = sc.nextInt();
                trace += arr[i][i];

                for(int j = i + 1; j < n; j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            int [] checker = new int [n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    checker[arr[i][j] - 1]++;
                }

                for(int j = 1; j < n; j++){
                    if(checker[j] != checker[j - 1]){
                        rows++;
                        break;
                    }
                }

                for(int j = 0; j < n; j++) checker[j] = 0;
            }

            for(int j = 0; j < n; j++){
                for(int i = 0; i < n; i++){
                    checker[arr[i][j] - 1]++;
                }

                for(int i = 1; i < n; i++){
                    if(checker[i] != checker[i - 1]){
                        cols++;
                        break;
                    }
                }

                for(int i = 0; i < n; i++) checker[i] = 0;
            }

            System.out.println("Case #" + t + ": " + trace + " " + rows + " " + cols);
        }
    }
}
