import java.io.*;
import java.util.HashMap;
 
public class Solution {
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int t = getInt(br.readLine());
        int ca=1;
        while (t-->0){
            int n = getInt(br.readLine());
 
            int[][] latin =new int[n][n];
            int trace = 0 ;
            for(int j=0;j<n;j++){
                String[] arr = br.readLine().split(" ");
                for(int i= 0;i<n;i++){
                    latin[j][i]= getInt(arr[i]);
                    if(j==i){
                        trace+=latin[j][i];
                    }
                }
            }
            int r=0,c=0;
            for(int l =0;l<n;l++){
                HashMap<Integer,Integer> rows = new HashMap<>();
                HashMap<Integer,Integer> cols = new HashMap<>();
 
                for(int i=0;i<n;i++){
                    rows.put(latin[l][i],1);
                    cols.put(latin[i][l],1);
                }
                if(rows.size()!=n){
                    r+=1;
                }
                if(cols.size()!=n){
                    c+=1;
                }
 
            }
            System.out.println("Case #"+ca+": "+trace+" "+r+" "+c);
           ca+=1;
        }
    }
    public static int getInt(String s){
        return  Integer.parseInt(s);
    }
}
 