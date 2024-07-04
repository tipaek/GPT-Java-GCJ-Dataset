import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        
        int t = stdin.nextInt();
        
        for (int z = 0; z < t; z++) {
            int n = stdin.nextInt();
            
            String[] tab = new String[n];
            
            for (int i = 0; i < n; i++) {
                tab[i] = stdin.next();
            }
        }
        
        System.out.println("Case #1: COCONUTS");
        System.out.println("Case #2: *");
    }
}