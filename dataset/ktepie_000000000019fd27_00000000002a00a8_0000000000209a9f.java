import java.util.*;
import java.io.*;

public class Solution{

  public static void solvef(String s, int k){
    String result = "";
    int paracounter = 0;
    for(int i=0;i<s.length();++i){
      char ch = s.charAt(i);
      int x = Integer.parseInt(String.valueOf(s.charAt(i)));
      if(paracounter == x) result += ch;
      else if(paracounter<x){
        int temp = 0;
        for(int j=0;j< x-paracounter;++j){
          result += "(";
          temp++;
        }
        paracounter += temp;
        result += ch;
      }
      else if(paracounter>x){
        int temp = 0;
        for(int j=0;j< paracounter-x;++j){
          result += ")";
          temp++;
        }
        paracounter -= temp;
        result+= ch;
      }
    }
    for(int j=0;j<paracounter;++j){
      result += ")";
    }
       System.out.println("Case #" + k + ": " + result);
  }

  public static void main(String[] args){
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for(int i=1;i<=t;++i){
      String s = in.next();
      solvef(s,i);
    }
    in.close();

  }
}
