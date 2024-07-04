import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        JavaSolution.main(args);
    }
}

class JavaSolution {
    public static void main(String[] args) throws IOException {
        Reader reader;
        if (Arrays.asList(args).contains("DEBUG_MODE")) {
            reader = new FileReader("input.txt");
        } else {
            reader = new InputStreamReader(System.in);
        }

        PrintStream writer = System.out;
//        OutputStreamWriter writer = new FileWriter("output.txt");

        try (Scanner in = new Scanner(new BufferedReader(reader))) {
            try (PrintWriter out = new PrintWriter(writer)) {
                JavaSolution solution = new JavaSolution(in, out);
                for (int i = 0, to = in.nextInt(); i < to; i++) {
                    out.printf("Case #%d: ", i + 1);
                    solution.run();
                }
            }
        }
    }

    private Scanner in;
    private PrintWriter out;

    private JavaSolution(Scanner in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    private void run() {
        int n = in.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextInt();
            }
        }
        int k = 0;
        for (int i = 0; i < n; i++) {
            k += a[i][i];
        }
        int r = 0;
        int c = 0;
        int[] row = new int[n];
        int[] col = new int[n];
        for (int i = 0; i < n; i++) {
            boolean frow = false;
            boolean fcol = false;
            for (int j = 0; j < n; j++) {
                if (row[a[i][j] - 1] == i + 1) {
                    frow = true;
                }
                row[a[i][j] - 1] = i + 1;

                if (col[a[j][i] - 1] == i + 1) {
                    fcol = true;
                }
                col[a[j][i] - 1] = i + 1;
            }
            if (frow) r++;
            if (fcol) c++;
        }
        out.printf("%d %d %d\n", k, r, c);
    }
}
