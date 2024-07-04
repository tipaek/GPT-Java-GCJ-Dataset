import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            System.out.println("Case #"+(i+1)+": "+balance(input));
        }
    }

    private static String balance(String input) {
        int prev = 0;
        String finalStr = "";
        for (int i = 0; i < input.length(); i++) {
            int num = Integer.parseInt(input.charAt(i)+"");
            if (i == 0) {
                int diff=num;
                while (diff > 0) {
                    finalStr += "(";
                    diff--;
                }
                finalStr += num;
                prev = num;
            } else {
                if(num==prev)
                {
                    finalStr += num;
                }
                else if(num<prev)
                {
                    int diff=prev-num;
                    while(diff>0)
                    {
                        finalStr += ")";
                        diff--;
                    }
                    finalStr += num;
                    prev=num;
                }
                else if(num>prev)
                {
                    int diff=num-prev;
                    while(diff>0)
                    {
                        finalStr += "(";
                        diff--;
                    }
                    finalStr += num;
                    prev=num;
                }
            }
        }
        while(prev>0)
        {
            finalStr += ")";
            prev--;
        }
        return finalStr;
    }
}
