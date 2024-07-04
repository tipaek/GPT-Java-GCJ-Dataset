import java.util.*;
class Solution
{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int ta,z=1,r,p,q,f;
        ta=sc.nextInt();
        int n,i,j;
        while(z<=ta){
            n=sc.nextInt();
            int s[]=new int[n];
            int d[]=new int[n];
           int t[]=new int[n];
            char re[]=new char[n];
            for (i=0;i<n;i++)
                t[i]=i;
            for (i=0;i<n;i++){
                s[i]=sc.nextInt();
                
                d[i]=sc.nextInt();
            }
            for (i=0;i<n;i++){
                for (j=i+1;j<n;j++){
                    if (s[j]<s[i]){
                        r=s[j];
                        s[j]=s[i];
                        s[i]=r;
                        r=d[j];
                        d[j]=d[i];
                        d[i]=r;
                        r=t[j];
                        t[j]=t[i];
                        t[i]=r;
                        
                    }
                }
            }
            
            p=0;
            re[0]='C';
            if (s[1]>=d[0])
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
                if (s[i]>=d[p]){
                    p=i;
                re[i]='C';
                }
                else if ((q==-1)||(s[i]>=d[q])){
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
                    if (t[j]==i){
                       System.out.print(c[j]);
                    }
                }
            }
                
                System.out.println();
            }
            
        
            
            z++;
        }
    }
}