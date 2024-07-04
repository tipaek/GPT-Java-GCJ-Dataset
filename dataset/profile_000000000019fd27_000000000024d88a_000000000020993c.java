package hackerrank;

import java.util.*;

public class HackerRank {

    public static void main(String[] args) {

        int t, N, row, col;

        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int sum = 0;
            N = sc.nextInt();
            int[][] arr = new int[N][N];

            //add
            for (row = 0; row < N; row++) {
                for (col = 0; col < N; col++) {
                    arr[row][col] = sc.nextInt();
                }

            }

            //print        
//            for (int row = 0; row < N; row++) {
//                for (int col = 0; col < N; col++) {
//                    System.out.print(arr[row][col] + "\t");
//                }
//                System.out.println("");
//            }
            //sum of the diagnol
            for (row = 0; row < N; row++) {
                for (col = 0; col < N; col++) {
                    if (row == col) {
                        sum = sum + arr[row][col];
                    }
                }

            }
            
            int detect = 0;
            boolean flag = false;
            for (row = 0; row < N; row++) {
                for (col = 0; col < N; col++) {
                    int num = arr[row][col];
                    for (int nextcol = col + 1; nextcol < N; nextcol++) {
                        if (num == arr[row][nextcol]) {
                            
                            flag = true;
                        }
                        
                    }
                    if(flag == true){
                        detect++;
                        break;
                    }
                   
                }
                   
                  
               
               
            }

            System.out.println("Case #" + i + ":" + " " + sum + " " + detect);

        }
    }

}
