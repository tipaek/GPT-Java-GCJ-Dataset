import java.util.*;
import java.io.*;

class nesting {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for(int t=1;t<=T;t++) {
            String s = br.readLine().trim();
            StringBuilder newStr = new StringBuilder();
            newStr.append("Case #").append(t).append(": ");
            int n = s.length();
            int currCnt = 0;
            for(int i=0;i<n;i++) {
                int x = Integer.parseInt(s.substring(i,i+1));
                if(x == currCnt) {
                    newStr.append(x);
                } else if(x > currCnt) {
                    int diff = x - currCnt;
                    for(int j=0;j<diff;j++) {
                        newStr.append("(");
                        currCnt++;
                    }
                    newStr.append(x);
                } else {
                    int diff = currCnt - x;
                    for(int j=0;j<diff;j++) {
                        newStr.append(")");
                        currCnt--;
                    }
                    newStr.append(x);
                }
            }
            if(currCnt != 0) {
                for(int j=0;j<currCnt;j++) {
                    newStr.append(")");
                }
            }
            if(t != T) {
                newStr.append("\n");
            }
            sb.append(newStr.toString());
        }
        System.out.print(sb.append("\n").toString());
    }
}