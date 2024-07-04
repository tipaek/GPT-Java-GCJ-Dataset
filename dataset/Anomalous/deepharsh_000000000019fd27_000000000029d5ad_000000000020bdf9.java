import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[] num = new int[n * 2];
            
            for (int j = 0; j < num.length; j++) {
                num[j] = scanner.nextInt();
            }
            
            System.out.println("Case #" + testCase + ": " + findSolution(num, "", 0));
        }
    }
    
    public static String findSolution(int[] num, String str, int i) {
        if (i == num.length - 2) {
            return "Impossible";
        }
        
        str += "C";
        
        if (num[i + 1] <= num[i + 2]) {
            while (num[i + 1] <= num[i + 2]) {
                str += "C";
                i += 2;
                
                if (i == num.length - 2) {
                    return str;
                }
            }
            return alternateSolution(num, str, i + 2);
        } else {
            return alternateSolution(num, str, i + 2);
        }
    }
    
    public static String alternateSolution(int[] num, String str, int i) {
        if (i == num.length - 2) {
            return "IMPOSSIBLE";
        }
        
        str += "J";
        
        if (num[i + 1] <= num[i + 2]) {
            while (num[i + 1] <= num[i + 2]) {
                str += "J";
                i += 2;
                
                if (i == num.length - 2) {
                    return str;
                }
            }
            return findSolution(num, str, i + 2);
        } else {
            return findSolution(num, str, i + 2);
        }
    }
}