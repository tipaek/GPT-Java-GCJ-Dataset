import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numStrings = scanner.nextInt();
            String[] strings = new String[numStrings];
            
            for (int i = 0; i < numStrings; i++) {
                strings[i] = scanner.next();
            }
            
            String result = mergeStrings(strings[0], strings[1]);
            int index = 2;
            
            while (!result.equals("*") && index < numStrings) {
                result = mergeStrings(result, strings[index]);
                index++;
            }
            
            if (!result.equals("*")) {
                result = removeAsterisks(result);
            }
            
            System.out.println("Case #" + caseNumber + ": " + result);
        }
        
        scanner.close();
    }
    
    public static String mergeStrings(String str1, String str2) {
        StringBuilder merged = new StringBuilder();
        int index1 = 0, index2 = 0;
        
        while (str1.charAt(index1) != '*') index1++;
        while (str2.charAt(index2) != '*') index2++;
        
        if (index1 < index2) {
            for (int i = 0; i < index1; i++) {
                if (str1.charAt(i) != str2.charAt(i)) return "*";
                merged.append(str1.charAt(i));
            }
            for (int i = index1; i < index2; i++) merged.append(str2.charAt(i));
        } else {
            for (int i = 0; i < index2; i++) {
                if (str2.charAt(i) != str1.charAt(i)) return "*";
                merged.append(str2.charAt(i));
            }
            for (int i = index2; i < index1; i++) merged.append(str1.charAt(i));
        }
        
        merged.append("*");
        index1++;
        index2++;
        
        int length1 = str1.length();
        int length2 = str2.length();
        
        if (length1 - index1 > length2 - index2) {
            for (int i = index1; i < length1 - length2 + index2; i++) {
                merged.append(str1.charAt(i));
            }
            int j = index2;
            for (int i = length1 - length2 + index2; i < length1; i++) {
                if (str1.charAt(i) != str2.charAt(j)) return "*";
                merged.append(str1.charAt(i));
                j++;
            }
        } else {
            for (int i = index2; i < length2 - length1 + index1; i++) {
                merged.append(str2.charAt(i));
            }
            int j = index1;
            for (int i = length2 - length1 + index1; i < length2; i++) {
                if (str1.charAt(j) != str2.charAt(i)) return "*";
                merged.append(str2.charAt(i));
                j++;
            }
        }
        
        return merged.toString();
    }
    
    public static String removeAsterisks(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '*') {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }
}