import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static BufferedReader reader;
    private static StringTokenizer tokenizer;
    private static int B;
    private static int[] currentBits;
    private static int checkCounter = 0;

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = new StringTokenizer(reader.readLine());
        int T = Integer.parseInt(tokenizer.nextToken());
        B = Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < T; i++) {
            resetState();
            if (!initializeBits()) return;
            if (!processBits()) return;
            if (!submitAnswer()) return;
        }
    }

    private static void resetState() {
        checkCounter = 0;
        currentBits = new int[B + 1];
        for (int k = 0; k <= B; k++) {
            currentBits[k] = -1;
        }
    }

    private static boolean initializeBits() throws IOException {
        for (int k = 1; k <= 5; k++) {
            if (!checkAndAssignBits(k)) return false;
        }
        return true;
    }

    private static boolean processBits() throws IOException {
        int type1Tester = findTypeTester(1);
        int type2Tester = findTypeTester(2);
        boolean foundBothTypes = (type1Tester != -1 && type2Tester != -1);

        for (int j = 1; j < 15 && !allBitsFound(); j++) {
            if (!updateBits(type1Tester, type2Tester)) return false;
            if (!findNewBits(j, foundBothTypes)) return false;
            if (!foundBothTypes && !performExtraCheck()) return false;
        }
        return true;
    }

    private static boolean submitAnswer() throws IOException {
        StringBuilder finalAnswer = new StringBuilder();
        for (int p = 1; p <= B; p++) {
            finalAnswer.append(currentBits[p]);
        }
        System.out.println(finalAnswer);
        System.out.flush();

        tokenizer = new StringTokenizer(reader.readLine());
        String verdict = tokenizer.nextToken();
        return !verdict.equals("N");
    }

    private static boolean checkAndAssignBits(int k) throws IOException {
        currentBits[k] = checkBit(k);
        if (currentBits[k] == -1) return false;

        currentBits[B - k + 1] = checkBit(B - k + 1);
        return currentBits[B - k + 1] != -1;
    }

    private static int findTypeTester(int type) {
        for (int k = 1; k <= B; k++) {
            if (currentBits[k] != -1 && currentBits[k] == currentBits[B - k + 1] && type == 1) {
                return k;
            } else if (currentBits[k] != -1 && currentBits[k] != currentBits[B - k + 1] && type == 2) {
                return k;
            }
        }
        return -1;
    }

    private static boolean updateBits(int type1Tester, int type2Tester) throws IOException {
        if (type1Tester != -1 && !updateBitType(type1Tester, 1)) return false;
        if (type2Tester != -1 && !updateBitType(type2Tester, 2)) return false;
        return true;
    }

    private static boolean updateBitType(int tester, int type) throws IOException {
        int newTesterValue = checkBit(tester);
        if (newTesterValue == -1) return false;

        if (currentBits[tester] != newTesterValue) {
            for (int k = 1; k <= B; k++) {
                if (currentBits[k] != -1 && currentBits[k] == type) {
                    currentBits[k] ^= 1;
                }
            }
        }
        return true;
    }

    private static boolean findNewBits(int j, boolean foundBothTypes) throws IOException {
        int l = j * 4 + 2;
        while (l < j * 4 + 6 && !allBitsFound()) {
            if (l > B / 2) {
                return true;
            } else if (!checkAndAssignBits(l)) {
                return false;
            }
            l++;
        }
        return true;
    }

    private static boolean performExtraCheck() throws IOException {
        int extra = checkBit(1);
        return extra != -1;
    }

    private static boolean allBitsFound() {
        for (int k = 1; k <= B; k++) {
            if (currentBits[k] == -1) {
                return false;
            }
        }
        return true;
    }

    private static int checkBit(int bitNum) throws IOException {
        System.out.println(bitNum);
        System.out.flush();
        tokenizer = new StringTokenizer(reader.readLine());
        String readIn = tokenizer.nextToken();
        try {
            return Integer.parseInt(readIn);
        } catch (NumberFormatException ex) {
            return -1;
        } finally {
            checkCounter++;
        }
    }
}