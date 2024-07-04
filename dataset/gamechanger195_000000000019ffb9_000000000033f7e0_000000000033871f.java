import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class Solution {
    static int n,m,tte;
    static int val[];
    static ArrayList<Node> graph[];
    static int edge[][];
    static int time[];
    public static void main(String args[]) throws IOException {
        FastReader in = new FastReader(System.in);
        StringBuilder sb = new StringBuilder();
        int i, j;
        int t0 = 0;
        int t = in.nextInt();
        while (t0++ < t) {
            n=in.nextInt();
            m=in.nextInt();
            val=new int[n+1];
            edge=new int[m][2];
            for(i=2;i<=n;i++)
                val[i]=in.nextInt()*-1;
            graph=new ArrayList[n+1];
            for(i=1;i<=n;i++){
                graph[i]=new ArrayList<>();
            }
            time=new int[n+1];
            int edtime[]=new int[m];
            int nodind[]=new int[n+1];
            int par[]=new int[n+1];
            boolean visited[]=new boolean[n+1];
            time[1]=0;
            for(i=0;i<m;i++){
                int x=in.nextInt();
                int y=in.nextInt();
                edge[i][0]=x;
                edge[i][1]=y;
                graph[x].add(new Node(y,i));
                graph[y].add(new Node(x,i));
            }
            tte=0;
            HashSet<Integer> list=new HashSet<>();
            visited[1]=true;
            for(Node z:graph[1]){
                visited[z.v]=true;
                list.add(z.v);
                nodind[z.v]=z.ind;
                par[z.v]=1;
            }
            int before=1;
            //System.out.println(list);
            while(true){
                HashSet<Integer> nlist=new HashSet<>();
                //System.out.println(list+" "+tte+" "+before);
                /*if(before==4)
                    break;*/
                int c=0;
                int f=0;
                for(int x:list){
                    if(val[x]==before){
                        f=1;
                        visited[x]=true;
                        edtime[nodind[x]]=tte-time[par[x]]+1;
                        time[x]=tte+1;
                        c++;
                        for(Node z:graph[x]){
                            if(!visited[z.v]) {
                                visited[z.v]=true;
                                nlist.add(z.v);
                                nodind[z.v] = z.ind;
                                par[z.v] = x;
                            }
                        }
                    }
                    else{
                        nlist.add(x);
                    }
                }
                if(f==0){
                    nlist=new HashSet<>();
                    int min=1000_000;
                    for(int x:list){
                        if(val[x]<0)
                            min=Math.min(min,val[x]*-1);
                    }
                    for(int x:list){
                        if(val[x]==min*-1){
                            visited[x]=true;
                            edtime[nodind[x]]=min-time[par[x]];
                            time[x]=min;
                            c++;
                            for(Node z:graph[x]){
                                if(!visited[z.v]) {
                                    visited[z.v]=true;
                                    nlist.add(z.v);
                                    nodind[z.v] = z.ind;
                                    par[z.v] = x;
                                }
                            }
                        }
                        else{
                            nlist.add(x);
                        }
                    }
                    tte=min;
                }
                if(f!=0)
                    tte++;
                before+=c;
                list=nlist;
                if(before>=n)
                    break;
            }
            for(i=0;i<m;i++){
                if(edtime[i]==0)
                    edtime[i]=1000_000;
            }


            sb.append("Case #" + t0 + ": ");
            for(i=0;i<m;i++)
                sb.append(edtime[i]).append(" ");
            sb.append("\n");
        }

        System.out.print(sb);


    }
}

class Node{
    int v,ind;
    public Node(int v,int ind){
        this.v=v;
        this.ind=ind;
    }
}

class FastReader {

    byte[] buf = new byte[2048];
    int index, total;
    InputStream in;

    FastReader(InputStream is) {
        in = is;
    }

    int scan() throws IOException {
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0) {
                return -1;
            }
        }
        return buf[index++];
    }

    String next() throws IOException {
        int c;
        for (c = scan(); c <= 32; c = scan()) ;
        StringBuilder sb = new StringBuilder();
        for (; c > 32; c = scan()) {
            sb.append((char) c);
        }
        return sb.toString();
    }

    int nextInt() throws IOException {
        int c, val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        for (; c >= '0' && c <= '9'; c = scan()) {
            val = (val << 3) + (val << 1) + (c & 15);
        }
        return neg ? -val : val;
    }

    long nextLong() throws IOException {
        int c;
        long val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        for (; c >= '0' && c <= '9'; c = scan()) {
            val = (val << 3) + (val << 1) + (c & 15);
        }
        return neg ? -val : val;
    }
}
