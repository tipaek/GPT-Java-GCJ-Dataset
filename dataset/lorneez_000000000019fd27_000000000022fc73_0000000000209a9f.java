import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner myScanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(myScanner.nextLine());
        for(int i=0; i<testCases; i++){
            String ret = "";
            String input = myScanner.nextLine();
            int open = 0;
            for(int s=0; s<input.length(); s++){
                String x = input.substring(s,s+1);
                while (open > Integer.parseInt(x)) {
                    open--;
                    ret += ")";
                }
                while (open < Integer.parseInt(x)) {
                    open ++;
                    ret += "(";
                }
                ret += x;
            }
            while(open > 0){
                ret += ")";
                open --;
            }

            System.out.println("Case #"+(i+1)+": "+ret);
        }
        myScanner.close();
    }
}