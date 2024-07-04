import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            String[] strings = new String[n];
            
            for (int i = 0; i < n; i++) {
                strings[i] = scanner.next();
            }
            
            String result = mergeStrings(strings[0], strings[1]);
            int index = 2;
            
            while (!result.equals("*") && index < n) {
                result = mergeStrings(result, strings[index]);
                index++;
            }
            
            result = removeAsterisks(result);
            System.out.println("Case #" + t + ": " + result);
        }
    }
    
    private static String mergeStrings(String a, String b) {
        StringBuilder merged = new StringBuilder();
        int indexA = 0, indexB = 0;
        
        while (a.charAt(indexA) != '*') indexA++;
        while (b.charAt(indexB) != '*') indexB++;
        
        if (indexA < indexB) {
            for (int i = 0; i < indexA; i++) {
                if (a.charAt(i) != b.charAt(i)) return "*";
                merged.append(a.charAt(i));
            }
            for (int i = indexA; i < indexB; i++) merged.append(b.charAt(i));
        } else {
            for (int i = 0; i < indexB; i++) {
                if (b.charAt(i) != a.charAt(i)) return "*";
                merged.append(b.charAt(i));
            }
            for (int i = indexB; i < indexA; i++) merged.append(a.charAt(i));
        }
        
        merged.append('*');
        
        int endA = a.length() - 1, endB = b.length() - 1;
        int lengthA = 0, lengthB = 0;
        
        while (a.charAt(endA) != '*') {
            lengthA++;
            endA--;
        }
        
        while (b.charAt(endB) != '*') {
            lengthB++;
            endB--;
        }
        
        for (int i = indexA; i < endA; i++) merged.append(a.charAt(i));
        merged.append('*');
        for (int i = indexB; i < endB; i++) merged.append(b.charAt(i));
        merged.append('*');
        
        indexA++;
        indexB++;
        
        int lenA = a.length(), lenB = b.length();
        
        if (lenA - indexA > lenB - indexB) {
            for (int i = indexA; i < lenA - lenB + indexB; i++) merged.append(a.charAt(i));
            int j = indexB;
            for (int i = lenA - lenB + indexB; i < lenA; i++) {
                if (a.charAt(i) != b.charAt(j)) return "*";
                merged.append(a.charAt(i));
                j++;
            }
        } else {
            for (int i = indexB; i < lenB - lenA + indexA; i++) merged.append(b.charAt(i));
            int j = indexA;
            for (int i = lenB - lenA + indexA; i < lenB; i++) {
                if (a.charAt(j) != b.charAt(i)) return "*";
                merged.append(b.charAt(i));
                j++;
            }
        }
        
        return merged.toString();
    }
    
    private static String removeAsterisks(String str) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '*') result.append(str.charAt(i));
        }
        
        return result.length() == 0 ? "*" : result.toString();
    }
}