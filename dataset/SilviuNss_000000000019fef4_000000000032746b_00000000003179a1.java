import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
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

/* class comp implements Comparator<String> {
  @Override
  public int compare(String o1, String o2) {
    return Integer.compare(o1.length(), o2.length());
  }
} */

public class Solution {     
    static int NMAX = 10000;
    
    public static void main(String[] args) {

        MyScanner ms = new MyScanner("");
        Writer wr;
        int i, k, T, U, Q;
        String R;
        char[] rez = new char[10];
        String[] results, strings;
        HashMap<Character, Integer> MSD = new HashMap<>();
        HashMap<Character, Integer> len_one = new HashMap<>();
        HashSet<Character> LSD = new HashSet<>();
        
        T = ms.nextInt();
        results = new String[T + 1];
        strings = new String[NMAX];
        
        for (k = 1; k <= T; k++) {
            U = ms.nextInt();
            for (i = 0; i < NMAX; i++) {
                Q = ms.nextInt();
                R = ms.next();
                //System.out.println("Q = " + Q + " si R = " + R);
                strings[i] = R;
            }
            //Arrays.sort(strings, new comp());
            //for (i = 0; i < 3; i++)
            //    System.out.println("strings[" + i + "] = " + strings[i]);
            
            for (i = 0; i < NMAX; i++) {
                String str = strings[i];
                char lsc = str.charAt(str.length() - 1);
                char msc = str.charAt(0);
                if (!LSD.contains(lsc))
                    LSD.add(lsc);
                if (str.length() > 1) {
                    if (MSD.containsKey(msc))
                        MSD.put(msc, MSD.get(msc) + 1);
                    else
                        MSD.put(msc, 1);
                } else {
                    if (len_one.containsKey(msc))
                        len_one.put(msc, len_one.get(msc) + 1);
                    else
                        len_one.put(msc, 1);
                }
            }
            //System.out.println("LSD keys = " + LSD);
            //System.out.println("MSD keys = " + MSD.keySet());

            for (Character c : LSD) {
                if (!MSD.containsKey(c)) {
                    rez[0] = c;
                    break;
                }
            }
            for (Character c : MSD.keySet()) {
                if (len_one.containsKey(c))
                    MSD.put(c, MSD.get(c) + len_one.get(c));
            }
            for (i = 1; i < 10; i++) {  
                int max = -1;
                for (Character c : MSD.keySet()) {
                    if (MSD.get(c) > max) {
                        max = MSD.get(c);
                        rez[i] = c;
                    }
                }
                MSD.remove(rez[i]);
            }
            StringBuilder builder = new StringBuilder();
            for (i = 0; i < 10; i++) {
                builder.append(rez[i]);
            }
            results[k] = builder.toString();
        }
        ms.close();
        
        wr = new Writer("");
        
        for(i = 1; i <= T; i++)
            wr.writeLine("Case #" + i + ": " + results[i]);
        
        wr.close();
    }
}
