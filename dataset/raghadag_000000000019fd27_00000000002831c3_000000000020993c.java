import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
        StringTokenizer stringTokenizer;
        StringBuilder answer = new StringBuilder();
        for (int testCase = 1; testCase <= T; testCase++) {
            int n = Integer.parseInt(input.readLine());
            int rowNumber = 0;
            Map<Integer, Integer>[] rowFlag = new Map[n];
            Map<Integer, Integer>[] colFlag = new Map[n];
            for (int i = 0; i < n; i++) {
                rowFlag[i] = new HashMap<>();
                colFlag[i] = new HashMap<>();
            }
            int sum = 0;
            int element, oldVal;
            for (int i = 0; i < n; i++) {
                stringTokenizer = new StringTokenizer(input.readLine());
                for (int j = 0; j < n; j++) {
                    element = Integer.parseInt(stringTokenizer.nextToken());
                    oldVal = rowFlag[rowNumber].containsKey(element) ? rowFlag[rowNumber].get(element) : 0;
                    rowFlag[rowNumber].put(element, oldVal + 1);
                    oldVal = colFlag[j].containsKey(element) ? colFlag[j].get(element) : 0;
                    colFlag[j].put(element, oldVal + 1);

                    if (j == rowNumber)
                        sum += element;
                }
                rowNumber++;
            }
            int r = 0, c = 0;
            for (int i = 0; i < n; i++) {
                for (int j : rowFlag[i].values()) {
                    if (j > 1) {
                        r++;
                        break;
                    }

                }
                for (int j : colFlag[i].values()) {
                    if (j > 1) {
                        c++;
                        break;
                    }

                }
            }
            answer.append("Case #" + testCase + ": " + sum + " " + r + " " + c + "\n");
        }
        System.out.println(answer);
    }
}
