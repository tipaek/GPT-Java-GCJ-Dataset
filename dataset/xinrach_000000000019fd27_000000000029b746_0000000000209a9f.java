import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution{
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int t = 1; t <= test; t++){
            String line = br.readLine();
            String ans = "";
            for (int i = 0; i < line.length(); i++){
                int x = Integer.parseInt(line.substring(i,i+1));
                for (int j = 0; j < x; j++){
                    ans += "(";
                }
                ans += x;
                for (int j = 0; j < x; j++){
                    ans += ")";
                }
            }
            while (ans.contains(")("))
            {
                ans = ans.replace(")(", "");
            }
            System.out.println("Case #" + t + ": " + ans);
        }
    }
}