import java.util.*;
public class Solution{
    public static void main(String []arg){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int a=1;a<=t;a++){
            int n=sc.nextInt();
            int [][]time_slot=new int[n][2];
            for(int i=0;i<n;i++){
                time_slot[i][0]=sc.nextInt();
                time_slot[i][1]=sc.nextInt();
            }
            Arrays.sort(time_slot,(p,q) -> Integer.compare(p[0],q[0]));
            boolean C_free=false,J_free=true;
            int busyC=time_slot[0][1],busyJ=-1;
            String ans="C";
            for(int i=1;i<n;i++){
                if(busyC<=time_slot[i][0]){
                    busyC=-1;
                    C_free=true;
                }
                if(busyJ<=time_slot[i][0]){
                    busyJ=-1;
                    J_free=true;
                }
                if(!C_free){
                    if(J_free){
                        if(busyC>time_slot[i][0]){
                            busyJ=time_slot[i][1];
                            ans+="J";
                            J_free=false;
                        }
                    }
                    else{
                        ans="IMPOSSIBLE";
                        break;
                    }
                }
                else{
                    ans+="C";
                }
            }
            System.out.println("Case #"+a+": "+ans);
        }
    }
}