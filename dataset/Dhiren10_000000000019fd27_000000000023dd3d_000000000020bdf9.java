import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String args[]) {
      FastReader sc = new FastReader();
      int t = sc.nextInt();
      int test=0;
      while(t-->0){
          test++;
          int n = sc.nextInt();
          Pair arr[] = new Pair[n];
          Pair dup[] = new Pair[n];
          for(int i=0;i<n;i++){
             int s = sc.nextInt();
             int e = sc.nextInt();
             arr[i] = new Pair(s,e);
             dup[i] = new Pair(s,e);
          }
          Arrays.sort(arr,new Comparator<Pair>(){
             @Override
             public int compare(Pair p1, Pair p2){
                 if(p1.start != p2.start){
                     return p1.start-p2.start;
                 }
                 return p1.end-p2.end;
             }
          });
          
          int flag=0;
          HashMap<Pair,Character> hs = new HashMap<>();
          int maxC = arr[0].end;
          int maxJ = arr[1].end;
          hs.put(new Pair(arr[0].start,arr[0].end),'C');
          hs.put(new Pair(arr[1].start,arr[1].end),'J');
          for(int i=2;i<n;i++){
              int st = arr[i].start;
              int en = arr[i].end;
              if(st<maxC && st<maxJ){
                  flag=1;
                  break;
              }
              else if(st>=maxC){
                  hs.put(new Pair(st,en),'C');
                  maxC = Math.max(maxC,en);
              }
              else if(st>=maxJ){
                  hs.put(new Pair(st,en),'J');
                  maxJ = Math.max(maxJ,en);
              }
          }
          String s = "";
          if(flag==1){
              s = "IMPOSSIBLE";
          }
          else{
              for(int i=0;i<n;i++){
                  Pair p = dup[i];
                  s += ""+ hs.get(new Pair(p.start,p.end));
              }
          }
          System.out.println("Case #"+test+": "+s);
      }
    }
}
class Pair{
    int start;
    int end;
    Pair(int s, int e){
        start=s;
        end=e;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair key = (Pair) o;
        return start == key.start && end == key.end;
    }
    @Override
    public int hashCode() {
        int result = start;
        result = 31*result + end;
        return result;
    }
}

class FastReader 
	{ 
		BufferedReader br; 
		StringTokenizer st; 
 
		public FastReader() 
		{ 
			br = new BufferedReader(new
					InputStreamReader(System.in)); 
		} 
 
		String next() 
		{ 
			while (st == null || !st.hasMoreElements()) 
			{ 
				try
				{ 
					st = new StringTokenizer(br.readLine()); 
				} 
				catch (IOException e) 
				{ 
					e.printStackTrace(); 
				} 
			} 
			return st.nextToken(); 
		} 
 
		int nextInt() 
		{ 
			return Integer.parseInt(next()); 
		} 
 
		long nextLong() 
		{ 
			return Long.parseLong(next()); 
		} 
 
		double nextDouble() 
		{ 
			return Double.parseDouble(next()); 
		} 
 
		String nextLine() 
		{ 
			String str = ""; 
			try
			{ 
				str = br.readLine(); 
			} 
			catch (IOException e) 
			{ 
				e.printStackTrace(); 
			} 
			return str; 
		} 
	}

	 	 