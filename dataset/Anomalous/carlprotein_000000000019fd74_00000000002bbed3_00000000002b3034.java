import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfRounds = scanner.nextInt();
        
        for (int i = 1; i <= numberOfRounds; i++) {
            int size = scanner.nextInt();
            scanner.nextLine();
            processTestCase(i, size, scanner);
        }
    }

    public static void processTestCase(int caseNumber, int size, Scanner scanner) {
        boolean noMatchFound = false;
        String leftPart = "";
        String rightPart = "";
        
        for (int i = 0; i < size; i++) {
            String row = scanner.nextLine().replace('*', ' ').trim();
            
            if (row.isEmpty()) {
                continue;
            }
            
            String leftSegment = "";
            String rightSegment = "";
            
            if (row.startsWith(" ")) {
                rightSegment = row.trim();
            } else if (row.endsWith(" ")) {
                leftSegment = row.trim();
            } else {
                String[] rowElements = row.split(" ");
                leftSegment = rowElements[0];
                rightSegment = rowElements[1];
            }
            
            if (leftPart.isEmpty()) {
                leftPart = leftSegment;
            } else if (!leftSegment.isEmpty()) {
                if (!leftPart.contains(leftSegment) && !leftSegment.contains(leftPart)) {
                    noMatchFound = true;
                    break;
                }
                if (leftSegment.contains(leftPart)) {
                    leftPart = leftSegment;
                }
            }
            
            if (rightPart.isEmpty()) {
                rightPart = rightSegment;
            } else if (!rightSegment.isEmpty()) {
                if (!rightPart.contains(rightSegment) && !rightSegment.contains(rightPart)) {
                    noMatchFound = true;
                    break;
                }
                if (rightSegment.contains(rightPart)) {
                    rightPart = rightSegment;
                }
            }
            
            if (leftPart.length() + rightPart.length() > 10000) {
                break;
            }
        }
        
        String result = leftPart + rightPart;
        
        if (noMatchFound || result.length() > 10000) {
            System.out.println("Case #" + caseNumber + ": *");
        } else {
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}