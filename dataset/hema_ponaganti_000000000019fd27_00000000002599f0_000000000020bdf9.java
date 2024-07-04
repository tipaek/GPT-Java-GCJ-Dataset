import java.util.*;
class Solution{
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int t1=t;
        while(t!=0){
            int n=sc.nextInt();
            int[] l=new int[n];
            int[] r=new int[n];
            int[] ts=new int[n];
            for(int i=0;i<ts.length;i++)
                ts[i]=i;
            for(int i=0;i<n;i++){
                l[i]=sc.nextInt();
                r[i]=sc.nextInt();
            }
            for(int i=0;i<l.length-1;i++)
            {
                int min=i;
                for(int j=i+1;j<l.length;j++)
                    if(l[j]<l[min])
                        min=j;
                int tp=l[min];
                l[min]=l[i];
                l[i]=tp;
                tp=r[min];
                r[min]=r[i];
                r[i]=tp;
                tp=ts[min];
                ts[min]=ts[i];
                ts[i]=tp;

            }
            int fg=0;
            int[] work=new int[2];
            String s="";
            work[0]=work[1]=0;
            for(int i=0;i<n;i++){
                if(l[i]>=work[0]){
                    work[0]=r[i];
                    s=s+"C";
                }
                else if(l[i]>=work[1]){
                    work[1]=r[i];
                    s=s+"J";
                }
                else{
                    fg=1;
                    s="IMPOSSIBLE";
                    break;
                }

            }
            if(fg!=1){
                char[] ch=new char[s.length()];
                for(int i=0;i<s.length();i++)
                    ch[i]=s.charAt(i);
                for(int i=0;i<l.length-1;i++)
                {
                    int min=i;
                    for(int j=i+1;j<l.length;j++)
                        if(ts[j]<ts[min])
                            min=j;
                    int tp=ts[min];
                    ts[min]=ts[i];
                    ts[i]=tp;
                    char c=ch[min];
                    ch[min]=ch[i];
                    ch[i]=c;
                }
                s=String.valueOf(ch);
            }

            System.out.println("Case #"+(t1-t+1)+": "+s);
            t--;
        }
    }
}