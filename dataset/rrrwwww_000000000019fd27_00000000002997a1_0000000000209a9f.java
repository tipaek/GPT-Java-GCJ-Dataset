import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(in.readLine());
        for (int c = 1; c <= t; c++) {
            String str = in.readLine();
            String newString = "";
            for(int i = 0; i < str.length(); i++) {
                //building new string starting with n ('s n and then n )'s
                int curr = str.charAt(i) - '0';
                for(int j = 0; j < curr; j++)
                    newString += "(";
                newString += "" + str.charAt(i);
                for(int k = 0; k < curr; k++) 
                    newString += ")";
                //replacing the )(
            }
            while(newString.contains(")(")) {
                newString = newString.replace(")(", "");
            }
            out.println("Case #" + c + ": " + newString);
        }
        out.close();
    }
}