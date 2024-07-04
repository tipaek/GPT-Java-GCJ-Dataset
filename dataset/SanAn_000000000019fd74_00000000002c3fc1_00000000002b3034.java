
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int i = 0; i < nTestCases; i++) {
            int n = sc.nextInt();
            String[] input = new String[n];
            for(int j=0; j<n; j++){
                input[j] = sc.next();
            }
            StringBuilder pattern = new StringBuilder("");
            Arrays.sort(input);

            String start= "";
            boolean possible = true;
            for(int j =0; j<n && possible;j++){
               // System.out.println(input[j]);
                if(input[j].startsWith("*"))
                    continue;

                int index = input[j].indexOf('*');
                String startToken = input[j].substring(0,index-1);
                if(start.equals("")){
                    start = startToken;
                } else if(!start.startsWith(startToken)){
                    if(startToken.startsWith(start)){
                        start = startToken;
                    } else {
                        possible = false;
                        break;
                    }
                }
            }
           // System.out.println(start);

            String end = "";
            for(int j =0; j<n && possible;j++){
                if(input[j].endsWith("*"))
                    continue;

                int index = input[j].lastIndexOf('*');
                String endToken = input[j].substring(index+1);
                if(end.equals("")){
                    end = endToken;
                } else if(!end.endsWith(endToken)){
                    if(endToken.endsWith(end)){
                        end = endToken;
                    } else {
                        possible = false;
                        break;
                    }
                }
            }
           // System.out.println(end);


            pattern.append(start);

            for(int j =0; j<n && possible;j++){
                pattern.append(squash(input[j]));
            }

            pattern.append(end);

            if(possible){
                System.out.println("Case #"+ (i+1) + ": " + pattern.toString() );
            } else {
                System.out.println("Case #"+ (i+1) + ": " + "*" );
            }

        }
    }

    private static String squash(String s) {
        StringTokenizer st = new StringTokenizer(s,"*");
        StringBuilder sb = new StringBuilder("");
        while(st.hasMoreTokens()){
            sb.append(st.nextToken());
        }
        return  sb.toString();
    }
}
