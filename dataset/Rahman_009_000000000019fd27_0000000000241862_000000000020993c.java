import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int x = 1; x <= t; ++x) {
            int n = in.nextInt();
            in.nextLine();
            int arr[][] = new int[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    arr[i][j] = in.nextInt();
            int trace = 0,rows = 0,cols = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i==j){
                        trace += arr[i][j];
                    }
                }
            }
            for(int i=0;i<n;i++){
                Set<Integer> set = new HashSet<>();
                for(int j=0;j<n;j++)
                    set.add(arr[i][j]);
                if(set.size() < n)
                    rows++;
                set.clear();
            }
            for(int i=0;i<n;i++){
                Set<Integer> set = new HashSet<>();
                for(int j=0;j<n;j++)
                    set.add(arr[j][i]);
                if(set.size() < n)
                    cols++;
                set.clear();
            }
            System.out.println("Case #" + x + ": " + trace + " " + rows + " "+cols);
    }
  }
}