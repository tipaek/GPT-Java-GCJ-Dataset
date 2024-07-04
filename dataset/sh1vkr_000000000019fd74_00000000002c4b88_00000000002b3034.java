import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;


import java.io.IOException;

public class Jfgkaldjkfhllasdjfhlbsdklsdnj {
    static Mylittlereader sc = new Mylittlereader();

    public static void main(String[] args) {

        int nooftestcases = sc.nextInt();
        for (int fghjk = 1; fghjk <= nooftestcases; fghjk++) {
            String my_little_answer = calculatesubstring (sc.nextInt());
            System.out.println("Case #" + fghjk+ ": " + my_little_answer);


        }
    }


    static String calculatesubstring(int xxx) {
        String myLittlearray[] = new String[xxx];
        int bigvalue = 0;
        int pos = -1;
        boolean flag = true;
        for (int i = 0; i < xxx; i++) {
            myLittlearray[i] = sc.nextLine();
            if (i >= 1)
                if (bigvalue < myLittlearray[i].length()) {
                    bigvalue = myLittlearray[i].length();
                    pos = i;
                }

        }

        for (int i = 0; i < xxx; i++) {
            String sub = myLittlearray[i].substring(1);
            if (flag && !myLittlearray[pos].contains(sub)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return myLittlearray[pos].substring(1);

        }
        return "*";


    }


    static class Mylittlereader {
        BufferedReader br;
        StringTokenizer st;

        public Mylittlereader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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
    }


}

