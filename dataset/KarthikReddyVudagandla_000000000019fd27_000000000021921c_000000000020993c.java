import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args){
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t =scan.nextInt();
        
       // System.out.println(t);
        for(int i=1;i<=t;i++) {
            int rc = scan.nextInt();
            scan.nextLine();
           // System.out.println(rc+"-->");
            int[][] matrix = new int[rc][rc];
            int trace=0;
            int r=0,c=0;
            
            for(int a=0;a<rc;a++){
                String line = scan.nextLine();
               // System.out.println(line);
                String[] temp=line.split(" ");
               // System.out.println(temp.length);
                for(int b = 0;b<rc;b++){
                   matrix[a][b]=Integer.parseInt(temp[b]);
                }
            }
            
            for(int m=0;m<rc;m++){
                trace+=matrix[m][m];
            }
            for(int nr=0;nr<rc;nr++){
                HashSet<Integer> hs = new HashSet<Integer>();
                for(int nc=0;nc<rc;nc++){
                    
                    hs.add(matrix[nr][nc]);
                }
                if(hs.size()!=rc)r++;
            }
            
            for(int nr=0;nr<rc;nr++){
                HashSet<Integer> hs = new HashSet<Integer>();
                for(int nc=0;nc<rc;nc++){
                    
                    hs.add(matrix[nc][nr]);
                    
                }
                if(hs.size()!=rc)c++;
            }
            System.out.println("Case #"+i+": "+trace+" "+r+" "+c);
        
            
        }

    }
}