import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Solution {
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

        for(int t=1;t<=tCase;t++){
            int n=fr.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            char[] cj = {'C','J'};
            int index=0;

            int chi=0;
            char[] ch = new char[n];

            int maxCL=-1, maxCR=-1,  maxJL=-1, maxJR=-1;

            for(int i=0;i<n;i++){
                startTimes[i]=fr.nextInt();
                endTimes[i]=fr.nextInt();
            }

            ch[chi++]='C';
            maxCL=startTimes[0];
            maxCR=endTimes[0];

            boolean isImpossible = false;

            for(int i=1;i<endTimes.length;i++){
                int j=0;
                boolean cOverlaps = false;
                boolean jOverlaps = false;

                while(j<chi){

                    if(!cOverlaps && ch[j]=='C'){
                        if((startTimes[i]<startTimes[j] && endTimes[i] > startTimes[j])){ //overlaps
                            cOverlaps=true;
                        } else if((startTimes[i]>startTimes[j] && startTimes[i] < endTimes[j] )){ //overlaps
                            //System.out.print("Hey");
                            cOverlaps=true;
                        }
                    } else if(!jOverlaps && ch[j]=='J'){
                        if((startTimes[i]<startTimes[j] && endTimes[i] > startTimes[j])){ //overlaps
                            jOverlaps=true;
                        } else if((startTimes[i]>startTimes[j] && startTimes[i] < endTimes[j] )){ //overlaps
                            jOverlaps=true;
                        }
                    }

                    j++;
                }

                if(jOverlaps && cOverlaps){
                    isImpossible=true;
                    break;
                } else if(!jOverlaps){
                    ch[chi++]='J';
                } else if(!cOverlaps){
                    ch[chi++]='C';
                }
            }

            System.out.print("Case #"+t+": ");
            if(!isImpossible){
                for (char c : ch) {
                    System.out.print(c);
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }


        }
    }
}
