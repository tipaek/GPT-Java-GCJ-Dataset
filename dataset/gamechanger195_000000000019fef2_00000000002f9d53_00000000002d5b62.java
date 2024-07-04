import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class Solution {
    static int fx,fy,f;
    static int ans[];
    static void recurse(int i,int arr[],int limit){
        if(i==limit){
            int pow=1;
            int x=0,y=0;
            for(int z:arr){
                if(z==1)
                    y=y-pow;
                if(z==2)
                    y=y+pow;
                if(z==3)
                    x=x-pow;
                if(z==4)
                    x=x+pow;
                pow=pow*2;
            }
            if(x==fx && y==fy){
                f=1;
                for(int z=0;z<arr.length;z++)
                    ans[z]=arr[z];
            }
            return;
        }
        if(f==1)
            return;
        arr[i]=1;
        recurse(i+1,arr,limit);
        if(f==1)
            return;
        arr[i]=2;
        recurse(i+1,arr,limit);
        if(f==1)
            return;
        arr[i]=3;
        recurse(i+1,arr,limit);
        if(f==1)
            return;
        arr[i]=4;
        recurse(i+1,arr,limit);
    }
    public static void main(String args[]) throws IOException {
        FastReader in = new FastReader(System.in);
        StringBuilder sb = new StringBuilder();
        int i, j;
        int t0 = 0;
        int t = in.nextInt();
        while (t0++ < t) {
            fx = in.nextInt();
            fy=in.nextInt();
            if(fx%2==fy%2){
                sb.append("Case #" + t0 + ": IMPOSSIBLE").append("\n");
                continue;
            }
            f=0;
            ans=new int[10];
            for(i=0;i<10;i++){
                recurse(0,new int[i+1],i+1);
                if(f==1)
                    break;
            }
            if(ans[0]==0){
                sb.append("Case #" + t0 + ": IMPOSSIBLE").append("\n");
            }
            else{
                String s="";
                for(i=0;i<10;i++){
                    if(ans[i]==1)
                        s=s+'S';
                    if(ans[i]==2)
                        s=s+'N';
                    if(ans[i]==3)
                        s=s+'W';
                    if(ans[i]==4)
                        s=s+'E';
                }
                sb.append("Case #" + t0 + ": "+s).append("\n");
            }
            //System.out.println(Arrays.toString(ans));

            //sb.append("Case #" + t0 + ": ").append("\n");

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
