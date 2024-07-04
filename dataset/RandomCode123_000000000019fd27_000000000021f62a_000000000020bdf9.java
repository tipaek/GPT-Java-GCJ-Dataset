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

            Map<Integer,Integer> times = new HashMap<Integer,Integer>();
            Map<Integer,String> result  = new HashMap<Integer,String>();

            ArrayList<Integer> activities = new ArrayList<Integer>();

            for(int k = 0; k<amount; k++){
                int s = in.nextInt();
                if(s<start){
                    start = s;
                }
                int e = in.nextInt();
                if(e>end){
                    end = e;
                }
                activities.add(s);
                times.put(s,e);
                in.nextLine();
            }

            int time = start+1;
            int jamie = -1;
            int cameron = start;
            result.put(activities.indexOf(start),"C");
            out: while(time!=end){
                if(jamie!=-1 && times.get(jamie)==time){
                    jamie = -1;
                }
                if(cameron!=-1 && times.get(cameron)==time){
                    cameron = -1;
                }

                for(Integer z : activities){
                    if(z==time){
                        if(jamie==-1){
                            jamie=z;
                            result.put(activities.indexOf(z),"J");
                        }else if(cameron==-1){
                            cameron=z;
                            result.put(activities.indexOf(z),"C");
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