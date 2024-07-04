import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class Solution {
    static FastReader in;
    static boolean print(long x,long y)throws Exception{
        System.out.println(x+" "+y);
        String s=in.next();
        if(s.equals("HIT") || s.equals("CENTER")) {
            return true;
        }
        return false;
    }
    public static void main(String args[]) throws Exception {
        in = new FastReader(System.in);
        StringBuilder sb = new StringBuilder();
        int i, j=0;
        int t0 = 0;
        int t = in.nextInt();
        long a=in.nextLong();
        long b=in.nextLong();
        long x=10/2;
        while (t0++ < t) {
            int f=0;
            outer:
            for(i=-1;i<2;i++){
                for(j=-1;j<2;j++){
                    System.out.println(x*i+" "+x*j);
                    String s=in.next();
                    if(s.equals("HIT") || s.equals("CENTER")) {
                        f=1;
                        break outer;
                    }
                }
            }
            if(f==0)
                System.out.println(1/0);
            long val=x*j;
            long l=x*i;
            long r=x*2;
            long rightmost=0;
            while(l<=r){
                if(l==r) {
                    rightmost=l;
                    break;
                }
                if(l+1==r){
                    if(print(r,val)){
                        rightmost=r;
                    }
                    else
                        rightmost=l;
                    break;
                }
                long mid=(l+r)/2;
                if(print(mid,val)){
                    l=mid;
                }
                else
                    r=mid;

            }
            System.out.println(rightmost);
            long leftmost=0;
            l=x*-2;
            r=x*i;
            while(l<=r){
                if(l==r) {
                    leftmost=l;
                    break;
                }
                if(l+1==r){
                    if(print(l,val)){
                        leftmost=l;
                    }
                    else
                        leftmost=r;
                    break;
                }
                long mid=(l+r)/2;
                if(print(mid,val)){
                    r=mid;
                }
                else
                    l=mid;
            }
            System.out.println(leftmost);
            long val1=(leftmost+rightmost)/2;
            long down=0,up=0;
            r=x*j;
            l=x*-2;
            while(l<=r){
                if(l==r) {
                    down=l;
                    break;
                }
                if(l+1==r){
                    if(print(val1,l)){
                        down=l;
                    }
                    else
                        down=r;
                    break;
                }
                long mid=(l+r)/2;
                if(print(val1,mid)){
                    r=mid;
                }
                else
                    l=mid;
            }
            System.out.println(down);
            l=x*j;
            r=x*2;
            while(l<=r){
                if(l==r) {
                    up=l;
                    break;
                }
                if(l+1==r){
                    if(print(val1,r)){
                        up=r;
                    }
                    else
                        up=l;
                    break;
                }
                long mid=(l+r)/2;
                if(print(val1,mid)){
                    l=mid;
                }
                else
                    r=mid;

            }
            System.out.println(up);
            long val2=(up+down)/2;
            print(val1,val2);
            //sb.append("Case #" + t0 + ": ").append("\n");

        }
        //System.out.print(sb);


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
