import java.util.*;
class Solution{
    public static void main(String as[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int ts[][]=new int[n][2];
            int m[]=new int[2];
            int m1[]=new int[2];
            //int c=0,jj=0; // state of both people
            for(int j=0;j<n;j++){
                ts[j][0]=sc.nextInt();
                ts[j][1]=sc.nextInt();
            }
            String fs="";
            m[0]=ts[0][1];
            m1[0]=ts[0][0];
            fs="C";
            for(int j=1;j<n;j++){
               if(j==1){
                   if(ts[j][0]<ts[j-1][1]){
                        m[1]=ts[j][1];
                        m1[1]=ts[j][0];
                        fs+="J";
                    }else{
                        fs+="C";
                    }
                }else{
                    if(ts[j][0]>=m[1]){
                        fs+="J";
                        m[1]=ts[j][1];
                    }else if(ts[j][0]>=m[0]){
                        fs+="C";
                        m[0]=ts[j][1];
                    }else{
                        if(ts[j][0]<m1[0]){
                            fs+="C";
                            m1[0]=ts[j][0];
                            //m[0]=ts[j][1];
                        }else if(ts[j][0]<m1[1]){
                            fs+="J";
                            m1[1]=ts[j][0];
                            //m[1]=ts[j][1];
                        }else{
                            fs="IMPOSSIBLE";
                            break;
                        }
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+fs);
        }
    }
}