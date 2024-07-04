import java.io.*;
import java.util.*;
public class Solution {
    
    public static void main(String[] args) {
        @SuppressWarnings("resource") 
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            String[] str = in.next().split("");
            StringBuilder str2= new StringBuilder();
            int openBracesCount = 0;
            for(int i = 0;i<=str.length-1;i++){     
                int a = Integer.parseInt(str[i]);
                if(openBracesCount > a) {
                    int b = openBracesCount - a;
                    for (int j = 0; j < b; j++) {
                        str2.append(")");
                        openBracesCount--;
                    }
                    str2.append(str[i]);
                } else if (openBracesCount < a) {
                    int c = a - openBracesCount;
                    for (int j = 0; j < c; j++) {
                        str2.append("(");
                        openBracesCount++;
                    }
                    str2.append(str[i]);
                } else if (openBracesCount == a) {
                    str2.append(str[i]);
                }
                if (i == str.length - 1) {
                    for (int j = 0; j < openBracesCount; j++) {
                        str2.append(")");
                    }
                }
            }            
            System.out.println("Case #" + t + ": " + str2);
        }
    }
    
}