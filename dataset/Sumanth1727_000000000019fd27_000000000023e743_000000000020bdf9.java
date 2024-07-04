import java.util.*;
class Solution
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
            char re[]=new char[n];
            for (i=0;i<n;i++){
                s[i]=sc.nextInt();
                sd[i]=s[i];
                d[i]=sc.nextInt();
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
            q=1;
            re[1]='J';
            f=0;
            for (i=2;i<n;i++){
                if (sd[i]>=d[p]){
                    p=i;
                re[i]='C';
                }
                else if (sd[i]>=d[q]){
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
                        if (s[i]==sd[j])
                            System.out.print(re[j]);
                    }
                }
                
                System.out.println();
            }
            
        
            
            z++;
        }
    }
}