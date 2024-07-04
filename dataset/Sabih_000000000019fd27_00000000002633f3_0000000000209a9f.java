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
            int first = Integer.parseInt(String.valueOf(s.charAt(0)));
            l=(first==0)?"0":open[first]+first;
            int countClose = 0, countOpen = (first==0)?0:first;
            for(int i=1;i<s.length();i++){
                int num = Integer.parseInt(String.valueOf(s.charAt(i)));
                int prev = Integer.parseInt(String.valueOf(s.charAt(i-1)));
                if(num > prev)
                {
                    int diff = num - prev;
                    String curr = open[diff]+num;
                    countOpen+=diff;
                    l=l+curr;
                }
                else if(num < prev){
                    int diff = prev- num;
                    String curr = num+"";
                    curr = curr.trim();
                    l=l+close[diff]+curr;
                    countClose+=diff;
                }
                else if(num == prev){
                    l = l+prev;
                }
            }
            // System.out.println("countClose = "+countClose);
            // System.out.println("countOpen = "+countOpen);
            l = l+close[(int)Math.abs(countOpen-countClose)];
            System.out.println("Case #"+(j+1)+": "+l);
        }
    }
}