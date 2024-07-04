import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static class FastReader{
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

        Boolean hasNext(){
            try{
                return br.ready();
            } catch(Exception e){
                return false;
            }
        }
    }

    public static class schItem implements Comparable<schItem>{
        int startTime;
        int endTime;
        int index;

        public schItem(int s, int e, int i){
            startTime = s;
            endTime = e;
            index = i;
        }

        @Override
        public int compareTo(schItem sI) {
            if(startTime > sI.startTime){
                return 1;
            }
            if(startTime == sI.startTime){
                return 0;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        FastReader myScanner = new FastReader();
        Integer trials = myScanner.nextInt();
        Integer inputs;
        char[] outString;
        boolean impossible;
        schItem C;
        schItem J;
        int startTime;
        int endTime;
        ArrayList<schItem> schedule = new ArrayList<schItem>();

        for(Integer i=1; i<=trials; i++){
            impossible = false;

            inputs = myScanner.nextInt();

            for(int j=0; j<inputs; j++){
                startTime = myScanner.nextInt();
                endTime = myScanner.nextInt();
                schedule.add(new schItem(startTime, endTime, j));
            }

            outString = new char[inputs];

            Collections.sort(schedule);

            C = schedule.remove(0);
            J = schedule.remove(0);

            outString[C.index] = 'C';
            outString[J.index] = 'J';



            while(!schedule.isEmpty()){
                startTime = schedule.get(0).startTime;

                if(startTime >= C.endTime){
                    // Give the event to C
                    C = schedule.remove(0);
                    outString[C.index] = 'C';
                } else if(startTime >= J.endTime){
                    // Give the event to J
                    J = schedule.remove(0);
                    outString[J.index] = 'J';
                } else{
                    // IMPOSSIBLE
                    impossible = true;
                    break;
                }
            }
            if(impossible) {
                System.out.println("Case #" + i.toString() + ": IMPOSSIBLE");
            } else{
                System.out.println("Case #" + i.toString() + ": " + new String(outString));
            }
            schedule.clear();
        }
    }
}