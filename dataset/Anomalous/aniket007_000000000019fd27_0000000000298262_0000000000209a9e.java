import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character after the integer input
        
        for (int i = 0; i < t; i++) {
            int b = sc.nextInt();
            sc.nextLine(); // Consume the newline character after the integer input
            String s = sc.nextLine();
            String[] sArray = s.split("");
            
            // Assuming you want to do something with the split array `sArray`
            // For demonstration, let's print the array
            for (String str : sArray) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
        
        sc.close();
    }
}