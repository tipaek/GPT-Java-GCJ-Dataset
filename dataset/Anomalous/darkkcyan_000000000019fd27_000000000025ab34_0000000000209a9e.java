import java.util.Scanner;
import java.io.PrintStream;

public class Main {
    private static final PrintStream out = System.out;
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = in.nextInt();
        int n = in.nextInt();
        for (int i = 0; i < testCases; i++) {
            new Main(n).solve();
        }
    }

    private final int[] result;
    private int equalPosition = -1;
    private int differentPosition = -1;
    private int questionsAsked = 0;

    public Main(int n) {
        result = new int[n];
        Arrays.fill(result, -1);
    }

    private int query(int position) {
        out.println(position + 1);
        out.flush();
        char response = in.next().charAt(0);
        assert response != 'N';
        questionsAsked++;
        return response == '0' ? 0 : 1;
    }

    private void provideAnswer(int[] result) {
        for (int value : result) {
            out.print(value);
        }
        out.println();
        out.flush();
        assert in.next().equals("Y");
    }

    private void reverseResult() {
        int left = 0, right = result.length - 1;
        while (left < right) {
            int temp = result[left];
            result[left] = result[right];
            result[right] = temp;
            left++;
            right--;
        }
    }

    private void invertResult() {
        for (int i = 0; i < result.length; i++) {
            if (result[i] != -1) {
                result[i] = 1 - result[i];
            }
        }
    }

    private void applyFix() {
        if (equalPosition == -1 && differentPosition == -1) return;
        if (equalPosition != -1 && differentPosition != -1) {
            if (query(equalPosition) != result[equalPosition]) invertResult();
            if (query(differentPosition) != result[differentPosition]) reverseResult();
        } else {
            int position = (differentPosition == -1) ? equalPosition : differentPosition;
            if (query(position) != result[position]) invertResult();
            query(0);
        }
    }

    private void solve() {
        int left = 0, right = result.length - 1;
        while (left < right) {
            if (questionsAsked % 10 == 0) applyFix();
            result[left] = query(left);
            result[right] = query(right);
            if (result[left] == result[right]) {
                equalPosition = left;
            } else {
                differentPosition = left;
            }
            left++;
            right--;
        }
        provideAnswer(result);
    }
}