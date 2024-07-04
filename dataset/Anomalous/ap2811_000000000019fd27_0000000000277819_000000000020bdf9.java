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
            
            // Sort intervals by end time
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (end[j] > end[j + 1]) {
                        swap(end, j, j + 1);
                        swap(start, j, j + 1);
                        swap(index, j, j + 1);
                    }
                }
            }
            
            int lastEndC = end[0];
            ch[0] = 'C';
            
            for (int i = 1; i < n; i++) {
                if (start[i] >= lastEndC) {
                    ch[i] = 'C';
                    lastEndC = end[i];
                }
            }
            
            int firstUnassigned = -1;
            for (int i = 0; i < n; i++) {
                if (ch[i] == 'x') {
                    firstUnassigned = i;
                    break;
                }
            }
            
            if (firstUnassigned != -1) {
                ch[firstUnassigned] = 'J';
                int lastEndJ = end[firstUnassigned];
                
                for (int i = firstUnassigned + 1; i < n; i++) {
                    if (start[i] >= lastEndJ && ch[i] == 'x') {
                        ch[i] = 'J';
                        lastEndJ = end[i];
                    }
                }
            }
            
            boolean impossible = false;
            for (int i = 0; i < n; i++) {
                if (ch[i] == 'x') {
                    impossible = true;
                    break;
                }
            }
            
            if (impossible) {
                s.append("IMPOSSIBLE");
            } else {
                for (int m = 1; m <= n; m++) {
                    for (int i = 0; i < n; i++) {
                        if (index[i] == m) {
                            s.append(ch[i]);
                        }
                    }
                }
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