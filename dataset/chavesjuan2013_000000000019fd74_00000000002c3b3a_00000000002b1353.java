import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    static int log2(int N)
    {
        return (int)(Math.log(N)/Math.log(2));
    }


    static int choose(int n , int k)
    {

        if(k == 0||k==n)
            return 1;
        return choose(n-1, k-1)+choose(n-1,k);
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int iter = 0;

        while(iter < T) {
            System.out.println("Case #"+(iter+1)+":");
            int N = Integer.parseInt(br.readLine());
            int pasos = 0;

            if(N == 1)
            {
                System.out.println(1+" "+1);
            }
            else
            {
                System.out.println(1+" "+1);
                N--;
                int total = 0;
                int index = 2;
                while(true)
                {
                    if(total+index<N) {
                        System.out.println(index+" "+2);
                        total += index-1;
                        index++;
                        pasos++;
                    }
                    else{
                        break;
                    }

                }

                index--;

                for(int i = 0; i < N - total;++i)
                {
                    System.out.println(index+" "+1);
                    index++;
                }
            }
            iter++;
        }
    }

}