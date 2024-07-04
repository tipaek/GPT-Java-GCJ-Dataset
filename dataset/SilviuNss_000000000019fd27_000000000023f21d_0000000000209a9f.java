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
        int i, j, k, T, len, last, digit, dif;
        char par;
        char[] S;
        StringBuilder Srez;
        String[] results;
                        
        T = ms.nextInt();
        results = new String[T];
        
        for(k = 0; k < T; k++) {
            S = ms.nextLine().toCharArray();
            Srez = new StringBuilder("");
            last = 0;
            len = S.length;
            for(i = 0; i < len; i++) {
                digit = Character.getNumericValue(S[i]);
                dif = digit - last;
                if(dif >= 0)
                    par = '(';
                else {
                    par = ')';
                    dif = -dif;
                }
                for(j = 0; j < dif; j++)
                    Srez.append(par);
                Srez.append(digit);
                last = digit;
            }
            for(j = 0; j < last; j++)
                    Srez.append(')');
            results[k] = Srez.toString();
        }
        ms.close();
        
        wr = new Writer("");
        
        for(i = 0; i < T; i++)
            wr.writeLine("Case #" + (i + 1) + ": " + results[i]);
        
        wr.close();
    }
}
