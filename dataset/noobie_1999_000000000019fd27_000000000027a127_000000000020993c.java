import java.io.*;
import java.lang.*;
import java.util.*;

class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        int c_no = 1;
        while(t-->0){
            int n = Integer.parseInt(in.readLine());
            int[][] arr = new int[n][n];
            for(int i=0;i<n;i++){
                String[] str = in.readLine().trim().split(" ");
                for(int j=0;j<n;j++)
                    arr[i][j] = Integer.parseInt(str[j]);
            }
            int trace = 0, row = 0, col = 0;
            for(int i=0;i<n;i++)
                trace+=arr[i][i];
            for(int i=0;i<n;i++){
                Set<Integer> set = new HashSet<Integer>();
                for(int j=0;j<n;j++)
                    set.add(arr[i][j]);
                if(set.size()!=n)
                    row++;
            }
            for(int i=0;i<n;i++){
                Set<Integer> set = new HashSet<Integer>();
                for(int j=0;j<n;j++)
                    set.add(arr[j][i]);
                if(set.size()!=n)
                    col++;
            }
            System.out.println("Case #"+c_no+": "+trace+" "+row+" "+col);
            c_no++;
        }   
    }
}