import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int g = 1; g <= t; ++g) {
            int n = in.nextInt();
            Frames[] arr = new Frames[n];
            for (int i=0; i<n; i++)
            {
                arr[i] = new Frames(in.nextInt(), in.nextInt(), i);
            }
            Arrays.sort(arr);
            ArrayList<Frames>js = new ArrayList<Frames>();
            ArrayList<Frames>cs = new ArrayList<Frames>();
            for (int i =1; i<arr.length; i++)
            {
                if(arr[i-1].intersect(arr[i]))
                {
                    js.add(arr[i-1]);
                    cs.add(arr[i]);
                }
                else
                {
                    js.add(arr[i-1]);
                    js.add(arr[i]);
                }
            }
            boolean wrong = false;
            for (int i =1; i<js.size(); i++)
            {
                if(js.get(i-1).intersect(js.get(i)))
                {
                    wrong = true;
                    break;
                }
            }
            for (int i = 1; i < cs.size(); i++) {
                if (cs.get(i - 1).intersect(cs.get(i))) {
                    wrong = true;
                    break;
                }
            }
            if(wrong){
                System.out.println("Case #" + g+ ": " + "IMPOSSIBLE");
            }
            else {

                System.out.println("Case #" + g+ ": ");
                for (int i =0; i<n; i++)
               {
                   boolean c = false;
                   for(int y=0; y<cs.size(); y++)
                   {
                       if(cs.get(0).me() ==i)
                       {
                           System.out.print("C");
                           c = true;
                           break;
                       }
                   }
                   if(!c)
                   {
                       System.out.print("J");
                   }

               }

            }


        }
    }
    static class Frames implements Comparable{
        private int maximum;
        private int minimum;
        private int me;

        public int me(){
            return me;
        }
        @Override
        public int compareTo(Object o) {

            Frames i = (Frames) o;
            return getMin() - (i.getMin());
        }

        public Frames(int min, int max, int me){
            minimum = min;
            maximum = max;
            this.me =me;
        }
        public int getMax(){
            return maximum;
        }
        public int getMin(){
            return minimum;
        }
        public boolean intersect(Frames o){
            if(this.minimum>o.getMin() && this.minimum<o.getMax())
            {
                return true;
            }
            else if(this.maximum>o.getMin() && this.maximum<o.getMax())
            {
                return true;
            }
return false;
        }

    }

}
