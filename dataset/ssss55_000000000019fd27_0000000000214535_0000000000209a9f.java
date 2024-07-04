    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
          String s = in.next();
          String s1 = "";
          for(int j = 0; j < s.length(); ++j){
            int curr = s.charAt(j) - 48;
            int temp = curr;
            int index = s1.length() - 1;
            while(index >= 0 && temp >= 0){
                if(s1.charAt(index) != ')' || temp == 0){
                  break;
                }
                else {
                 --index;
                 --temp;
                }
            }
            String insert = "";
            for(int m = 0; m < temp; ++m){
                insert += "(";
            }
            insert += curr;
            for(int m = 0; m < temp; ++m){
                insert += ")";
            }
            if(index >= 0){
                s1 = s1.substring(0, index + 1) + insert + s1.substring(index + 1);
            }
            else{
                s1 = s1 + insert;
            }
            //System.out.println(s1);
          }
          System.out.println("Case #" + i + ": " + s1);
        }
      }
    }