import java.util.*;
class Solution{
    static class pair{
        int first;
        int second;
        pair(int f,int s){
            this.first=f;
            this.second=s;
        }
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        for(int k=1;k<=t;++k){
            int n=sc.nextInt();
            pair[] p=new pair[n];
            for(int i=0;i<n;++i){
                int f=sc.nextInt();
                int s=sc.nextInt();
                p[i]=new pair(f,s);
            }
            Arrays.sort(p, new Comparator<pair>(){
                public int compare (pair p1, pair p2){
                    return p1.first-p2.first;
                }
            });
                String ans="";
                int flag=0;
                int startc=-1,startj=-1;
                for(int i=0;i<n;++i){
                    if(startc<=p[i].first){
                        ans+="C";
                        startc=p[i].second;
                    }
                    else if(startj<=p[i].first){
                        ans+="J";
                        startj=p[i].second;
                    }
                    else {
                        flag=1;
                        break;
                    }
                }
                System.out.print("Case #"+k+": ");
                if(flag==1){
                    System.out.println("IMPOSSIBLE");
                }
                else {
                    System.out.println(ans);
                }        
        }
    }
}