import java.io.*;
import java.util.*;


class Solution {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        printOutput(fio);
        fio.close();
    }

    public static void printOutput(FastIO fio) {
        int numTest = fio.nextInt();

        for(int i = 1; i <= numTest; i++) {
            String digit = fio.next();
            fio.println("Case #" + i + ": " + nestDigit(digit));
        }
    }

    public static String nestDigit(String digit) {
        StringBuilder sb = new StringBuilder();
        int size = digit.length();
        char curr = digit.charAt(0);
        char prev = curr;
        int count; // number of close brackets needed

        if(curr == '0') {
            sb.append('0');
            count = 0;
        } else {
            count = curr - 48;
            int temp = count;
            while(temp != 0) {
                sb.append('(');
                temp--;
            }
            sb.append(curr);
        }

        for(int i = 1; i < size; i++) {

            curr = digit.charAt(i);

            if(prev == '0') {
                count = curr - 48;
                int temp = count;
                while(temp != 0) {
                    sb.append('(');
                    temp--;
                }
                sb.append(curr);
            } else {
                int diff = prev - curr;

                if (diff > 0) {
                    while (diff != 0) {
                        sb.append(')');
                        count--;
                        diff--;
                    }

                    sb.append(curr);
                } else if (diff < 0) {
                    while (diff != 0) {
                        sb.append('(');
                        count++;
                        diff++;
                    }

                    sb.append(curr);
                } else {
                    sb.append(curr);
                }
            }
            prev = curr;
        }

        while(count != 0) {
            sb.append(')');
            count--;
        }
        return sb.toString();
    }
}

class FastIO extends PrintWriter {

    BufferedReader br;

    StringTokenizer st;


    public FastIO() {

        super(new BufferedOutputStream(System.out));

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