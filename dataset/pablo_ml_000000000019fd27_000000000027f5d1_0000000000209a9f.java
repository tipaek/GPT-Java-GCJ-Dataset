import java.util.*;
import java.io.*;
public class Solution {
    /*public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int activities[] = new int[24*60];
            int n = in.nextInt();

            boolean conflict = false;
            String solution = "";

            int occupied[] = new int[2];
            for(int j = 0; j < n; j++) {
                int startTime = in.nextInt();
                int finishTime = in.nextInt();

                boolean coincidence = false;

                occupied[0] = 0;
                occupied[1] = 0;
                for(int k = startTime; k < finishTime; k++) {
                    switch (activities[k]) {
                        case 0:
                            activities[k] = 1;
                            break;
                        case 1:
                            occupied[0] = 1;
                            activities[k] = 3;
                            coincidence = true;
                            break;
                        case 2:
                            occupied[1] = 1;
                            activities[k] = 3;
                            coincidence = true;
                            break;
                        case 3:
                            conflict = true;
                            break;

                    }
                    if(conflict) break;
                }

                if(conflict) {
                    break;
                } else {
                    if(coincidence) {
                        if(occupied[0] == 1) {
                            for(int k = startTime; k < finishTime; k++) {
                                if(activities[k] == 1) {
                                    activities[k] = 2;
                                }
                            }
                            solution += "J";
                        } else {
                            solution += "C";
                        }
                    } else {
                        solution += "C";
                    }
                }
            }
            if(conflict) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ":"  + " " + solution);
            }

        }
    }*/

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String line = in.nextLine();
        for (int i = 1; i <= t; ++i) {
            line = in.nextLine();

            String[] splitted = line.split("0", -1);
            String finalSolution = "";
            for(int j = 0; j < splitted.length; j++) {
                if(splitted[j].length() > 0) {
                    String solution = "";
                    int max = 0;
                    int openedBrackets = 0;
                    int[] digits = new int[splitted[j].length()];
                    for (int k = 0; k < digits.length; k++) {
                        digits[k] = Character.getNumericValue(splitted[j].charAt(k));
                        if (digits[k] > max) {
                            max = digits[k];
                        }
                    }

                    openedBrackets = max;
                    solution += (new String("(")).repeat(max) + digits[0];
                    for (int k = 1; k < digits.length; k++) {
                        if (openedBrackets < digits[k]) {
                            solution += (new String("(")).repeat(digits[k] - openedBrackets);
                            openedBrackets = digits[k];
                        }
                        solution += digits[k];
                        if (k != digits.length - 1 && digits[k] > digits[k + 1]) {
                            solution += (new String(")")).repeat(digits[k + 1] - digits[k]);
                            openedBrackets -= (digits[k + 1] - digits[k]);
                        }
                    }
                    solution += (new String(")")).repeat(openedBrackets);

                    if (j == splitted.length - 1) {
                        finalSolution += solution;
                    } else {
                        finalSolution += solution + "0";
                    }
                }
                else {
                    if(j != splitted.length-1) {
                        finalSolution += "0";
                    }

                }
            }
            System.out.println("Case #" + i + ":"  + " " + finalSolution);

        }
    }
}