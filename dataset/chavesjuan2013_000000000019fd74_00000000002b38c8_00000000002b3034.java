import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int iter = 0;
        while(iter < T)
        {
            int N = Integer.parseInt(br.readLine());
            ArrayList<String> temp = new ArrayList<>();
            for(int i = 0; i < N; ++i)
            {
                StringBuilder s = new StringBuilder(br.readLine().replace("*",""));
                temp.add(s.reverse().toString());
            }

            String maxSuffix = temp.get(0);
            boolean flag = true;

            for(int i = 1; i< temp.size(); ++i)
            {
                if(!maxSuffix.startsWith(temp.get(i)))
                {
                    if(temp.get(i).startsWith(maxSuffix))
                    {
                        maxSuffix = temp.get(i);
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
            }

            if(flag)
            {
                System.out.println("Case #"+(iter+1)+": "+new StringBuilder(maxSuffix).reverse());
            }
            else
            {
                System.out.println("Case #"+(iter+1)+": "+"NO");
            }

            iter++;
        }
    }
}