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
            int left = m1 - 1;
            int right = m2 + 1;
            int[] res = new int[B];
            res[m1] = read(in, out, m1);
            res[m2] = read(in, out, m2);

            boolean sameInBetween = res[m1] == res[m2];

            int[] originalMidValue = new int[2];
            int[] leftRightCheckPosition = new int[2];
            int[] leftRightCheckValue = new int[2];

            originalMidValue[0] = res[m1];
            originalMidValue[1] = res[m2];

            int count = 2;

            while(left >= 0 && right <= B - 1 && count <= T){
                res[left] = read(in, out, left);
                res[right] = read(in, out, right);
                if(sameInBetween){
                    if(res[left] == res[right]){
                        left--;
                        right++;
                    } else{
                        leftRightCheckPosition[0] = left;
                        leftRightCheckPosition[1] = right;
                        leftRightCheckValue[0] = res[left];
                        leftRightCheckValue[1] = res[right];
                        break;
                    }
                } else{
                    if(res[left] != res[right]){
                        left--;
                        right++;
                    } else{
                        leftRightCheckPosition[0] = left;
                        leftRightCheckPosition[1] = right;
                        leftRightCheckValue[0] = res[left];
                        leftRightCheckValue[1] = res[right];
                        break;
                    }
                }
                count += 2;
            }


            if(sameInBetween) {
                // same in mid
                while (left > 0 && right < B - 1 && count <= T) {
                    left--;
                    right++;

                    if (count % 10 != 0) {
                        res[left] = read(in, out, left);
                        res[right] = read(in, out, right);
                        count += 2;
                    }

                    else if (count % 10 == 0){
                        int tm1 = read(in, out, m1);
                        int tm2 = read(in, out, m2);
                        int tl = read(in, out, leftRightCheckPosition[0]);
                        int tr = read(in, out, leftRightCheckPosition[1]);
                        count += 4;
                        if(tm1 == originalMidValue[0] && tm2 == originalMidValue[1]){
                            if(leftRightCheckValue[0] != tl && leftRightCheckValue[1] != tr){
                                reverse(res, left, right);
                            }
                        } else{
                            if(leftRightCheckValue[0] != tl && leftRightCheckValue[1] != tr){
                                compliment(res, left, right);
                            } else{
                                compliment(res, left, right);
                                reverse(res, left, right);
                            }
                        }

                    }
                }
            } else{
                // diff in mid
                while (left > 0 && right < B - 1 && count <= T) {
                    left--;
                    right++;

                    if (count % 10 != 0) {
                        res[left] = read(in, out, left);
                        res[right] = read(in, out, right);
                        count += 2;
                    }

                    else if (count % 10 == 0){
                        int tm1 = read(in, out, m1);
                        int tm2 = read(in, out, m2);
                        int tl = read(in, out, leftRightCheckPosition[0]);
                        int tr = read(in, out, leftRightCheckPosition[1]);
                        count += 4;
                        if(tm1 == originalMidValue[0] && tm2 == originalMidValue[1]){
                            if(leftRightCheckValue[0] != tl && leftRightCheckValue[1] != tr){
                                compliment(res, left, right);
                                reverse(res, left, right);
                            }
                        } else{
                            if(leftRightCheckValue[0] != tl && leftRightCheckValue[1] != tr){
                                compliment(res, left, right);
                            }
                        }
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < res.length; i++){
                sb.append(res[i] + "");
            }
            String r = readString(in, out, sb.toString());
        }

        public void compliment(int[] arr, int left, int right){
            for(int i = left; i <= right; i++){
                if(arr[i] == 0) arr[i] = 1;
                else if(arr[i] == 1) arr[i] = 0;
            }
        }


        public void reverse(int[] arr, int left, int right){
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