import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        int tc;
        tc=scan.nextInt();
        for(int iter=0;iter<tc;++iter){
            int xIn,yIn;
            xIn=scan.nextInt();
            yIn=scan.nextInt();
            int steps=99999,ans=99999;
            if(xIn ==0 && yIn==0){
                steps=0;
                ans=0;
            }
            char path[]=scan.nextLine().substring(1).toCharArray();
            int i=0;
            while(i<path.length){
                int xadd,yadd;
                if(path[i]=='E'){
                    xadd=1;yadd=0;
                }
                else if(path[i]=='W'){
                    xadd=-1;yadd=0;
                }
                else if(path[i]=='N'){
                    xadd=0;yadd=1;
                }
                else{
                    xadd=0;yadd=-1;
                }
                xIn+=xadd;
                yIn+=yadd;
                steps=Math.abs(xIn)+Math.abs(yIn);
                if(steps==i+1){
                    if(steps<ans)ans=steps;
                }
                else if(steps<(i+1)){
                    int var=Math.abs(i+1-steps);
                    steps=steps+(var/2)+(var%2);
                    if(steps<ans)ans=steps;
                }
                i++;
            }
            if(ans==99999)System.out.printf("Case #%d: IMPOSSIBLE\n",iter+1);
            else System.out.printf("Case #%d: %d\n",iter+1,ans);
        }
        
    }
}