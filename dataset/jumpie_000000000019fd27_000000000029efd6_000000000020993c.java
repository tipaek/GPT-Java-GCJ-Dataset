import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int k = 0;
      int r = 0;
      int rt = 0;
      int rmax=0;
      int c = 0;
      int clist[] = new int[n];
      int cmax[] = new int[n];
      Arrays.fill(cmax,0);
      for (int j = 1; j<=n*n; j++) {
        //System.out.println("j=" + j);
            int m = in.nextInt();
            if((j / (n+1)) == 0){
                //System.out.println("array0 m="+m);
                clist[(j / n)] = m;
            }else{
                if (clist[(j % n)] != m){
                    //System.out.println("diff m="+m);
                    clist[(j % n)] =  m;
                }
                else{
                    //System.out.println("same m="+m);
                    cmax[(j % n)]++;
                    //System.out.println("cmax["+(j % n)+ "]=" +cmax[(j % n)]);
                }
            }
            
            if((j % n) == 1){
                rt=m;
            }
            else{
                if(rt!=m){
                    rt=m;
                }
                else{
                    rmax++;
                }
            }
            if((j % n) == 0){
                if(rmax!=0){
                    rmax++;
                }
                if(rmax > r){
                    r=rmax;
                }
                rmax=0;
            }
            if((j % (n+1)) == 1){
                k += m;
            }
      }
      for(int q=0; q < cmax.length ;q++){
          //System.out.println("cmax["+q+ "]=" +cmax[q]);
          if(cmax[q] > c){
              c =++ cmax[q];
          }
          //System.out.println("c="+c);
      }
      System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
    }
  }
}
