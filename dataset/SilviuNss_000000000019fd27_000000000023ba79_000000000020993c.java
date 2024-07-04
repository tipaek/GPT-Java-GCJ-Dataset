import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

class Writer {

    private BufferedWriter bw;

    // name - numele fisierului de output
    public Writer(String name) {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void write(String info) {
        try {
            bw.write(info);
        } catch (IOException ex) {
            System.err.println("Nu se poate scrie in buffer");
            System.exit(1);
        }
    }

    public void writeLine(String info) {
        write(info);
        writeNewLine();
    }

    public void writeNewLine() {
        try {
            bw.newLine();
        } catch (IOException ex) {
            System.err.println("Nu se poate scrie in buffer");
            System.exit(1);
        }
    }

    public void close() {
        try {
            bw.close();
        } catch (IOException ex) {
            System.err.println("Nu se poate inchide bufferul de scriere");
            System.exit(1);
        }
    }
}


class MyScanner {

    BufferedReader br;
    StringTokenizer st;
    String name;

    public MyScanner(String name) {
        this.name = name;
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

    String[] nextWords() {
        return nextLine().split(" ");
    }

    String[] nextWords(String separators) {
        return nextLine().split(separators);
    }

    public void close() {
        try {
            br.close();
        } catch (IOException ex) {
            System.err.println("Nu se poate inchide bufferul de citire");
            System.exit(1);
        }
    }
}

public class Solution {
    
    public static void main(String[] args) {

        MyScanner ms = new MyScanner("");
        Writer wr;
        int i, j, k, T, N, nr_rows, nr_cols, sum_diag, nr;
        HashSet<Integer>[] rows;
        HashSet<Integer>[] columns;
        int[][] results;
                        
        T = ms.nextInt();
        results = new int[T][3];
        
        for(k = 0; k < T; k++) {
            nr_rows = 0;
            nr_cols = 0;
            sum_diag = 0;
            N = ms.nextInt();
            rows = new HashSet[N];
            columns = new HashSet[N];
            for(i = 0; i < N; i++) {
                rows[i] = new HashSet<>();
                columns[i] = new HashSet<>();
            }
            for(i = 0; i < N; i++) {
                for(j = 0; j < N; j++) {
                    nr = ms.nextInt();
                    if(i == j)
                        sum_diag += nr;
                    if(rows[i] != null) {
                        if(rows[i].contains(nr))
                            rows[i] = null;
                        else
                            rows[i].add(nr);
                    }
                    if(columns[j] != null){
                        if(columns[j].contains(nr))
                            columns[j] = null;
                        else
                            columns[j].add(nr);
                    }
                }
            }
            for(i = 0; i < N; i++) {
                if(rows[i] == null)
                    nr_rows++;
                if(columns[i] == null)
                    nr_cols++;
            }
            results[k][0] = sum_diag;
            results[k][1] = nr_rows;
            results[k][2] = nr_cols;
        }
        ms.close();
        
        wr = new Writer("");
        
        for(i = 0; i < T; i++)
            wr.writeLine("Case #" + (i + 1) + ": " + results[i][0] + " "  + results[i][1] + " " + results[i][2]);
        
        wr.close();
    }
}
