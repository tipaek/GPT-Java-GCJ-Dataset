import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static Scanner input = new Scanner(System.in);
    private static PrintStream output = new PrintStream(System.out);
    private static PrintStream logger = null;

    private static boolean debug = false;

    public static <E> void log(E msg) {
        if (debug) {
            logger.println("LOG: " + msg);
        }
    }

    public static <E> void out(E msg) {
        out(msg, false);
    }

    public static <E> void outln(E msg) {
        out(msg, true);
    }

    private static <E> void out(E msg, boolean println) {
        output.print(msg);
        if (println) {
            output.println();
        }
        output.flush();

        if (debug) {
            logger.print("OUT: " + msg);
            if (println) {
                logger.println("\\n");
            } else {
                logger.println();
            }
            logger.flush();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length > 0 && args[0].equals("-debug")) {
            debug = true;
            logger = new PrintStream(new File("log.txt"));
        }

        int cases = input.nextInt();
        int b = input.nextInt();
        input.nextLine();
        for (int i = 0; i < cases; ++i) {
            solve(i + 1, b, cases);
        }
    }

    private static void solve(int testCaseNumber, int length, int cases) {
        int halfLength = length / 2;
        List<Qubit> data = new ArrayList<>(halfLength + 1);
        data.add(new Qubit(1, true)); // padding
        int samePosition = -1;
        int switchPosition = -1;
        int pos = 1;
        int questionCount = 1;
        while (true) {
            if (questionCount == 151) {
                StringBuilder result = new StringBuilder();
                for (int i = 1; i < halfLength + 1; i++) {
                    result.append(data.get(i).value);
                }
                for (int i = halfLength; i > 0; i--) {
                    result.append(data.get(i).same ? data.get(i).value : 1 - data.get(i).value);
                }
                outln(result.toString());
                // if(testCaseNumber == 47) {
                //     return;
                // }
                if(input.hasNext()) {
                    String answer = input.next();
                    if ("Y".equals(answer)) {
                        return;
                    } else {
                        System.exit(0);
                    }
                } else {
                    return;
                }
            }
            if (questionCount % 10 == 1 && questionCount != 1) {
                if (samePosition != -1) {
                    outln(samePosition);
                    String answerStr = input.next();
                    if("N".equals(answerStr)) {
                        System.exit(0);
                    }
                    int answer = Integer.parseInt(answerStr);
                    if (answer != data.get(samePosition).value) {
                        data.stream().filter(q -> q.same).forEach(q -> q.value = 1 - q.value);
                    }
                    questionCount++;
                }
                if (switchPosition != -1) {
                    outln(switchPosition);
                    String answerStr = input.next();
                    if("N".equals(answerStr)) {
                        System.exit(0);
                    }
                    int answer = Integer.parseInt(answerStr);
                    if (answer != data.get(switchPosition).value) {
                        data.stream().filter(q -> !q.same).forEach(q -> q.value = 1 - q.value);
                    }
                    questionCount++;
                }
            }
            if (questionCount % 10 != 0 && pos <= halfLength) { // ask 2 question: for pos and (length-pos+1)
                outln(pos);
                String answerStr = input.next();
                if("N".equals(answerStr)) {
                    System.exit(0);
                }
                int posAnswer = Integer.parseInt(answerStr);
                outln(length - pos + 1);
                answerStr = input.next();
                if("N".equals(answerStr)) {
                    System.exit(0);
                }
                int otherAnswer = Integer.parseInt(answerStr);
                data.add(new Qubit(posAnswer, posAnswer == otherAnswer));
                if(samePosition == -1 && posAnswer == otherAnswer) {
                    samePosition = pos;
                }
                if(switchPosition == -1 && posAnswer != otherAnswer) {
                    switchPosition = pos;
                }
                pos++;
                questionCount += 2;
            } else { // ask 1 question and ignore the answer
                outln(pos);
                input.next();
                questionCount++;
            }
        }
    }

    static class Qubit {
        int value;
        boolean same;

        public Qubit(int value, boolean same) {
            this.value = value;
            this.same = same;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public boolean isSame() {
            return same;
        }

        public void setSame(boolean same) {
            this.same = same;
        }
    }
}