import java.io.*;
import java.util.*;

class LatinSquare{
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

            System.out.println(sum+" "+row+" "+col);
        }
    }
}