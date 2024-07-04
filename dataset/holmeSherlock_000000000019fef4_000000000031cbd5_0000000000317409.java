import java.io.*;
import java.util.*;
class Solution{
    public static void main(String args[]){
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int ct=1;
        while(ct<=t){
            int x=sc.nextInt();
            int y=sc.nextInt();
            char arr[]=sc.nextLine().trim().toCharArray();
            int[] pathx=new int[arr.length+1];
            int[] pathy=new int[arr.length+1];
            pathx[0]=x;
            pathy[0]=y;
            int i=1;
            for(char c:arr){
                switch(c){
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
                pathx[i]=x;
                pathy[i]=y;
                i++;
            }
            int cattime[]=new int[arr.length+1];
            int mytime[]=new int[arr.length+1];
            for(i=0;i<arr.length+1;i++){
                cattime[i]=i;
                int xdist=Math.abs(pathx[i]);
                int ydist=Math.abs(pathy[i]);
                mytime[i]=xdist+ydist;
            }
            int min=Integer.MAX_VALUE;
            for(i=0;i<arr.length+1;i++){
                if(mytime[i]<=cattime[i] && cattime[i]<min)
                    min=cattime[i];
            }
            if(min==Integer.MAX_VALUE)
                System.out.println("Case #" + ct + ": IMPOSSIBLE");
            else
                System.out.println("Case #" + ct + ": "+min);
            ct++;
        }
    }
}