import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
          int countN = in.nextInt();
          int a[][] = new int[countN][countN];
          int transpose[][]=new int[countN][countN]; 
          int temp=0; int total =0;
	  for (int j = 0; j < countN; j++) {
              HashSet<Integer> hs = new HashSet<>();
              for(int k = 0; k < countN; k++){
                  a[j][k] = in.nextInt();
                  if(k==j){
                     total += a[j][k];
                  }
                  hs.add(a[j][k]);
                  transpose[k][j] = a[j][k];
              }
              if(hs.size() < countN){
                      temp +=1;
              }
          }
          int temp1=0;
          for (int j = 0; j < countN; j++) {
              HashSet<Integer> hs1 = new HashSet<>();
              for(int k = 0; k < countN; k++){
                  hs1.add(transpose[j][k]);
              }
            if(hs1.size() < countN){
                   temp1 +=1;
            }
          }
          System.out.println("Case #" + i + ": " + total+ " " + temp+ " " + temp1);
	}
    }
}