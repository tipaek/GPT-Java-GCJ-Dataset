import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Arrays.*;

public class Solution {

    public static void main(String[] args) {
        new Solution().haha();
    }

    public void haha() {
        BufferedReader in = null;

        try{
            //in = new BufferedReader(new FileReader("xxx.txt"));
            in = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(in.readLine());
            for(int i=0;i<T;i++){
                System.out.print("Case #"+(i+1)+":");
                int N = Integer.parseInt(in.readLine());
                int[] ss = new int[N];
                int[] ee = new int[N];
                String[] line;
                StringBuffer sb = new StringBuffer();
                for(int a=0;a<N;a++){
                    line = in.readLine().split(" ");
                    ss[a] = Integer.parseInt(line[0]);
                    ee[a] = Integer.parseInt(line[1]);
                }
                LinkedList<PP> cc = new LinkedList<PP>();
                LinkedList<PP> jj = new LinkedList<PP>();
                for(int a=0;a<N;a++){
                    PP p = new PP(ss[a],ee[a]);
                    if(isOverlapping(cc,p)==false){
                        cc.add(p);
                        sb.append('C');
                    } else if(isOverlapping(jj,p)==false){
                        jj.add(p);
                        sb.append('J');
                    } else {
                        sb = new StringBuffer("IMPOSSIBLE");
                    }
                }
                System.out.print(" "+sb+"\n");
            }
            in.close();
        }catch(Exception e){
            e.printStackTrace();
            try{
                in.close();
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
        //System.out.print("Ha Ha :D\n");
    }
    
    boolean isOverlapping(LinkedList<PP> list, PP p){
        for(int i=0;i<list.size();i++){
            PP t = list.get(i);
            if(p.s>t.s && p.s<t.e) return true;
            if(p.e>t.s && p.e<t.e) return true;
        }
    
        return false;
    }
    class PP {
        int s;
        int e;
        public PP(int s, int e){
            this.s = s;
            this.e = e;
        }
    }
}