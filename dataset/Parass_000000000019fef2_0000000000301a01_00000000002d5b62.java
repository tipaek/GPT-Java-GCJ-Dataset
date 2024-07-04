
import java.io.*;
import java.util.*;


class Solution {

    public static void main(String[] args) {

        InputReader in = new InputReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt(), l = 0;

        while (t-- > 0) {

            out.print("Case #" + (++l) + ": ");
            long x = in.nextInt(), y = in.nextInt();

            long num = Math.min(Math.abs(x), Math.abs(y));
            long num2 = Math.max(Math.abs(x), Math.abs(y));
            HashMap<Long, Character> set = new HashMap<>();

            if ((num + num2) % 2 == 0) {
                out.println("IMPOSSIBLE");
                continue;
            }


            if (num == Math.abs(x)) {
                char ch = 'W';
                if (x > 0)
                    ch = 'E';
                long pow = 1, max = 0, hell = 0;
                while (num != 0) {
                    long rem = num % 2;
                    if (rem == 1) {
                        set.put(pow, ch);
                        max = Math.max(max, pow);
                    } else {
                        hell += pow;
                    }

                    num = num / 2;
                    pow = pow * 2;
                }

                ch = 'S';
                if (y > 0)
                    ch = 'N';

                y = Math.abs(y);

                if (x == 0) {

                    StringBuilder ans = new StringBuilder();
                    num = y;
                    int flag = 0;
                    while (num != 0) {
                        long rem = num % 2;
                        if (rem == 1) {
                            ans.append(ch);
                        } else {
                            flag = 1;
                            break;
                        }
                        num = num / 2;
                    }

                    if (flag == 1) {
                        out.println("IMPOSSIBLE");
                    } else {
                        out.println(ans);
                    }

                } else if (hell+max*2 == y) {

                    StringBuilder ans = new StringBuilder();
                    long p = 1;
                    while (true) {
                        if (p > max) {
                            ans.append(ch == 'N' ? 'S' : 'N');
                            break;
                        }

                        if (set.containsKey(p))
                            ans.append(set.get(p));
                        else
                            ans.append(ch == 'N' ? 'S' : 'N');

                        p = p * 2;
                    }
                    out.println(ans);


                } else if (hell + y == max * 2) {

                    StringBuilder ans = new StringBuilder();
                    long p = 1;
                    while (true) {
                        if (p > max) {
                            ans.append(ch);
                            break;
                        }

                        if (set.containsKey(p))
                            ans.append(set.get(p));
                        else
                            ans.append(ch == 'N' ? 'S' : 'N');

                        p = p * 2;
                    }
                    out.println(ans);

                } else {
                    out.println("IMPOSSIBLE");
                }


            } else if (num == Math.abs(y)) {

                char ch = 'S';
                if (x > 0)
                    ch = 'N';

                long hell = 0;
                long pow = 1, max = 0;
                while (num != 0) {
                    long rem = num % 2;
                    if (rem == 1) {
                        set.put(pow, ch);
                        max = Math.max(max, pow);
                    } else {
                        hell += pow;
                    }

                    num = num / 2;
                    pow = pow * 2;
                }


                ch = 'W';
                if (x > 0)
                    ch = 'E';

                x = Math.abs(x);

                if (y == 0) {

                    StringBuilder ans = new StringBuilder();
                    num = x;
                    int flag = 0;
                    while (num != 0) {
                        long rem = num % 2;
                        if (rem == 1) {
                            ans.append(ch);
                        } else {
                            flag = 1;
                            break;
                        }
                        num = num / 2;
                    }

                    if (flag == 1) {
                        out.println("IMPOSSIBLE");
                    } else {
                        out.println(ans);
                    }


                }else if (hell+max*2 == x) {

                    StringBuilder ans = new StringBuilder();
                    long p = 1;
                    while (true) {
                        if (p == max) {
                            ans.append(ch == 'W' ? 'E' : 'W');
                            break;
                        }

                        if (set.containsKey(p))
                            ans.append(set.get(p));
                        else
                            ans.append(ch == 'W' ? 'E' : 'W');

                        p = p * 2;
                    }
                    out.println(ans);

                } else if (hell + x == max * 2) {

                    StringBuilder ans = new StringBuilder();
                    long p = 1;
                    while (true) {
                        if (p > max) {
                            ans.append(ch);
                            break;
                        }

                        if (set.containsKey(p))
                            ans.append(set.get(p));
                        else
                            ans.append(ch == 'W' ? 'E' : 'W');

                        p = p * 2;
                    }
                    out.println(ans);

                } else
                    out.println("INPOSSIBLE");
            } else
                out.println("IMPOSSIBLE");



        }

        out.close();

    }


    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public int[] shuffle(int[] arr) {
            Random r = new Random();
            for (int i = 1, j; i < arr.length; i++) {
                j = r.nextInt(i);
                arr[i] = arr[i] ^ arr[j];
                arr[j] = arr[i] ^ arr[j];
                arr[i] = arr[i] ^ arr[j];
            }
            return arr;
        }

        public InputReader() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
            tokenizer = null;
        }

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
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

        public char nextChar() {
            return next().charAt(0);
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }


    }

}
