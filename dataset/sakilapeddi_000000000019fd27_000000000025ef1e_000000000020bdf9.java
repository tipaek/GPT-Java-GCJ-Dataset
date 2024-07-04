import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int l=0;l<t;l++){
            int n=sc.nextInt();
            int[][] a=new int[n][3];
            for(int i=0;i<n;i++){
                a[i][0]=sc.nextInt();
                a[i][1]=sc.nextInt();
                a[i][2]=i;
            }
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(a[i][0]>a[j][0]){
                        int t1=a[i][0],t2=a[i][1],t3=a[i][2];
                        a[i][0]=a[j][0];a[i][1]=a[j][1];a[i][2]=a[j][2];
                        a[j][0]=t1;a[j][1]=t2;a[j][2]=t3;
                    }
                }
            }
           // System.out.println(Arrays.toString(a));
            int st1=0,et1=0,st2=0,et2=0;
            String[] ans=new String[n];
            int flag=0;
            for(int i=0;i<n;i++){
                int s=a[i][0],e=a[i][1];
                if(s>=et1){
                    ans[a[i][2]]="C";
                    et1=e;
                }
                
                else if(s>=et2){
                    //ans+="J";
                    ans[a[i][2]]="J";
                    et2=e;
                }
                
                else{
                    System.out.println("Case #"+(l+1)+": IMPOSSIBLE");
                    flag=1;
                }
            }
            if(flag==0) {
                String str="";
                for(int i=0;i<n;i++) str+=ans[i];
                System.out.println("Case #"+(l+1)+": "+str);
            }
        }
    }
}