import java.util.*;
import java.io.*;

class Solution {//Rename to Solution
    static Scanner scan;
    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(System.in);
        final int T = scan.nextInt();
        for(int t = 1; t <= T; t++){
            int l = scan.nextInt();
            int r = scan.nextInt();
            int n = 0;
            //Get them to one value of n away from eachother.
            if(l > r){
                int d = l-r;
                n = (int) Math.ceil(.5*(-1+Math.sqrt(1+4*2*d)));
                l -= n*(n+1)/2;
            }
            else if (r > l){
                int d = r-l;
                n = (int) Math.ceil(.5*(-1+Math.sqrt(1+4*2*d)));
                r -= n*(n+1)/2;
            }
            System.out.println(n + " " + l + " " + r);
            if(l > r){
                int n0 = n+1;
                int nf = (int) Math.floor(.001 + 2*(-.5+Math.sqrt(.25-(-l-n0*n0/4.0+n0/2.0))));
                if(nf>=n0) {
                    n += (nf - n0) / 2 + 1;
                    l -= (n0 + nf) * ((nf - n0) / 2 + 1)/2;
                }
                n0 = n0+1;
                nf = (int) Math.floor(.001 + 2*(-.5+Math.sqrt(.25-(-r-n0*n0/4.0+n0/2.0))));
                if(nf>=n0) {
                    n += (nf - n0) / 2 + 1;
                    r -= (n0 + nf) * ((nf - n0) / 2 + 1)/2;
                }
            }
            else{
                int n0 = n+1;
                int nf = (int) Math.floor(.001 + 2*(-.5+Math.sqrt(.25-(-r-n0*n0/4.0+n0/2.0))));
                if(nf>=n0) {
                    n += (nf - n0) / 2 + 1;
                    r -= (n0 + nf) * ((nf - n0) / 2 + 1)/2;
                }
                n0 = n0+1;
                nf = (int) Math.floor(.001 + 2*(-.5+Math.sqrt(.25-(-l-n0*n0/4.0+n0/2.0))));
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