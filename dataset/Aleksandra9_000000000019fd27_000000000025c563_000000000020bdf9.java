import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


class Pair implements Comparable<Pair> {
    final int a;
    final int b;
    final int el;

    public Pair(int a, int b, int el){
        this.a = a;
        this.b = b;
        this.el = el;
    }

	@Override
	public int compareTo(Pair arg0) {
		int res = Integer.compare(this.a, arg0.a);
	      if (res == 0)
	        res = Integer.compare(this.b, arg0.b);
	      return res;
	}
}

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for(int t=1; t<=tests; t++) {
        	 int N = in.nextInt();
        	 Pair[] pairs = new Pair[N];
        	 for(int i=0;i<N;i++) {
        		 pairs[i] = new Pair(in.nextInt(), in.nextInt(), i);
        	 }
        	 Arrays.sort(pairs);
        	 char[] result = new char[N];
        	 boolean immpossible = false;
        	 int cam =0;
        	 int jac =0;
        	 for(int i=0;i<N;i++) {
        		 if(pairs[i].a >= cam) {
        			 result[pairs[i].el] = 'C';
        			 cam = pairs[i].b;
        		 }
        		 else if(pairs[i].a >= jac) {
        			 result[pairs[i].el] = 'J';
        			 jac = pairs[i].b;
        		 } else {
        			 immpossible = true;
        			 break;
        		 }
        	 }
        		 
        	 if(immpossible)
        		 System.out.println("Case #"+t+": IMPOSSIBLE");
        	 else {
        		 System.out.print("Case #"+t+": ");
        		 for(int i=0; i<N; i++) {
        			 System.out.print(result[i]);
        		 }
        		 System.out.println();
        	 }
      }
	}
}