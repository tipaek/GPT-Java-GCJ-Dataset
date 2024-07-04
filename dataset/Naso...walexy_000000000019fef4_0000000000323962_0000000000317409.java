

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static Scanner good = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      
       
         public static void main(String[] args) {
              int x_cor=0;  int y_cor=0;
              //int pur_x;  int pur_y;
              int move = 0;   int trace=0;
             int test = Integer.parseInt(good.nextLine());
             int test2 = 1;
              while(test > 0){
                  String command = good.nextLine();
                  String [] b = command.split(" ");
                  x_cor = Integer.parseInt(b[0]);
                   y_cor = Integer.parseInt(b[1]);
                   
                   String [] c = b[2].split("");
                   for(int counter = 0; counter< c.length; counter++){
                       move++;
                       switch(c[counter]){
                           case "S":
                               
                               y_cor--;
                            
                               break;
                           case "N":
                               y_cor++;
                              
                               break;
                           case "E":
                               x_cor++;
                               
                               break;
                           case "W":
                               x_cor--;
                               
                               break;
                           default:
                               break;  
                       }
                       if(x_cor < 0 && y_cor < 0){ 
                          
                           trace = (x_cor * -1) + (y_cor * -1);
                       }
                       else  if(x_cor < 0 && y_cor >= 0){ 
                          
                           trace = (x_cor * -1) + y_cor;
                       }
                        else  if(x_cor >= 0 && y_cor < 0){ 
                          
                           trace = x_cor + (y_cor * -1);
                       }
                        else if(x_cor >= 0 && y_cor >= 0){ 
                           trace = x_cor + y_cor;
                       }
                              
                       if(move >= trace){
                           System.out.println("Case #" + test2+ ": " + move);
                           break;
                       }
                       else if (counter == c.length-1){
                        System.out.println("Case #" + test2+ ": " + "IMPOSSIBLE");
                     }
                   }
                   test2++; test--;
                   move = 0; trace = 0;
              }
         }
}
              
