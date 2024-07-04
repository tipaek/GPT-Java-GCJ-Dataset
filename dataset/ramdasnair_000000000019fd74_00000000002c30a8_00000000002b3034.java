import java.util.Scanner;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		boolean debug = false;

		Scanner input = new Scanner(System.in);

		int t = input.nextInt();

		for(int u=1; u <= t; u++) {

            int n = input.nextInt();

            String[] pats = new String[n];

            for(int i=0; i < n; i++) {
                pats[i] = input.next();
            }

            char[] ch = new char[10 * 10 * 10 * 10];
            for (int i=0; i < 100 * 100; i++) {
                ch[i] = '.';
            }

            String current = pats[0];

            int index = 0;
            String[] first = new String[n];
            String[] last = new String[n];
            String[] mid = new String[n];

            int firstLenMax = Integer.MIN_VALUE;
            int firstMaxIndex = -1;

            int lastLenMax = Integer.MIN_VALUE;
            int lastMaxIndex = -1;

            for(int i=0; i < n; i++) {
                String[] split = pats[i].split("\\*");

                first[i] = split[0];
                if (first[i].length() > firstLenMax) {
                    firstLenMax = first[i].length();
                    firstMaxIndex = i;
                }
                last[i] = split[split.length -1];

                if (last[i].length() > lastLenMax) {
                    lastLenMax = last[i].length();
                    lastMaxIndex = i;
                }

                mid[i] = "";
                for(int j=1; j < split.length - 1; j++) {
                    if (j == 1) {
                        mid[i] += split[j];
                    } else {
                        mid[i] += "*" + split[j];
                    }

                }
            }

            boolean isPossible = true;

            for(int i=0; i < n; i++) {
                for(int j=i+1; j < n; j++) {
                    for(int k=0; k < Math.min(first[i].length(), first[j].length()); k++) {
                        if (first[i].charAt(k) != first[j].charAt(k)) {
                            isPossible = false;
                            break;
                        }
                    }

                    int lastLength = Math.min(last[i].length(), last[j].length());

                    for(int k=0; k < lastLength; k++) {
                        if (last[i].charAt(last[i].length() - 1 - k) != last[j].charAt(last[j].length() - 1 - k)) {
                            isPossible = false;
                            break;
                        }
                    }

                }
            }

            current = last[lastMaxIndex];

            if (debug) {
                for(int i=0; i < n; i++ ) {
                    System.out.println("| " + first[i] + " | " + mid[i] + " | " + last[i] );
                }
            }
            StringBuilder sb = new StringBuilder();
		    for(int i=0; i < current.length(); i++) {
                if (current.charAt(i) != '*') {
                    sb.append(current.charAt(i));
                }
            }

            String y = sb.toString();

		    if (!isPossible) y = "*";

		    System.out.println("Case #" + u + ": " + y);
        }

	}

	public static String findMaxPoss(String s1, String s2) {

	    int buffer = Math.max(s1.length(), s2.length()) * 11;
        char[] ch = new char[buffer];
        for (int i=0; i < buffer; i++) {
            ch[i] = '.';
        }

	    int s1Index = 0;
	    for(int i=0; i < s1.length(); i++) {
	        if (s1.charAt(i) == '*') {
                s1Index += 10;
            } else {
                ch[s1Index] = s1.charAt(i);
                s1Index++;
            }
        }

        for(int i=0; i < s2.length(); i++) {
            if (s2.charAt(i) == '*') {
                s1Index += 10;
            } else {
                ch[s1Index] = s2.charAt(i);
                s1Index++;
            }
        }
        System.out.println(ch);
	    return s1;
    }
}