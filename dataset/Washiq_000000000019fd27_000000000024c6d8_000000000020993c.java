import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        int ts=in.nextInt();
        
        for(int o=0;o<ts;o++){
        
        int n = in.nextInt();
        
        int a[][] = new int[n][n];
        
        HashSet<Integer> r[] = new HashSet[n];
        int row=0; boolean svr=false;
        for(int i=0;i<n;i++){
            r[i] = new HashSet();
            svr=false;
            for(int j=0;j<n;j++){
                a[i][j] = in.nextInt();
                if(!r[i].add(a[i][j]) && !svr){
                    row++; svr=true;
                }
            }
        }
        HashSet<Integer> c[] = new HashSet[n];
        int col=0;
         for(int i=0;i<n;i++){
            c[i] = new HashSet();
            svr=false;
            for(int j=0;j<n;j++){
                if(!c[i].add(a[j][i]) && !svr){
                    col++; svr=true;
                }
            }
         }
         int t=0;
         for(int i=0;i<n;i++){
              t+=a[i][i];
              
         }
         
         System.out.println("Case #"+(o+1)+": "+t+" "+row +" "+col);
       
        }
        
        
    }
    
}
