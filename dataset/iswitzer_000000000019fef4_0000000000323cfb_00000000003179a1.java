import java.io.*;
import java.util.*;

//Overrandomized
public class Solution {
    public static HashMap<String,Range> ranges = new HashMap<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        ArrayList<String> answers = new ArrayList<>();
        int cases = Integer.parseInt(in.nextLine());
        for(int c = 1; c <= cases; c++) {
            ranges.clear();
            long upperBound = Integer.parseInt(in.nextLine());
            String ans = "Case #" + c + ": ";
            //HashMap<String,Range> ranges = new HashMap<>();

            ArrayList<String> nums = new ArrayList<>();
            for(int i=0; i<10000; i++) {
                String[] info = in.nextLine().split(" ");
                String query = info[0];
                long queryNum = Long.parseLong(query);
                String[] result = info[1].split("");
                for(int k=0; k<result.length; k++) {
                    if(!nums.contains(result[k])) nums.add(result[k]);
                }
                long min1; long max1;
                if(queryNum < 10) {
                    min1 = 1;
                    max1 = queryNum;
                    store(result[0], min1, max1);
                } else {
                    if(query.length() == result.length) {
                        String[] queries = query.split("");
                        store(result[0], 1, Integer.parseInt(queries[0]));
                        for(int k=1; k<result.length; k++) store(result[k],0,9);
                    } else {
                        for(int k=0; k<result.length; k++) store(result[k],0,9);
                    }
                }
            }

            HashMap<String,Integer> known = new HashMap<>();
            HashMap<String, ArrayList<String>> possible = new HashMap<>();

            for(String s : nums) {
                Range r = ranges.get(s);
                ArrayList<String> n = new ArrayList<>();
                for(int i=r.min; i<=r.max; i++) n.add(i + "");
                possible.put(s,n);
            }

            ArrayList<String> copy = new ArrayList<>();
            for(String s : nums) copy.add(s);
            while(!nums.isEmpty()) {
                String know = "-1";
                for(String s : nums) {
                    if(possible.get(s).size() == 1) {
                        know = possible.get(s).get(0);
                        known.put(s,Integer.parseInt(know));
                        nums.remove(s);
                        break;
                    }
                }
                if(know.equals("-1")) System.out.println("Something went wrong :(");
                else {
                    for(String n : nums) {
                        ArrayList<String> check = possible.get(n);
                        if(check == null || check.size() == 0) continue;
                        if(check.contains(know)) {
                            check.remove(know);
                            possible.put(n,check);
                        }
                    }
                }
            }

            copy.sort(Comparator.comparingInt(known::get));
            for(String s : copy) ans += s;
            answers.add(ans);
        }

        for(String s : answers) System.out.println(s);
    }

    public static void store(String s, long min, long max) {
        if(ranges.containsKey(s)) {
            Range curr = ranges.get(s);
            if(curr.min > min) min = curr.min;
            if(curr.max < max) max = curr.max;
        }
        ranges.put(s, new Range((int)min,(int)max));
    }

    private static class Range {
        public int min;
        public int max;

        public Range(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}
