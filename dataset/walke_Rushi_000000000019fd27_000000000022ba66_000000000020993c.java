import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String args[]) throws IOException{
        BuffereReader br = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());
        int p=1;
        while(t-->0){
        
            int n= Integer.parseInt(br.readLine());
            int a[][]= new int[n][n];
            for(int i=0;i<n;i++){
                String[] inp= br.readLine().split(" ");
                for(int j=0;j<n;j++){
                    a[i][j]= Integer.parseInt(inp[j]);
                }
            }
            
            int rownum=0, colnum=0;
            
            for(int i=0;i<n;i++){
                ArrayList<Integer> listrow = new ArrayList<Integer>();
                for(int i=1;i<=n;i++){
                    listrow.add(i);
                }
                ArrayList<Integer>listrow = listcol;
                for(int j=0;j<n;j++){
                listcol.remove(new Integer(a[i][j]));
                listrow.remove(new Integer(a[j][i]));
                }
                if(!listrow.isEmpty()){
                rownum++;
                }
                if(!listcol.isEmpty()){
                colnum++;
                }
            }
            int trace=0;
            for(int i=0;i<n;i++){
            trace+= a[i][i];
            }
            System.out.println("Case #"+p+": "+trace+" "+rownum+" "+colnum);
        }
    }
}
            