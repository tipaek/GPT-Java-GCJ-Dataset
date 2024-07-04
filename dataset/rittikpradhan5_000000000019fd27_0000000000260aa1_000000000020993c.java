import java.util.*;
class L {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt(),c=1;
        while(t>0) {
            int n=in.nextInt(),cr=0,cc=0,sum=0;
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    a[i][j]=in.nextInt();
                }
            }
            for(int i=0;i<n;i++) {
                int f[]=new int[n+5];
                for(int j=0;j<n;j++) {
                    if(f[a[i][j]]==0) f[a[i][j]]++;
                    else {
                        cr++;break ;
                    }
                }
            }
            for(int i=0;i<n;i++) {
                int f[]=new int[n+5];
                for(int j=0;j<n;j++) {
                    if(f[a[j][i]]==0) f[a[j][i]]++;
                    else {
                        cc++;break ;
                    }
                }
            }
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(i==j) sum+=a[i][j];
                }
            }
        System.out.println("Case #"+c+":"+" "+sum+" "+cr+" "+cc);  
        t--;
        c++;
        }
    }
}