import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int B = sc.nextInt();
        
        for (int i = 0; i < T; i++) {
            sc.next(); // Read and discard the string input
            ArrayList<Integer> temp = new ArrayList<>();
            int count = 1;
            
            for (int j = 0; j < B; j++) {
                if (count % 10 == 1) {
                    j--; // Decrement j to retry this iteration
                } else {
                    System.out.println(j);
                    temp.add(sc.nextInt());
                }
                count++;
            }
            
            StringBuilder result = new StringBuilder();
            for (int num : temp) {
                result.append(num);
            }
            System.out.println(result);
            
            String check = sc.next();
            if (check.equals("N")) {
                break;
            }
        }
        sc.close();
    }
}