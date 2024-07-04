import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        StringBuilder output = new StringBuilder();
        int t = reader.nextInt();
        int caseNumber = 1;
        while (t-- > 0) {
            int n = reader.nextInt();
            Vestigium vestigium = new Vestigium(reader,output,caseNumber,n);
            vestigium.solve();
            caseNumber++;
        }
        System.out.print(output);
    }
}

class Vestigium {
    FastReader reader;
    StringBuilder output;
    int     caseNumber,
            matrix[][],
            trace,
            repeatedColumns,
            repeatedRows;


    public Vestigium(FastReader reader, StringBuilder output, int caseNumber, int size) {
        this.reader = reader;
        this.output = output;
        this.caseNumber = caseNumber;
        this.trace = 0;
        this.repeatedRows = 0;
        this.repeatedColumns = 0;
        this.matrix = new int[size][size];
    }

    public void solve(){
        this.readMatrix();
        this.getRepeatedColumns();
        output.append("Case #")
                .append(caseNumber).append(": ")
                .append(trace)
                .append(" ").append(repeatedRows)
                .append(" ").append(repeatedColumns)
                .append("\n");
    }

    void readMatrix() {
        HashSet<Integer> rowSet = new HashSet<>();
        boolean repeated = false;
        for (int row = 0; row < matrix.length; row++) {
            rowSet.clear();
            repeated = false;
            for (int column = 0; column < matrix.length; column++) {
                matrix[row][column] = reader.nextInt();
                if (!repeated) {
                    if (rowSet.contains(matrix[row][column])) {
                        this.repeatedRows++;
                        repeated = true;
                    }
                    rowSet.add(matrix[row][column]);
                }
                if (row == column) {
                    trace += matrix[row][column];
                }
            }
        }
    }

    void getRepeatedColumns() {
        HashSet<Integer> columnSet = new HashSet<>();
        boolean repeated = false;
        flag: for (int column = 0; column < matrix.length; column++) {
            columnSet.clear();
            repeated = false;
            for (int row = 0; row < matrix.length; row++) {
                if (!repeated) {
                    if (columnSet.contains(matrix[row][column])) {
                        this.repeatedColumns++;
                        repeated = true;
                        continue flag;
                    }
                    columnSet.add(matrix[row][column]);
                }
            }
        }
    }
}

class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
