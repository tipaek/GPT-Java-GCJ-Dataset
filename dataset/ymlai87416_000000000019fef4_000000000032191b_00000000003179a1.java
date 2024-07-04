import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static String   FILENAME;
    static Scanner sc;
    static String   IN;
    static String   OUT;
    static PrintStream out;

    static{
        try{
            /*
            FILENAME = "Solution-large";
            IN = FILENAME + ".in";
            OUT = FILENAME + ".out";
            sc = new Scanner(new File(IN));
            out      = new PrintStream(
                    new FileOutputStream(OUT, false));
                    */

            //IN = "C:\\GitProjects\\algorithm_practice\\temp\\src\\B\\B-test.in";
            IN = null;
            if(IN == null)
                sc = new Scanner(System.in);
            else
                sc = new Scanner(new File(IN));
            out = new PrintStream(System.out);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private String solve(int U, int[] query, String[] ans, String digits, char zeroChar){
        boolean[][] qq = new boolean[10][10];
        for (int i = 0; i < 10; i++) {
            if(i == digits.indexOf(zeroChar)) {
                qq[i][0] = true;
                continue;
            }
            else
                qq[i][0] = false;
            for (int j = 1; j < 10; j++) {
                qq[i][j] = true;
            }
        }


        for (int i = 0; i < 1000; i++) {
            int nd = numDigit(query[i]);
            int qd = ans[i].length();

            if(nd == qd){
                int leftMostD = query[i] / ((int)Math.pow(10, nd-1));
                char leftMostC = ans[i].charAt(0);
                int leftMostCIdx = digits.indexOf(leftMostC);
                for (int j = leftMostD+1; j < 10; j++) {
                    qq[leftMostCIdx][j] = false;
                }
            }

            //now apply the map

            //if any more clue, then use it
        }


        //make the conclusion
        String result = "";
        for(int i=0; i<10; ++i){
            //check unique
            int cnt = 0;
            int firstIdx = -1;
            for (int j = 0; j < 10; j++) {
                if(qq[j][i]) {
                    cnt++;
                    firstIdx = j;
                }
            }
            if(cnt != 1)
                System.out.println("shit! " + i + " have conflict: " + cnt);
            //output result
            result += digits.charAt(firstIdx);
        }

        return result;
    }


    private int numDigit(int number){
        if (number < 100000) {
            if (number < 100) {
                if (number < 10) {
                    return 1;
                } else {
                    return 2;
                }
            } else {
                if (number < 1000) {
                    return 3;
                } else {
                    if (number < 10000) {
                        return 4;
                    } else {
                        return 5;
                    }
                }
            }
        } else {
            if (number < 10000000) {
                if (number < 1000000) {
                    return 6;
                } else {
                    return 7;
                }
            } else {
                if (number < 100000000) {
                    return 8;
                } else {
                    if (number < 1000000000) {
                        return 9;
                    } else {
                        return 10;
                    }
                }
            }
        }
    }

    static
    public class nextPermutation {

        // Function to swap the data
        // present in the left and right indices
        public static char[] swap(char data[], int left, int right)
        {

            // Swap the data
            char temp = data[left];
            data[left] = data[right];
            data[right] = temp;

            // Return the updated array
            return data;
        }

        // Function to reverse the sub-array
        // starting from left to the right
        // both inclusive
        public static char[] reverse(char data[], int left, int right)
        {

            // Reverse the sub-array
            while (left < right) {
                char temp = data[left];
                data[left++] = data[right];
                data[right--] = temp;
            }

            // Return the updated array
            return data;
        }

        // Function to find the next permutation
        // of the given integer array
        public static boolean findNextPermutation(char data[])
        {

            // If the given dataset is empty
            // or contains only one element
            // next_permutation is not possible
            if (data.length <= 1)
                return false;

            int last = data.length - 2;

            // find the longest non-increasing suffix
            // and find the pivot
            while (last >= 0) {
                if (data[last] < data[last + 1]) {
                    break;
                }
                last--;
            }

            // If there is no increasing pair
            // there is no higher order permutation
            if (last < 0)
                return false;

            int nextGreater = data.length - 1;

            // Find the rightmost successor to the pivot
            for (int i = data.length - 1; i > last; i--) {
                if (data[i] > data[last]) {
                    nextGreater = i;
                    break;
                }
            }

            // Swap the successor and the pivot
            data = swap(data, nextGreater, last);

            // Reverse the suffix
            data = reverse(data, last + 1, data.length - 1);

            // Return true as the next_permutation is done
            return true;
        }

    }

    private String solveSmall(int U, int[] query, String[] ans, String digits, char zeroChar){
        //gather all the letter
        char[] c = digits.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if(c[i] == zeroChar){
                c[i] = c[0];
                c[0] = zeroChar;
            }
        }
        
        int[] digit = new int[26];

        while(true){
            boolean ok = true;
            if(c[0] != zeroChar) break;
            for (int i = 0; i < 26; i++) {
                digit[i] = -1;
            }
            for (int i = 0; i < c.length; i++) {
                digit[c[i] - 'A'] = i;
            }
            for (int j = 0; j < 1000; j++) {
                int q = query[j];
                String r = ans[j];
                int rc = 0;
                for(int i=0; i<r.length(); ++i){
                    rc = rc * 10 + digit[r.charAt(i)-'A'];
                }
                if(rc > q) {
                    ok = false;
                    break;
                }
            }

            if(ok)
                return new String(c);

            nextPermutation.findNextPermutation(c);
        }

        return "";
    }

    private void run() throws Exception {
        int t = sc.nextInt();
        sc.nextLine();

        int[] query = new int[1000];
        String[] ans = new String[1000];
        int[] c =new int[26];

        for (int i = 0; i <26 ; i++) {
            c[i] = 0;
        }
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");

            int U=  sc.nextInt();
            sc.nextLine();

            for (int j = 0; j < 1000; j++) {
               String s = sc.nextLine();
               String[] ss = s.split(" ");
               query[j] = Integer.parseInt(ss[0]);
               ans[j] = ss[1].trim();

                for (int k = 0; k < ans[j].length(); k++) {
                    int idx = ans[j].charAt(k) - 'A';
                    c[idx] += 1;
                }
            }

            String map = "";
            int leastFreq = Integer.MAX_VALUE;
            char zeroChar = ' ';
            for (int j = 0; j < 26; j++) {
                if(c[j] != 0) {
                    char ccc = ((char) ('A' + j));
                    map +=ccc ;
                    if(c[j] < leastFreq){
                        leastFreq = c[j];
                        zeroChar =ccc;
                    }
                }
            }

            String result = solveSmall(U, query, ans, map, zeroChar);
            out.println(result);
        }
        sc.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }
}