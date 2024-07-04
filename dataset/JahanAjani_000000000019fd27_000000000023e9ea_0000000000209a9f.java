import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    in.nextLine();
    String[] lis = new String[t];
    List<String> res;
    for (int i = 1; i <= t; ++i) {
      String s = in.nextLine(); //read line of s string
      lis[i-1] = s;
    }
    res = new ArrayList<String>(t);
    printModifiedString(lis, res);
    for(int i=0; i<res.size(); i++){
          System.out.println("Case #" + i+1 + ": " + res.get(i));
    }
  }
  
  public static void printModifiedString(String[] lis, List<String> res){
      Stack<Character> st;
      StringBuffer sb;
      for(String s : lis){
        st = new Stack<Character>();
        sb = new StringBuffer();
        char[] chars = s.toCharArray();
        for(int i=0; i<chars.length; i++){
            int val = chars[i] - '0';
            if(st.size() == val){
                sb.append(chars[i]);
            }else if(st.size() < val){
                fillBuffer(sb, st, (val-st.size()));
                sb.append(chars[i]);
            }else if(st.size() > val){
                emptyBuffer(sb, st, (st.size() - val));
                sb.append(chars[i]);
            }
            
        }
        
        while(!st.isEmpty()){
            sb.append(')');
            st.pop();
        }
        
        res.add(sb.toString());
        
      }
    }
    
    public static void emptyBuffer(StringBuffer sb, Stack<Character> st, int diff){
        for(int i=0; i<diff; i++){
            sb.append(')');
            st.pop();
        }
    }
    
    public static void fillBuffer(StringBuffer sb, Stack<Character> st, int diff){
        for(int i=0; i<diff; i++){
            sb.append('(');
            st.push('(');
        }
    }
}