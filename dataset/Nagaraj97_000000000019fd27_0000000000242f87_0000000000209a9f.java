
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = sc.nextInt();
    sc.nextLine();
    for (int k = 1; k <= t; k++) {
      String str = sc.nextLine();
      String s = new String();
      int n = str.length();
      s = getStrings(str.charAt(n-1)-'0', ')');
      s = String.valueOf(str.charAt(n-1)) + s;
      //System.out.println("STring = "+str);
      for(int i = n-2; i >=0; i--){
        //System.out.println(k+" "+i);
        int x1 = str.charAt(i) - '0';
        int x2 = str.charAt(i+1) - '0';
        //System.out.println(x1+" "+x2+" "+str.charAt(i)+" "+str.charAt(i+1));
        if(x1 > x2){
          s = getStrings(x1-x2,')') + s;
        }
        else if(x1 < x2){
          s = getStrings(x2-x1,'(') + s;
        }
        s = String.valueOf(str.charAt(i)) + s;
      }
      s = getStrings(str.charAt(0)-'0', '(') + s;
      System.out.println("Case #" + k + ": " + s);
    }
  }
  public static String getStrings(int n,char ch){
    StringBuilder str = new StringBuilder(n);
    for(int i = 0; i < n; i++){
      str.append(ch);
    }
    return str.toString();
  }
}
