import java.util.*;
import java.io.*;


import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String n1 = sc.nextLine();
        int n = Integer.parseInt(n1);
       for(int i=1;i<=n;i++){
            String N1 = sc.nextLine();
            int N = Integer.parseInt(N1);
             int[][] m = new int[N][N];
            
            for(int j=0;j<N;j++){
             
            String line = sc.nextLine();
            int c =0;
            for(String s : line.split(" ")){
            if(c<N)
            m[j][c] = Integer.parseInt(s);
            c =c+1;
            
            }
            
            }
            
            
            int dr =0;
            int dc =0;
            int fr=0;int fc=0;
            //for dup rows and cols
            for(int h=0;h<N;h++){
                Set<Integer> r = new HashSet<Integer>();
                Set<Integer> c = new HashSet<Integer>();
                fr=0;fc=0;
                for(int k=0;k<N;k++){
                    if(r.add(m[h][k])==false && fr ==0){
                        //System.out.println(r);
                        dr = dr+1;
                        fr = 1;
                    }
                    if(c.add(m[k][h])==false && fc==0){
                        dc= dc+1;
                        fc = 1;
                    }
                        
                }
                
            }
            
            //for trace
            int tr =0;
            for(int a=0;a<N;a++){
                for(int b=0;b<N;b++){
                    if(a==b){
                        tr = tr + m[a][b];
                    }
                }
            }
            
             
            System.out.println("Case #"+i+": "+tr +" "+dr +" "+dc +" " );
            
        }
    
    }
}
        
    
