import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i = 0; i < t; i++) {
            int n  = s.nextInt();
            int[][] a = new int[n][4];
            for(int j = 0 ; j < n; j++) {
                a[j][0] = s.nextInt();
                a[j][1] = s.nextInt();
                a[j][2] = j;
                a[j][3] = 0;
            }
            
            solve(a, i);
        }
    }
    
    public static void solve(int[][] arr, int testCase) {
        StringBuilder sb = new StringBuilder();
        sb.append("Case #");
        sb.append(testCase+1);
        sb.append(": ");
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int c = 0, j = 0;
        for(int i=0; i<arr.length; i++){
            int start = arr[i][0];
            int end = arr[i][1];
            if(start >= c){
                c = end;
                arr[i][3] = 1;
            }else if(start >= j){
                j = end;
                arr[i][3] = 2;
            }else{
                System.out.println(String.format("Case #%d: IMPOSSIBLE", testCase+1));
                return;
            }
        }
        Arrays.sort(arr, (a, b) -> a[2] - b[2]);
        for(int i=0; i<arr.length; i++){
            if(arr[i][3] ==1){
                sb.append("C");
            }else{
                sb.append("J");
            }
        }
        System.out.println(sb.toString());
        return;
    }
    
}