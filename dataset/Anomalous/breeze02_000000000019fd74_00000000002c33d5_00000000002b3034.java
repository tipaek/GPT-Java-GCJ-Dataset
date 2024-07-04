import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private int n;
    private String[] prefix;
    private String[] suffix;
    private String[] middle;
    private String combinedPrefix;
    private String combinedSuffix;
    private String combinedMiddle;
    private boolean result;

    public static void main(String[] args) throws NumberFormatException, IOException {
        Solution solution = new Solution();
        solution.run();
    }

    private void init() {
        prefix = null;
        suffix = null;
        middle = null;
        combinedPrefix = "";
        combinedSuffix = "";
        combinedMiddle = "";
    }

    private void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        prefix = new String[n];
        suffix = new String[n];
        middle = new String[n];

        for (int i = 0; i < n; ++i) {
            String temp = br.readLine();
            String[] items = temp.split("\\*");

            prefix[i] = items[0];
            middle[i] = "";

            for (int j = 1; j < items.length - 1; ++j) {
                middle[i] += items[j];
            }

            if (temp.endsWith("*")) {
                if (items.length != 1) {
                    middle[i] += items[items.length - 1];
                }
                suffix[i] = "";
            } else {
                suffix[i] = new StringBuilder(items[items.length - 1]).reverse().toString();
            }

            combinedMiddle += middle[i];
        }
    }

    private void process() {
        for (int i = 0; i < n; ++i) {
            if (!combinedPrefix.startsWith(prefix[i])) {
                if (prefix[i].startsWith(combinedPrefix)) {
                    combinedPrefix = prefix[i];
                } else {
                    result = false;
                    return;
                }
            }

            if (!combinedSuffix.startsWith(suffix[i])) {
                if (suffix[i].startsWith(combinedSuffix)) {
                    combinedSuffix = suffix[i];
                } else {
                    result = false;
                    return;
                }
            }
        }
        result = true;
    }

    private void output() throws IOException {
        if (result) {
            bw.write(combinedPrefix + combinedMiddle + new StringBuilder(combinedSuffix).reverse().toString() + "\n");
        } else {
            bw.write("*\n");
        }
        bw.flush();
    }

    private void run() throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; ++i) {
            init();
            input();
            process();
            bw.write("Case #" + (i + 1) + ": ");
            output();
        }
    }
}