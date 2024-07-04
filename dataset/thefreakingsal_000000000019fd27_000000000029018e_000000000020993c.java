package Contests.CodeJam;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int z = 1;
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            int[][] arr = new int[n][n];
            for(int i=0; i<arr[0].length; i++){
                for(int j=0; j<arr.length; j++){
                    arr[i][j] = in.nextInt();
                }
            }



            /**
             * ROW Calculation
             */
            int sum = 0;
            for(int i=0; i<arr.length; i++){
                for(int j=0; j<arr.length; j++){
                    if(i==j){
                        sum += arr[i][j];
                    }
                }
            }

            int c = 0;
            int r = 0;
            for(int i=0; i<n; i++){
                int[] rr = arr[i];
                Arrays.sort(rr);
                int count = 1;
                for(int j=1; j<n; j++){
                    if(rr[j] == rr[j-1]){
                        count++;
                    }else{
                        count = 1;
                    }
                    if(count>r){
                        r = count;
                    }
                }
                int[] col = new int[n];
                for (int j = 0; j < n; j++) {
                    col[j] = arr[j][i];
                }
                Arrays.sort(col);
                int count_c = 1;

                for (int pp = 1; pp < n; pp++) {
                    if (col[pp] == col[pp - 1]) {
                        count_c++;
                    } else {
                        count_c = 1;
                    }
                    if (count_c >= c){
                        c = count_c;
                    }
                }

            }

            if(r==1) r = 0;
            if(c==1) c = 0;
            System.out.println("Case #" + z +  ": "+ sum + " " +  r  + " " + c);
            z++;
        }
    }
}
