import java.util.*;

class Solution {
    static char[] ans;
    static int i, j, r, c, t, b;
    static char l;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        t = scanner.nextInt();
        b = scanner.nextInt();
        
        for (int tim = 0; tim < t; tim++) {
            ans = new char[b];
            Arrays.fill(ans, '1');
            
            for (i = 1, j = 0, r = -1, c = -1; j < (b + 1) / 2; i += 2) {
                if (i > 10 && i % 10 == 1) {
                    handleSpecialCase();
                } else {
                    processPair();
                }
            }
            
            System.out.println(String.valueOf(ans));
            System.out.flush();
            
            char result = scanner.next().charAt(0);
            if (result == 'N') {
                return;
            }
        }
    }

    static void complement(char[] array) {
        for (int i = 0; i < b; i++) {
            array[i] = (array[i] == '0') ? '1' : '0';
        }
    }

    static void reverse(char[] array) {
        for (int i = 0; i < b / 2; i++) {
            char temp = array[i];
            array[i] = array[b - i - 1];
            array[b - i - 1] = temp;
        }
    }

    static void processPair() {
        System.out.println(j + 1);
        System.out.flush();
        System.out.println(b - j);
        System.out.flush();
        
        ans[b - 1 - j] = scanner.next().charAt(0);
        if (ans[j] == ans[b - 1 - j]) {
            c = j;
        } else {
            r = j;
        }
        j++;
    }

    static void handleSpecialCase() {
        if (c != -1) {
            System.out.println(c + 1);
            l = scanner.next().charAt(0);
            if (ans[c] != l) {
                complement(ans);
            }
        } else {
            System.out.println(1);
            l = scanner.next().charAt(0);
        }
        
        if (r != -1) {
            System.out.println(r + 1);
            l = scanner.next().charAt(0);
            if (ans[r] != l) {
                reverse(ans);
            }
        } else {
            System.out.println(1);
            l = scanner.next().charAt(0);
        }
        System.out.flush();
    }
}