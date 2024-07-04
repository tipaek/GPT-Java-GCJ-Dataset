import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    
    private static final boolean DEBUG = false;
    private static final boolean FROM_FILE = false;
    private static final String INPUT_FILE = "testB.in";
    
    private static PrintWriter writer;
    private static Scanner scanner;
    
    private static void debugPrintln(String s) {
        if (DEBUG) {
            writer.println(s);
        }
    }
    
    private static void debugPrint(String s) {
        if (DEBUG) {
            writer.print(s);
        }
    }
    
    private static long now() {
        return System.nanoTime();
    }
    
    private static double round(double value, int sigDigits) {
        double factor = Math.pow(10, sigDigits);
        return Math.round(value * factor) / factor;
    }
    
    private static void printTime(long start, long stop) {
        long elapsed = stop - start;
        double msPerNs = 1e-6;
        debugPrintln("Ms elapsed: " + round(elapsed * msPerNs, 4) + " (" + round(start * msPerNs, 4) + ", " + round(stop * msPerNs, 4) + ")");
    }
    
    private static class Digit implements Comparable<Digit> {
        private final char character;
        private int count;
        
        public Digit(char character) {
            this.character = character;
            this.count = 1;
        }
        
        @Override
        public String toString() {
            return String.valueOf(character);
        }
        
        @Override
        public int compareTo(Digit other) {
            return Integer.compare(this.count, other.count);
        }
        
        public void increment() {
            count++;
        }
    }
    
    private static void processCase(int caseNum) {
        int u = scanner.nextInt();
        HashMap<Character, Digit> characterCounts = new HashMap<>();
        
        for (int i = 0; i < 10000; i++) {
            int q = scanner.nextInt();
            String message = scanner.next();
            
            for (char c : message.toCharArray()) {
                characterCounts.computeIfAbsent(c, Digit::new).increment();
            }
        }
        
        ArrayList<Digit> digits = new ArrayList<>(characterCounts.values());
        Collections.sort(digits);
        
        StringBuilder answer = new StringBuilder();
        answer.append(digits.get(0));
        
        for (int i = digits.size() - 1; i >= 1; i--) {
            answer.append(digits.get(i));
        }
        
        writer.print("Case #" + caseNum + ": " + answer);
    }
    
    public static void main(String[] args) throws Exception {
        scanner = FROM_FILE ? new Scanner(new File(INPUT_FILE)) : new Scanner(System.in);
        writer = new PrintWriter(System.out);
        
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            processCase(i + 1);
            
            if (i < t - 1) {
                writer.println();
            }
        }
        
        writer.close();
        scanner.close();
    }
}