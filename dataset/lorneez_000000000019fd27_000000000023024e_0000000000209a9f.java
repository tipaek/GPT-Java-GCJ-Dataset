import java.util.*;
import java.io.*;
public class NestingDepth {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner myScanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.parseInt(myScanner.nextLine());
        for(int i=1; i<=cases; i++){
            String ret = "";
            String input = myScanner.nextLine();
            int open = 0;
            for(int s=0; s<input.length(); s++){
                String element = input.substring(s,s+1);
                while (open > Integer.parseInt(element)) {
                    open--;
                    ret += ")";
                }
                while (open < Integer.parseInt(element)) {
                    open ++;
                    ret += "(";
                }
                ret += element;
            }
            while(open > 0){
                open --;
                ret += ")";
            }
            System.out.println(ret);
        }
        myScanner.close();
    }
}