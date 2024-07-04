import java.util.*;
import java.io.*;
public class Mysoln {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int term = sc.nextInt();
    
    for (int i = 0; i < term; ++i) {

      String pre_inp = sc.next();
      
      int lengt = pre_inp.length();
      
      char[] inpu = pre_inp.toCharArray();
      String outpu = ""; 
      
      for(int j = 0; j < lengt; ++j) {

          String Charact = Character.toString(inpu[j]);
 
          int integer = Integer.parseInt(Charact);
          if(inpu[j] != '0' && j == 0){
              for(int k = 1; k <= integer; ++k){
                  outpu = outpu.concat("(");
              }
          }
          if(inpu[j] == '0')
          {
              if(j != 0){
                  if(inpu[j] != inpu[j - 1]){
                      int diff = inpu[j - 1] - inpu[j];
                      for(int k = 1; k <= diff; ++k){
                          outpu = outpu.concat(")");
                      }
                  }
              }
              outpu = outpu.concat("0");
          }
          if(inpu[j] != '0'){
              if(j != 0){
                  if(inpu[j] != inpu[j - 1]){
                      if(inpu[j] < inpu[j - 1]){
                            int diff = inpu[j - 1] - inpu[j];
                            for(int k = 1; k <= diff; ++k){
                                outpu = outpu.concat(")");
                            }
                      }
                      if(inpu[j] > inpu[j - 1]){
                            int diff = inpu[j] - inpu[j - 1];
                            for(int k = 1; k <= diff; ++k){
                                outpu = outpu.concat("(");
                            }
                      }
                  }
              }
              outpu = outpu.concat(Charact);
              if(j == lengt - 1){
                    for(int k = 1; k <= integer; ++k){
                          outpu = outpu.concat(")");
                    }
                }
          }
      }
      System.out.println("Case #" + (i + 1) + ": " + outpu);
    }
  }
}