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
            StringBuilder rightStr = new StringBuilder();
            for (int i=0; i<n; i++) {
                StringBuilder maybe = new StringBuilder();
                String curr = patts.get(i);
                int count = curr.length()-1;
                while (curr.charAt(count) != '*') {
                    maybe.insert(0, curr.charAt(count));
                    count--;
                }
                if (maybe.length() > max) {
                    max = maybe.length();
                    rightStr = maybe;
                }
            }
            max = 0;
            StringBuilder leftStr = new StringBuilder();
            for (int i=0; i<n; i++) {
                StringBuilder maybe = new StringBuilder();
                String curr = patts.get(i);
                int count = 0;
                while (curr.charAt(count) != '*') {
                    maybe.append(curr.charAt(count));
                    count++;
                }
                if (maybe.length() > max) {
                    max = maybe.length();
                    leftStr = maybe;
                }
            }
            boolean khalas = false;
            for (int i=0; i<n; i++) {
                String curr = patts.get(i);
                if (curr.charAt(curr.length()-1) != '*') {
                    int right = rightStr.length()-1;
                    int counter = curr.length()-1;
                    while (curr.charAt(counter) != '*' && right>=0) {
                        if (curr.charAt(counter) != rightStr.charAt(right)) {
                            khalas = true;
                            break;
                        }
                        counter--;
                        right--;
                    }
                    if (khalas) break;
                }

                if (curr.charAt(0) != '*') {
                    int left = leftStr.length();
                    int counter = 0;
                    int leftCounter = 0;
                    while (curr.charAt(counter) != '*' && leftCounter < left) {
                        if (curr.charAt(counter) != leftStr.charAt(leftCounter)) {
                            khalas = true;
                            break;
                        }
                        counter++;
                        leftCounter++;
                    }
                    if (khalas) break;
                }
            }
            if (khalas) {
                System.out.println("Case #" + x + ": *");
            }
            else {
                leftStr.append(rightStr);
                System.out.println("Case #" + x + ": " + leftStr);
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


1
4
THIS*ME
T*E
THISISME*
THISISME*

* */