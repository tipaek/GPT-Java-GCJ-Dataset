import java.util.*;
import java.io.*;

public class Solution1{

  static void solvef(String s,int cas){
    String result = "";

    if(s.length()==1){
      char temp = s.charAt(0);
      if(temp=='1') result = "(1)";
      else result ="(0)";

    }
    else{
      for(int i=0;i<s.length()-1;++i){
        char temp = s.charAt(i);
        if (temp=='1' && result=="")result = "(";
        if(temp =='1' && s.charAt(i+1)=='0')result = result+temp+")";
        else if(temp=='0' && s.charAt(i+1)=='1') result = result+temp+"(";
        else result = result+temp;
      }
      if(s.charAt(s.length()-1)=='1') result = result + s.charAt(s.length()-1) + ")";
      else result = result + s.charAt(s.length()-1);
    }



    System.out.println("Case #" + cas + ": " + result);
  }

  public static void main(String[] args){
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for(int i=0;i<t;++i){
      int n = in.nextInt();
      String s = String.valueOf(n);
      solvef(s,i);
    }
    in.close();

  }
}
