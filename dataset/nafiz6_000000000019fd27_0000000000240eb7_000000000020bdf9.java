import java.util.*;
import java.io.*;

class Pair implements Comparable{
    int st,end,ord;

    public Pair(int s, int e,int o){
        st=s;
        end=e;
        ord = o;
    }

    @Override
    public int compareTo(Object o) {
        int ost = ((Pair)o).st;
        return this.st - ost;
    }
}

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int z = 1; z <= t; ++z) {
            int N = in.nextInt();
            List<Pair> tasks = new ArrayList<>();
            for (int i=0;i<N;i++){
                int s,e;
                s = in.nextInt();
                e = in.nextInt();
                tasks.add(new Pair(s,e,i));
            }
            Collections.sort(tasks);
            int[] col = new int[N];
            boolean imp = false;
            for (int i=0;i<tasks.size();i++){
                Pair curr = tasks.get(i);
                for (int j=i+1;j<N;j++){
                    Pair comp = tasks.get(j);
                    if (comp.st >= curr.end)break;
                    if (col[i]==0)col[i]=1;
                    if (col[i]==col[j])imp=true;
                    col[j]=col[i]*-1;
                }
                if (imp)break;
            }
            if (imp)System.out.println("Case #" + z + ": IMPOSSIBLE"  );
            else{
                String[] order = new String[N];
                StringBuilder sb = new StringBuilder();
                for (int i=0;i<N;i++){
                    if (col[i]<=0 )order[tasks.get(i).ord] = "C";
                    else order[tasks.get(i).ord] = "J";
                }
                for (int i=0;i<N;i++)sb.append(order[i]);
                System.out.println("Case #" + z + ": " + sb.toString()  );

            }


        }
    }
}