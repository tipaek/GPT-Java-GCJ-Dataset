import java.util.*;
import java.io.*;
import java.lang.*;

class intervals{

public static void main(String args[]){
       
        int t,k,i;
        int n;
        int left,right;
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        for(k=1;k<=t;k++){
            n=sc.nextInt();
            pair a[]=new pair[n];
            int ans[]=new int[n];
            ArrayList<triple> interval=new ArrayList<triple>();
            for(i=0;i<n;i++){
                left=sc.nextInt();
                right=sc.nextInt();
                a[i]=new pair(left,right);
                interval.add(new triple(left,i,true));
                interval.add(new triple(right,i,false));
            }
            Collections.sort(interval,new Comparator<triple>(){
                @Override
                public int compare(triple a, triple b){
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
            for(i=0;i<interval.size();i++){
                triple v=interval.get(i);
                if(v.s>=ec)
                    c=true;
                if(v.s>=ej)
                    j=true;
                if(v.b)
                    count++;
                else 
                    count--;
                if(count<=2 && v.b){
                    if(c){
                        ans[v.ind]=1;
                        ec=a[v.ind].e;
                        c=false;
                    }
                    else if(j){
                        ans[v.ind]=2;
                        ej=a[v.ind].e;
                        j=false;
                    }
                }       
                else if(count>2){
                    flag=1;
                    break;
                }
            }
            if(flag==1){
                System.out.print("Case #"+k+": IMPOSSIBLE\n");
                continue;
            }
            StringBuilder str=new StringBuilder();
            for(i=0;i<n;i++)
                str.append(ans[i]==1?'C':'J');
            System.out.print("Case #"+k+": "+str+"\n");
        }
        System.out.flush();
    }
    static class pair{
        int s,e;
        public pair(int x,int y){
            s=x;
            e=y;
        }
    }
    static class triple{
        int s,ind;
        boolean b;
        public triple(int x,int y,boolean z){
            s=x;
            ind=y;
            b=z;
        }
    }
}
