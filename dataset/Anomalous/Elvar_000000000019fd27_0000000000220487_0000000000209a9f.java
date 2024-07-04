import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int x = 1; x <= T; x++) {
            String S = sc.next();
            int n = S.length();
            int[] H = new int[n];
            int[] V = new int[n];
            int[] a = new int[n];
            
            for (int i = 0; i < n; i++) {
                a[i] = Character.getNumericValue(S.charAt(i));
            }
            
            for (int i = 0; i < n; i++) {
                int max = a[0];
                int index = 0;
                
                for (int j = 0; j < n; j++) {
                    if (max < a[j]) {
                        max = a[j];
                        index = j;
                    }
                }
                
                int k = index;
                while (k <= n - 2 && a[k + 1] == a[k]) {
                    k++;
                }
                
                if (index == 0) {
                    int diff = max;
                    if (k < n - 1) {
                        diff = max - a[k + 1];
                    }
                    V[index] += diff;
                    H[k] += diff;
                    for (int j = 0; j <= k; j++) {
                        a[j] -= diff;
                    }
                    
                } else if (index == n - 1) {
                    int diff = max - a[index - 1];
                    V[index] += diff;
                    H[index] += diff;
                    a[index] -= diff;
                    
                } else {
                    int diff = max;
                    if (k == n - 1 || a[index - 1] > a[k + 1]) {
                        diff = a[index] - a[index - 1];
                        V[index] += diff;
                        H[k] += diff;
                        for (int j = index; j <= k; j++) {
                            a[j] -= diff;
                        }
                        
                    } else {
                        diff = max - a[k + 1];
                        V[index] += diff;
                        H[k] += diff;
                        for (int j = index; j <= k; j++) {
                            a[j] -= diff;
                        }
                    }
                }
            }
            
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < V[i]; j++) {
                    result.append("(");
                }
                result.append(S.charAt(i));
                for (int j = 0; j < H[i]; j++) {
                    result.append(")");
                }
            }
            
            System.out.println("Case #" + x + ": " + result.toString());
        }
        
        sc.close();
    }
}