
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner();
        int cases = Integer.parseInt(sc.next());
        int c = 1;
        while (cases-- > 0) {
            int l = Integer.parseInt(sc.next());
            int[][] m = new int[l][l];

            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m.length; j++) {
                    m[i][j] = Integer.parseInt(sc.next());
                }
            }
            int fila = 0;
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < m.length - 1; j++) {
                    for (int k = j + 1; k < m.length; k++) {
                        if (m[i][j] == m[i][k]) {
                            fila++;
                             j=m.length;
                            break;
                        }
                    }
                }
            }
            int columna=0;
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < m.length-1; j++) {
                    for (int k = j + 1; k < m.length; k++) {
                        //System.out.println(m[j][i]+" "+m[k][i]);
                        if (m[j][i] == m[k][i]) {
                            columna++;
                            j=m.length;
                            break;
                        }
                    }
                }
            }
            int acom=0;
            
            for(int i=0; i<l; i++){
                acom+=m[i][i];
            }
            
            System.out.println("Case #"+c+": "+acom+" "+fila+" "+columna);
            c++;
        }
    }

    static class Scanner {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        int spaces = 0;

        public String nextLine() throws IOException {
            if (spaces-- > 0) {
                return "";
            } else if (st.hasMoreTokens()) {
                return new StringBuilder(st.nextToken("\n")).toString();
            }
            return br.readLine();
        }

        public String next() throws IOException {
            spaces = 0;
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public boolean hasNext() throws IOException {
            while (!st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) {
                    return false;
                }
                if (line.equals("")) {
                    spaces = Math.max(spaces, 0) + 1;
                }
                st = new StringTokenizer(line);
            }
            return true;
        }
    }
}
