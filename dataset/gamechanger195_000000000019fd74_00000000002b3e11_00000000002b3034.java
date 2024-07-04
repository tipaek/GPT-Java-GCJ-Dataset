import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class Solution {
    public static void main(String args[]) throws IOException {
        FastReader in = new FastReader(System.in);
        StringBuilder sb = new StringBuilder();
        int i, j;
        int t0 = 0;
        int t = in.nextInt();
        while (t0++ < t) {
            int n=in.nextInt();
            String arr[]=new String[n];
            for(i=0;i<n;i++)
                arr[i]=in.next();

            StringBuilder start=new StringBuilder();
            StringBuilder end=new StringBuilder();
            int f=0;
            outer:
            for(i=0;i<n;i++){
                int l=arr[i].length();
                if(arr[i].charAt(0)!='*'){
                    for(j=0;j<l;j++){
                        if(arr[i].charAt(j)=='*')
                            break;
                        if(start.length()>=(j+1)){
                             if(arr[i].charAt(j) !=start.charAt(j)) {
                                 f = 1;
                                 break outer;
                             }
                        }
                        else
                            start.append(arr[i].charAt(j));

                    }
                }
                for(j=l-1;j>=0;j--){
                    if(arr[i].charAt(j)=='*')
                        break;
                    if(end.length()>=(l-j)){
                        if(arr[i].charAt(j) !=end.charAt(l-j-1)) {
                            f = 1;
                            break outer;
                        }
                    }
                    else
                        end.append(arr[i].charAt(j));
                }
                //System.out.println(start+" "+end);
            }
            if(f==0)
                sb.append("Case #" + t0 + ": "+start+end.reverse()).append("\n");
            else
                sb.append("Case #" + t0 + ": "+"*").append("\n");

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
