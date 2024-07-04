import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Main {
    private static ArrayList<String> patterns;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int ti = 1; ti <= t; ti++) {
            n = sc.nextInt();
            patterns = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                patterns.add(sc.next());
            }
            patterns.sort(new Comparator<String>() {
                @Override
                public int compare(String arg0, String arg1) {
                    int cnt0 = 0, cnt1 = 0;
                    for (int i = 0; i < arg0.length(); i++) {
                        if (arg0.charAt(i) == '*')
                            cnt0++;
                    }
                    for (int i = 0; i < arg1.length(); i++) {
                        if (arg1.charAt(i) == '*')
                            cnt1++;
                    }
                    return cnt0 - cnt1;
                }
            });
            System.out.println("Case #" + ti + ": " + solve());
        }
        sc.close();
    }

    private static String solve() {
        String str = "";
        str = findLongestSub();
        String smallest = findSmallestSub(str);
        for (int i = 0; i < patterns.size(); i++) {
            if (patterns.get(i).endsWith(smallest))
                continue;
            return "*";
        }
        return str;
    }

    private static String findLongestSub() {
        String longSub = "", sub;
        int pos;
        for (String pattern : patterns) {
            pos = pattern.indexOf('*');
            sub = pattern.substring(pos + 1);
            if (sub.length() > longSub.length())
                longSub = sub;
        }
        return longSub;
    }

    private static String findSmallestSub(String str) {
        String smallestSub = str, sub;
        int pos;
        for (String pattern : patterns) {
            pos = pattern.indexOf('*');
            sub = pattern.substring(pos + 1);
            if (sub.length() < smallestSub.length())
                smallestSub = sub;
        }
        return smallestSub;
    }
}