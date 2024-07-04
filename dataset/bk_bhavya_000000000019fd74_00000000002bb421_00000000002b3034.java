import java.io.*;
import java.util.*;
import java.util.regex.*;
class Solution{
    public static void main(String args[]){
        FastReader sc=new FastReader();
        int t = sc.nextInt();
        int val = t;
        while(t-- != 0){
            int n = sc.nextInt();
            String[] arr = new String[n];
            ArrayList<String> ch = new ArrayList<>();
            ArrayList<Integer> in = new ArrayList<>();
            for(int i = 0; i < n;i++){
                arr[i] = sc.nextLine();
                ch.add(arr[i].replaceAll("\\*",""));
                
            }
            int max = 0;
            String m =ch.get(0);
            for(int i = 0; i < n;i++){
                if(ch.get(i).length() > max){
                    max = ch.get(i).length();
                    m = ch.get(i);
                }
            }
            boolean an = false;
            for(int i = 0; i < n;i++){
                StringBuffer sb = new StringBuffer();
                int j = 0;
                if(!ch.get(i).equals(m)){
                    while(j != arr[i].length()){
                        if(arr[i].charAt(j) == '*')
                            sb.append("[A-Z]+");
                        else
                            sb.append(arr[i].charAt(j));
                        j++;
                    }
                }
                Pattern p = Pattern.compile(sb.toString());
                Matcher mat = p.matcher(m);
                if(mat.find())
                    an = true;
                else{
                    an = false;
                    break;
                }
            }
            if(an == false)
                System.out.println("Case #"+(val-t)+": *");
            else
                System.out.println("Case #"+(val-t)+": "+m);
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