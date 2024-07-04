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
                 return p1.start-p2.start;
             }
          });
          
          int flag=0;
          HashMap<Pair,Character> hs1 = new HashMap<>();
          HashMap<Pair,Character> hs2 = new HashMap<>();
          int maxC = arr[0].end;
          int maxJ = 0;
          hs1.put(new Pair(arr[0].start,arr[0].end),'C');
          for(int i=1;i<n;i++){
              int st = arr[i].start;
              int en = arr[i].end;
              if(maxC<=st && hs1.get(new Pair(st,en)) == null){
                  hs1.put(new Pair(st,en),'C');
                  maxC = en;
              }
              else if(maxJ<=st && hs2.get(new Pair(st,en)) == null){
                  hs2.put(new Pair(st,en),'J');
                  maxJ = en;
              }
              else{
                  flag=1;
                  break;
              }
          }
          StringBuilder sb = new StringBuilder();
          if(flag==1 || ((hs1.size()+hs2.size()) != n) ){
              sb.append("IMPOSSIBLE");
          }
          else{
              for(int i=0;i<n;i++){
                  Pair p = dup[i];
                  if(hs1.get(p) != null){
                      sb.append(hs1.get(new Pair(p.start,p.end)));
                      hs1.remove(p);
                  }
                  else{
                      sb.append(hs2.get(new Pair(p.start,p.end)));
                      hs2.remove(p);
                  }
              }
          }
          String s = sb.toString();
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

	 	 