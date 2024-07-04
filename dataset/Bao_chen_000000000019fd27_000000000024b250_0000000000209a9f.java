import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    in.nextLine();
    for (int i = 1; i <= t; ++i) {
      String s = in.nextLine();
      int[] array = new int[s.length()];
      for(int j = 0; j < s.length(); j++) {
        array[j] = Character.getNumericValue(s.charAt(j));
      }
      solve(i, array);
    }
  }
  
  private static void solve(int caseNum, int[] array) {
    //0, 
    List<String> list = new ArrayList();
    int pre = 0;
    for(int j = 0; j < array.length; j++) {
        
        int a = array[j];
        int max = a*2+1;
        String[] cur = new String[max];
        for(int i = 0; i < a; i++) {
            cur[i] = "(";
        }
        cur[a] = ""+a;
        for(int i = a+1; i < max; i++) {
            cur[i] = ")"; 
        }
        if(pre == 0) {
            for(int i = 0; i < cur.length; i++) {
                list.add(cur[i]);
            }
        }else {
            int offset = Math.min(a, pre);
            int start = list.size() - offset;
            for(int i = offset; i < cur.length; i++) {
                //(1), start = 2, i = 1 i < 3, (11
                //(11, start = 3, i = 2 i < 3, (11
                if(start < list.size()) {
                    list.set(start, cur[i]);
                }else {
                    list.add(cur[i]);
                }
                start++;
            }
        }
        pre = a;
    }
    StringBuilder answer = new StringBuilder();
    for(int i = 0; i < list.size(); i++) {
        answer.append(list.get(i));
    }
    
    System.out.println("Case #" + caseNum + ": " + answer.toString());
  }
}