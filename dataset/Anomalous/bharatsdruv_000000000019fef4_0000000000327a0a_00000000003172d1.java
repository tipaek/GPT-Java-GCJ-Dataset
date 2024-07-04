import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int tc = 1; tc <= testCases; tc++) {
            int N = scanner.nextInt();
            int D = scanner.nextInt();
            long[] array = new long[N];
            
            for (int i = 0; i < N; i++) {
                array[i] = scanner.nextLong();
            }
            
            Arrays.sort(array);
            int flag = -1;
            int result = 0;
            
            for (int i = 0; i <= N - D - 1; i++) {
                long current = array[i];
                int count = 1;
                
                for (int j = i + 1; j < i + D; j++) {
                    if (array[j] != current) {
                        flag = 0;
                        break;
                    }
                    count++;
                }
                
                if (count > D) {
                    flag = 1;
                    break;
                }
            }
            
            if (flag != 1) {
                if (D == 2) {
                    result = 1;
                } else if (D == 3 && N == 1) {
                    result = 2;
                } else {
                    flag = 0;
                    for (int i = 0; i < N - 1; i++) {
                        long current = array[i];
                        for (int j = i + 1; j < N; j++) {
                            if (array[j] % current == 0) {
                                result = 1;
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 1) {
                            break;
                        }
                    }
                    if (flag == 0) {
                        result = 2;
                    }
                }
            }
            
            System.out.println("Case #" + tc + ": " + result);
        }
        
        scanner.close();
    }
}