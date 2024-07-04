import java.util.*;
import java.io.*;

public class Solution {
    static class Point implements Comparable<Point> {
        int a;
        int b;
		int c;
        public Point(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        public int getA(){
            return a;
        }
        public int getB(){
            return b;
        }
        public int getC(){
			return c;
		}
        @Override
        public int compareTo(Point o) {
            if(this.a == o.a) return this.b - o.b;
            return this.a - o.a;
        }

    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        String out = "";
        for (int i = 1; i <= t; i++) {
            int N = in.nextInt();
            out = "";
            char[] output = new char[N];
            int currC = 0;
            int currJ = 0;
            ArrayList<Point> times = new ArrayList<>();
            ArrayList<Integer> cTasks = new ArrayList<>();
            ArrayList<Integer> jTasks = new ArrayList<>();
    		for(int j = 0; j < N; j++){
    			int a = in.nextInt();
    			int b = in.nextInt();
    			times.add(new Point(a,b,j));
    		}
    		Collections.sort(times);
            for(int k = 0; k < times.size(); k++){
                if(k == 0){
                    output[times.get(k).getC()] = 'C';
                    currC = times.get(k).getB();
                }
                else if(times.get(k).getA() < currC){
					if(times.get(k).getA() < currJ){
						out = "IMPOSSIBLE";
						break;
					}
					else{
						output[times.get(k).getC()] = 'J';
						currJ = times.get(k).getB();
					}
                }
                else{
					output[times.get(k).getC()] = 'C';
					currC = times.get(k).getB();
				}
            }
            if(out == "IMPOSSIBLE")
            	System.out.println("Case #" + i + ": " + out);
            else{
				for(char c : output){
					out+=Character.toString(c);
				}
				System.out.println("Case #" + i + ": " + out);
			}
        }
    }
}