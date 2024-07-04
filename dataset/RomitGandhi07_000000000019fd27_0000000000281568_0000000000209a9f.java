import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int x=1;x<=t;++x){
            char[] c=sc.next().toCharArray();
            StringBuilder ans=new StringBuilder();
            int n=c.length,temp=0;
            for(int i=0;i<c[0]-'0';++i){
                ans.append("(");
            }
            ans.append(c[0]);
            for(int i=1;i<n;++i){
                if(c[i]<c[i-1]){
                    temp=c[i-1]-c[i];
                    for(int j=0;j<temp;++j){
                       ans.append(")");
                    }
                }
                else if(c[i]>c[i-1]){
                    temp=c[i]-c[i-1];
                    for(int j=0;j<temp;++j){
                        ans.append("(");
                    }
                }
                ans.append(c[i]);
            }
            for(int i=0;i<c[n-1]-'0';++i){
                ans.append(")");
            }
            System.out.println("Case #"+x+": "+ans);
        }
    }
}
        