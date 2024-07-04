import java.util.*;

class Solution {
    static char[] answer;
    static int index, pairIndex, reverseIndex, complementIndex, totalBits, testCases;
    static char tempChar;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        testCases = scanner.nextInt();
        totalBits = scanner.nextInt();
        
        for (int test = 0; test < testCases; test++) {
            answer = new char[totalBits];
            Arrays.fill(answer, '1');
            pairIndex = 0;
            reverseIndex = -1;
            complementIndex = -1;

            for (index = 1; pairIndex < (totalBits + 1) / 2; index += 2) {
                if (index > 10 && index % 10 == 1) {
                    handleBitManipulation();
                } else {
                    readBits();
                }
            }

            System.out.println(String.valueOf(answer));
            System.out.flush();
            char feedback = scanner.next().charAt(0);
            if (feedback == 'N') {
                return;
            }
        }
    }

    static void complement(char[] bits) {
        for (int i = 0; i < totalBits; i++) {
            bits[i] = (bits[i] == '0') ? '1' : '0';
        }
    }

    static void reverse(char[] bits) {
        for (int i = 0; i < totalBits / 2; i++) {
            char temp = bits[i];
            bits[i] = bits[totalBits - 1 - i];
            bits[totalBits - 1 - i] = temp;
        }
    }

    static void readBits() {
        System.out.println(pairIndex + 1);
        System.out.flush();
        answer[pairIndex] = scanner.next().charAt(0);

        System.out.println(totalBits - pairIndex);
        System.out.flush();
        answer[totalBits - 1 - pairIndex] = scanner.next().charAt(0);

        if (answer[pairIndex] == answer[totalBits - 1 - pairIndex]) {
            complementIndex = pairIndex;
        } else {
            reverseIndex = pairIndex;
        }
        pairIndex++;
    }

    static void handleBitManipulation() {
        if (complementIndex != -1) {
            System.out.println(complementIndex + 1);
            tempChar = scanner.next().charAt(0);
            if (answer[complementIndex] != tempChar) {
                complement(answer);
            }
        } else {
            System.out.println(1);
            tempChar = scanner.next().charAt(0);
        }

        if (reverseIndex != -1) {
            System.out.println(reverseIndex + 1);
            tempChar = scanner.next().charAt(0);
            if (answer[reverseIndex] != tempChar) {
                reverse(answer);
            }
        } else {
            System.out.println(1);
            tempChar = scanner.next().charAt(0);
        }
        System.out.flush();
    }
}