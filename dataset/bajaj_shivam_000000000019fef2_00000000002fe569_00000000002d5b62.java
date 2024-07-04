import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
class Pairs {
    long first;
    long second;
    Pairs(long first,long second){
        this.first=first;
        this.second=second;
    }
}

public class Solution {
    public static  long max= (long) Math.pow(10,2);
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        long start=1;
        HashMap<Pairs,String> map=new HashMap<>();
        ArrayList<Pairs> l=new ArrayList<>();
        Pairs p=new Pairs(0,0);
        String sb=new String("");
        map.put(p,sb);
        l.add(p);
        boolean vis[][]=new boolean[1000][1000];
        String ans[][]=new String[1000][1000];
        vis[0][0]=true;
        while (start<=20){
            ArrayList<Pairs> temp=new ArrayList<>();
            for(Pairs pair:l){
                long x=pair.first;
                long y=pair.second;
                String s=map.get(pair);

                //left
                long xl=x-start;
                long yl=y;
                String sbl=s+"W";
                Pairs pl=new Pairs(xl,yl);
                //map.put(pl,sbl);
                //temp.add(pl);
                if(!vis[(int) (xl+100)][(int) (yl+100)]){
                    map.put(pl,sbl);
                    temp.add(pl);
                    vis[(int) (xl+100)][(int) (yl+100)]=true;
                    ans[(int) (xl+100)][(int) (yl+100)]=sbl;
                }

                //right

                long xr=x+start;
                long yr=y;
                String sbr=s+"E";
                Pairs pr=new Pairs(xr,yr);
                //map.put(pr,sbr);
                //temp.add(pr);
                if(!vis[(int) (xr+100)][(int) (yr+100)]){
                    map.put(pr,sbr);
                    temp.add(pr);
                    vis[(int) (xr+100)][(int) (yr+100)]=true;
                    ans[(int) (xr+100)][(int) (yr+100)]=sbr;
                }
                //top

                long xt=x;
                long yt=y+start;
                String sbt=s+"N";
                Pairs pt=new Pairs(xt,yt);
                //map.put(pt,sbt);
                //temp.add(pt);
                if(!vis[(int) (xt+100)][(int) (yt+100)]){
                    map.put(pt,sbt);
                    temp.add(pt);
                    vis[(int) (xt+100)][(int) (yt+100)]=true;
                    ans[(int) (xt+100)][(int) (yt+100)]=sbt;
                }
                //down

                long xd=x;
                long yd=y-start;
                String sbd=s+"S";
                Pairs pd=new Pairs(xd,yd);
                //map.put(pd,sbd);
                //temp.add(pd);
                if(!vis[(int) (xd+100)][(int) (yd+100)]){
                    map.put(pd,sbd);
                    temp.add(pd);
                    vis[(int) (xd+100)][(int) (yd+100)]=true;
                    ans[(int) (xd+100)][(int) (yd+100)]=sbd;
                }
            }
            l.clear();
            l.addAll(temp);
            temp.clear();
            start=2*start;
        }
        /*for(Map.Entry<Pairs,String> entry:map.entrySet()){
            Pairs pp=entry.getKey();
            String b=entry.getValue();
            System.out.println(pp.first+" "+pp.second+" "+b);
        }*/

        int t=Integer.parseInt(br.readLine());
        for (int tt=1;tt<=t;tt++){
            String s[]=br.readLine().split(" ");
            int x=Integer.parseInt(s[0]);
            int y=Integer.parseInt(s[1]);
            if(vis[x+100][y+100]){
                String ss=ans[x+100][y+100];
                System.out.println("Case #"+tt+": "+ss);
            }else{
                System.out.println("Case #"+tt+": "+"IMPOSSIBLE");
            }

        }
    }
}
