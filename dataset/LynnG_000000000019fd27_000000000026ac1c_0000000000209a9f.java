import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));    
    int t = in.nextInt(); //number of tests
    String s = in.nextLine();
    for (int i = 1; i <= t; ++i) {
        s = in.nextLine();
        String sp = "";
        int openP =0;
        for(int index = 0; index < s.length(); index++){
            int num = Integer.parseInt(s.substring(index,index+1));
            
            //insert open paren needed
            while(num > openP){
                sp = sp + "(";
                openP ++;
            }
            //put num in new string
            sp = sp + num;
            //add closed parentheses
            int closedP = 0;
            if(index < s.length()-1){
                int nextNum = Integer.parseInt(s.substring(index+1,index+2));
                closedP = num-nextNum;
            }
            else{
                closedP = Integer.parseInt(s.substring(s.length()-1));
            }
            for(int rep = 0; rep < closedP; rep++){
                sp = sp + ")";
                openP --;
            }  
        }
      System.out.println("Case #" + i +": " + sp);
    }
  } 
}
