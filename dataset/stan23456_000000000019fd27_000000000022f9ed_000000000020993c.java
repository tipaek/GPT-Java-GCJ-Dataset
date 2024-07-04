import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(br.readLine());
        for(int i =0;i<t;i++){
            int n= Integer.parseInt(br.readLine());
            int trace=0;
            int numRows=0;
            int numCols=0;
            int arr[][] = new int[n][n];
            for(int x=0;x<n;x++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                HashSet<Integer> temp = new HashSet<Integer>();
                for(int y=0;y<n;y++) {
                    arr[x][y] = Integer.parseInt(st.nextToken());
                    temp.add(arr[x][y]);
                    if(x==y)
                        trace+=arr[x][y];
                }
                if(temp.size() != n){
                    numRows++;
                }
            }

            for(int x=0;x<n;x++){
                HashSet<Integer> temp = new HashSet<Integer>();
                for(int y=0;y<n;y++){
                    temp.add(arr[y][x]);
                }
                if(temp.size() !=n)
                    numCols++;

            }
            System.out.println("Case #"+(i+1)+": "+trace+" "+numRows+" "+numCols);



        }
    }
}