package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static ArrayList<String> patternList = new ArrayList<>();

    public static void main(String[] args) {
        int testCase;
        int numberOfPattern;
        String[] result;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        testCase = Integer.parseInt(in.nextLine().trim());
        result = new String[testCase];
        for(int i=0; i<testCase; i++){
            int smallestLengthPrefix = -1;
            String smallestPatternPrefix = null;
            int smallestIndexPrefix = -1;
            int largestIndexPrefix = -1;
            int largestLengthPrefix = -1;
            String largestPatternPrefix = null;
            int smallestLengthSuffix = -1;
            String smallestPatternSuffix = null;
            int smallestIndexSuffix = -1;
            int largestIndexSuffix = -1;
            int largestLengthSuffix = -1;
            String largestString = "";
            String largestPatternSuffix = null;

            numberOfPattern = Integer.parseInt(in.nextLine().trim());
            for (int j=0; j<numberOfPattern; j++) {
                String inputString = in.nextLine().trim();
                patternList.add(inputString);
                //ArrayList<String> part = new ArrayList<>();
                if(largestString.length() < inputString.length()){
                    largestString = inputString;
                }
                String[] part = inputString.split(Pattern.quote("*"));
                /*part.add(partString[0]);
                if(partString.length == 1)
                    part.add("");
                else
                    part.add(partString[1]);
                System.out.println("Part 1 = " + part.get(0) + "  Part 2 = " + part.get(1));
                System.out.println(part.size()); 5252655252 */

                if (!part[0].equals("")) {
                    if (inputString.length() < smallestLengthPrefix || smallestLengthPrefix == -1) {
                        smallestLengthPrefix = inputString.length();
                        smallestPatternPrefix = inputString;
                        //smallestIndexPrefix = j;
                    }
                    if (largestLengthPrefix < inputString.length()) {
                        largestLengthPrefix = inputString.length();
                        largestPatternPrefix = inputString;
                        //largestIndexPrefix = j;
                    }
                }


                if (part.length == 2 && !part[1].equals("")) {
                    if (inputString.length() < smallestLengthSuffix || smallestLengthSuffix == -1) {
                        smallestLengthSuffix = inputString.length();
                        smallestPatternSuffix = inputString;
                        //smallestIndexSuffix = j;
                    }
                    if (largestLengthSuffix < inputString.length()) {
                        largestLengthSuffix = inputString.length();
                        largestPatternSuffix = inputString;
                        //largestIndexSuffix = j;
                    }
                }
            }
            result[i] = matchPattern(smallestPatternSuffix, largestPatternSuffix, smallestPatternPrefix, largestPatternPrefix, largestString);
        }
        for (int i = 0; i < testCase; i++) {
            if(result[i] == null)
                System.out.println("Case #" + (i + 1) + ": *");
            else
                System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }
    private static String matchPattern(String smallestPatternSuffix, String largestPatternSuffix, String smallestPatternPrefix, String largestPatternPrefix, String largestString) {
        for(String pattern : patternList) {
            if(pattern.startsWith("*")) {
                //*ABC
                if(!pattern.endsWith(smallestPatternSuffix.substring(1))) {
                    patternList.clear();
                    return null;
                }
                if(!largestPatternSuffix.endsWith(pattern.substring(1))){
                    patternList.clear();
                    return null;
                }
            } else if(pattern.endsWith("*")) {
                // ABC*
                if(!pattern.startsWith(smallestPatternPrefix.substring(0, smallestPatternPrefix.length() - 1))) {
                    patternList.clear();
                    return null;
                }
                if(!largestPatternPrefix.startsWith(pattern.substring(1))){
                    patternList.clear();
                    return null;
                }
            } else {
                // ABC*GF
                if(!pattern.startsWith(smallestPatternPrefix.substring(0, smallestPatternPrefix.length() - 1)) || !pattern.endsWith(smallestPatternSuffix.substring(1))) {
                    patternList.clear();
                    return null;
                }
                if(!largestPatternPrefix.startsWith(pattern.substring(1))){
                    patternList.clear();
                    return null;
                }
                if(!largestPatternSuffix.endsWith(pattern.substring(1))){
                    patternList.clear();
                    return null;
                }
                    /*if(!pattern.endsWith(smallestPatternSuffix.substring(1,smallestPatternSuffix.length()))) {
                        patternList.clear();
                        return null;
                    }*/
            }
            /*if(!pattern.endsWith(smallestPatternSuffix.substring(1))) {
                patternList.clear();
                return null;
            }*/
        }
        patternList.clear();
        return largestString.replace("*", "");
    }
}

