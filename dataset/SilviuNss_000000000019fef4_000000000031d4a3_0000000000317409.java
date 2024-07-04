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
        int i, k, T, X, Y, absX, absY, len;
        String M;
        char[] str;
        String[] results;
        
        T = ms.nextInt();
        results = new String[T + 1];
        
        for(k = 1; k <= T; k++) {
            X = ms.nextInt();
            Y = ms.nextInt();
            M  = ms.next();
            len = M.length();
            str = M.toCharArray();
            
            //System.out.println("X = " + X + " si Y = " + Y + " si M = " + M + " si len = " + len);
            
            for (i = 0; i < len; i++) {
                /* Take a move */
                //System.out.println("Acum X = " + X + " si Y = " + Y);
                if (str[i] == 'N')
                    Y++;
                else if (str[i] == 'S')
                    Y--;
                else if (str[i] == 'E')
                    X++;
                else
                    X--;
                absX = Math.abs(X);
                absY = Math.abs(Y);
                if (absX > absY) {
                    if (X > 0)
                        X--;
                    else
                        X++;
                }
                else if (absX < absY) {
                    if (Y > 0)
                        Y--;
                    else
                        Y++;
                }
                else if (absX == 0 && absY == 0) {
                    i++;
                    break;
                } else {
                    /* Consider next move */
                    if (i == len - 1)
                        continue;
                    if (X > 0) {
                        if (Y > 0) {
                            if (str[i + 1] == 'N' || str[i + 1] == 'W')
                                Y--;
                            else
                                X--;
                        } else {
                            if (str[i + 1] == 'N' || str[i + 1] == 'E')
                                X--;
                            else
                                Y++;
                        }
                    } else {
                        if (Y > 0) {
                            if (str[i + 1] == 'N' || str[i + 1] == 'E')
                                Y--;
                            else
                                X++;
                        } else {
                            if (str[i + 1] == 'N' || str[i + 1] == 'W')
                                X++;
                            else
                                Y++;
                        }
                    }
                }
            }
            //System.out.println("Acum X = " + X + " si Y = " + Y);
            if (X == 0 && Y == 0)
                results[k] = i + "";
            else
                results[k] = "IMPOSSIBLE";
        }
        ms.close();
        
        wr = new Writer("");
        
        for(i = 1; i <= T; i++)
            wr.writeLine("Case #" + i + ": " + results[i]);
        
        wr.close();
    }
}
