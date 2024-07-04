import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int x=1; x<=t; x++) {
            int n = in.nextInt();
            List<String> patts = new ArrayList<>();
            in.nextLine();
            for (int i = 0; i < n; i++) {
                patts.add(in.nextLine());
            }
            int max = 0;
            int ind = 0;
            for (int i=0; i<n; i++) {
                int count = 0;
                int len = patts.get(i).length();
                for (int j=0; j<len; j++) {
                    char c = patts.get(i).charAt(j);
                    if (c != '*') count++;
                }
                if (count > max) {
                    max = count;
                    ind = i;
                }
            }

            StringBuilder res = new StringBuilder();
            String want = patts.get(ind);
            for (int i=0; i<want.length(); i++) {
                char c = want.charAt(i);
                if (c != '*') res.append(c);
            }

            boolean khalas = false;
            for (int i=0; i<n; i++) {
                if (i == ind) continue;
                String curr = patts.get(i);
                int st = 0;
                int en = curr.length()-1;
                int indS = 0;
                int indE = res.length()-1;
                while (st<en) {
                    char start = curr.charAt(st);
                    char end = curr.charAt(en);
                    char startS = res.charAt(indS);
                    char endS = res.charAt(indE);
                    if (start != '*') {
                        if (start == startS) {
                            st++; indS++;
                        }
                        else {
                            khalas = true;
                            break;
                        }
                    }

                    if (end != '*') {
                        if (end == endS) {
                            en--; indE--;
                        }
                        else {
                            khalas = true;
                            break;
                        }
                    }
                }
                if (khalas) break;
            }
            if (khalas) {
                System.out.println("Case #" + x + ": *");
            }
            else {
                System.out.println("Case #" + x + ": " + res);
            }

        }

    }

}
/*
2
5
*CONUTS
*COCONUTS
*OCONUTS
*CONUTS
*S
2
*XZ
*XYZ

* */