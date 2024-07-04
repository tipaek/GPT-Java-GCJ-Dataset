import java.util.*;
import java.io.*;
public class Solution {
  public static void solve(Scanner in, int index) {
    int n = in.nextInt();
    String[] p = new String[n];
    for(int i = 0; i < n; ++i) {
        p[i] = in.next();
    }
    String head = "";
    for(int i = 0; i < n; ++i) {
        String tmp = p[i].substring(0, p[i].indexOf("*"));
        if(tmp.length() >= head.length() && tmp.indexOf(head) == 0) {
            head = tmp;
        } else if(tmp.length() < head.length() && head.indexOf(tmp) == 0) {
            continue;
        } else {
            head = null;
            break;
        }
    }
    String tail = "";
    for(int i = 0; i < n; ++i) {
        String tmp = p[i].substring(p[i].lastIndexOf("*") + 1, p[i].length());
        if(tmp.length() >= tail.length() && tmp.lastIndexOf(tail) + tail.length() == tmp.length()) {
            tail = tmp;
        } else if(tmp.length() < tail.length() && tail.lastIndexOf(tmp) + tmp.length() == tail.length()) {
            continue;
        } else {
            tail = null;
            break;
        }
    }
    String ans = "";
    if(head != null && tail != null) {
        StringBuilder mid = new StringBuilder();
        for(int i = 0; i < n; ++i) {
            int a = p[i].indexOf("*");
            int b = p[i].lastIndexOf("*");
            if(a < b) {
                mid.append(p[i].substring(a + 1, b).replaceAll("\\*", ""));
            }
        }
        ans = head + mid.toString() + tail;
    } else {
        ans = "*";
    }
    System.out.println("Case #" + index + ": " + ans);
  }    
    
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      solve(in, i);
    }
  }
}