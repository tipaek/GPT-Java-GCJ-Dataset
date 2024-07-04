import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception{
        Scanner in = new Scanner((System.in));
        int T = in.nextInt();
        for(int t=0;t<T;t++){
            int leftSize = 0;
            int prevValue = -1;
            String s = in.next();
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i++) {
                int current = s.charAt(i)-48;
                if(current == 0){
                    if(leftSize!=0){
                        sb.append(getRepeatedString(")", leftSize));
                        leftSize = 0;
                        prevValue = -1;
                    }
                    sb.append("0");
                }
                else{
                    if (current > prevValue && prevValue != -1){
                        leftSize += current - prevValue;
                        sb.append(getRepeatedString("(", current - prevValue));
                        sb.append(current);
                    }
                    else if(current == prevValue && prevValue != -1){
                        sb.append(current);
                    }
                    else if(current < prevValue && prevValue != -1){
                        leftSize -= prevValue - current;
                        sb.append(getRepeatedString(")", prevValue - current));
                        sb.append(current);
                    }
                    else {
                        leftSize = current;
                        sb.append(getRepeatedString("(", current));
                        sb.append(current);
                    }
                    prevValue = current;
                }
            }
            sb.append(getRepeatedString(")", leftSize));
            System.out.println("Case #"+(t+1) +": "+sb.toString());
        }
    }

    public static String getRepeatedString(String symbol, int n){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(symbol);
        }
        return sb.toString();
    }
    
}
