import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    
    private static final boolean DEBUG = false;
    private static final boolean FROM_FILE = false;
    private static final String INPUT_FILE = "testB.in";
    
    private static PrintWriter writer;
    private static Scanner scanner;
    
    private static void debugPrintln(String message) {
        if (DEBUG) {
            writer.println(message);
        }
    }
    
    private static void debugPrint(String message) {
        if (DEBUG) {
            writer.print(message);
        }
    }
    
    private static long currentTimeInNano() {
        return System.nanoTime();
    }
    
    private static double roundToSignificantDigits(double value, int significantDigits) {
        double scale = Math.pow(10, significantDigits);
        return Math.round(value * scale) / scale;
    }
    
    private static void printElapsedTime(long start, long end) {
        long elapsedTime = end - start;
        double millisecondsPerNanosecond = 1e-6;
        
        debugPrintln("Milliseconds elapsed: " + roundToSignificantDigits(elapsedTime * millisecondsPerNanosecond, 4) + 
                     " (" + roundToSignificantDigits(start * millisecondsPerNanosecond, 4) + ", " + 
                     roundToSignificantDigits(end * millisecondsPerNanosecond, 4) + ")");
    }
    
    private static void processCase(int caseNumber) {
        String sequence = scanner.next();
        int length = sequence.length();
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;
        
        for (int i = 0; i < length; i++) {
            int nextDepth = Character.getNumericValue(sequence.charAt(i));
            
            if (nextDepth > currentDepth) {
                result.append("(".repeat(nextDepth - currentDepth));
            } else if (nextDepth < currentDepth) {
                result.append(")".repeat(currentDepth - nextDepth));
            }
            
            result.append(nextDepth);
            currentDepth = nextDepth;
        }
        
        result.append(")".repeat(currentDepth));
        
        writer.print("Case #" + caseNumber + ": " + result);
    }
    
    public static void main(String[] args) throws Exception {
        scanner = FROM_FILE ? new Scanner(new File(INPUT_FILE)) : new Scanner(System.in);
        writer = new PrintWriter(System.out);
        
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            processCase(i + 1);
            
            if (i < testCases - 1) {
                writer.println();
            }
        }
        
        writer.close();
        scanner.close();
    }
}