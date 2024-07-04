import java.util.*;
import java.io.*;

public class Solution {
    
    public static void findStr(String str, int caseNum){
        int open = 0;
        StringBuffer res = new StringBuffer();
        for(int i = 0 ; i < str.length() ; i++){
            int num = str.charAt(i) - '0';
            if(open < num){
                while(open < num){
                    res.append("(");
                    open++;
                }
            }
            else{
                while(open > num){
                    res.append(")");
                    open--;
                }
            }
            res.append(str.charAt(i));
        }
        while(open > 0){
            res.append(")");
            open--;
        }
        System.out.println("Case #"+caseNum+": "+res);
    }
    
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    String total = in.next();
    int t = Integer.parseInt(total);
    for (int i = 0; i < t; ++i) {
      String line = in.next();
      findStr(line, i+1);
    }
  }
}