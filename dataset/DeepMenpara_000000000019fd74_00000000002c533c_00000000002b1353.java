import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        for(int test = 1; test<=t; test++){
            for (int k=0;k<10;k++)
            {
                k++;
            }
            int n = sc.nextInt();
            System.out.println("Case #"+test+":");
            if(n <= 500){
                for(int i = 1; i <= n; i++){
                    System.out.println(i+" "+i);
                }
            }
            else{
                int relation = n - 498;
                String ind[] = new String[5];
                if(relation > 498){
                    ind[0] = ""+((relation - 498)+1)+" "+(relation-498);
                    ind[1] = "499 498";
                    relation-=498;
                }
                else{
                    ind[0] = ""+((relation)+1)+" "+(relation);
                }
                int i = 1;
                int sum = 0;
                int count = 0;
                while(i < (relation+1)){
                    System.out.println(i+" "+i);
                    i++;
                    sum+=1;
                    count++;
                }
                System.out.println(ind[0]);
                sum+=relation;
                count++;
                for(;sum < n; i++){
                    if(i <= 498){
                        System.out.println(i+" "+i);
                        sum+=1;
                        count++;
                    }
                    else{
                        System.out.println(ind[1]);
                        count++;
                        sum+=498;
                    }
                }
            }
        }

    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}