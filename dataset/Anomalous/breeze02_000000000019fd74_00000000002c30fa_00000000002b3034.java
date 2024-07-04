import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private int n;
    private String[] prefix;
    private String[] suffix;
    private String[] middle;

    private String cprefix;
    private String csuffix;
    private String cmiddle;

    private boolean result;

    private void init() {
        prefix = new String[n];
        suffix = new String[n];
        middle = new String[n];
        cprefix = "";
        csuffix = "";
        cmiddle = "";
    }

    private void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; ++i) {
            String temp = br.readLine();
            String[] items = temp.split("\\*");

            prefix[i] = items[0];
            middle[i] = String.join("", items, 1, items.length - 1);

            if (temp.endsWith("*")) {
                middle[i] += items.length > 1 ? items[items.length - 1] : "";
                suffix[i] = "";
            } else {
                suffix[i] = new StringBuilder(items[items.length - 1]).reverse().toString();
            }

            cmiddle += middle[i];
        }
    }

    private void process() {
        for (int i = 0; i < n; ++i) {
            if (!cprefix.startsWith(prefix[i])) {
                if (prefix[i].startsWith(cprefix)) {
                    cprefix = prefix[i];
                } else {
                    result = false;
                    return;
                }
            }

            if (!csuffix.startsWith(suffix[i])) {
                if (suffix[i].startsWith(csuffix)) {
                    csuffix = suffix[i];
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
            bw.write(cprefix + cmiddle + new StringBuilder(csuffix).reverse().toString() + "\n");
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

    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().run();
    }
}