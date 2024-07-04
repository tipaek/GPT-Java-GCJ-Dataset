import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
          int countN = in.nextInt();
          int a[][] = new int[countN][2];
          boolean current =true;
          int chighest=0; int jhighest=0;
          int clowest=0; int jlowest=0;
          StringBuilder output = new StringBuilder();
	  for (int j = 0; j < countN; j++) {
              for(int k = 0; k < 2; k++){
                  a[j][k] = in.nextInt();
              }
          }
          String res ="";
          for (int j = 0; j < countN; j++) {
              for(int k = 0; k < 2; k++){
                  if(j==0& k==1){
                      output.append('C');
                      current = true;
                      clowest = a[j][0];
                      chighest = a[j][1];
                  }else if(j>0 && k==1){
                     if(current== true && a[j][0] >= chighest){
                       output.append('C');
                       chighest = a[j][1];
                     }else if(current == true && a[j][0] <= chighest){
                         if(a[j][1]<=jlowest || a[j][0] >=jhighest){
                           output.append('J');
                           current = false;
                           jlowest = a[j][0];
                           jhighest = a[j][1];  
                         }else{
                           res = "IMPOSSIBLE";
                         }
                     }else if(current == false && a[j][0] >= jhighest){
                           output.append('J');
                           jhighest = a[j][1];
                     }else if(current == false && a[j][0] <= jhighest){
                         if(a[j][1]<=clowest || a[j][0] >=chighest){
                           output.append('C');
                           current = true;
                           clowest = a[j][0];
                           chighest = a[j][1];
                         }else{
                           res = "IMPOSSIBLE";
                         }
                           
                     }else{
                         res = "IMPOSSIBLE";
                     }
                  }
              }
          }
          System.out.println("Case #" + i + ": " + (res.equals("IMPOSSIBLE") ? res : output.toString()));
	}
    }
}