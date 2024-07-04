import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
            in.nextLine();
            List<String> patternArray = new ArrayList<>();
            List<String> replacedArray = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                String pattern = in.nextLine();
                patternArray.add(pattern.replace("*", ".*"));
                replacedArray.add(pattern.replace("*", ""));
            }

            boolean containsFlag = true;
            Integer masterPatternIndex = null;
            for (int j = 0; j < n; j++) {
                containsFlag = true;
                String tempString = replacedArray.get(j);
                for (int k = 0; k < n; k++) {
                    if (j == k) {
                        continue;
                    }
                    String tempString2 = replacedArray.get(k);
                    if (!tempString.contains(tempString2)) {
                        containsFlag = false;
                        break;
                    }
                }
                if (containsFlag) {
                    masterPatternIndex = j;
                    break;
                }
            }

            if (null != masterPatternIndex && containsFlag) {
                System.out.println("Case #" + i + ": " + patternArray.get(masterPatternIndex).replace(".*", ""));
            } else {
                int count = 0;
                Integer indexOfStart = null;
                for (int j = 0; j < n; j++) {
                    String tempString = patternArray.get(j);
                    if (!tempString.startsWith(".*")) {
                        count++;
                        if (count > 1) {
                            break;
                        }
                        indexOfStart = j;
                    }

                }
                if (count > 1) {
                    System.out.println("Case #" + i + ": *");
                } else {
                    //TODO try merging the array

                    for(int x = 0;x<n;x++) {
                        if(null != indexOfStart) {
                            if(x!=indexOfStart) {
                                continue;
                            }
                        }
                        String pattern = patternArray.get(x);
                        pattern = pattern.replace(".*", "*");
                        String finalString = null;

                        for (int j = 0; j < n; j++) {
                            if (null!=indexOfStart && j == indexOfStart) {
                                continue;
                            }
                            if(x==j) {
                                continue;
                            }
                            String pattern2 = patternArray.get(j);
                            String replacedPattern2 = pattern2.replace(".*", "*");
                            StringBuilder sb = new StringBuilder();
                            for (int k = 0; k < pattern.length(); k++) {
                                Character c = pattern.charAt(k);
                                if(c == '*') {
                                    if(replacedPattern2.isEmpty()) {
                                        continue;
                                    }
                                    replacedPattern2 = replacedPattern2.replaceFirst("\\*","");
                                    int ind = replacedPattern2.indexOf("*");
                                    if(-1 == ind) {
                                        sb.append(replacedPattern2);
                                        replacedPattern2 = "";
                                    } else {
                                        String str = replacedPattern2.substring(0, ind);
                                        sb.append(str);
                                        replacedPattern2 = replacedPattern2.substring(ind);
                                    }
                                } else {
                                    sb.append(c);
                                }
                            }
                            String newStr = sb.toString();
                            boolean matches = true;
                            for (int k = 0; k < n; k++) {
                                String pattern3 = patternArray.get(k);
                                if(!newStr.matches(pattern3)) {
                                    matches = false;
                                }
                            }
                            if(matches) {
                                finalString = newStr;
                                break;
                            }
                        }
                        if(null == finalString) {
                            System.out.println("Case #" + i + ": *");
                        } else {
                            System.out.println("Case #" + i + ": " + finalString);
                        }
                    }
                }
            }
        }
    }
}
