import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

class clase implements Comparable {

    int incio;
    int fin;
    String nombre;
    int id;

    public clase(int incio, int fin, int id) {
        this.incio = incio;
        this.fin = fin;
        this.id = id;
    }

    @Override
    public int compareTo(Object t) {
        clase otro = (clase) t;
        if (this.fin < otro.fin) {
            return -1;
        }

        if (this.fin > otro.fin) {
            return 1;
        }

        if (this.incio < otro.incio) {
            return -1;
        }

        if (this.incio > otro.incio) {
            return 1;
        }

        return 0;

    }

}

public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner();

        int casos = Integer.parseInt(sc.next());
        for (int z = 1; z <= casos; z++) {

            int num =Integer.parseInt(sc.next());
            clase vec[] = new clase[num];
            for (int i = 0; i < num; i++) {
                int inicio =Integer.parseInt(sc.next());
                int fin =Integer.parseInt(sc.next());

                vec[i] = new clase(inicio, fin, i);
            }

            Arrays.sort(vec);

            int c = 0;
            int j = 0;
            boolean impo = false;
            for (int i = 0; i < num; i++) {
                if (c <= vec[i].incio) {
                    c = vec[i].fin;
                    vec[i].nombre = "C";
                } else {
                    if (j <= vec[i].incio) {
                        j = vec[i].fin;
                        vec[i].nombre = "J";
                    } else {
                        impo = true;
                        break;
                    }

                }

            }
            String rta = "";

            if (impo) {
                rta = "IMPOSSIBLE";
            } else {
                for (int i = 0; i < num; i++) {
                    for (int k = 0; k < num; k++) {
                        if (vec[k].id == i) {
                            rta += vec[k].nombre;
                        }

                    }
                }
            }
            System.out.println("Case #" + z + ": " + rta);

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
