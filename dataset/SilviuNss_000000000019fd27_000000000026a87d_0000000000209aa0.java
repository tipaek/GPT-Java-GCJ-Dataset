import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
        int i, T, N, K;
        String rez;
        String[] results;
        
        T = ms.nextInt();
        results = new String[T + 1];
        
        for(i = 1; i <= T; i++) {
            N = ms.nextInt();
            K = ms.nextInt();
            if(K % N == 0)
                rez = trivial(N, K);
            else if(K - N < 3) {
                rez = new String("IMPOSSIBLE\n");
            } else
                rez = computeLatin(N, K);
            results[i] = rez;
        }
        ms.close();
        
        wr = new Writer("");
        
        for(i = 1; i <= T; i++)
            wr.write("Case #" + i + ": " + results[i]);
        
        wr.close();
    }
    
    static String trivial(int N, int K) {
        StringBuilder rez = new StringBuilder("POSSIBLE\n");
        int i, j, start, val = K / N;
        
        for(i = 0; i < N; i++) {
            start = (val - i) % N;
            if(start == 0)
                start = N;
            for(j = 0; j < N; j++) {
                rez.append(start);
                rez.append(' ');
                if(++start == N + 1)
                    start = 1;
            }
            rez.append('\n');
        }
        return rez.toString();
    }
    
    static String computeLatin(int N, int K) {
        StringBuilder rez = new StringBuilder("POSSIBLE\n");
        int i, j, a, b, c, R, alpha, x, y, z, end, min = 1, pos;
        int[] line = new int[N];
        
        R = K % N;
        if(R < 3)
            R += N;
        if(R % 2 == 0)
            b = 2;
        else
            b = 1;
        c = R / 2 + 1 - b;
        a = N - b - c;
        alpha = (K - R) / N;
        x = alpha;
        y = alpha + 1;
        z = alpha + 2;
        line[0] = x;
        line[b] = z;
        line[a + b] = y;
        if(min == x)
            min = z + 1;
        if(b == 2) {
            line[1] = min;
            if(++min == x)
                min = z + 1;
        }
        end = a + b;
        for(i = b + 1; i < end; i++) {
            line[i] = min;
            if(++min == x)
                min = z + 1;
        }
        for(i = end + 1; i < N; i++) {
            line[i] = min;
            if(++min == x)
                min = z + 1;
        }
        
        for(i = 0; i < N; i++) {
            if(i < a)
                pos = (N - i) % N;
            else if(i < a + b)
                pos = (N + a + b - i) % N;
            else
                pos = (N + b - i) % N;
            for(j = 0; j < N; j++) {
                rez.append(line[(N + pos + j) % N]);
                rez.append(' ');
            }
            rez.append('\n');
        }
        return rez.toString();
    }
}
