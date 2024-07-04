package parenting;

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t =0; t<T; t++){
            int N = in.nextInt();
            int[][] array = new int[N][4];
            for(int n=0; n < N; ++n){
                array[n][0] = in.nextInt();
                array[n][1] = in.nextInt();
                array[n][2] = n;
                array[n][3] = 0;
            }
            solve(array, t);
        }
    }

    public static void solve(int[][] array, int t){
        StringBuilder sb = new StringBuilder();
        sb.append("Case #");
        sb.append(t+1);
        sb.append(": ");
        Arrays.sort(array, (a, b) -> a[0] - b[0]);
        int c = 0, j = 0;
        for(int i=0; i<array.length; i++){
            int start = array[i][0];
            int end = array[i][1];
            if(start >= c){
                c = end;
                array[i][3] = 1;
            }else if(start >= j){
                j = end;
                array[i][3] = 2;
            }else{
                System.out.println(String.format("Case #%d: IMPOSSIBLE", t+1));
                return;
            }
        }
        Arrays.sort(array, (a, b) -> a[2] - b[2]);
        for(int i=0; i<array.length; i++){
            if(array[i][3] ==1){
                sb.append("C");
            }else{
                sb.append("J");
            }
        }
        System.out.println(sb.toString());
        return;
    }
}