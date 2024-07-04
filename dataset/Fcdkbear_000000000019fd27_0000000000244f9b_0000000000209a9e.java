import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {

        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int tests = in.nextInt();
        int b = in.nextInt();
        for (int testNumber = 1; testNumber <= tests; ++testNumber) {
           List<Integer> samePositions = new ArrayList<>();
           List<Integer> differentPositions = new ArrayList<>();
           int queryNumberToMake = 1;
           int position = 0;
           int[] res = new int[b];
           while (position < b / 2) {
               if ((queryNumberToMake % 10 == 1) && (queryNumberToMake != 1)) {
                   if (samePositions.size() > 0) {
                       out.println(samePositions.get(0) + 1);
                       out.flush();
                       int value = in.nextInt();
                       if (value != res[samePositions.get(0)]) {
                           for (Integer idx : samePositions) {
                               res[idx] ^= 1;
                               res[b - idx - 1] ^= 1;
                           }
                       }
                       queryNumberToMake++;
                   }
                   if (differentPositions.size() > 0) {
                       out.println(differentPositions.get(0) + 1);
                       out.flush();
                       int value = in.nextInt();
                       if (value != res[differentPositions.get(0)]) {
                           for (Integer idx : differentPositions) {
                               res[idx] ^= 1;
                               res[b - idx - 1] ^= 1;
                           }
                       }
                       queryNumberToMake++;
                   }
               } else if (queryNumberToMake % 10 == 0) {
                       out.println(1);
                       out.flush();
                       int v = in.nextInt();
                       queryNumberToMake++;
                   }
               else {
                   out.println(position + 1);
                   out.flush();
                   res[position] = in.nextInt();
                   out.println(b - position);
                   out.flush();
                   res[b - position - 1] = in.nextInt();
                   if (res[position] == res[b - position - 1]) {
                       samePositions.add(position);
                   } else {
                       differentPositions.add(position);
                   }
                   queryNumberToMake += 2;
                   position++;
               }
           }
           for (int i = 0; i < b; ++i) {
               out.print(res[i]);
           }
           out.println();
           out.flush();
           String answer = in.next();
        }
        out.close();

    }

    static class Activity {
        int start;
        int end;
        int index;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
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
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }


    }
}
