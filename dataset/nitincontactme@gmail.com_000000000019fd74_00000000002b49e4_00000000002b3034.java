
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Pattern;

class Solution {
    public static void main1(String[] args) {
        //System.out.println(".\\*CONUTS".matches(".\\*COCONUTS"));
        System.out.println(Pattern.compile(".*CONUTS").equals(Pattern.compile(".*COCONUTS")));
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i11 = 0; i11 < t; i11++) {
            int n = in.nextInt();
            String[] arr = new String[n];
            String ans = null;
            for (int i = 0; i < n; i++) {
                arr[i] = in.next();//.replace("*", "\\.*");
                if (ans == null)ans=arr[i];
                else ans = combine(ans, arr[i]);
                if (ans==null)break;
               // System.out.println(ans);
            }
            System.out.print("Case #"+(i11+1)+": ");
            System.out.print(ans==null?"*":ans.replace("*", ""));
            System.out.println();
        }
        in.close();
    }

    private static String combine(String s1, String s2) {
        //StringBuilder ans = new StringBuilder();
        //System.out.println(s1+"\t"+s2);
        //System.out.println(s1.replace("*", ".*").matches(s2.replace("*", ".*")));


        String[] arr1 = s1.split("\\*");
        String[] arr2 = s2.split("\\*");

        String pre1 = s1.substring(0, s1.indexOf('*'));
        String pre2 = s2.substring(0, s2.indexOf('*'));

        if (!pre1.startsWith(pre2) && !pre2.startsWith(pre1))return  null;

        String app1 = s1.substring(s1.indexOf('*')+1);
        String app2 = s2.substring(s2.indexOf('*')+1);

        if (!app1.endsWith(app2) && !app2.endsWith(app1)) return null;

        return (pre1.length()>pre2.length()?pre1:pre2) +"*"+ (app1.length()>app2.length()?app1:app2);

        /*int l1=0, l2=0;
        while (l1<s1.length() && l2<s2.length()) {
            char c1 = s1.charAt(l1), c2 = s1.charAt(l2);
            if (c1==c2) {
                ans.append(c1);
                l1++;l2++;
            } else if (c1=='*' && c2=='*') {
                l1++;l2++;
            }
        }*/
    }
}
