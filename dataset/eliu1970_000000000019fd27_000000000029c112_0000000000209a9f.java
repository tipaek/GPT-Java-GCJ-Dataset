import java.io.*;
import java.util.*;
/**
 * Write a description of class Snail here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CodeJamNestingDepth
{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int nn = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int n = 1; n <= nn; n++){
            String str = br.readLine();
            String result = "";
            int z = 0;

            for(int index = 0; index < str.length(); index++){
                int x = Integer.parseInt(str.substring(index,index+1));
                int temp = z;
                if(temp < x){
                    for(int i = 0; i < x-temp; i++){
                        result += "(";
                        z++;
                    }
                }
                else{
                    for(int i = 0; i < temp-x; i++){
                        result += ")";
                        z--;
                    }
                }
                result += x;
            }
            
            for(int i = 0; i < z; i++){
                result += ")";
            }

            out.println("Case #" + n + ": " + result);
        }
        out.close();
    }
}
