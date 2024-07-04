import java.util.*;
import java.io.*;

class Solution {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = sc.nextInt();
        for (int t = 1; t < testCases + 1; t++) {
            String startString = sc.next();
            String finalString = "";
            int previous = 0;
            int nbP = 0;
            for (int i = 0; i < startString.length(); i++) {
                try {
                    int value = Integer.parseInt(startString.substring(i, i + 1));
                    if (value > previous) {
                        while (nbP < value) {
                            finalString += "(";
                            nbP++;
                        }
                        finalString += value;
                    } else if (value < previous) {
                        int toClose = nbP - value;
                        for (int j = 0; j < toClose; j++) {
                            finalString += ")";
                            nbP --;
                        }
                        finalString += value;
                    } else {
                        finalString += value;
                    }
                    previous = value;
                } catch (NumberFormatException e) {
                    System.err.println("oups");
                }
            }
            for (int i = 0; i < nbP; i++) {
                finalString += ")";
            }
            System.out.println("Case #" + t + ": " + finalString);

        }
    }
}