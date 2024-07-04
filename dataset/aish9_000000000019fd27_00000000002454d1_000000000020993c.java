import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Solution {

 
   public static void main(String args[]) 
   { 
      Scanner s = new Scanner(System.in);
      int T=s.nextInt();
      for(int z=0;z<T;z++){
      N=s.nextInt();
    int[][] b=new int[N][N];
    int k=0,r=0,c=0;
    for (int i = 0; i < N; i++) 
            {
                for (int j = 0; j < N; j++) 
                {
                    b[i][j] = s.nextInt();
                    if(i==j){
                        k+=b[i][j];
                    }
                }
            }
            HashSet<Integer> setr = new HashSet<Integer>();
         boolean flagr=false;
    for (int i = 0; i < N; i++) 
            {
                for (int j = 0; j < N; j++) 
                {
                 if( ! setr.add(b[i][j]))
               {
                 //   System.out.print("c:"+b[i][j]);
                     flagr=true;  
               }
                     if(j==2 && flagr==true){
                         r++;
                         flagr=false;
                         setr.clear();
                     }
                }
                  setr.clear();
                }
             HashSet<Integer> setc = new HashSet<Integer>();
       boolean flag=false;
    for (int j = 0; j < N; j++) 
            {
                for (int i =0; i < N; i++) 
                {
                 if( ! setc.add(b[i][j]))
                 flag=true;
                 if(i==2 && flag==true){
                     //System.out.print("c:"+b[i][j]);
                         c++;
                          flag=false;
                          setc.clear();
                     }
                }
                    setc.clear();
                }    
                
                
                System.out.print("Case #"+(z+1)+": "+k+" "+r+" "+c);
      }
    } 
} 
