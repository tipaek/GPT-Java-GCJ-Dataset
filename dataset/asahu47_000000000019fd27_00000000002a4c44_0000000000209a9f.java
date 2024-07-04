import java.util.*;
import java.io.*;
public class Solution
{

   public static void main(String[] args) 
   {
      Scanner scan = new Scanner(System.in) ;
      int t = scan.nextInt();
      
      for(int i = 0; i < t+1; i++){
          String line = scan.nextLine();
          int parcount = 0;
          int w = line.length();
          for(int j = 0; j < w; j++){
            if(Integer.parseInt(line.substring(j,j+1)) > parcount){
               line = line.substring(0,j) + "(" + line.substring(j);
               j++;
               parcount++;
            }
            else{
               int f = Integer.parseInt(line.substring(j,j+1));
               if(f == 0){
                  String temp = line.substring(0,j);
                  for(int k = 0; k < parcount; k++)
                     temp += ")";
                  line = temp + line.substring(j);
                  j += parcount;
                  parcount = 0;
               }
               else if(f < parcount){
                  String temp = line.substring(0,j);
                  for(int k = 0; k < parcount - f; k++)
                     temp += ")";
                  line = temp + line.substring(j);   
                  j += parcount - f - 1;
                  parcount = parcount - f;
               }
            }
            w = line.length();
          }
          for(int k = 0; k < parcount; k++)
                     line += ")";
        if(!line.equals("")){
          System.out.println("Case #" + (i-1) + ": " + line);
        }
      }
   }
}