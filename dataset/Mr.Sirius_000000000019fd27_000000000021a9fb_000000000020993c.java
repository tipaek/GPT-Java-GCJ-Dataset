import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner sc;

        if (args.length > 0) {
            sc = new Scanner(new File(args[0]));
        } else {
            sc = new Scanner(System.in);
        }

        int t = sc.nextInt();
        for (int tt = 1; tt <= t; ++tt) {
            MyMatrix mm = _s(sc);
            System.out.println("Case #" + tt + ": " + mm.trace + " " + mm.repeatedRows + " " + mm.repeatedColumns);
        }
        sc.close();
    }

    static MyMatrix _s(Scanner sc) {
        MyMatrix matrix = new MyMatrix();
        int n = sc.nextInt();
        MyLine rows[] = new MyLine[n];
        MyLine columns[] = new MyLine[n];
        for (int x = 0; x < n; ++x) {
            rows[x] = new MyLine();
            columns[x] = new MyLine();
        }

        for (int y = 0; y < n; ++y) {
            for (int x = 0; x < n; ++x) {
                int num = sc.nextInt();
                if (x == y)
                    matrix.trace += num;
                if (!rows[x].repeat) {
                    if (rows[x].line.contains(num)) {
                        rows[x].repeat = true;
                        ++matrix.repeatedColumns;
                    } else {
                        rows[x].line.add(num);
                    }
                }
                if (!columns[y].repeat) {
                    if (columns[y].line.contains(num)) {
                        columns[y].repeat = true;
                        ++matrix.repeatedRows;
                    } else {
                        columns[y].line.add(num);
                    }
                }
            }
        }

        return matrix;
    }

    static class MyLine {
        boolean repeat = false;
        Set line = new HashSet();
    }

    static class MyMatrix {
        int trace = 0, repeatedRows = 0, repeatedColumns = 0;
    }
}