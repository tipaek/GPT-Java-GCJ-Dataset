import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    String  T = in.nextLine(); 
    int t = Integer.parseInt(T);
    
    for (int i = 1; i <= t; ++i) {
        int N = in.nextInt();
        int K = in.nextInt();
        
        int[] arr = new int[N];
        
        int[] temp = new int[N];
        
        int[][] mm = new int[N][N];
        int f = 0;
        
        int[] arrTemp = new int[N];
        
        String result = "";
        int pat = 0;
        
        boolean isPos = false;
        
        for(int q=0; q <N; q++){
            arr[q] = q+1;
        }
        
        if(((K%N) == 0) && (K > N)){
            result = "POSSIBLE";
            isPos = true;
            pat = K/N;
            
            for(int r=0; r < N; r++){
            
                for(int xx=0; xx < pat-1; xx++){
                    for (int a=0; a < 1; a++) {
                        f = arr[0];
                    
                        for (int ii=1; ii < arr.length; ii++){
                            arr[ii-1] = arr[ii];
                        }
                        
                        arr[arr.length-1] = f; 
                    }
                }
                
                for(int c=0; c < N; c++){
                    mm[r][c] = arr[c];
                }
                
            }
            
        } else {
            result = "IMPOSSIBLE";
        }
        
        System.out.println("Case #" + i + ": " + result);
        if(isPos){
          for (int ll=0; ll < N; ll++){
            for (int bb = 0; bb < N; bb++){
                System.out.print(mm[ll][bb]+ " ");
            }
            System.out.println(" ");
        }
      }
    }
  }
}