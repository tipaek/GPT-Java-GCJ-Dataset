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

            StringBuilder solution = new StringBuilder();
            int temp = 0;
            int tempNext = 0;

            int openBrackets = 0;
            tempNext = Character.getNumericValue(line.charAt(0));
            for(int j = 0; j < line.length()-1; j++) {
                temp = Character.getNumericValue(line.charAt(j));
                tempNext = Character.getNumericValue(line.charAt(j+1));

                if(temp > openBrackets) {
                    repeatString(solution,"(", temp-openBrackets);
                    openBrackets = temp;
                }
                solution.append(temp);
                if(temp > tempNext) {
                    repeatString(solution,")",temp-tempNext);
                    openBrackets -= (temp-tempNext);
                }
            }

            if(tempNext > openBrackets) {
                repeatString(solution,"(", tempNext-openBrackets);
                openBrackets = tempNext;
            }
            solution.append(tempNext);
            repeatString(solution,")",openBrackets);

            System.out.println("Case #" + i + ":"  + " " + solution);

        }
    }

    private static void repeatString(StringBuilder original, String piece, int times) {
        for(int i = 0; i < times; i++) {
            original.append(piece);
        }
    }
}