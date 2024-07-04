import java.io.*;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = getInt(br.readLine());
        int cas=1;
        while (tc-->0){
            int n = getInt(br.readLine());

            int[][] latin =new int[n][n];
            int trace = 0 ;
            for(int j=0;j<n;j++){
                String[] arr = br.readLine().split(" ");
                for(int x= 0  ;x<n;x++){
                    latin[j][x]= getInt(arr[x]);
                    if(j==x){
                        trace+=latin[j][x];
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
            System.out.println("Case #"+cas+": "+trace+" "+r+" "+c);
            cas+=1;
        }
    }
    public static int getInt(String s){
        return  Integer.parseInt(s);
    }
}
