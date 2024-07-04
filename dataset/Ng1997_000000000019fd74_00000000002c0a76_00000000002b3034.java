
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        PatternMatching.Run();
    }
}

class PatternMatching {
    public static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static void Run() {
        int t = sc.nextInt();
        for (int i=1; i<=t; i++) {
            String ans = solve();
            System.out.printf("Case #%d: %s\n", i, ans);
        }
    }
    public static String solve() {
        int n = sc.nextInt();
        String []arr = new String[n];
        for (int i=0; i<n;i++) {
            arr[i] = sc.next();
        }
        Str narr[] = new Str[n];
        for (int i=0; i<n; i++) {
            narr[i] = new Str();
            for (int j=0; j<arr[i].length(); j++) {
                if (arr[i].charAt(j) != '*' && j == 0) {
                    String pre = "";
                    for (int k=0; k<arr[i].length(); k++) {
                        if (arr[i].charAt(k) != '*')
                            pre = pre + arr[i].charAt(k);
                        else
                            break;
                    }
                    narr[i].st = pre;
                    break;
                } else if (j==0 && arr[i].charAt(j) == '*') {
                    narr[i].st = "*";
                    break;
                } else {
                    break;
                }
            }
            for (int j=arr[i].length()-1; j>=0; j--) {
                if (arr[i].charAt(j) != '*' && j == arr[i].length()-1) {
                    String pre = "";
                    for (int k=arr[i].length()-1; k>=0; k--) {
                        if (arr[i].charAt(k) != '*')
                            pre = arr[i].charAt(k) + pre;
                        else
                            break;
                    }
                    narr[i].end = pre;
                    break;
                } else if (j==arr[i].length()-1 && arr[i].charAt(j) == '*') {
                    narr[i].end = "*";
                    break;
                } else {
                    break;
                }
            }
            String mid = "";
            for (int j=narr[i].st.length(); j<arr[i].length() - narr[i].end.length(); j++) {
                if (arr[i].charAt(j) == '*') {
                    continue;
                } else {
                    mid += arr[i].charAt(j);
                }
            }
            narr[i].mid = mid;
        }
        Str ans = narr[0];
        for (int i=1; i<arr.length; i++) {
            if (ans.st.equals("*")) {
                ans.st = narr[i].st;
            } else if(!narr[i].st.equals("*")) {
                if (narr[i].st.length() > ans.st.length()) {
                    int ind = narr[i].st.indexOf(ans.st);
                    if (ind != 0) {
                        return "*";
                    } else {
                        ans.st = narr[i].st;
                    }
                } else {
                    int ind = ans.st.indexOf(narr[i].st);
                    if (ind != 0) {
                        return "*";
                    }
                }
            }
            if (ans.end.equals("*")) {
                ans.end = narr[i].end;
            } else if(!narr[i].end.equals("*")) {
                if (narr[i].end.length() > ans.end.length()) {
                    int ind = narr[i].end.lastIndexOf(ans.end);
                    if (ind + ans.end.length() != narr[i].end.length()) {
                        return "*";
                    } else {
                        ans.end = narr[i].end;
                    }
                } else {
                    int ind = ans.end.lastIndexOf(narr[i].end);
                    if (ind + narr[i].end.length() != ans.end.length()) {
                        return "*";
                    }
                }
            }
            ans.mid += narr[i].mid;
        }
        return ans.toString();
    }
}

class Str {
    String st,end,mid;
    Str() {
        st = new String();
        end = new String();
        mid = new String();
    }

    @Override
    public String toString() {
        String x = st;
        if (x.equals("*")) {
            x="";
        }
        String y = end;
        if (y.equals("*")) {
            y = "";
        }
        return x + mid + y;
    }
}
