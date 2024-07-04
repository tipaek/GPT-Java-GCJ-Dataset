import java.io.IOException;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

    public static String updateStr(String s) {
        String finalStr = "";
        int pendingRight = 0, pendingFull = 0;

        int n = s.length();

        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            int num = c-48;

            if(i == 0) {

                finalStr += c;
                pendingFull += num;

            } else {

                if(num <= (pendingFull+pendingRight)) {

                    while(num < pendingFull+pendingRight && pendingRight > 0) {
                        finalStr = finalStr + ")";
                        pendingRight--;
                    }

                    if(pendingRight > 0) {
                        finalStr += c;
                        continue;
                    }

                    int diff = pendingFull - num;
                    pendingFull = num;
                    for(int j=0; j<diff; j++) {
                        finalStr = "(" + finalStr + ")";
                    }
                    finalStr += c;
                } else {
                    int diff = num - (pendingFull+pendingRight);
                    String temp = "" + c;
                    for (int j = 0; j < diff; j++) {
                        temp = "(" + temp;
                    }
                    finalStr += temp;
                    pendingRight += diff;
                }
            }
        }

        for(int i=0; i<pendingRight; i++) {
            finalStr = finalStr + ")";
        }

        for(int i=0; i<pendingFull; i++) {
            finalStr = "(" + finalStr + ")";
        }

        return finalStr;
    }

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.valueOf(bufferedReader.readLine());
        for(int i=0; i<tc; i++) {
            String s = bufferedReader.readLine();
            String finalStr = updateStr(s);
            System.out.println("Case #"+(i+1)+": "+finalStr);
        }
    }

}