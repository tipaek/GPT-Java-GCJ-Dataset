import java.util.*;
import java.io.*;

public class Solution {
    public static void sortbyColumn(int arr[][], int col) 
    { 
        Arrays.sort(arr, new Comparator<int[]>() { 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        }); 
    }
    static class Point implements Comparable<Point> {
        int a;
        int b;

        public Point(int a, int b) {
            this.a = a;
            this.b = b;
        }
        public int getA(){
            return a;
        }
        public int getB(){
            return b;
        }
        @Override
        public int compareTo(Point o) {
            if(this.a == o.a) return this.b - o.b;
            return this.a - o.a;
        }

    }
                        //no one
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String out = "";
        for (int i = 1; i <= t; i++) {
            int N = in.nextInt();
            ArrayList<Point> times = new ArrayList<>();
            ArrayList<Integer> cTasks = new ArrayList<>();
            ArrayList<Integer> jTasks = new ArrayList<>();
    		for(int j = 0; j < N; j++){
    			int a = in.nextInt();
    			int b = in.nextInt();
    			times.add(new Point(a,b));
    		}
    		Collections.sort(times);
            for(int k = 0; k < times.size(); k++){
                if(k == 0){
                    out+="C";
                    cTasks.add(times.get(k).getB());
                }
                else if(times.get(k).getA()>cTasks.get(cTasks.size()-1)){
                    out+="C";
                    cTasks.add(times.get(k).getB());
                }
                else if(!out.contains("J")){
                    out+="J";
                    jTasks.add(times.get(k).getB());
                }
                else if(times.get(k).getA()>jTasks.get(jTasks.size()-1)){
                    out+="J";
                    jTasks.add(times.get(k).getB());
                }
                else{
                    out = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + out);
        }
    }
}