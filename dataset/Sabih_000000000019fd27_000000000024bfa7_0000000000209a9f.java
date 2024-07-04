import java.io.*;
import java.util.*;
class Solution{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String open[] = {"","(","((","(((","((((","(((((","((((((","(((((((","((((((((","((((((((("};
        String close[] = {"",")","))",")))","))))",")))))","))))))",")))))))","))))))))",")))))))))"};
        int t = Integer.parseInt(br.readLine());
        for(int j=0;j<t;j++){
            String s = br.readLine();
            String l = "";
            for(int i=0;i<s.length();i++){
                int num = Integer.parseInt(
                    String.valueOf(s.charAt(i))
                    );
                
                l = l + open[num]+s.charAt(i)+close[num];
            }
            System.out.println("Case #"+(j+1)+": "+l);
        }
    }
}