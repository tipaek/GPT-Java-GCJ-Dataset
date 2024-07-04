import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args)throws Exception  {
        FastReader in = new FastReader(System.in);
        int t = in.nextInt(),i; 
        for(int test=1;test<=t;++test) {
            int x=in.nextInt(),y=in.nextInt();
            String s="";
            if(x==0 && y==1)
                s="N";
            else if(x==0 && y==-1)
                s="S";
            else if((x==0 && (y==2 || y==-2 || y==4 || y==-4)) || ((x==2 || x==-2 || x==4 || x==-4) && y==0))
                s="IMPOSSIBLE";
            else if(x==0 && y==3)
                s="NN";
            else if(x==0 && y==-3)
                s="SS";
            else if(y==0 && x==1)
                s="E";
            else if(y==0 && x==-1)
                s="W";
            else if(y==0 && x==3)
                s="EE";
            else if(y==0 && x==-3)
                s="WW";
            else if((x==1 || x==-1 || x==-3 || x==3) && (y==1 || y==-1 || y==3 || y==-3))
                s="IMPOSSIBLE";
            else if(x==1 && y==2)
                s="EN";
            else if(x==1 && y==4)
                s="ENN";
            else if(x==1 && y==-2)
                s="ES";
            else if(x==1 && y==-4)
                s="ESS";
            else if(x==-1 && y==2)
                s="WN";
            else if(x==-1 && y==4)
                s="WNN";
            else if(x==-1 && y==-2)
                s="WS";
            else if(x==-1 && y==-4)
                s="WSS";
            else if(y==1 && x==2)
                s="NE";
            else if(y==1 && x==4)
                s="NEE";
            else if(y==1 && x==-2)
                s="NW";
            else if(y==1 && x==-4)
                s="NWW";
            else if(y==-1 && x==2)
                s="SE";
            else if(y==-1 && x==4)
                s="SEE";
            else if(y==-1 && x==-2)
                s="SW";
            else if(y==-1 && x==-4)
                s="SWW";
            else if((x==2 || x==-2 || x==4 || x==-4) && (y==2 || y==-2 || y==4 || y==-4))
                s="IMPOSSIBLE";
            else if((x==3 || x==-3) && (y==3 || y==-3))
                s="IMPOSSIBLE";
            else if(x==2 && y==3)
                s="SEN";
            else if(x==-2 && y==3)
                s="SWN";
            else if(x==2 && y==-3)
                s="NES";
            else if(x==-2 && y==-3)
                s="NWS";
            else if(y==2 && x==3)
                s="WNE";
            else if(y==-2 && x==3)
                s="WSE";
            else if(y==2 && x==-3)
                s="ENW";
            else if(y==-2 && x==-3)
                s="ESW";
            else if(x==3 && y==4)
                s="EEN";
            else if(x==3 && y==-4)
                s="EES";
            else if(x==-3 && y==4)
                s="WWN";
            else if(x==-3 && y==-4)
                s="WWS";
            System.out.println("Case #"+test+": "+s);
        }
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
    String nextLine() throws IOException {
        int c;
        for (c = scan(); c <= 32; c = scan()) ;
        StringBuilder sb = new StringBuilder();
        for (; c != 10 && c != 13; c = scan()) {
            sb.append((char) c);
        }
        return sb.toString();
    }
    char nextChar() throws IOException {
        int c;
        for (c = scan(); c <= 32; c = scan()) ;
        return (char) c;
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