import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
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

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {

        FastReader fr = new FastReader();
        int tCase = fr.nextInt();
        String input = "";
        String output;//= new String();
        for(int t=1;t<=tCase;t++){
            input=fr.nextLine();

            output="";
            //output = new StringBuilder();
            int depth=0;

            int curDepth=0;

            for(int i=0;i<input.length();i++){
                depth=Integer.parseInt(String.valueOf(input.charAt(i)));

                if(curDepth==depth) {
                    output+=input.charAt(i);
                    continue;
                }

                if(depth<curDepth){
                    int j=curDepth-depth;
                    while(j!=0){
                        output+=")";
                        j--;
                    }
                    output+=input.charAt(i);
                    curDepth=depth;
                    continue;
                }




//                while(curDepth!=0){
//                    output+=")";
//                    curDepth--;
//                }

                int j=depth-curDepth;

                curDepth=depth;
                while(j!=0){
                    output+="(";
                    j--;
                }
                output+=input.charAt(i);


            }

            while(curDepth!=0){
                output+=")";
                curDepth--;
            }

            System.out.print("Case #"+t+": ");

            if(output.equals(""))
                System.out.println(input);
            else
                System.out.println(output);


        }


    }
}
