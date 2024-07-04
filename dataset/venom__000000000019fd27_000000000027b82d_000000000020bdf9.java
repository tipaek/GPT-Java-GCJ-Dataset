
import java.util.*;
import java.io.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int count =0;
        while(t-- != 0){
            int check = 0;
            int n = sc.nextInt();
            int[][] arr = new int[n][4];
            for(int i=0;i<n; i++){
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
                arr[i][2] = i;
                arr[i][3] = 0;
            }
            StringBuilder sb = new StringBuilder();
        sb.append("Case #");
        sb.append(count+1);
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
                check++;
                System.out.println(String.format("Case #%d: IMPOSSIBLE", count+1));
                break;
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
            if(check!=1)
                System.out.println(sb.toString());
            count++;
            check = 0;
        }
    }
     
}