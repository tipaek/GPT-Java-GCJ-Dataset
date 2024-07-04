import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            int amount = in.nextInt();
            in.nextLine();
            int start = Integer.MAX_VALUE;
            int end = Integer.MIN_VALUE;

            Map<Integer,String> result  = new HashMap<Integer,String>();
            Map<Integer,int[]> activities = new HashMap<Integer,int[]>();

            for(int k = 0; k<amount; k++){
                int s = in.nextInt();
                if(s<start){
                    start = s;
                }
                int e = in.nextInt();
                if(e>end){
                    end = e;
                }
                int[] p = new int[]{s,e};
                activities.put(k,p);
                in.nextLine();
            }

            int time = start;
            int jamie = -1;
            int cameron = -1;

            out: while(time!=end){
                if(jamie!=-1 && activities.get(jamie)[1]==time){
                    jamie = -1;
                }
                if(cameron!=-1 && activities.get(cameron)[1]==time){
                    cameron = -1;
                }

                for (Map.Entry<Integer,int[]> entry : activities.entrySet()) {
                    int z = entry.getValue()[0];
                    if(z==time){
                        if(jamie==-1){
                            jamie=entry.getKey();
                            result.put(entry.getKey(),"J");
                        }else if(cameron==-1){
                            cameron=entry.getKey();
                            result.put(entry.getKey(),"C");
                        }else{
                            result = null;
                            break out;
                        }
                    }
                }

                time++;
            }
            String results;
            if(result == null){
                results = "IMPOSSIBLE";
            }else{
                StringBuilder builder = new StringBuilder();
                for(int l = 0; l<amount; l++){
                    builder.append(result.get(l));
                }
                results = builder.toString();
            }

            System.out.println("Case #" + i + ": " + results);
        }
    }

}