import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalCases = sc.nextInt();
        
        for (int caseNumber = 1; caseNumber <= totalCases; caseNumber++) {
            int numberOfStrings = sc.nextInt();
            List<String> stringList = new ArrayList<>();
            
            for (int i = 0; i < numberOfStrings; i++) {
                String inputString = sc.next().substring(1);
                stringList.add(inputString);
            }
            
            TreeSet<String> sortedSet = new TreeSet<>(stringList);
            List<String> sortedList = new ArrayList<>(sortedSet);
            String[] sortedArray = sortedList.toArray(new String[0]);
            
            // Insertion sort based on length
            for (int i = 1; i < sortedArray.length; i++) {
                String currentString = sortedArray[i];
                int j = i - 1;
                while (j >= 0 && currentString.length() < sortedArray[j].length()) {
                    sortedArray[j + 1] = sortedArray[j];
                    j--;
                }
                sortedArray[j + 1] = currentString;
            }
            
            boolean isValid = true;
            for (int i = 1; i < sortedArray.length && isValid; i++) {
                if (!sortedArray[i].contains(sortedArray[i - 1])) {
                    isValid = false;
                }
            }
            
            System.out.print("Case #" + caseNumber + ": ");
            if (isValid) {
                System.out.println(sortedArray[sortedArray.length - 1]);
            } else {
                System.out.println("*");
            }
        }
        sc.close();
    }
}