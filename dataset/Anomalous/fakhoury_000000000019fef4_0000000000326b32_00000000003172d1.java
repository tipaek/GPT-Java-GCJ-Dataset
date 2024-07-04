import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int testCases = in.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            System.out.print("Case #" + caseNumber + ": ");
            BigInteger factor = new BigInteger("310853026593002220559793640539460000");
            int n = in.nextInt();
            int d = in.nextInt();
            BigInteger[] array = new BigInteger[n];
            
            for (int i = 0; i < n; i++) {
                array[i] = new BigInteger(in.next()).multiply(factor);
            }
            
            long answer = Long.MAX_VALUE;
            
            for (int i = 0; i < n; i++) {
                BigInteger current = BigInteger.ONE;
                
                for (int iteration = 1; iteration <= 50; iteration++, current = current.add(BigInteger.ONE)) {
                    BigInteger x = array[i].divide(current);
                    ArrayList<Long> divisibleList = new ArrayList<>();
                    long currentSum = 0;
                    
                    for (int j = 0; j < n; j++) {
                        if (array[j].mod(x).equals(BigInteger.ZERO)) {
                            divisibleList.add(array[j].divide(x).longValue());
                        } else {
                            currentSum += array[j].divide(x).longValue();
                        }
                    }
                    
                    Collections.sort(divisibleList);
                    long currentAnswer = 0;
                    int remainingD = d;
                    
                    for (Long value : divisibleList) {
                        if (remainingD >= value) {
                            remainingD -= value;
                            currentAnswer += value - 1;
                        }
                    }
                    
                    if (currentSum >= remainingD) {
                        currentAnswer += remainingD;
                        answer = Math.min(answer, currentAnswer);
                    }
                }
            }
            System.out.println(answer);
        }
    }

    /** FastReader class for fast input reading */
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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