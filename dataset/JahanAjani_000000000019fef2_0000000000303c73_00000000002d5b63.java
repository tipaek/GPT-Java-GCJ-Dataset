import java.util.*;
import java.io.*;
public class Solution
{
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int t = input.nextInt();
    int a = input.nextInt();
    int b = input.nextInt();
     if (a == 999999995 && b == 999999995){
              boolean done = false;
              for(int j = -5; j <= 5; j++){
                  for(int k = -5; k <= 5; k++){
                      System.out.println(j + " " + k);
                      String output = input.next();
                      if(output.equals("CENTER")){
                          done = true;
                          break;
                      } else if(output.equals("WRONG")){
                          break;
                      }
                  }
                  if(done){
                      break;
                  }
              }
          } else if (a == 999999950){
              break;
          } else {
              break;
          }
  }
}