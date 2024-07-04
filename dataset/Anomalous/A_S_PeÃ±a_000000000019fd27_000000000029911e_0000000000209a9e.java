import java.util.Scanner;

public class Solution {
    
    private static final Scanner scanner = new Scanner(System.in);
    
    private static String solve(int B) {
        int[] arr = new int[B + 1];
        int matchIndex = -1;
        int diffIndex = -1;
        int queries = 0;
        int temp;
        
        for (int i = 1; i <= B / 2; ++i) {
            if (queries > 0 && queries % 10 == 0) {
                if (matchIndex > -1) {
                    System.out.printf("%d\n", matchIndex);
                    temp = scanner.nextInt();
                    ++queries;
                    if (arr[matchIndex] != temp) {
                        for (int j = 1; j < i; ++j) {
                            arr[j] ^= 1;
                            arr[B - j + 1] ^= 1;
                        }
                    }
                }
                if (diffIndex > -1) {
                    System.out.printf("%d\n", diffIndex);
                    temp = scanner.nextInt();
                    ++queries;
                    if (arr[diffIndex] != temp) {
                        for (int j = 1; j < i; ++j) {
                            temp = arr[j];
                            arr[j] = arr[B - j + 1];
                            arr[B - j + 1] = temp;
                        }
                    }
                }
                if (queries % 2 == 1) {
                    System.out.printf("%d\n", 1);
                    temp = scanner.nextInt();
                    ++queries;
                }
            }
            
            System.out.printf("%d\n", i);
            arr[i] = scanner.nextInt();
            System.out.printf("%d\n", B - i + 1);
            arr[B - i + 1] = scanner.nextInt();
            
            if (matchIndex < 0 && arr[i] == arr[B - i + 1]) {
                matchIndex = i;
            } else if (diffIndex < 0 && arr[i] != arr[B - i + 1]) {
                diffIndex = i;
            }
            
            queries += 2;
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= B; ++i) {
            result.append(arr[i]);
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        int T = scanner.nextInt();
        int B = scanner.nextInt();
        
        for (int t = 1; t <= T; ++t) {
            String result = solve(B);
            System.out.printf("%s\n", result);
            String response = scanner.next();
            if (response.equals("N")) {
                System.exit(0);
            }
        }
        
        scanner.close();
    }
}