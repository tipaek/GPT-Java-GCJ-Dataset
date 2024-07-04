import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        while (n > 0) {
            int testCases = scanner.nextInt();
            String[] strings = new String[testCases];
            
            for (int i = 0; i < testCases; i++) {
                strings[i] = scanner.next();
            }
            
            // Sort strings by length
            Arrays.sort(strings, Comparator.comparingInt(String::length));
            
            String reference = strings[testCases - 1];
            boolean isValid = true;
            String result = "";
            
            for (int i = 0; i < testCases - 1; i++) {
                int starIndexRef = reference.indexOf('*');
                String prefixRef = reference.substring(0, starIndexRef);
                String suffixRef = reference.substring(starIndexRef + 1);
                
                int starIndexStr = strings[i].indexOf('*');
                String prefixStr = strings[i].substring(0, starIndexStr);
                String suffixStr = strings[i].substring(starIndexStr + 1);
                
                if (!prefixRef.contains(prefixStr) || !suffixRef.contains(suffixStr)) {
                    isValid = false;
                    break;
                }
                
                result = prefixRef + suffixRef;
            }
            
            if (isValid) {
                System.out.println(result);
            } else {
                System.out.println('*');
            }
            
            n--;
        }
        
        scanner.close();
    }
}