import java.io.*;
import java.util.*;
class Solution{
    public static void main(String args[]){
        FastReader sc=new FastReader();
        int t=sc.nextInt();
        int val = t;
        while(t-->0){
            String s = sc.nextLine();
            Stack<Character> temp = new Stack<Character>();
            Deque<Character> view = new LinkedList<Character>();
            int ss = 0;
            int z =0,y = 0,yy=0,tempo=-1;
            int count = 0;
            while(ss != s.length()){
                if(temp.isEmpty())
                    temp.push(s.charAt(ss));
                else{
                    char c = temp.peek();
                    if(s.charAt(ss) == c)
                        temp.push(s.charAt(ss));
                    else{
                        y = ((int)temp.peek() - 48);
                        yy = ((int)s.charAt(ss) - 48);
                        tempo=y;
                        if(yy < y)
                            z = y-yy;
                        else
                            z = y;
                        if(count == 0 || count == (tempo-count)){
                            while(y != 0 && (tempo-count) != 0){
                                view.add('(');
                                count++;
                                y--;
                            }
                        }
                        while(!temp.isEmpty())
                            view.add(temp.pop());
                        while(z != 0 && count != 0 && yy < tempo ){
                            view.add(')');
                            count--;
                            z--;
                        }
                        temp.push(s.charAt(ss));
                    }
                }
                ss++;
            }
            if(count == 0)
                tempo = -1;
            StringBuffer sb = new StringBuffer();
            while(!view.isEmpty())
                sb.append(view.removeFirst());
            while(!temp.isEmpty()){
                if(temp.peek() != '0'){
                    y = ((int)temp.peek() - 48);
                    z = y;
                    if(count == 0 || count == tempo){
                        while(y != 0 && tempo != 0){
                            sb.append('(');
                            count++;
                            y--;
                            tempo--;
                        }
                    }
                    while(!temp.isEmpty())
                        sb.append(temp.pop());
                    while(z != 0 && count != 0){
                        sb.append(')');
                        count--;
                        z--;
                    }
                }
                else
                    sb.append(temp.pop());
            }
            System.out.println("Case #"+(val-t)+": "+sb.toString());
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