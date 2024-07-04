import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int z = 0; z < t; z++) {
            boolean thatTrue = true;
            int n = sc.nextInt();
            sc.nextLine();
            String s = "*";
            for (int i = 0; i < n; i++) {
                String snew = sc.nextLine();
                snew = snew.replaceAll("\\*{2,}", "*");
                snew = snew.trim();
                if (snew.charAt(0) == '*' && snew.charAt(snew.length() - 1) == '*') {
                    s = Solution.replaceee(s, snew);

                } else if (snew.charAt(0) == '*') {
                    int j = Solution.searchLast(s);
                    if (j + 1 == s.length()) {
                        s = s.substring(0, j) + snew;
                        continue;
                    }
                    String flag = s.substring(j + 1, s.length());
                    if (snew.contains(flag)) {
                        s = s.substring(0, j) + snew;
                    } else if (flag.contains(snew.substring(1, snew.length()))) {
                        continue;
                    } else {
                        thatTrue = false;
                        break;
                    }
                } else if (snew.charAt(snew.length() - 1) == '*') {
                    int j = Solution.searchFirst(s);
                    if (j == 0) {
                        s = snew.substring(0, snew.length() - 1) + s;
                        continue;
                    }
                    String flag = s.substring(0, j);
                    if (snew.contains(flag)) {
                        s = snew.substring(0, snew.length() - 1) + s;
                    } else if (flag.contains(snew.substring(0, snew.length() - 1))) {
                        continue;
                    } else {
                        thatTrue = false;
                        break;
                    }
                } else {
                    String originalNew = snew;
                    snew = originalNew.substring(searchLast(originalNew), originalNew.length());
        //First
                    if(true) {
                        int j = Solution.searchLast(s);
                        if (j + 1 == s.length()) {
                            s = s.substring(0, j) + snew;
                            //continue;
                        }
                        String flag = s.substring(j + 1, s.length());
                        if (snew.contains(flag)) {
                            s = s.substring(0, j) + snew;
                        } else if (flag.contains(snew.substring(1, snew.length()))) {
                            //continue;
                        } else {
                            thatTrue = false;
                            break;
                        }
                    }
        //Second
                    for(int rr = 0; rr < 1; rr++) {
                        snew = originalNew.substring(0, searchFirst(originalNew) + 1);
                        int j = Solution.searchFirst(s);
                        if (j == 0) {
                            s = snew.substring(0, snew.length() - 1) + s;
                            continue;
                        }
                        String flag = s.substring(0, j);
                        if (snew.contains(flag)) {
                            s = snew.substring(0, snew.length() - 1) + s;
                        } else if (flag.contains(snew.substring(0, snew.length() - 1))) {
                            continue;
                        } else {
                            thatTrue = false;
                            break;
                        }
                    }
        //Third
                    if(true) {
                        snew = originalNew.substring(searchFirst(originalNew), searchLast(originalNew) + 1);
                        s = Solution.replaceee(s, snew);
                    }
                }
            }
            System.out.print("Case #" + z + 1 + ": ");
            if (thatTrue && s.length() > 0) {
                s = s.replaceAll("\\*{1,}", "");
                System.out.println(s);
            } else {
                System.out.println("*");
            }
        }
    }

    public static int searchLast(String s) {
        int w = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '*') {
                w = i;
                break;
            }
        }
        return w;
    }
    public static int searchFirst(String s) {
        int w = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                w = i;
                break;
            }
        }
        return w;
    }
    public static String replaceee(String s, String replace){
        if(s.contains(replace)) return s;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '*'){
                if (i == 0 && i + 1 == s.length()){
                    s = replace;
                    break;
                } else if(i == 0) {
                    s = replace + s.substring(1, s.length());
                    i += replace.length();
                    break;
                } else if(i + 1 == s.length()) {
                    s = s.substring(0, s.length() - 1) + replace;
                    i += replace.length();
                    break;
                } else {
                    s = s.substring(0, i) + replace + s.substring(i + 1, s.length());
                    i += replace.length();
                    break;
                }
            }
        }
        return s;
    }

    public static void second(){

    }

    public static void third(){

    }
}
