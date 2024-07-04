import java.io.*;
import java.util.*;
class Pair implements Comparable<Pair>
{
    int first;
    char second;
    Pair(int first,char second){
        this.first=first;
        this.second=second;
    }
    public int compareTo(Pair p){
        if(first==p.first){
            if(second==p.second) return 0;
            else if(second<p.second) return -1;
            else return 1;
        }
        else if(first<p.first) return -1;
        else return 1;
    }
}
public class Solution
{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int z=1;z<=t;z++){
            int n=sc.nextInt();
            ArrayList<Pair>st=new ArrayList<>();
            HashMap<Integer,Integer>hm=new HashMap<>();
            for(int i=1;i<=n;i++){
                int x=sc.nextInt();
                int y=sc.nextInt();
                st.add(new Pair(x,'s'));
                st.add(new Pair(y,'e'));
                hm.put(y,x);
            }
            Collections.sort(st);
            int c=0,cst=0,j=0,jst=0;
            String res="";
            for(Pair it:st){
                if(it.second=='s'){
                    if(c==0){
                        c=1;
                        cst=it.first;
                        res+="C";
                    }
                    else if(j==0){
                        j=1;
                        jst=it.first;
                        res+="J";
                    }
                    else{
                        res="IMPOSSIBLE";
                        break;
                    }
                }
                else{
                    if(c==1 && j==1){
                        int xx=hm.get(it.first);
                        if(cst==xx) --c;
                        else --j;
                    }
                    else if(c==1) c=0;
                    else j=0;
                }
            }
            System.out.print("Case #"+z+": "+res);
            System.out.println();
        }
    }   
}