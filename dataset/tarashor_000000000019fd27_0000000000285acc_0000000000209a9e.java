import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static final int MAX_QUESTIONS = 150;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int testCasesCount = in.nextInt();
        int length = in.nextInt();
        for (int testCaseNumber = 1; testCaseNumber <= testCasesCount; testCaseNumber++) {
            solve(in, length);
        }
    }

    private static final int NOTHING = 1;
    private static final int COMPLEMENT = 1 << 1;
    private static final int REVERSE = 1 << 2;
    private static final int COMPL_REV = 1 << 3;

    private static class Manipulation{
        int manipulation = NOTHING;
        int requests = 0;
    }

    static int requests = 0;

    private static void solve(Scanner in, int length) {
        int checkEqual = -1;
        int checkDiff = -1;
        int i = 0;
        int mid = length / 2;
        char[] state = new char[length];
        Arrays.fill(state, '?');

        while (i < mid && requests <= 150) {
            Manipulation manipulation = getManipulation(in, state, checkEqual, checkDiff);
            manipulate(state, manipulation, i, length);

            while (requests % 10 == 0) {
                state[i] = readPos(in, i);
                state[length - i - 1] = readPos(in, length - i - 1);
                if (checkDiff < 0 && state[i] != state[length - i - 1]) {
                    checkDiff = i;
                }

                if (checkEqual < 0 && state[i] == state[length - i - 1]) {
                    checkEqual = i;
                }
                i++;
            }
        }
        for (int j = 0; j < state.length; j++){
            System.out.print(state[i]);
        }
        System.out.println();

    }

    private static void manipulate(char[] state, Manipulation manipulation, int pos, int length) {
        int man = manipulation.manipulation;

        for (int i = 0; i <= pos; i++){
            if (state[i] == state[length - i - 1]) {
                if (((man & COMPLEMENT) == COMPLEMENT)
                        || ((man & COMPL_REV) == COMPL_REV)) {
                    state[i] = complement(state[i]);
                    state[length - i - 1] = complement(state[length - i - 1]);
                }
            } else {
                if (((man & COMPLEMENT) == COMPLEMENT)
                        || ((man & REVERSE) == REVERSE)) {
                    state[i] = complement(state[i]);
                    state[length - i - 1] = complement(state[length - i - 1]);
                }
            }
        }
    }

    private static char complement(char c) {
        return c == '1' ? '0' : c == '0' ? '1' : c;
    }

    private static Manipulation getManipulation(Scanner in, char[] state, int checkEqual, int checkDiff) {
        Manipulation manipulation = new Manipulation();
        if (checkDiff < 0 && checkEqual < 0) return manipulation;

        int manEq = NOTHING | REVERSE | COMPLEMENT | COMPL_REV;
        if (checkEqual > 0){
            char prevState = state[checkEqual];
            char newState = readPos(in, checkEqual);
            if (prevState != newState){
                if(prevState == '0'){
                    manEq = COMPLEMENT | COMPL_REV;
                } else {
                    manEq = REVERSE | NOTHING;
                }
            } else {
                if(prevState == '0'){
                    manEq = REVERSE | NOTHING;
                } else {
                    manEq = COMPLEMENT | COMPL_REV;
                }
            }
        }

        int manDiff = NOTHING | REVERSE | COMPLEMENT | COMPL_REV;
        if (checkDiff > 0){
            char prevState = state[checkDiff];
            char newState = readPos(in, checkDiff);
            if (prevState != newState){
                if(prevState == '0'){
                    manDiff = COMPLEMENT | REVERSE;
                } else {
                    manDiff = COMPL_REV | NOTHING;
                }
            } else {
                if(prevState == '0'){
                    manDiff = COMPL_REV | NOTHING;
                } else {
                    manDiff = COMPLEMENT | REVERSE;
                }
            }
        }

        manipulation.manipulation = manDiff & manEq;
        return manipulation;
    }

    private static char readPos(Scanner in, int pos) {
        System.out.println(pos);
        String response = in.nextLine();
        requests++;
        return response.charAt(0);
    }

}
