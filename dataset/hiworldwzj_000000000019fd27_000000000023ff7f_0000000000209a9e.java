import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] TB = reader.readLine().split(" ");
        int T = Integer.parseInt(TB[0]);
        int B = Integer.parseInt(TB[1]);
        while(T != 0) {
            T--;
            queryCount = 150;
            int[] bits = new int[B + 1];
            Arrays.fill(bits, -1);
            for(int i = 1; i <= B; i++) {
                if(i % 10 != 1) {
                    bits[i] = queryLoc(i, reader);
                }
            }

            // find Same loc or Different Loc
            int sameLoc = -1;
            int differLoc = -1;
            for(int i = 1; i <= B; i++) {
                if(bits[i] != -1 && bits[B + 1 - i] != -1) {
                    if(bits[i] == bits[B + 1 - i]) {
                        sameLoc = i;
                    } else {
                        differLoc = i;
                    }
                    break;
                }
            }
            if(sameLoc != -1) {
                handleSameLoc(bits, B, sameLoc, reader);
            } else {
                handleDifferentLoc(bits, B, differLoc, reader);
            }
            while(queryCount != 0) {
                queryLoc(1, reader);
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i < bits.length; i++) {
                sb.append("" + bits[i]);
            }
            System.out.println(sb.toString());
            System.out.flush();
            String ans = reader.readLine();
            if(ans.equals("Y")) {
                continue;
            } else {
                break;
            }
        }
    }

    public static void handleDifferentLoc(int[] bits, int B, int differLoc, BufferedReader reader) throws Exception {
        for(int i = 1; i <= B; i++) {
            if(bits[i] != -1) continue;
            if(i % 10 != 1) continue;
            int loc = i;
            int reverseLoc = (B + 1 - loc);
            int queryLocValue = queryLoc(loc, reader);
            int queryReverseLocValue = queryLoc(reverseLoc, reader);
            int queryDifferLocValue = queryLoc(differLoc, reader);
            if(queryDifferLocValue == bits[differLoc]) {
                int case1Value = -1;  
                if(queryReverseLocValue == bits[reverseLoc]) {
                    case1Value = queryLocValue;
                }
                int case2Value = -1; 
                if(queryLocValue != bits[reverseLoc]) {
                    case2Value = 1 - queryReverseLocValue;
                }
                bits[loc] = Math.max(case1Value, case2Value);
            } else {
                int case1Value = -1;
                if(queryReverseLocValue != bits[reverseLoc]) {
                    case1Value = 1 - queryLocValue;
                }
                int case2Value = -1; 
                if(queryLocValue == bits[reverseLoc]) {
                    case2Value = queryReverseLocValue;
                }
                bits[loc] = Math.max(case1Value, case2Value);
            }
        }
    }

    public static void handleSameLoc(int[] bits, int B, int sameLoc, BufferedReader reader) throws Exception {
        for(int i = 1; i <= B; i++) {
            if(bits[i] != -1) continue;
            if(i % 10 != 1) continue;
            int loc = i;
            int reverseLoc = (B + 1 - loc);
            int queryLocValue = queryLoc(loc, reader);
            int queryReverseLocValue = queryLoc(reverseLoc, reader);
            int querySameLocValue = queryLoc(sameLoc, reader);
            if(querySameLocValue == bits[sameLoc]) { 
                int case1Value = -1;  
                if(queryReverseLocValue == bits[reverseLoc]) {
                    case1Value = queryLocValue;
                }
                int case2Value = -1; 
                if(queryLocValue == bits[reverseLoc]) {
                    case2Value = queryReverseLocValue;
                }
                bits[loc] = Math.max(case1Value, case2Value);
            } else { 
                int case1Value = -1; 
                if(queryReverseLocValue != bits[reverseLoc]) {
                    case1Value = 1 - queryLocValue;
                }
                int case2Value = -1; 
                if(queryLocValue != bits[reverseLoc]) {
                    case2Value = 1 - queryReverseLocValue;
                }
                bits[loc] = Math.max(case1Value, case2Value);
            }
        }
    }

    public static int queryCount = 0;

    public static int queryLoc(int loc, BufferedReader reader) throws Exception {
        System.out.println(loc);
        System.out.flush();
        queryCount--;
        return Integer.parseInt(reader.readLine());
    }

}
