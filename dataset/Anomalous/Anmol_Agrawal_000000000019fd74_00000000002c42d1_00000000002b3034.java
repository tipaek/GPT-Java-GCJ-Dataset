import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tt = 1; tt <= t; tt++) {
            int n = sc.nextInt();
            List<String> asteriskString = new ArrayList<>();
            List<String> stringAsterisk = new ArrayList<>();
            List<String> asteriskStringAsterisk = new ArrayList<>();
            String ans = "";
            
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                if (i == 0) {
                    ans = s;
                    continue;
                }
                if (s.charAt(0) == '*' && s.charAt(s.length() - 1) == '*') {
                    asteriskStringAsterisk.add(s);
                } else if (s.charAt(0) == '*' && s.charAt(s.length() - 1) != '*') {
                    asteriskString.add(s);
                } else if (s.charAt(0) != '*' && s.charAt(s.length() - 1) == '*') {
                    stringAsterisk.add(s);
                }
            }
            
            boolean modified = true;
            while (modified) {
                modified = false;
                if (ans.charAt(0) == '*' && !stringAsterisk.isEmpty()) {
                    modified = true;
                    ans = stringAsterisk.remove(0) + ans.substring(1);
                }
                if (ans.charAt(ans.length() - 1) == '*' && !asteriskString.isEmpty()) {
                    modified = true;
                    ans = ans.substring(0, ans.length() - 1) + asteriskString.remove(0);
                } else {
                    for (int i = 0; i < ans.length(); i++) {
                        if (ans.charAt(i) == '*' && !asteriskStringAsterisk.isEmpty()) {
                            modified = true;
                            ans = ans.substring(0, i) + asteriskStringAsterisk.remove(0) + ans.substring(i + 1);
                        }
                    }
                }
            }
            
            boolean compare = true;
            if (asteriskStringAsterisk.isEmpty()) {
                if (!stringAsterisk.isEmpty() && ans.charAt(ans.length() - 1) == '*') {
                    ans = ans.replace("*", "");
                    outerLoop:
                    for (String x : stringAsterisk) {
                        x = x.replace("*", "");
                        for (int i = 0, j = 0; i < x.length(); i++, j++) {
                            if (j >= ans.length()) {
                                ans = x;
                                break;
                            } else if (ans.charAt(j) != x.charAt(i)) {
                                compare = false;
                                break outerLoop;
                            }
                        }
                    }
                } else if (!asteriskString.isEmpty() && ans.charAt(0) == '*') {
                    ans = ans.replace("*", "");
                    outerLoop:
                    for (String x : asteriskString) {
                        x = x.replace("*", "");
                        for (int i = x.length() - 1, j = ans.length() - 1; i >= 0; i--, j--) {
                            if (j < 0) {
                                ans = x;
                                break;
                            } else if (ans.charAt(j) != x.charAt(i)) {
                                compare = false;
                                break outerLoop;
                            }
                        }
                    }
                }
            } else {
                compare = false;
            }
            
            if (!compare) {
                ans = "*";
            }
            System.out.println("Case #" + tt + ": " + ans);
        }
    }
}