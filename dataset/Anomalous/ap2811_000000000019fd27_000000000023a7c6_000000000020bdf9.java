import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int o = 1; o <= t; o++) {
            int n = sc.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            int[] index = new int[n];
            char[] ch = new char[n];
            
            for (int i = 0; i < n; i++) {
                start[i] = sc.nextInt();
                end[i] = sc.nextInt();
                index[i] = i + 1;
                ch[i] = 'x';
            }
            
            // Sort based on end times using bubble sort
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (end[j] > end[j + 1]) {
                        swap(end, j, j + 1);
                        swap(start, j, j + 1);
                        swap(index, j, j + 1);
                    }
                }
            }
            
            int endC = end[0];
            ch[0] = 'C';
            
            // Assign tasks to Cameron
            for (int i = 1; i < n; i++) {
                if (start[i] >= endC) {
                    ch[i] = 'C';
                    endC = end[i];
                }
            }
            
            // Find the first unassigned task
            int firstUnassigned = -1;
            for (int i = 0; i < n; i++) {
                if (ch[i] == 'x') {
                    firstUnassigned = i;
                    break;
                }
            }
            
            if (firstUnassigned != -1) {
                ch[firstUnassigned] = 'J';
                int endJ = end[firstUnassigned];
                
                // Assign tasks to Jamie
                for (int i = firstUnassigned + 1; i < n; i++) {
                    if (start[i] >= endJ && ch[i] != 'C') {
                        ch[i] = 'J';
                        endJ = end[i];
                    }
                }
            }
            
            // Check if all tasks are assigned
            boolean possible = true;
            for (char c : ch) {
                if (c == 'x') {
                    possible = false;
                    break;
                }
            }
            
            if (!possible) {
                System.out.println("Case #" + o + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + o + ": ");
                for (int m = 1; m <= n; m++) {
                    for (int i = 0; i < n; i++) {
                        if (index[i] == m) {
                            System.out.print(ch[i]);
                        }
                    }
                }
                System.out.println();
            }
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}