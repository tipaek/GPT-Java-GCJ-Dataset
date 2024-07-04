import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String ansStr = "";
            String str = in.nextLine();

            char pDepth = 0; //current parentheses depth
            for(int j=0; j<str.length(); j++){
                if(str.charAt(j)-'0'>pDepth){
                    do {
                        ansStr += '(';
                        pDepth++;
                    } while (str.charAt(j) - '0' > pDepth);
                    ansStr += str.charAt(j);
                }
                else if(str.charAt(j)-'0'<pDepth) {
                    do {
                        ansStr += ')';
                        pDepth--;
                    } while (str.charAt(j) - '0' < pDepth);
                    ansStr += str.charAt(j);
                }
                else{
                    ansStr += str.charAt(j);
                }

                //finish parentheses at the end
                if(j == (str.length()-1) ){
                    while(pDepth>0){
                        ansStr += ')';
                        pDepth--;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + ansStr);
        }
    }
}