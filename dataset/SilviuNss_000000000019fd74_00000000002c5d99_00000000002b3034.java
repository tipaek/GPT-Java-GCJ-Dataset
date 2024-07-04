import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        int i, j, T, N, index;
        String rez, str;
        String[] results;
        ArrayList<String> beg, end, newAl;
        boolean finished;
        
        T = ms.nextInt();
        results = new String[T + 1];
        
        for(i = 1; i <= T; i++) {
            finished = false;
            rez = ""; str = "";
            StringBuilder rezB = new StringBuilder("");
            N = ms.nextInt();
            beg = new ArrayList<>(N);
            end = new ArrayList<>(N);

            for(j = 0; j < N; j++) {
                str = ms.nextLine();
                int len = str.length();
                    for(int k = 1; k < len; k++) {
                        if(str.charAt(k - 1) == '*' && str.charAt(k) == '*') {
                            str = str.substring(0, k) + str.substring(k + 1);
                            len--; k--;
                        }
                    }
                if (str.compareTo("*") == 0)
                    continue;
                index = str.lastIndexOf('*');
                if (index > 0) {
                    String aux = str.substring(0, index + 1);
                    if(!beg.contains(aux))
                        beg.add(aux);
                }
                if (index < str.length() - 1) {
                    StringBuilder auxB = new StringBuilder();
                    String aux = str.substring(index + 1);
                    aux = auxB.append(aux).reverse().toString();
                    if(!end.contains(aux))
                        end.add(aux);
                }
            }
            System.out.println("BEG = " + beg);
            System.out.println("END = " + end);
            int maxI = -1;
            while(!beg.isEmpty() && !finished) {
                newAl = new ArrayList<>(beg.size());
                for(String pt : beg) {
                    index = pt.indexOf('*');
                    if(index > maxI) {
                        maxI = index;
                        str = pt;
                    }
                }
                while(beg.remove(str));
                str = str.substring(0, maxI);
                rezB = rezB.append(str);
                for(String pt : beg) {
                    if (pt.indexOf('*') == maxI && pt.substring(0, maxI).compareTo(str) != 0) {
                        rez = "*";
                        finished = true;
                        break;
                    }
                    String aux = pt;
                    index = aux.length() - 1;
                    while(index > 0) {
                        index = aux.lastIndexOf('*', index);
                        Pattern p = Pattern.compile(aux.substring(0, index + 1));
                        Matcher m = p.matcher(str);
                        if(!m.matches()) {
                            index--;
                            continue;
                        }
                        String aux2 = aux.substring(index + 1);
                        if(!aux2.isEmpty() && !newAl.contains(aux2))
                            newAl.add(aux2);
                    }
                    if(aux.isEmpty()) {
                        rez = "*";
                        finished = true;
                        break;
                    }
                }
                beg = newAl;
                System.out.println("Acum BEG = " + beg);
            }
            if(!finished)
                rez = rezB.toString();
            maxI = -1;
            if (!finished && !end.isEmpty()) {
                for(String st : end) {
                    if(st.length() > maxI) {
                        maxI = st.length();
                        str = st;
                    }
                }
                while(end.remove(str));
                for(String st : end) {
                    String aux = str.substring(0, st.length());
                    System.out.println("st = " + st + " si aux = " + aux);
                    if(aux.compareTo(st) != 0) {
                        finished = true;
                        rez = "*";
                        break;
                    }
                }
                if (!finished) {
                    StringBuilder auxB = new StringBuilder();
                    rez = rez + auxB.append(str).reverse().toString();
                }
            }
            if(rez.length() > 10000)
                rez = "*";
            results[i] = rez;
        }
        ms.close();
        
        wr = new Writer("");
        
        for(i = 1; i <= T; i++)
            wr.writeLine("Case #" + i + ": " + results[i]);
        
        wr.close();
    }
}
