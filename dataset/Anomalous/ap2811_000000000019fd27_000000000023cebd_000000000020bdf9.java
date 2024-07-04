import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
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
            
            // Sort by end times using Bubble Sort
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (end[j] > end[j + 1]) {
                        swap(end, j, j + 1);
                        swap(start, j, j + 1);
                        swap(index, j, j + 1);
                    }
                }
            }
            
            int e = end[0];
            ch[0] = 'C';
            for (int i = 1; i < n; i++) {
                if (start[i] >= e) {
                    ch[i] = 'C';
                    e = end[i];
                }
            }
            
            int k = findFirstUnassigned(ch);
            if (k != -1) {
                ch[k] = 'J';
                e = end[k];
                for (int i = k + 1; i < n; i++) {
                    if (start[i] >= e && ch[i] != 'C') {
                        ch[i] = 'J';
                        e = end[i];
                    }
                }
            }
            
            if (n == 2 && (ch[0] == 'C' && ch[1] == 'J' || ch[0] == 'J' && ch[1] == 'C')) {
                ch[0] = 'C';
                ch[1] = 'C';
            }
            
            if (containsUnassigned(ch)) {
                System.out.println("Case #" + o + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + o + ": ");
                printSchedule(ch, index, n);
                System.out.println();
            }
        }
        
        sc.close();
    }
    
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    private static int findFirstUnassigned(char[] ch) {
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 'x') {
                return i;
            }
        }
        return -1;
    }
    
    private static boolean containsUnassigned(char[] ch) {
        for (char c : ch) {
            if (c == 'x') {
                return true;
            }
        }
        return false;
    }
    
    private static void printSchedule(char[] ch, int[] index, int n) {
        for (int m = 1; m <= n; m++) {
            for (int i = 0; i < n; i++) {
                if (index[i] == m) {
                    System.out.print(ch[i]);
                }
            }
        }
    }
}