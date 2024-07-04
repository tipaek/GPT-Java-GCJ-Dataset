import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = getInt(br.readLine());
        int count=1;
        while (tc-->0){
            int n = getInt(br.readLine());

            int[][] mat =new int[n][n];
            int trace = 0 ;
            for(int j=0;j<n;j++){
                String[] arr = br.readLine().split(" ");
                for(int x= 0  ;x<n;x++){
                    mat[j][x]= getInt(arr[x]);
                    if(j==x){
                        trace+=mat[j][x];
                    }
                }
            }
            int r=0,c=0;
            for(int u =0;u<n;u++){
                HashMap<Integer,Integer> row = new HashMap<>();
                HashMap<Integer,Integer> col = new HashMap<>();

                for(int i=0;i<n;i++){
                    row.put(mat[u][i],1);
                    col.put(mat[i][u],1);
                }
                if(row.size()!=n){
                    r+=1;
                }
                if(col.size()!=n){
                    c+=1;
                }
                row=null;
                col=null;
            }
            System.out.println("Case #"+count+": "+trace+" "+r+" "+c);
            count+=1;
        }
    }
    public static int getInt(String s){
        return  Integer.parseInt(s);
    }
}
