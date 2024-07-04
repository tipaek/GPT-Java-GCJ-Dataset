import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner in= new Scanner(System.in);
        int t=in.nextInt();
        for(int x=1;x<=t;x++){
            int n=in.nextInt();
            int[] start=new int[n+1];
            int[] end=new int[n+1];
            for(int i = 0;i<n;i++){
                start[i]=in.nextInt();
                end[i]=in.nextInt();
            }
            int c1=0,c2=n;
            start[n]=-5;end[n]=-5;
            String y="C";
            // if(start[1]<end[0] && start[1]>start[0]){
            //     String y="CJ";
            // }
            // else{
            //     String y="CC";
            //     c1++;
            // }
            // if(n<3){
            //     System.out.println("Case #" + x + ": " + y);
            // }
            // 4 3 360 480 420 540 600 660 3 0 1440 1 3 2 4 5 99 150 1 100 100 301 2 5 150 250 2 0 720 720 1440
            for(int i=1;i<n;i++){
                if(start[i]>=end[c1] || end[i]<=start[c1]){
                    y+='C';
                    c1=i;
                }
                else if(start[i]>=end[c2] || end[i]<=start[c2]){
                    y+='J';
                    c2=i;
                }
                else{
                    y="IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #" + x + ": " + y);
        }
    }
}