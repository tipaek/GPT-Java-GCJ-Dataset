import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        int T = in.nextInt();
        int B = in.nextInt();
        for(int i = 0; i < T; i++) solver.solve(in, out, T, B);
        out.close();
    }

    static class Task {
        public void solve(InputReader in, PrintWriter out, int T, int B) {

            int m1 = B / 2 - 1;
            int m2 = B / 2;
            int ld = -1, rd = -1, ls = -1, rs = -1;
            boolean isSameMid = false;
            int left = m1;
            int right = m2;
            int[] res = new int[B];
            Arrays.fill(res, -1);

            for(int i = 0; i < 150; i += 2) {

                int f = read(in, out, left);
                int s = read(in, out, right);

                if (i == 0) {
                    isSameMid = f == s;
                } else{
                    if (f == s && ls == -1 && rs == -1) {
                        ls = left;
                        rs = right;
                    } else if (f != s && ld == -1 && rd == -1) {
                        ld = left;
                        rd = right;
                    }
                }

                if (i % 10 == 0) {
                    int nm1v = read(in, out, m1);
                    int nm2v = read(in, out, m2);
                    i += 2;
                    if (isSameMid) {
                        if (nm1v != res[m1] || nm2v != res[m2]) {
                            if (ld == -1 || rd == -1) compliment(res, 0, B);
                            else {
                                int nldv = read(in, out, ld);
                                int nrdv = read(in, out, rd);
                                i += 2;
                                if (nldv == res[ld] || nrdv == res[rd]) {
                                    compliment(res, 0, B);
                                    reverse(res, 0, B);
                                } else {
                                    compliment(res, 0, B);
                                }
                            }
                        } else {
                            if (ld != -1 ||  rd != -1) {
                                int nldv = read(in, out, ld);
                                int nrdv = read(in, out, rd);
                                i += 2;
                                if (nldv != res[ld] || nrdv != res[rd]) {
                                    reverse(res, 0, B);
                                }
                            }
                        }
                    } else {
                        if (nm1v != res[m1] || nm2v != res[m2]) {
                            if (ls == -1 || rs == -1) compliment(res, 0, B);
                            else {
                                int nlsv = read(in, out, ls);
                                int nrsv = read(in, out, rs);
                                i += 2;
                                if (nlsv == res[ls] || nrsv == res[rs]) {
                                    reverse(res, 0, B);
                                } else {
                                    compliment(res, 0, B);
                                }
                            }
                        } else {
                            if (ls != -1 || rs != -1) {
                                int nlsv = read(in, out, ls);
                                int nrsv = read(in, out, rs);
                                i += 2;
                                if (nlsv != res[ls] || nrsv != res[rs]) {
                                    compliment(res, 0, B);
                                    reverse(res, 0, B);
                                }
                            }
                        }
                    }
                }

                res[left] = f;
                res[right] = s;
                left--;
                right++;
                if(left < 0 || right >= B){
                    StringBuilder sb = new StringBuilder();
                    for(int j = 0; j < res.length; j++){
                        sb.append(res[j] + "");
                    }
                    String r = readString(in, out, sb.toString());
                    return;
                }
            }
        }

        public void compliment(int[] arr, int left, int right){
            for(int i = left; i < right; i++){
                if(arr[i] == 0) arr[i] = 1;
                else if(arr[i] == 1) arr[i] = 0;
            }
        }


        public void reverse(int[] arr, int left, int right){
            right--;
            while(left < right){
                int tmp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = tmp;
            }
        }


        public int read(InputReader in, PrintWriter out, int p){
            out.println(p + 1);
            out.flush();
            return in.nextInt();
        }

        public String readString(InputReader in, PrintWriter out, String p){
            out.println(p);
            out.flush();
            return in.next();
        }


    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            String n = next();
            return Integer.parseInt(n);
        }
    }
}