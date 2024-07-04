import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        int n = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String answer = processInput(in, n);
            System.out.println(answer);
            System.out.flush();
            if(in.next().equals("N")) {
                System.exit(0);
            }
        }
    }
//    B == 10
//    static String processInput(Scanner input, int n) {
//        char[] answer = new char[n];
//        Arrays.fill(answer, 'N');
//        for(int i = 1; i <= n; ++i) {
//            System.out.println(i);
//            System.out.flush();
//            answer[i-1] = input.next().toCharArray()[0];
//        }
//        return new String(answer);
//    }
    static String processInput(Scanner input, int n) {
        char[] answer = new char[n];
        Arrays.fill(answer, 'N');
        for(int i = 1; i <= 5; ++i) {
            System.out.println(i);
            System.out.flush();
            answer[i-1] = input.next().toCharArray()[0];
        }
        for(int i = 1; i <= 5; ++i) {
            System.out.println(n-i);
            System.out.flush();
            answer[n-i] = input.next().toCharArray()[0];
        }
        char[][] candidates = possibleCandidate(answer, 5);
        int[] tries = positionToTry(candidates[0], 5, n);

        int finishedLength = 5;
        for(int i = 0; i < 14; ++i) {
            char[] triesResult = new char[3];
            for(int j = 0; j < 3; ++j) {
                System.out.println(tries[j]+1);
                System.out.flush();
                triesResult[j] = input.next().toCharArray()[0];
            }
            int matchedResult = 0;
            for(int j = 0; j < 4; ++j) {
                if(triesResult[0] == candidates[j][tries[0]]
                        && triesResult[1] == candidates[j][tries[1]]
                        && triesResult[2] == candidates[j][tries[2]]) {
                    matchedResult = j;
                    break;
                }
            }
            answer = candidates[matchedResult];
            for(int j = 1; j <= 7 && finishedLength + j < n; ++j) {
                System.out.println(finishedLength + j);
                System.out.flush();
                answer[finishedLength + j - 1] = input.next().toCharArray()[0];
            }
            finishedLength += 7;
            if(finishedLength >= n) {
                break;
            }
        }
        return new String(answer);
    }

    static char[][] possibleCandidate(char[] currentAnswer, int length) {
        int B = currentAnswer.length;
        char[][] answer = new char[4][];
        answer[0] = currentAnswer; // unchanged.
        answer[1] = new char[currentAnswer.length]; // complemented
        answer[2] = new char[currentAnswer.length]; // reversed
        answer[3] = new char[currentAnswer.length]; // both
        Arrays.fill(answer[1], 'N');
        Arrays.fill(answer[2], 'N');
        Arrays.fill(answer[3], 'N');
        for(int i = 0; i < length; ++i) {
            answer[1][i] = currentAnswer[i]=='0'?'1':'0';
            answer[2][B-1-i] = currentAnswer[i];
            answer[3][B-1-i] = currentAnswer[i]=='0'?'1':'0';

            answer[1][B-1-i] = currentAnswer[B-1-i]=='0'?'1':'0';
            answer[2][i] = currentAnswer[B-1-i];
            answer[3][i] = currentAnswer[B-1-i]=='0'?'1':'0';
        }

        if(currentAnswer[length] != 'N') {
            answer[1][length] = currentAnswer[length]=='0'?'1':'0';
            answer[2][B-1-length] = currentAnswer[length];
            answer[3][B-1-length] = currentAnswer[length]=='0'?'1':'0';
        }

        if(currentAnswer[B-1-length] != 'N') {
            answer[1][B-1-length] = currentAnswer[B-1-length]=='0'?'1':'0';
            answer[2][length] = currentAnswer[B-1-length];
            answer[3][length] = currentAnswer[B-1-length]=='0'?'1':'0';
        }

        return answer;
    }

    static int[] positionToTry(char[] candidate, int length, int n) {
        int[] answer = new int[3];
        Arrays.fill(answer, -1);
        for(int i = 0; i < length-2; ++i) {
            for(int j = 0; j < length-1; ++j) {
                for(int k = 0; k < length; ++k) {
                    if(!isCompliment(candidate[i], candidate[j], candidate[k],
                            candidate[n-i-1], candidate[n-j-1], candidate[n-k-1])) {
                        return new int[]{i, j, k};
                    }
                }
            }
        }
        return answer;
    }

    static boolean isCompliment(char l1, char l2, char l3, char r1, char r2, char r3) {
        if(l1 != '0') {
            l2 = l2=='0'?'1':'0';
            l3 = l3=='0'?'1':'0';
        }

        if(r1 != '0') {
            r2 = r2=='0'?'1':'0';
            r3 = r3=='0'?'1':'0';
        }

        return r2 == l2 && r3 == l3;
    }
}