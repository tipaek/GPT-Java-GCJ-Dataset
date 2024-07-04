import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCases = in.nextInt();
        ArrayList<TestCase> testCases = new ArrayList<>();

        while (numTestCases > 0) {
            int N = in.nextInt();
            ArrayList<ArrayList<Integer>> tempMatrix = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < N; j++) {
                    row.add(in.nextInt());
                }
                tempMatrix.add(row);
            }
            testCases.add(new TestCase(N, tempMatrix));
            numTestCases--;
        }

        for (TestCase c : testCases) {
            int trace = 0;
            int numRow = 0;
            int numCol = 0;
            ArrayList<Integer> seenValues = new ArrayList<>();

            for (int i = 0; i < c.N; i++) {
                trace += c.matrix.get(i).get(i);
            }

            for (ArrayList<Integer> arrayList : c.matrix) {
                for (Integer num : arrayList) {
                    if (!seenValues.contains(num)) {
                        seenValues.add(num);
                    } else {
                        numRow++;
                        break;
                    }
                }
                seenValues.clear();
            }

            for (int i = 0; i < c.N; i++) {
                for (int j = 0; j < c.N; j++) {
                    int num = c.matrix.get(j).get(i);
                    if (!seenValues.contains(num)) {
                        seenValues.add(num);
                    } else {
                        numCol++;
                        break;
                    }
                }
                seenValues.clear();
            }
            System.out.println("Case #" + (testCases.indexOf(c)+1) + ": " + trace + " " + numRow + " " + numCol);
        }

    }

}

class TestCase {
    int N;
    ArrayList<ArrayList<Integer>> matrix;

    TestCase(int N, ArrayList<ArrayList<Integer>> matrix) {
        this.N = N;
        this.matrix = matrix;
    }
}
