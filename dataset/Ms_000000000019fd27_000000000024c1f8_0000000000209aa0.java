import java.util.*;
public class Solution{
public static int gcd(int n, int k){
            int num=1;
            for(int i=1;i<=n/2;i++){
                if(n%i==0 && k%i==0)
                    num=i;
            }
            return num;
        }
    public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    if(sc.hasNextInt()){
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int max = n*n;
            if(k>max || k<n){
                System.out.println("Case #"+"k"+": "+"IMPOSSIBLE");
                continue;
            }
            else if(k%n==0){
                System.out.println("Case #"+"k"+": "+"POSSIBLE");
                continue;
            }
            else if(gcd(k,n)>1){
                System.out.println("Case #"+"k"+": "+"POSSIBLE");
                continue;
            }
            else
                System.out.println("Case #"+"k"+": "+"IMPOSSIBLE");
        }
    }
}     

}