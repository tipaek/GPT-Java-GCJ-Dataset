
import java.util.Scanner;
import java.util.Stack;

class Solution {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int t=Integer.parseInt(sc.nextLine());
    for(int a=1;a<=t;a++) {
      String s=sc.nextLine();
      StringBuilder result=new StringBuilder();
      Stack st=new Stack<Character>();
      for(int i=0;i<s.length();i++) {
        int n=Integer.parseInt(""+s.charAt(i));
        while(st.size()<n) {
          st.add('(');
          result.append('(');
        }
        while(st.size()>n) {
          st.pop();
          result.append(')');
        }
        result.append(n);
      }
      while(st.size()>0) {
        st.pop();
        result.append(')');
      }
      System.out.println("Case #"+a+": "+result);
    }
  }

}
