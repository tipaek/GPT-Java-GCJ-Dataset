import java.util.*;
import java.io.*;

public class solution {
    static int total=0;
    static int temp1=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
          int countN = in.nextInt();
          int a[][] = new int[countN][countN];
          int transpose[][]=new int[countN][countN]; 
          int temp=0;  
	  for (int j = 0; j < countN; ++j) {
              HashSet<Integer> hs = new HashSet<>();
              for(int k = 0; k < countN; ++k){
                  a[j][k] = in.nextInt();
                  hs.add(a[j][k]);
                  if(hs.size() < countN){
                      temp +=1;
                  }
                  transpose[j][k]=a[k][j];
              }
          }
          taceMatrix(a, countN, transpose);
          System.out.println("Case #" + i + ": " + total+ " " + temp+ " " + temp1);
	  
        }
    }
    
    public static void taceMatrix(int a[][], int countN, int t[][]){
        for (int j = 0; j < countN; ++j) {
            HashSet<Integer> hs1 = new HashSet<>();
              for(int k = 0; k < countN; ++k){
                  if(k==j){
                     total += a[j][k];
                  }
                  hs1.add(a[j][k]);
                  if(hs1.size() < countN){
                      temp1 +=1;
                  }
              }
          }
    }
}