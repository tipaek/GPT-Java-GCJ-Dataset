import java.io.*;
import java.util.*;
/**
 * Write a description of class Snail here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Solution
{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int nn = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int n = 1; n <= nn; n++){
            String str = br.readLine();
            String result = "";
            int nump = 0;

            for(int index = 0; index < str.length(); index++){
                int x = Integer.parseInt(str.substring(index,index+1));
                int temp = nump;
                if(temp < x){
                    for(int i = 0; i < x-temp; i++){
                        result += "(";
                        nump++;
                    }
                }
                else{
                    for(int i = 0; i < temp-x; i++){
                        result += ")";
                        nump--;
                    }
                }
                result += x;
            }
            
            for(int i = 0; i < nump; i++){
                result += ")";
            }

            out.println("Case #" + n + ": " + result);
        }
        out.close();
    }
}
