import java.util.*;
public class Solution{
    static int directions[] = {0,0,0,1,1,0,0,-1,-1,0};
    public static int hasPath(String s,int cx,int cy,int x,int y,int index){
        if(index>=s.length()){
            if(cx==x&&cy==y){
                return 0;
            }
            return -1;
        }
        if(cx==x&&cy==y){
            return 0;
        }
        int dx = 0;
        int dy = 0;
        if(s.charAt(index)=='N'){
            dx = 0;
            dy = 1;
        }
        if(s.charAt(index)=='E'){
            dx = 1;
            dy = 0;
        }
        if(s.charAt(index)=='S'){
            dx = 0;
            dy = -1;
        }
        if(s.charAt(index)=='W'){
            dx = -1;
            dy = 0;
        }
        int ans = Integer.MAX_VALUE;
        int smallAns = -1;
        for(int i=0;i<=8;i+=2){
            smallAns = hasPath(s,cx+directions[i],cy+directions[i+1],x+dx,y+dy,index+1);
            if(smallAns!=-1){
                ans = Math.min(ans,1+smallAns);
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int t = 1;
        while(t<=T){
            int x = sc.nextInt();
            int y = sc.nextInt();
            String s = sc.next();
            int ans = hasPath(s,0,0,x,y,0);
            System.out.print("Case #"+t+": ");
            if(ans==-1){
                System.out.println("IMPOSSIBLE");
            }else{
                System.out.println(ans);
            }
            t++;
        }
    }
}