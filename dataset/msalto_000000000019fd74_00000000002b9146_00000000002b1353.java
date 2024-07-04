import java.util.*;

public class Solution {

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        int testCases = readInt(scanner);
        for (int i = 1; i <= testCases; ++i) {
        	System.out.println("Case #" + i + ":");
            solve(readInt(scanner));
        }
    }
    
    private static void solve(int n) {
        int row = 1;
        int next =  2;
        int sum = 1;
        System.out.println("1 1");
        while (true) {
            int newSum = sum + next;
            if (newSum >= n) {
                int diff = n - sum;
                for (int i = 0; i < diff; i++) {
                    System.out.println(++row + " " + 1);
                }
                break;
            } else {
                sum = newSum;
                System.out.println(++row + " " + 2);
            }
            ++next;
        }
    }

    private static int readInt(Scanner scanner) {
        String line = scanner.nextLine();
        return Integer.parseInt(line);
    }

    

}

