import java.io.*;
import java.util.*;

class Solution{
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-->0){
            int sum = 0;
            int n = Integer.parseInt(in.readLine());
            int arr[][] = new int[n][n];
            for(int i=0;i<n;i++){
                String[] str = in.readLine().trim().split(" ");
                for(int j=0;j<n;j++){
                    arr[i][j] = Integer.parseInt(str[j]);
                    if(i==j)
                        sum+=arr[i][j];
                }
            }
            int row = 0, col = 0;
            for(int i=0;i<n;i++){
                Set<Integer> colSet = new HashSet<Integer>();
                Set<Integer> rowSet = new HashSet<Integer>();
                boolean f1 = false, f2 = false;
                for(int j=0;j<n;j++){
                    if(rowSet.contains(arr[i][j]))
                        f1 = true;
                    if(colSet.contains(arr[j][i]))
                        f2 = true;
                    rowSet.add(arr[i][j]);
                    colSet.add(arr[j][i]);
                }
                if(f1)
                    row++;
                if(f2)
                    col++;
            }
            System.out.println(sum+" "+col+" "+row);
        }
    }
}