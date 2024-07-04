
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author qboiler
 */
public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        for(int i =1;i<=testCases; ++i) {
            processCase(reader, i);
        }
    }


    public static void processCase(BufferedReader reader, int caseN) throws IOException {

        String input = reader.readLine();
        int currentDepth = 0;
        String output = "";
        for(int i=0;i<input.length(); ++i){
            int n = Integer.parseInt(String.valueOf(input.charAt(i)));
            while(currentDepth<n){
                output+= "(";
                ++currentDepth;
            }
            while(currentDepth>n){
                output+=")";
                --currentDepth;
            }
            output += n;
        }
        while(currentDepth>0){
            output+=")";
            --currentDepth;
        }
        System.out.println("Case #"+caseN+": "+ output);
    }
}
