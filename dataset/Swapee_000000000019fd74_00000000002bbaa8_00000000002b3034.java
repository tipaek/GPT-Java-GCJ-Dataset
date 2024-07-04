import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solu {
    static FR sc = new FR();

    public static void main(String[] args) {

        int t = sc.NI();
        for (int i = 1; i <=t; i++) {
            String res = solve(sc.NI());
            System.out.println("Case #" + i + ": " + res);


        }
    }


    static String solve(int N) {
        String arr[] = new String[N];
        int max = 0;
        int pos = -1;
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.NL();
            if (i >= 1)
                if (max < arr[i].length()) {
                    max = arr[i].length();
                    pos = i;
                }

        }

        for (int i = 0; i < N; i++) {
            String sub = arr[i].substring(1);
            if (flag && !arr[pos].contains(sub)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return arr[pos].substring(1);

        }
        return "*";


    }


    static class FR {
        BufferedReader br;
        StringTokenizer st;

        public FR() {
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

        int NI() {
            return Integer.parseInt(next());
        }

        long NL() {
            return Long.parseLong(next());
        }

        double ND() {
            return Double.parseDouble(next());
        }

        String NL() {
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

