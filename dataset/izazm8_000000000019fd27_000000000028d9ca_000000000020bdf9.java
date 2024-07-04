import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Solution {

    static class Time{
        public int endTime;
        public int startTime;
        public int index;
    }

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

            Time[] times = new Time[n];
            for(int i=0;i<n;i++){
                times[i]=new Time();
            }

            int index=0;

            int chi=0;
            char[] ch = new char[n];


            for(int i=0;i<n;i++){
                times[i].startTime=fr.nextInt();
                times[i].endTime=fr.nextInt();
                times[i].index=i;
//                startTimes[i]=fr.nextInt();
//                endTimes[i]=fr.nextInt();
            }

            int minS;

            for(int i=0;i<n;i++){
                minS = times[i].startTime;
                index=i;
                for(int j=i+1;j<n;j++){
                    if(minS>times[j].startTime){
                        minS=times[j].startTime;
                        index=j;
                    }
                }

                int temp = times[i].startTime;
                int temp1 = times[i].endTime;
                int temp2 = times[i].index;

                times[i].startTime=times[index].startTime;
                times[i].endTime=times[index].endTime;
                times[i].index=times[index].index;
                times[index].startTime=temp;
                times[index].endTime=temp1;
                times[index].index=temp2;


            }


//            for(int i=0;i<n;i++){
//                System.out.println(times[i].startTime+ "   "+times[i].endTime);
//            }


            int c = -1;
            int j = -1;

            boolean imp = false;

            for(int i=0;i<n;i++){
                if(times[i].startTime>=c){
                    c=times[i].endTime;
                    ch[times[i].index]='C';
                } else if(times[i].startTime>=j) {
                    j=times[i].endTime;
                    ch[times[i].index]='J';
                } else {
                    imp = true;
                    break;
                }
            }


            System.out.print("Case #"+t+": ");
            if(!imp) {
                for (char c1 : ch) {
                    System.out.print(c1);
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }

//            ch[0]='C';
//
//            int maxJ=-1, maxC=-1;
//
//            maxC=times[0].endTime;
//
//            for(int i=1;i<n;i++){
//                if(times[i].startTime < times[i-1].endTime && maxC > times[i].endTime){
//                    //maxJ=times[i].endTime;
//                    ch[times[i].index] = 'J';
//                } else if (times[i].startTime>=times[i-1].endTime){
//                    ch[times[i].index]='C';
//                }
//            }



            //boolean isImpossible = false;
//
//            for(int i=1;i<endTimes.length;i++){
//                int j=0;
//                boolean cOverlaps = false;
//                boolean jOverlaps = false;
//
//                while(j<chi){
//
//                    if(!cOverlaps && ch[j]=='C'){
//                        if((startTimes[i]<startTimes[j] && endTimes[i] > startTimes[j])){ //overlaps
//                            cOverlaps=true;
//                        } else if((startTimes[i]>startTimes[j] && startTimes[i] < endTimes[j] )){ //overlaps
//                            //System.out.print("Hey");
//                            cOverlaps=true;
//                        }
//                    } else if(!jOverlaps && ch[j]=='J'){
//                        if((startTimes[i]<startTimes[j] && endTimes[i] > startTimes[j])){ //overlaps
//                            jOverlaps=true;
//                        } else if((startTimes[i]>startTimes[j] && startTimes[i] < endTimes[j] )){ //overlaps
//                            jOverlaps=true;
//                        }
//                    }
//
//                    j++;
//                }
//
//                if(jOverlaps && cOverlaps){
//                    isImpossible=true;
//                    break;
//                } else if(!jOverlaps){
//                    ch[chi++]='J';
//                } else if(!cOverlaps){
//                    ch[chi++]='C';
//                }
//            }




        }
    }
}
