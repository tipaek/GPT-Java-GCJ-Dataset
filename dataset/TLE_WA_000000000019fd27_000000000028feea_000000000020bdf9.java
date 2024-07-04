import java.util.*;
import java.io.*;
import java.math.*;

class intervals{
    
    public static void main(String args[])
    {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int t,k,i,n,left,right;
        t=sc.nextInt();
        for(k=1;k<=t;k++)
        {
            n=sc.nextInt();
            pair a[]=new pair[n];
            int ans[]=new int[n];
            ArrayList<tuples> p=new ArrayList<tuples>();
            for(i=0;i<n;i++){
                left=sc.nextInt();
                right=sc.nextInt();
                a[i]=new pair(left,right);
                p.add(new tuples(left,i,true));
                p.add(new tuples(right,i,false));
            }
            Collections.sort(p,new Comparator<tuples>(){
                @Override
                public int compare(tuples a, tuples b){
                    if(a.s==b.s){
                        if(a.b==b.b)
                            return a.ind-b.ind;
                        return ((a.b?1:0)-(b.b?1:0));
                    }
                    return a.s-b.s;
                }
            });
            int count=0;
            boolean c=true,j=true;
            int ec=0,ej=0;
            int flag=0;
            for(i=0;i<p.size();i++){
                tuples tups=p.get(i);
                if(tups.s>=ec)
                    c=true;
                if(tups.s>=ej)
                    j=true;
                if(tups.b)
                    count++;
                else 
                    count--;
                if(count<=2 && tups.b){
                    if(c){
                        ans[tups.ind]=1;
                        ec=a[tups.ind].e;
                        c=false;
                    }
                    else if(j){
                        ans[tups.ind]=2;
                        ej=a[tups.ind].e;
                        j=false;
                    }
                }       
                else if(count>2){
                    flag=1;
                    break;
                }
            }
            if(flag==1){
                sb.append("Case #"+k+": IMPOSSIBLE\n");
                continue;
            }
            StringBuilder str=new StringBuilder();
            for(i=0;i<n;i++)
                str.append(ans[i]==1?'C':'J');
            sb.append("Case #"+k+": "+str+"\n");
        }
        sb.deleteCharAt(sb.length()-1);
        out.println(sb);
        out.flush();
    }
    static class pair{
        int s,e;
        public pair(int x,int y){
            s=x;
            e=y;
        }
    }
    static class tuples{
        int s,ind;
        boolean b;
        public tuples(int x,int y,boolean z){
            s=x;
            ind=y;
            b=z;
        }
    }
    static PrintWriter out;
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
            out=new PrintWriter(System.out);
        }
        String next(){
            while(st==null || !st.hasMoreElements()){
                try{
                    st= new StringTokenizer(br.readLine());
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str = "";
            try{
                str=br.readLine();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}