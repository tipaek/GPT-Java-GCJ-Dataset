import java.io.*;
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
                char[] prints = new char[times.size()];

                char current = 'C';
                char other = 'J';
                prints[0] = current;
                for(int j = 0; j < times.size(); j++){
                    prints[j] = current;
                    
                }
                for(int j = 0; j < times.size(); j++){
                    current = prints[j];
                    time t = times.get(j);

                    if(current == 'C')
                        other = 'J';
                    else
                        other = 'C';
                    for(int k = 0; k < times.size(); k++){
                        if(prints[k] != current || prints[k] != other) {
                            if ((times.get(k).end < t.end && times.get(k).end > t.start) || (times.get(k).start < t.end && times.get(k).start > t.start)) {
                                prints[k] = other;

                            }
                        }

                    }

                }
                for(int j = 0; j < prints.length; j++){
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
