import java.util.*;
import java.io.*;

class Solution {//Rename to Solution
    static Scanner scan;
    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(System.in);
        final int T = scan.nextInt();
        for(int t = 1; t <= T; t++){
            long l = scan.nextLong();
            long r = scan.nextLong();
            long n = 0;
            //Get them to one value of n away from eachother.
            if(l > r){
                long d = l-r;
                n = (long) Math.floor(.001 + .5*(-1+Math.sqrt(1+4*2*d)));
                l -= n*(n+1)/2;
            }
            else if (r > l){
                long d = r-l;
                n = (long) Math.floor(.001 + .5*(-1+Math.sqrt(1+4*2*d)));
                r -= n*(n+1)/2;
            }
            if(l >= r){
                long n0 = n+1;
                long nf = (long) Math.floor(.001 + 2*(-.5+Math.sqrt(.25-(-l-n0*n0/4.0+n0/2.0))));
                if (nf%2!=n0%2)
                    nf--;
                if(nf>=n0) {
                    n += (nf - n0) / 2 + 1;
                    l -= (n0 + nf) * ((nf - n0) / 2 + 1)/2;
                }
                n0 = n0+1;
                nf = (long) Math.floor(.001 + 2*(-.5+Math.sqrt(.25-(-r-n0*n0/4.0+n0/2.0))));
                if (nf%2!=n0%2)
                    nf--;
                if(nf>=n0) {
                    n += (nf - n0) / 2 + 1;
                    r -= (n0 + nf) * ((nf - n0) / 2 + 1)/2;
                }
            }
            else{
                long n0 = n+1;
                long nf = (long) Math.floor(.001 + 2*(-.5+Math.sqrt(.25-(-r-n0*n0/4.0+n0/2.0))));
                if (nf%2!=n0%2)
                    nf--;
                if(nf>=n0) {
                    n += (nf - n0) / 2 + 1;
                    r -= (n0 + nf) * ((nf - n0) / 2 + 1)/2;
                }
                n0 = n0+1;
                nf = (long) Math.floor(.001 + 2*(-.5+Math.sqrt(.25-(-l-n0*n0/4.0+n0/2.0))));
                if (nf%2!=n0%2)
                    nf--;
                if(nf>=n0) {
                    n += (nf - n0) / 2 + 1;
                    l -= (n0 + nf) * ((nf - n0) / 2 + 1)/2;
                }
            }
            System.out.println("Case #" + t + ": " + n + " " + l + " " + r);
        }
        scan.close();
    }
}