import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Solution {

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        for(int i = 1; i <= T; i++){
            int N = in.nextInt();
            //int[][] times = new int[N][2];
            ArrayList<time> times = new ArrayList<>();
            int max = 0;
            for(int j = 0; j< N; j++){
                time t = new time();
                t.start = in.nextInt();
                t.end = in.nextInt();
                max = Math.max(t.end,max);
                times.add(t);

            }

            int[] timeline = new int[max + 1];

            for(int j = 0; j < N; j++){
                timeline[times.get(j).start]++;
                timeline[times.get(j).end]--;

            }

            int[] workers = new int[max + 1];
            int add = 0;

            boolean b = false;

            for(int j = 0; j < max; j++){
                add+= timeline[j];
                if(add > 2){
                    b = true;
                    break;

                }
                workers[j] = add;

            }
            if(b)
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            else{
                System.out.print("Case #" + i + ": ");
                char C = 'C';
                char J = 'J';
                int prev = 0;
                char prevC = C;
                ArrayList<Integer> timeC = new ArrayList<>();
                for(int j = 0; j < times.size(); j++){
                    timeC.add(times.get(j).start);

                }
                char[] prints=  new char[times.size()];
                Collections.sort(times, (t1,t2) -> t1.start < t2.start ? -1: t1.start > t2.start ? 1 : 0);
                prints[timeC.indexOf(times.get(0).start)] = C;
                int maxEnd = times.get(0).end;
                for(int j = 1; j < times.size(); j++){
                    if(maxEnd < times.get(j).start){
                        prints[timeC.indexOf(times.get(j).start)] = C;
                        prevC = C;

                    }
                    else {
                        if(prevC == J){
                            prints[timeC.indexOf(times.get(j).start)] = C;

                        }
                        else{
                            prints[timeC.indexOf(times.get(j).start)] = J;

                        }


                    }

                    if(times.get(j).end>maxEnd){
                        maxEnd = times.get(j).end;
                        prevC = prints[timeC.indexOf(times.get(j).start)];

                    }

                }
                for(int j = 0; j < times.size(); j++){
                    System.out.print(prints[j]);

                }
                System.out.println();

            }

        }

    }

    public static class time{
        int start;
        int end;

    }

}
