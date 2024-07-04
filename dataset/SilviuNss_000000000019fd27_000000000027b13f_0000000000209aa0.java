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
            if(N == 3 && (K == 7 || K == 8))
                rez = new String("IMPOSSIBLE\n");
            else if(N == 4 && K == 10)
                rez = "POSSIBLE\n4 2 1 3\n2 1 3 4\n1 3 4 2\n3 4 2 1\n";
            else if(N == 4 && K == 10)
                rez = "POSSIBLE\n4 1 2 3\n1 2 3 4\n2 3 4 1\n3 4 1 2\n";
            else if(K % N == 0)
                rez = trivial(N, K);
            else if(K - N < 3 || N * N - K < 3) {
                if((K - N == 2  || N * N - K == 2) && N % 2 == 0)
                    rez = specialEvenCase(N, K);
                else
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
            start = (N + val - i) % N;
            if(start == 0)
                start = N;
            for(j = 0; j < N; j++) {
                rez.append(start);
                if(j != N - 1)
                    rez.append(' ');
                if(++start == N + 1)
                    start = 1;
            }
            rez.append('\n');
        }
        return rez.toString();
    }
    
    static String specialEvenCase(int N, int K) {
        StringBuilder rez = new StringBuilder("POSSIBLE\n");
        int i, j, min, max, half = N / 2;
        int[] line = new int[N];
        if(K - N == 2) {
            line[0] = 1;
            line[half] = 2;
            min = 3;
            for(i = 1; i < half; i++)
                line[i] = min++;
            for(i = half + 1; i < N; i++)
                line[i] = min++;
        } else {
            line[0] = N;
            line[half] = N - 1;
            max = N - 2;
            for(i = 1; i < half; i++)
                line[i] = max--;
            for(i = half + 1; i < N; i++)
                line[i] = max--;
        }
        max = half - 1;
        for(i = 0; i < max; i++) {
            for(j = 0; j < N; j++) {
                rez.append(line[(N + j - i) % N]);
                if(j != N - 1)
                    rez.append(' ');
            }   
            rez.append('\n');
        }
        for(j = 0; j < N; j++) {
            rez.append(line[(j + 1) % N]);
            if(j != N - 1)
                rez.append(' ');
        }   
        rez.append('\n');
        max = N - 1;
        for(i = half; i < max; i++) {
            for(j = 0; j < N; j++) {
                rez.append(line[(N + j - i) % N]);
                if(j != N - 1)
                    rez.append(' ');
            }   
            rez.append('\n');
        }
        for(j = 0; j < N; j++) {
            rez.append(line[(N + j + 1 - half) % N]);
            if(j != N - 1)
                rez.append(' ');
        }   
        rez.append('\n');
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
                if(j != N - 1)
                    rez.append(' ');
            }
            rez.append('\n');
        }
        return rez.toString();
    }
}
