import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int numberOfStrings = scanner.nextInt();
            List<String> strings = new ArrayList<>();
            
            for (int i = 0; i < numberOfStrings; i++) {
                strings.add(scanner.next());
            }
            
            TreeSet<String> sortedUniqueStrings = new TreeSet<>(strings);
            List<String> sortedStringsList = new ArrayList<>(sortedUniqueStrings);
            String[] sortedStringsArray = new String[sortedStringsList.size()];
            sortedStringsList.toArray(sortedStringsArray);
            
            Arrays.sort(sortedStringsArray, (a, b) -> Integer.compare(b.length(), a.length()));
            
            boolean isMatch = true;
            String pattern = sortedStringsArray[0].replace("*", "");
            
            for (int i = 1; i < sortedStringsArray.length && isMatch; i++) {
                if (!isPatternMatch(sortedStringsArray[i], pattern)) {
                    isMatch = false;
                }
            }
            
            System.out.print("Case #" + caseIndex + ": ");
            if (isMatch) {
                System.out.println(pattern);
            } else {
                System.out.println("*");
            }
        }
        
        scanner.close();
    }
    
    public static boolean isPatternMatch(String first, String second) {
        if (first.isEmpty() && second.isEmpty()) {
            return true;
        }
        if (first.length() > 1 && first.charAt(0) == '*' && second.isEmpty()) {
            return false;
        }
        if (!first.isEmpty() && !second.isEmpty() && first.charAt(0) == second.charAt(0)) {
            return isPatternMatch(first.substring(1), second.substring(1));
        }
        if (!first.isEmpty() && first.charAt(0) == '*') {
            return isPatternMatch(first.substring(1), second) || isPatternMatch(first, second.substring(1));
        }
        return false;
    }
}