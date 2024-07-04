import java.io.*;
import java.util.*;
class Solution{
    public static void main(String args[]){
        FastReader sc=new FastReader();
        int t=sc.nextInt();
        int val = t;
        while(t-->0){
            int n = sc.nextInt();
            int[] arr = new int[(n*2)];
            for(int i = 0; i < arr.length;i++){
                arr[i] = sc.nextInt();
            }
            int count = 0;
            boolean check = false;
            TreeMap<Integer,ArrayList<Integer>> tm = new TreeMap<>();
            StringBuffer sb = new StringBuffer();
            for(int i = 0;i<arr.length;i++){
                if(!tm.containsKey(arr[i]))
                    tm.put(arr[i],new ArrayList<Integer>());
                if(i%2 == 0)
                    tm.get(arr[i]).add(1);
                else
                    tm.get(arr[i]).add(2);
            }
            for(int key: tm.keySet()){
                if(tm.get(key).size() == 1){
                    if(tm.get(key).get(0) == 1){
                        count++;
                        if(count == 1)
                            sb.append("C");
                        else if(count == 2)
                            sb.append("J");
                        else if(count >= 3){
                            check = true;
                            break;
                        }
                    }
                    else{
                        count--;
                    }
                }
                else{
                    if(count != 0){
                        if(tm.get(key).indexOf(2) != -1){
                            tm.get(key).remove(new Integer(2));
                            count--;
                        }
                        else{
                            count++;
                            tm.get(key).remove(new Integer(1));
                            if(count == 1)
                                sb.append("C");
                            else if(count == 2)
                                sb.append("J");
                            else if(count >= 3){
                                check = true;
                                break;
                            }
                        }
                    }
                }
            }
            while(count < 0){
                sb.append("C");
                count++;
            }
            if(check == true){
                System.out.println("Case #"+(val-t)+": IMPOSSIBLE");
            }
            else{
                System.out.println("Case #"+(val-t)+": "+sb.toString());
            }
        }
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