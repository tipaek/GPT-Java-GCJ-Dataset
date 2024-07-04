import java.util.*;
import java.io.*;

public class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int K;
        int R;
        int C;
        String s;
        String[] line;
        for(int i=1;i<=T;i++){
            K=0;
            R=0;
            C=0;
            int n = Integer.parseInt(br.readLine()); 
            int[][] arr=new int[n][n];
            for(int x=0;x<n;x++){
                s=br.readLine();
                line = s.split(" ");
                for(int y=0;y<n;y++){
                    arr[x][y]=Integer.parseInt(line[y]);
                    if(x==y) K+=arr[x][y];
                }
            }
            for(int a=0;a<n;a++){
                row_loop : for(int b=0;b<n;b++){
                    for(int c=b+1;c<n;c++){
                        if(arr[a][b]==arr[a][c]){ 
                            R++;
                            
                            break row_loop;
                        }
                    }
                }
            }
            for(int d=0;d<n;d++){
                col_loop : for(int e=0;e<n;e++){
                    for(int f=e+1;f<n;f++){
                        if(arr[e][d]==arr[f][d]){ 
                            C++;
                            
                            break col_loop;
                        }
                    }
                }
            }
    
    System.out.println("Case #"+i+": "+K+" "+R+" "+C);   
    }
  }
     
    
}
