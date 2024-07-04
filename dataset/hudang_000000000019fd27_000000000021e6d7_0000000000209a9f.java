import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        int cnt;
        char[] inp;
        StringBuffer ret;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            cnt = 0;
            ret = new StringBuffer();

            inp = in.next().toCharArray();
            for(int x = 0 ; x < inp.length ; x++){
                if(x == 0){
                    for(int y = 0 ; y < inp[x]-'0' ; y++){
                        ret.append('(');
                        cnt++;
                    }
                    ret.append(inp[x]);
                }
                if (x == (inp.length -1)){
                    if(inp.length == 1){
                        for(int y = 0 ; y < inp[x]-'0' ; y++){
                            ret.append(')');
                            cnt--;
                        }
                    }else {
                        if (inp[x - 1] > inp[x]) {
                            for (int y = 0; y < inp[x - 1] - inp[x]; y++) {
                                ret.append(')');
                                cnt--;
                            }
                        }
                        ret.append(inp[x]);
                        for (int y = 0; y < inp[x] - '0'; y++) {
                            ret.append(')');
                            cnt--;
                        }
                    }
                }
                if(x != 0 && x != (inp.length -1)){
                    if(inp[x-1] > inp[x]) {
                        for (int y = 0; y < inp[x - 1] - inp[x]; y++) {
                            ret.append(')');
                            cnt--;
                        }
                    }
                    if(inp[x-1] < inp[x]) {
                        for (int y = 0, c = cnt; y < inp[x] - inp[x - 1] - c; y++) {
                            ret.append('(');
                            cnt++;
                        }
                    }
                    ret.append(inp[x]);
                    if(inp[x] < inp[x+1]) {
                        for (int y = 0; y < inp[x+1] - inp[x]; y++) {
                            ret.append('(');
                            cnt++;
                        }
                    }
                }
            }


            System.out.println("Case #" + i + ": " + ret.toString());
        }
    }
}