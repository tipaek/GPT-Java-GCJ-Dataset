import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void solve(Scanner scanner) {
        int u = scanner.nextInt();
        char[] result = new char[10];
        ArrayList<HashSet<Character>> charSets = new ArrayList<>(10);
        
        for (int i = 0; i < 10; i++) {
            charSets.add(new HashSet<>());
        }
        
        for (int i = 0; i < 10000; i++) {
            int q = scanner.nextInt();
            String r = scanner.next();
            
            if (q == 10 && r.length() == 2) {
                charSets.add(0, new HashSet<>());
                charSets.get(0).add(r.charAt(1));
            } else if (q < 10) {
                charSets.get(q).add(r.charAt(0));
            }
        }
        
        for (int i = 0; i < 10; i++) {
            result[i] = charSets.get(i).iterator().next();
            for (int j = i + 1; j < 10; j++) {
                charSets.get(j).remove(result[i]);
            }
        }
        
        for (char c : result) {
            System.out.print(c);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            System.out.print("Case #" + i + ": ");
            solve(scanner);
        }
        
        scanner.close();
    }
}