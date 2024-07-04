import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int o = 1; o <= t; o++) {
            int n = sc.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            int[] index = new int[n];
            char[] ch = new char[n];
            StringBuilder s = new StringBuilder();
            
            for (int i = 0; i < n; i++) {
                start[i] = sc.nextInt();
                end[i] = sc.nextInt();
                index[i] = i + 1;
                ch[i] = 'x';
            }
            
            // Sort intervals by start time using Bubble Sort
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (start[j] > start[j + 1]) {
                        swap(start, j, j + 1);
                        swap(end, j, j + 1);
                        swap(index, j, j + 1);
                    }
                }
            }
            
            int cEnd = 0, jEnd = 0;
            boolean possible = true;
            
            for (int i = 0; i < n; i++) {
                if (start[i] >= cEnd) {
                    ch[i] = 'C';
                    cEnd = end[i];
                } else if (start[i] >= jEnd) {
                    ch[i] = 'J';
                    jEnd = end[i];
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (!possible) {
                s.append("IMPOSSIBLE");
            } else {
                char[] result = new char[n];
                for (int i = 0; i < n; i++) {
                    result[index[i] - 1] = ch[i];
                }
                s.append(result);
            }
            
            System.out.println("Case #" + o + ": " + s);
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}