import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int tc=1;tc<=t;tc++){
            int n=in.nextInt();
            int a[][]=new int[n][2];
            for(int i=0;i<n;i++){
                a[i][0]=in.nextInt();
                a[i][1]=in.nextInt();
            }
            String s=new String();
            s=s+'j';
            int count=0;
            for(int i=1;i<n;i++){
                if(a[i][0]<a[i-1][1]){
                    if(s.charAt(s.length()-1)=='c'){
                        s=s+'j';
                    }
                    else{
                        s=s+'c';
                    }
                    count++;
                }
                else{
                    s=s+s.charAt(s.length()-1);
                }
            }
            if(s.isEmpty()|| count==n-1){
                s="IMPOSSIBLE";
            }
            System.out.println("Case #"+tc+": "+s);
        }
    }
}