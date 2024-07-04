import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
            int trace=0;
            for(int i=0;i<n;i++){
                ArrayList<Integer> listrow = new ArrayList<Integer>();
                for(int k=1;k<=n;k++){
                    listrow.add(k);
                     trace+= a[k][k];
                }
                ArrayList<Integer>listcol = listrow;
                for(int j=0;j<n;j++){
                    if(listcol.contains(a[i][j]))
                        listcol.remove(new Integer(a[i][j]));
                    if(listrow.contains(a[j][i]))
                        listrow.remove(new Integer(a[j][i]));
                }
                if(!listrow.isEmpty()){
                rownum++;
                }
                if(!listcol.isEmpty()){
                colnum++;
                }
            }
            
            
           
            
            System.out.println("Case #"+p+": "+trace+" "+rownum+" "+colnum);
            p++;
        }
    }
}
            