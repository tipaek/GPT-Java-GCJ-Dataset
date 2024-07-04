import java.util.*;

class Solution {
    static char[] ans;
    static int index, pairIndex, sameIndex, diffIndex, totalBits, totalCases;
    static char tempChar;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        totalCases = scanner.nextInt();
        totalBits = scanner.nextInt();
        
        for (int caseNum = 0; caseNum < totalCases; caseNum++) {
            ans = new char[totalBits];
            Arrays.fill(ans, '1');
            index = 0;
            sameIndex = -1;
            diffIndex = -1;

            for (int i = 1; index < (totalBits + 1) / 2; i += 2) {
                if (i > 10 && i % 10 == 1) {
                    applyTransformations();
                } else {
                    readPair();
                }
            }
            
            System.out.print(String.valueOf(ans));
            System.out.flush();
            char result = scanner.next().charAt(0);
            if (result == 'N') {
                return;
            }
        }
    }

    static void complementArray(char[] array) {
        for (int i = 0; i < totalBits; i++) {
            array[i] = array[i] == '0' ? '1' : '0';
        }
    }

    static void reverseArray(char[] array) {
        for (int i = 0; i < totalBits / 2; i++) {
            char temp = array[i];
            array[i] = array[totalBits - 1 - i];
            array[totalBits - 1 - i] = temp;
        }
    }

    static void readPair() {
        System.out.println(index + 1);
        System.out.flush();
        ans[index] = scanner.next().charAt(0);
        
        if (index != totalBits - 1 - index) {
            System.out.println(totalBits - index);
            System.out.flush();
            ans[totalBits - 1 - index] = scanner.next().charAt(0);
        }
        
        if (ans[index] == ans[totalBits - 1 - index]) {
            sameIndex = index;
        } else {
            diffIndex = index;
        }
        
        index++;
    }

    static void applyTransformations() {
        if (sameIndex != -1) {
            System.out.println(sameIndex + 1);
            tempChar = scanner.next().charAt(0);
            if (ans[sameIndex] != tempChar) {
                complementArray(ans);
            }
        } else {
            System.out.println(1);
            tempChar = scanner.next().charAt(0);
        }
        
        if (diffIndex != -1) {
            System.out.println(diffIndex + 1);
            tempChar = scanner.next().charAt(0);
            if (ans[diffIndex] != tempChar) {
                reverseArray(ans);
            }
        } else {
            System.out.println(1);
            tempChar = scanner.next().charAt(0);
        }
        
        System.out.flush();
    }
}