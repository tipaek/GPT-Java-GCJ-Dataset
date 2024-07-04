import java.util.*;
import java.io.*;

class Solution{

  int diff(char a, char b){
    return ((a-'0')-(b-'0'));
  }

  String mniplt(String S){
    int N = S.length();
    String out = "";
    int n = 0;
    n = S.charAt(0)-'0';
    for(int i=0;i<n;i++)
      out = out + "(";
    for(int i=0;i<N-1;i++){
      out = out + S.charAt(i);
      n = diff(S.charAt(i), S.charAt(i+1));
      if(n<0){
        n *= -1;
        for(int j=0;j<n;j++)
          out = out + "(";
      }
      else
        for(int j=0;j<n;j++)
          out = out + ")";
    }
    n = S.charAt(N-1)-'0';
    out = out + S.charAt(N-1);
    for(int i=0;i<n;i++)
      out = out + ")";

    return out;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    Solution obj = new Solution();

    int T = sc.nextInt();
    if(!(T>=1 && T<=100))
    System.exit(0);

    for(int i=0;i<T;i++){
      String S = sc.next();
      if(!(S.length()>=1 && S.length()<=100))
      System.exit(0);
      else
      System.out.println("Case #"+(i+1)+": "+obj.mniplt(S));
    }
  }
}
