import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
          int x = in.nextInt();
          int y = in.nextInt();
          int x0 = Math.abs(x);
          int y0 = Math.abs(y);
          
          if ((x0+y0) % 2 == 0){
              System.out.println("Case #" + i + ": IMPOSSIBLE");
              continue;
          }
          String s = "";
          if(x0 == 0){
              switch(y0){
                  case 1: s = "N"; break;
                  case 3: s = "NN"; break;
              }
          }
          if(x0 == 1){
              switch(y0){
                  case 0: s = "E"; break;
                  case 2: s = "EN"; break;
                  case 4: s = "WEN"; break;
              }
          }
          if(x0 == 2){
              switch(y0){
                  case 1: s = "NE"; break;
                  case 3: s = "SEN"; break;
              }
          }
          if(x0 == 3){
              switch(y0){
                  case 0: s = "EE"; break;
                  case 2: s = "WNE"; break;
                  case 4: s = "EEN"; break;
              }
          }
          if(x0 == 4){
              switch(y0){
                  case 1: s = "SNE"; break;
                  case 3: s = "NNE"; break;
              }
          }
          if(x0 != x){
              s = s.replace("W", "P");
              s = s.replace("E", "W");
              s = s.replace("P", "E");
          }
          if(y0 != y){
              s = s.replace("N", "P");
              s = s.replace("S", "N");
              s = s.replace("P", "S");
          }
          System.out.println("Case #" + i + ": " + s);
        }
      }
}