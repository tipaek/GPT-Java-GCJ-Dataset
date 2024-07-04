
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) {
        FastReader fd = new FastReader();
        int t = fd.nextInt();
        for(int test = 1; test<=t; test++){
            int n = fd.nextInt();
            System.out.println("Case #"+test+":");
            if(n <= 500){
                for(int i = 1; i <= n; i++){
                    System.out.println(i+" "+i);
                }
            }
            else{
                int rel = n - 498;
                String pos[] = new String[5];
                if(rel > 498){
                    pos[0] = ""+((rel - 498)+1)+" "+(rel-498);
                    pos[1] = "499 498";
                    rel-=498;
                }
                else{
                    pos[0] = ""+((rel)+1)+" "+(rel);
                }
                int i = 1;
                int sum = 0;
                int count = 0;
                while(i < (rel+1)){
                    System.out.println(i+" "+i);
                    i++;
                    sum+=1;
                    count++;
                }
                System.out.println(pos[0]);
                sum+=rel;
                count++;
                for(;sum < n; i++){
                    if(i <= 498){
                        System.out.println(i+" "+i);
                        sum+=1;
                        count++;
                    }
                    else{
                        System.out.println(pos[1]);
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
