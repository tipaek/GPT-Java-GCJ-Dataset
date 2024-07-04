
import java.util.*;
import java.util.Scanner;

public class Solution{
    public static int[] solve(int[][]arr,int size){
        Set<Integer> count = new HashSet<Integer>();
        int row=0,col=0,trace=0;

        for(int i=0;i<size;i++){
            count.clear();
            for (int j=0;j<size;j++){
                if(count.contains(arr[i][j])){
                    row++;
                    break;
                }
                count.add(arr[i][j]);
            }
        }
        for(int i=0;i<size;i++){
            count.clear();
            for (int j=0;j<size;j++){
                if(count.contains(arr[j][i])){
                    col++;
                    break;
                }
                count.add(arr[j][i]);
            }
        }
        for(int i=0;i<size;i++){
            trace+=arr[i][i];
        }
    return new int[]{row,col,trace};
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int it = 1;
        while(it<=t){
            int n = s.nextInt();
            int [][]arr = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j =0;j<n;j++){
                    arr[i][j] = s.nextInt();
                }
            }
            int[] ans = solve(arr,n);
            System.out.println("Case #"+it+": "+ans[2]+" "+ans[0]+" "+ans[1]);
            it++;
        }
    }
}