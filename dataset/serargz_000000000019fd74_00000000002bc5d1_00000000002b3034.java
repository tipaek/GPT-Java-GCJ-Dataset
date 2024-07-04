import java.util.Scanner;
import java.lang.Math;
import java.util.*;
import java.util.stream.*;

public class Solution {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();

        for(int i=0; i<t; i++)
            System.out.println(String.format("Case #%d: %s", (i+1), doit(i)));
    }

    private static String doit(int t) {
        int n = sc.nextInt();
        sc.nextLine();
        List<String> words = new ArrayList<>();

        for (int i=0; i<n; i++) {
            words.add(sc.nextLine());
        }

        StringBuffer retPrefix = new StringBuffer();
        StringBuffer retSufix = new StringBuffer();
        StringBuffer mid = new StringBuffer();
        String tmp;

        for (int i=0; i<words.size(); i++)  {
            tmp = words.get(i);
            if(tmp.charAt(0) != '*') {
                for (int j=0; j<tmp.length() && tmp.charAt(j) != '*'; j++) {
                    if(retPrefix.length() >= j+1) {
                        if(retPrefix.charAt(j) != tmp.charAt(j)) return "*";
                        else continue;
                    } else {
                        retPrefix.append(tmp.charAt(j));
                    }
                }
            }

            int first = -1, last = -1;
            for(int j=0; j<tmp.length(); j++) {
                if(tmp.charAt(j) == '*') {
                    if(first == -1) first = j;
                    last = j;
                }
            }

            for(int j=first+1; j<last; j++) {
                if(tmp.charAt(j) != '*')
                    mid.append(tmp.charAt(j));
            }

            tmp = new StringBuilder(tmp).reverse().toString();
            if(tmp.charAt(0) != '*') {
                for (int j=0; j<tmp.length() && tmp.charAt(j) != '*'; j++) {
                    if(retSufix.length() >= j+1) {
                        if(retSufix.charAt(j) != tmp.charAt(j)) return "*";
                        else continue;
                    } else {
                        retSufix.append(tmp.charAt(j));
                    }
                }
            }
        }

        return retPrefix.append(mid).append(retSufix.reverse()).toString();
    }
}

