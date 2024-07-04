import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] TB = reader.readLine().split(" ");
        int T = Integer.parseInt(TB[0]);
        int B = Integer.parseInt(TB[1]);
        while(T != 0) {
            T--;
            int[] bits = new int[B + 1];
            Arrays.fill(bits, -1);
            int loc = 1;
            for(int i = 1; i <= 150; i++) {
                if(i == 1) { 
                    bits[loc] = queryLoc(loc, reader);
                    loc = nextLoc(loc, B);
                    continue;
                }
                if((i % 10) != 1) {
                    bits[loc] = queryLoc(loc, reader);
                    loc = nextLoc(loc, B);
                    continue;
                }
                if((i % 10) == 1) {
                  
                    int sameLoc = -1;
                    int differLoc = -1;
                    for(int j = 1; j <= (B / 2 - 1); j++) {
                        int reverJ = B + 1 - j;
                        if((bits[j] != -1) && (bits[reverJ] != -1)) {
                            if(bits[j] == bits[reverJ]) {
                                if(sameLoc == -1) sameLoc = j;
                            } else {
                                if(differLoc == -1) differLoc = j;
                            }
                        }
                    }
                    if((sameLoc != -1) && (differLoc != -1)) {
                        handleDiffSameLoc(bits, B, loc, differLoc, sameLoc, reader);
                    } else if(sameLoc != -1 && differLoc == -1) {
                        handleSameLoc(bits, B, loc, sameLoc, reader);
                    } else if(differLoc != -1 && sameLoc == -1) {
                        handleDiffLoc(bits, B, loc, differLoc, reader);
                    } else {
                        throw new Exception("sb");
                    }
                    i += 2;
                    loc = nextLoc(loc, B);
                    continue;
                }
            }
            printAns(bits, B);
            String ans = reader.readLine();
            if(ans.equals("Y")) {
                continue;
            } else {
                break;
            }

        }
    }

    public static void printAns(int[] bits, int B) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= B; i++) {
            sb.append("" + bits[i]);
        }
        System.out.println(sb.toString());
        System.out.flush();
    }

    public static int nextLoc(int loc, int B) {
        int midB = B / 2;
        if(loc == midB + 1) {
            return midB;
        }
        if(loc == midB) {
            return midB + 1;
        }
        if(loc <= midB) {
            return B + 1 - loc;
        } else {
            return B + 1 - loc + 1;
        }
    }

    public static void reverse(int[] bits, int B) {
        for(int i = 1; i <= B / 2; i++) {
            int tmp = bits[i];
            bits[i] = bits[B + 1 - i];
            bits[B + 1 - i] = tmp;
        }
        return;
    }

    public static void fan(int[] bits, int B) {
        for(int i = 1; i <= B; i++) {
            if(bits[i] != -1) {
                bits[i] = 1 - bits[i];
            }
        }
        return;
    }

    public static boolean isAllSame(int[] bits, int B) {
        int dest = bits[1];
        for(int i = 1; i <= B; i++) {
            if(bits[i] != dest) {
                return false;
            }
        }
        return true;
    }

    public static void handleDiffSameLoc(int[] bits, int B, int nextLoc, int differLoc, int sameLoc, BufferedReader reader) throws Exception {
        int queryLocValue = queryLoc(nextLoc, reader);
        int queryDifferLocValue = queryLoc(differLoc, reader);
        int querySameLocValue = queryLoc(sameLoc, reader);
        if(querySameLocValue == bits[sameLoc]) {
            if(queryDifferLocValue == bits[differLoc]) { 
                bits[nextLoc] = queryLocValue;
            } else { 
                reverse(bits, B);
                bits[nextLoc] = queryLocValue;
            }
        } else { 
            fan(bits, B);
            if(queryDifferLocValue == (1 - bits[differLoc])) { 
                reverse(bits, B);
                bits[nextLoc] = queryLocValue;
            } else {
                bits[nextLoc] = queryLocValue;
            }
        }
    }

    public static void handleDiffLoc(int[] bits, int B, int nextLoc, int differLoc, BufferedReader reader) throws Exception {
        int queryLocValue = queryLoc(nextLoc, reader);
        int queryDifferLocValue = queryLoc(differLoc, reader);
        queryLoc(differLoc, reader); 
        if(queryDifferLocValue == bits[differLoc]) {
            bits[nextLoc] = queryLocValue;
        } else {
            reverse(bits, B);
            bits[nextLoc] = queryLocValue;
        }
    }

    public static void handleSameLoc(int[] bits, int B, int nextLoc, int sameLoc, BufferedReader reader) throws Exception {
        int queryLocValue = queryLoc(nextLoc, reader);
        int querySameLocValue = queryLoc(sameLoc, reader);
        queryLoc(sameLoc, reader); 
        if(querySameLocValue == bits[sameLoc]) {
            bits[nextLoc] = queryLocValue;
        } else { 
            fan(bits, B);
            bits[nextLoc] = queryLocValue;
        }
    }

    public static int queryLoc(int loc, BufferedReader reader) throws Exception {
        System.out.println(loc);
        System.out.flush();
        return Integer.parseInt(reader.readLine());
    }

}
