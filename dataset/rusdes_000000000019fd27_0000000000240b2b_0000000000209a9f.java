import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = reader.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String S = reader.next();
            char[] arr = S.toCharArray();
            String str = "";
            int currOpen = 0;
            for (int j = 0; j < S.length(); j++){
                int next = S.charAt(j) - 48;
                str = addBrackets(str, currOpen, next);
                if (next != currOpen)
                    currOpen = next;

            }
            for(int k = 1; k <= currOpen; k++){
                str += ")";
            }

            System.out.println("Case #" + i + ": " + str);
        }
    }

    static String addBrackets(String str, int currOpen, int nextNum){
        final String open = "(", close = ")";
        if(currOpen > nextNum){
            for(int i = 1; i <= currOpen - nextNum; i++){
                str += close;
            }
        }else if (currOpen < nextNum){
            for(int i = 1; i <= nextNum - currOpen; i++) {
                str += open;
            }
        }
        str += nextNum;
        return str;
    }
}