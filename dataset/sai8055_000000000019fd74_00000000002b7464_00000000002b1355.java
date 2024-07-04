import java.util.*;
class solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1;i<=t;i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a[][] = new int[n][m];
            for(int j = 0;j<n ;j++ ){
                for(int k =0;k<m ;k++)
                {
                    a[j][k] = sc.nextInt();
                }
            }
            int sum = 0;
            for(int j = 0;j<n ;j++ ){
                for(int k =0;k<m ;k++)
                {
                    sum +=a[j][k];
                }
            }
            int avg = 0;
            for(int j = 1;j<n-1 ;j++ ){
                for(int k =1;k<m-1 ;k++)
                {
                    if(i!=j)
                        avg +=a[j][k];
                }
            }
            if(avg/n > 1)
                sum += avg;
            System.out.println("Case #"+i+": "+sum);
        }
        
    }
}