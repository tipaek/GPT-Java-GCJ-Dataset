import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int x = 1; x<=T;x++){
            long L = sc.nextLong();
            long R = sc.nextLong();
            long l = L;
            long r = R;
            long m = 0;
            if(L>=R){
                m = (long) Math.max(0,Math.floor(Math.sqrt(2*(L-R)))-5);
                while(L-m*(m+1)/2 >=R) m++;
                m--;
                l-= m*(m+1)/2;
                
            }
            else if(L<R){
                m = (long) Math.max(0,Math.floor(Math.sqrt(2*(R-L)))-5);
                while(R-m*(m+1)/2 >L) m++;
                r-=m*(m+1)/2;
            }
            long n = m;
            long k = 0;
            //System.out.println(m+ " "+l+ " "+r);
            if(r>m || l>m){
            if(m%2 == 0){
                //laekkum l um oddatolur og r um slettar
                long i = m/2;
                k = (long) Math.max(0,Math.floor(Math.sqrt(l+i*i))-4);
                while(k*k-i*i<l) k++;
                k--;
                //System.out.println(k);
                l-= k*k-i*i;
                r -= 2*(k*(k+1)/2-i*(i+1)/2);
                
            }
            else if(m%2 == 1){
                //laekkum l um slettar og r um oddatolur
                k = (long) Math.max(0,Math.floor(Math.sqrt(r+(m/2+1)*(m/2+1)))-4);
                while(k*k-(m/2+1)*(m/2+1)<r ) k++;
                k--;
                //System.out.println(k);
                r-= k*k-(m/2+1)*(m/2+1);
                l-= 2*(k*(k+1)/2-m/2*(m/2+1)/2);
                
            }
            
            n = 2*k;
            }
            if(r<0){
                r+=n;
                n--;
                
            }
            if(l<0){
                l+=n;
                n--;
                
            }
            if(l>=n+1){
                n++;
                l-=n;
            }
            if(r>=n+1){
                n++;
                r-=n;
            }
            System.out.println("Case #"+x+": "+n+" "+l+" "+r);
        }
        
    }
}