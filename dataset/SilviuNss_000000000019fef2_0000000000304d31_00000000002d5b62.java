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
        int i, k, T, row, col, index = 0, sum, dirR, dirC;
        String[] results;
        
        T = ms.nextInt();
        results = new String[T + 1];
        
        for(k = 1; k <= T; k++) {
            dirR = 1;
            dirC = 1;
            StringBuilder rez = new StringBuilder("");
            col = ms.nextInt();
            row = ms.nextInt();
            
            if (row < 0) {
                dirR = -1;
                row = -row;
            }
            if (col < 0) {
                dirC = -1;
                col = -col;
            }
            if (row % 2 == col % 2) {
                results[k] = "IMPOSSIBLE";
                continue;
            }
            //System.out.println("row = " + row + " si col = " + col);
            sum = row + col;
            
            for (i = 31; i >= 1; i--)
                if ((sum & (1 << i)) > 0) {
                    index = i;
                    break;
                }
            //System.out.println("Pentru k = " + k + ", index = " + index);
            while(row != 0 || col != 0) {
                if (row > col) {
                    if(dirR == 1)
                        rez.append('N');
                    else
                        rez.append('S');
                    row -= (1 << index);
                    if (row < 0) {
                        row = -row;
                        dirR = -dirR;
                    }
                } else {
                    if(dirC == 1)
                        rez.append('E');
                    else
                        rez.append('W');
                    col -= (1 << index);
                    if (col < 0) {
                        col = -col;
                        dirC = -dirC;
                    }
                }
                index--;
            }
            /*if (row > 0) {
                if (row < (1 << (index + 1)) - 1) {
                   results[k] = "IMPOSSIBLE";
                    continue;
                }
                char c = dirR == 1 ? 'N' : 'S';
                for (i = 0; i <= index; i++)
                    rez.append(c);
            } else {
                if (col < (1 << (index + 1)) - 1) {
                   results[k] = "IMPOSSIBLE";
                    continue;
                }
                char c = dirC == 1 ? 'E' : 'W';
                for (i = 0; i <= index; i++)
                    rez.append(c);
            }*/
            results[k] = rez.reverse().toString();
        }
        ms.close();
        
        wr = new Writer("");
        
        for(i = 1; i <= T; i++)
            wr.writeLine("Case #" + i + ": " + results[i]);
        
        wr.close();
    }
}
