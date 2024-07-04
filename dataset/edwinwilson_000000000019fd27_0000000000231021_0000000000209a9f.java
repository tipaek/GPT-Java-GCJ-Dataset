    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Character.getNumericValue(in.nextLine().charAt(0)); // Scanner has functions to read ints, longs, strings, chars, etc.
        String solution = "";

        for(int currentCase = 1; currentCase <= numCases; currentCase++) {
            solution += "Case #" + currentCase + ": ";

            String line = in.nextLine();
            Integer nestingLevel = 0;

            for(int i = 0; i < line.length(); i++) {
                Integer current = Character.getNumericValue(line.charAt(i));
                if(current == 0 && nestingLevel == 0) {
                    solution += current;
                    continue;
                }

                if(nestingLevel == current) {
                    solution += current;
                }

                if(nestingLevel < current) {
                    for(int j = 1; j <= current - nestingLevel; j++) {
                        solution += "(";
                    }
                    solution += current;
                    nestingLevel += current - nestingLevel;
                }

                if(nestingLevel > current) {
                    for(int j = 1; j <= nestingLevel - current; j++) {
                        solution += ")";
                    }
                    solution += current;
                    nestingLevel -= nestingLevel - current;
                }

                if(nestingLevel > 0 && i == line.length() - 1) {
                    for(int j = 1; j <= nestingLevel; j++) {
                        solution += ")";
                    }
                    continue;
                }
            }

            solution += "\n";
        }

        System.out.print(solution);
      }
    }
