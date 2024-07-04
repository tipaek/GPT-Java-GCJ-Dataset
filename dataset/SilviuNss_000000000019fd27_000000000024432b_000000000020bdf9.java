import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

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

class Interval {
    
    int S, E, index;

    public Interval(int S, int E, int index) {
        this.S = S;
        this.E = E;
        this.index = index;
    }
}

public class Solution {
     
    public static void main(String[] args) {

        MyScanner ms = new MyScanner("");
        Writer wr;
        int i, j, k, T, N, endC, endJ;
        char[] rez;
        String[] results;
        ArrayList<Interval> intervals;
        
        T = ms.nextInt();
        results = new String[T];
        
        for(k = 0; k < T; k++) {
            endC = 0;
            endJ = 0;
            N = ms.nextInt();
            rez = new char[N];
            intervals = new ArrayList<>(N);
            for(i = 0; i < N; i++)
                intervals.add(new Interval(ms.nextInt(), ms.nextInt(), i));
            intervals.sort((Interval i1, Interval i2)-> i1.S - i2.S);
            for(Interval in : intervals) {
                if(endC <= in.S) {
                    rez[in.index] = 'C';
                    endC = in.E;
                } else if(endJ <= in.S) {
                    rez[in.index] = 'J';
                    endJ = in.E;
                } else {
                    rez = "IMPOSSIBLE".toCharArray();
                    break;
                }
            }
            results[k] = String.valueOf(rez);
        }
        ms.close();
        
        wr = new Writer("");
        
        for(i = 0; i < T; i++)
            wr.writeLine("Case #" + (i + 1) + ": " + results[i]);
        
        wr.close();
    }
}
