import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int casos = Integer.parseInt(br.readLine());

        for(int p = 0; p < casos; ++p)
        {
            char s[] = br.readLine().toCharArray();
            String res = "";
            int abre = valueOfDigit(s[0]);
            while(abre>0)
            {
                res+="(";
                abre--;
            }

            for(int i = 0; i < s.length-1; ++i)
            {
                int act = valueOfDigit(s[i]);
                int sig = valueOfDigit(s[i+1]);

                res += act;
                int veces = act - sig >= 0? act - sig : sig - act;

                if(sig - act > 0)
                {
                    while(veces>0)
                    {
                        res += "(";
                        veces--;
                    }
                }
                else if(sig - act < 0)
                {
                    while(veces>0)
                    {
                        res += ")";
                        veces--;
                    }
                }
            }


            res += valueOfDigit(s[s.length - 1]);

            int cierra = valueOfDigit(s[s.length-1]);
            while(cierra>0)
            {
                res+=")";
                cierra--;
            }
            System.out.println("Case #"+(p+1)+": "+res);
        }
    }

    public static int valueOfDigit(char c)
    {
        return c - '0';
    }
}