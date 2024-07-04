import java.util.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedOutputStream;

public class Solution{

    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
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
    // public static PrintWriter out;
    // public static void printArr(int[] arr){
    //     for(int i = 0;i<arr.length;i++){
    //         out.print(arr[i] + " ");
    //     }
    //     out.println();
    // }
    public static class Pair implements Comparable<Pair>{
        int start;
        int end;

        public int compareTo(Pair p){
            if(this.start>p.start){
                return 1;
            }else{
                return -1;
            }
        }
    }
    public static void main(String[] args){
        FastReader s = new FastReader();
        // out=new PrintWriter (new BufferedOutputStream(System.out));
        int t = s.nextInt();
        for(int u = 1;u<=t;u++){
            int n = s.nextInt();
            HashMap<Pair, Character> map = new HashMap<>();
            ArrayList<Pair> list = new ArrayList<>();
            ArrayList<Pair> ques = new ArrayList<>();
            for(int i = 0;i<n;i++){
                Pair np = new Pair();
                np.start = s.nextInt();
                np.end = s.nextInt();
                list.add(np);
                ques.add(np);
            }
            Collections.sort(list);
            int j = list.get(0).end;
            int c = list.get(1).end;
            map.put(list.get(0), 'J');
            map.put(list.get(1), 'C');
            Boolean ok = true;
            for(int i = 2;i<list.size();i++){
                Pair curr = list.get(i);
                if(curr.start>=j){
                    j = curr.end;
                    map.put(curr, 'J');
                    continue;
                }else if(curr.start>=c){
                    c = curr.end;
                    map.put(curr, 'C');
                    continue;
                }else{
                    ok = false;
                    break;
                }
            }
            if(!ok){
                System.out.println("Case #" + u + ": " + "IMPOSSIBLE");
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<ques.size();i++){
                Pair curr = ques.get(i);
                sb.append(map.get(curr));
            }
            System.out.println("Case #" + u + ": " + sb.toString());
        }
        // out.close();
    }

}