import java.util.*;

public class Solution {
    Scanner sc = new Scanner(System.in);

    void run(){
        int tests = sc.nextInt();

        for( int t = 0; t < tests; t++){
            solve(t);
        }
    }

    void solve(int t){
        int U = sc.nextInt();
        //int[] low = new int[26];
        int[] high = new int[26];
        System.out.print("Case #" + (t+1) + ": ");

        //System.out.println((char) (1 + 65));

        for (int i = 0; i < 26; i++) {
            //low[i] = Integer.MIN_VALUE;
            high[i] = Integer.MAX_VALUE;
        }

        //ArrayList<Query> q = new ArrayList<Query>();
        for (int i = 0; i < 10000; i++) {
            int number = sc.nextInt();
            String numberEnc = Integer.toString(number);
            String response = sc.next();
            //q.add(new Query(number, response));

            if (response.length() < numberEnc.length()) {
                continue;
            }

            //for (int p = 0; p < response.length(); p++) {
                char letter = response.charAt(0);
                int maxValue = Character.getNumericValue(numberEnc.charAt(0));

                if (high[letter - 65] > maxValue || high[letter - 65] == 0) {
                    high[letter - 65] = maxValue;
                }

            //}

            for (int p = 0; p < response.length(); p++) {
                char letterp = response.charAt(p);
                if (high[letterp - 65] == Integer.MAX_VALUE) {
                    high[letterp - 65] = 0;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 26; j++) {
                if (high[j] == Integer.MAX_VALUE) {
                    continue;
                }
                if (high[j] == i) {
                    System.out.print((char) (j + 65));
                }
            }
        }

        System.out.println();







    }

    /*
    private class Query {
        int q;
        String r;

        Query(int qi, String ri) {
            q = qi;
            r = ri;
        }
    }

     */

    public static void main(String[] args){
        (new Solution()).run();
    }
}
