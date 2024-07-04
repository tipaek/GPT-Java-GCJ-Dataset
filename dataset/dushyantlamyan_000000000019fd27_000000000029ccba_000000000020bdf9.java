import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
          int countN = in.nextInt();
          int a[][] = new int[countN][2];
          int b[][] = new int[countN][2];
          StringBuilder output = new StringBuilder();
	  for (int j = 0; j < countN; j++) {
              for(int k = 0; k < 2; k++){
                  a[j][k] = in.nextInt();
                  b[j][k] = a[j][k];
              }
          }
          String res = "";
          int count = 0;
          int chance = 0;
          for (int j = 0; j < countN; j++) {
              for(int k = 0; k <j; k++){
                  if(j==k){
                      break;
                  }
                  if(a[j][0] > b[k][0] && a[j][0] < b[k][1] ){
                      count += 1; 
                      chance = k;
                  } else if (a[j][1] > b[k][0] && a[j][1] < b[k][1] ){
                      count += 1;
                      chance = k;
                  } else {
                  }
              }
              if(count==0){
                  if (j==0 || output.charAt(chance) == 'C')
                  {
                    output.append('C');
                  }else{
                     output.append('J'); 
                  }
              }else if(count==1){
                  if(output.charAt(chance) == 'C')
                  {     
                     output.append('J');
                  }else{
                      output.append('C'); 
                  }
              }else{
                  res = "IMPOSSIBLE";
              }
              count = 0;
          }
          System.out.println("Case #" + i + ": " + (res.equals("IMPOSSIBLE") ? res : output.toString()));
	}
    }
}