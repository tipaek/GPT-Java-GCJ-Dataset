import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int x=1;x<=t;++x){
            int n=sc.nextInt();
            int st=0,et=0;
            ArrayList<Demo> al=new ArrayList<Demo>();
            char[] ct=new char[n];
            for(int i=0;i<n;++i){
                st=sc.nextInt();
                et=sc.nextInt();
                al.add(new Demo(st,et,i));
            }
            Collections.sort(al,new sortByS());
            int curc=-1,curj=-1,temp=0;
            boolean flag=false;
            String ans="";
            for(int i=0;i<n;++i){
                temp=al.get(i).s;
                if(temp>=curc){
                    ct[al.get(i).i]='C';
                    curc=al.get(i).e;
                }
                else if(temp>=curj){
                    ct[al.get(i).i]='J';
                    curj=al.get(i).e;
                }
                else{
                    flag=true;
                    ans="IMPOSSIBLE";
                    break;
                }
            }
            if(!flag){
                ans=new String(ct);
            }
            System.out.println("Case #"+x+": "+ans);
        }
    }
}

class Demo{
    int s=0,e=0,i=-1;
    public Demo(int s,int e,int i){
        this.s=s;
        this.e=e;
        this.i=i;
    }
}

class sortByS implements Comparator<Demo>{
    public int compare(Demo a,Demo b){
        return a.s-b.s;
    }
}