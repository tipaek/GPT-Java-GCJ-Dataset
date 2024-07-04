import java.util.*;
public class Solution{
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        int t =s.nextInt();
        for(int i=1; i<=t; i++){
            int n = s.nextInt();
            String ans = "";int cl=0;int jl=0;int flas=0;
            int smalC=Integer.MAX_VALUE;
            int smalJ=Integer.MAX_VALUE;
            for(int j=0; j<n; j++){
                int st=s.nextInt();
                int e= s.nextInt();
                if(st>=cl){
                    cl=e;
                    ans += "C";
                    if(st<smalC)
                        smalC=st;
                }else if(st>=jl){
                    jl=e;
                    ans += "J";
                    if(st<smalJ){
                        smalJ=st;
                    }
                }else if(st<cl && st<jl){
                    if(st<smalC && e<=smalC){
                        ans += "C";
                        smalC=st;
                    }else if(st<smalJ && e<=smalJ){
                        ans += "J";
                        smalJ=st;
                    }else{
                        ans="IMPOSSIBLE";
                        flas=1;
                    
                    }
                }
            }
            if (flas==1){
                ans = "IMPOSSIBLE";
            }
            System.out.println("Case #"+i+ ": "+ans);

        }

    }
}