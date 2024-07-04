import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class Solution {
    static long binary(long key){
        long l=1,r=2000_000_004;
        while(l<=r){
            if(l==r)
                return l;
            if(l+1==r){
                if(l*(l+1)/2>=key)
                    return l;
                return r;
            }
            long mid=(l+r)/2;
            if(mid*(mid+1)/2>=key)
                r=mid;
            else
                l=mid+1;

        }
        return 1/0;
    }
    static long binary1(long key,long ini){
        long l=0,r=2000_000_004;
        while(l<=r){
            if(l==r)
                return l;
            else if(l+1==r){
                if(key>=ini*(r)+(r)*(r-1))
                    return r;
                return l;
            }
            long m=(l+r)/2;
            if(key>=ini*(m)+m*(m-1))
                l=m;
            else
                r=m;
        }
        return 1/0;
    }
    static long binary2(long key,long ini){
        long l=0,r=2000_000_004;
        while(l<=r){
            if(l==r)
                return l;
            else if(l+1==r){
                if(key>=ini*(r)+(r)*(r))
                    return r;
                return l;
            }
            long m=(l+r)/2;
            if(key>=ini*(m)+m*(m))
                l=m;
            else
                r=m;
        }
        return 1/0;
    }
    public static void main(String args[]) throws IOException {
        FastReader in = new FastReader(System.in);
        StringBuilder sb = new StringBuilder();
        int i, j;
        int t0 = 0;
        int t = in.nextInt();
        while (t0++ < t) {
            long l=in.nextLong();
            long r=in.nextLong();
            long ans=0,next=1;
            if(l>r){
                long z=l-r;
                long x=binary(z);
                if(l>=x*(x+1)/2) {
                    ans += x;
                    l=l-x*(x+1)/2;
                    next=x+1;
                }
                else{
                    ans+=x-1;
                    l=l-x*(x-1)/2;
                    next=x;
                }
            }
            else if(r>l){
                long z=r-l;
                long x=binary(z);
                if(r>=x*(x+1)/2) {
                    ans += x;
                    r=r-x*(x+1)/2;
                    next=x+1;
                }
                else{
                    ans+=x-1;
                    r=r-x*(x-1)/2;
                    next=x;
                }
            }
            if(l>=r){
                long z=binary1(l,next);
                long z1=binary2(r,next);
                l=l-z*next-z*(z-1);
                r=r-next*z1-z1*z1;
                ans+=z+z1;
            }
            else{
                long z=binary1(r,next);
                long z1=binary2(l,next);
                r=r-z*next-z*(z-1);
                l=l-next*z1-z1*z1;
                ans+=z+z1;
            }

            sb.append("Case #" + t0 + ": "+ans+" "+l+" "+r).append("\n");
        }

        System.out.print(sb);


    }
}

class FastReader {

    byte[] buf = new byte[2048];
    int index, total;
    InputStream in;

    FastReader(InputStream is) {
        in = is;
    }

    int scan() throws IOException {
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0) {
                return -1;
            }
        }
        return buf[index++];
    }

    String next() throws IOException {
        int c;
        for (c = scan(); c <= 32; c = scan()) ;
        StringBuilder sb = new StringBuilder();
        for (; c > 32; c = scan()) {
            sb.append((char) c);
        }
        return sb.toString();
    }

    int nextInt() throws IOException {
        int c, val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        for (; c >= '0' && c <= '9'; c = scan()) {
            val = (val << 3) + (val << 1) + (c & 15);
        }
        return neg ? -val : val;
    }

    long nextLong() throws IOException {
        int c;
        long val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        for (; c >= '0' && c <= '9'; c = scan()) {
            val = (val << 3) + (val << 1) + (c & 15);
        }
        return neg ? -val : val;
    }
}
