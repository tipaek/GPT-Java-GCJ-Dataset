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
            for(int i=0;i<n;i++){
                l[i]=sc.nextInt();
                r[i]=sc.nextInt();
            }
            // for(int i:l)
            //     System.out.println(i);
            // for(int i:r)
            //     System.out.println(i);
            for(int i=0;i<l.length-1;i++)
            {
                int min=i;
                for(int j=i+1;j<l.length;j++)
                    if(l[j]<l[min])
                        min=j;
                int temp=l[min];
                l[min]=l[i];
                l[i]=temp;
                temp=r[min];
                r[min]=r[i];
                r[i]=temp;

            }
            int[] duty=new int[2];
            String s="";
            duty[0]=duty[1]=0;
            for(int i=0;i<n;i++){
                if(l[i]>=duty[0]){
                    duty[0]=r[i];
                    s=s+"C";
                }
                else if(l[i]>=duty[1]){
                    duty[1]=r[i];
                    s=s+"J";
                }
                else{
                    s="IMPOSSIBLE";
                    break;
                }

            }
            System.out.println("Case #"+(t1-t+1)+": "+s);
            t--;
        }
    }
}