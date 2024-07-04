import java.util.*;
public class Solution
{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t,z=1,r,p,q,f;
        t=sc.nextInt();
        int n,i,j;
        while(z<=t){
            n=sc.nextInt();
            int s[]=new int[n];
            int d[]=new int[n];
            int sd[]=new int[n];
            int dd[]=new int[n];
            char re[]=new char[n];
            for (i=0;i<n;i++){
                s[i]=sc.nextInt();
                sd[i]=s[i];
                d[i]=sc.nextInt();
                dd[i]=d[i];
            }
            for (i=0;i<n;i++){
                for (j=i+1;j<n;j++){
                    if (sd[j]<sd[i]){
                        r=sd[j];
                        sd[j]=sd[i];
                        sd[i]=r;
                        r=d[j];
                        d[j]=d[i];
                        d[i]=r;
                    }
                }
            }
            
            p=0;
            re[0]='C';
            if (sd[1]>=d[0])
                {
                    re[1]='C';
                    p=1;
                    q=-1;
                }
            else
            {
            re[1]='J';
                q=1;
            }
            f=0;
            for (i=2;i<n;i++){
                if (sd[i]>=d[p]){
                    p=i;
                re[i]='C';
                }
                else if ((q==-1)||(sd[i]>=d[q])){
                        q=i;
                        re[i]='J';
                }
                else {
                    f=1;
                    break;
                }
            }
            if (f==1){
                System.out.println("Case #"+z+": IMPOSSIBLE");
            }
            else{
                System.out.print("Case #"+z+": ");
                for (i=0;i<n;i++){
                    for (j=0;j<n;j++){
                        if ((s[i]==sd[j])&&(dd[i]==d[j]))
                            System.out.print(re[j]);
                    }
                }
                
                System.out.println();
            }
            
        
            
            z++;
        }
    }
}