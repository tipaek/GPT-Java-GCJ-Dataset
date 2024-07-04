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
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < n; i++) {
                start[i] = sc.nextInt();
                end[i] = sc.nextInt();
                index[i] = i;
                ch[i] = 'x';
            }
            
            // Sort based on end times
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
            
            boolean isPossible = true;
            for (char c : ch) {
                if (c == 'x') {
                    isPossible = false;
                    break;
                }
            }
            
            if (!isPossible) {
                result.append("IMPOSSIBLE");
            } else {
                for (int i = 1; i <= n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (index[j] == i - 1) {
                            result.append(ch[j]);
                        }
                    }
                }
            }
            
            System.out.println("Case #" + o + ": " + result);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}