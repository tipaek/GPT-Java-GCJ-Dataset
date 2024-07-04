import java.util.*;
public class Solution{
    public static ArrayList<String> ans;
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        for(int t=1;t<=test;t++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            ans=new ArrayList<String>();
            knowPath(x,y,"",0,0,1);
            Collections.sort(ans,new Comparator<String>(){
                public int compare(String a,String b){
                    return a.length()-b.length();
                }
            });
            if(ans.size()==0){
                System.out.println("Case #"+t+": IMPOSSIBLE");
            }else{
                System.out.println("Case #"+t+": "+ans.get(0));
            }
        }
    }
    public static void knowPath(int x,int y,String s, int cx,int cy, int step){
        if(step>=10)
        return;
        if(cx==x&&cy==y){
            ans.add(s);
            return;
        }
        int dr[]={1,-1,0,0};
        int dc[]={0,0,1,-1};
        for(int i=0;i<4;i++){
            int dist=(int)Math.pow(2,step-1);

            if(dr[i]==1&&dc[i]==0){
                knowPath(x,y,s+"E",cx+dist,cy,step+1);
            }
            if(dr[i]==-1&&dc[i]==0){
                knowPath(x,y,s+"W",cx-dist,cy,step+1);
            }
            if(dr[i]==0&&dc[i]==1){
                knowPath(x,y,s+"N",cx,cy+dist,step+1);
            }
            if(dr[i]==0&&dc[i]==-1){
                knowPath(x,y,s+"S",cx,cy-dist,step+1);
            }
        }
    }
}