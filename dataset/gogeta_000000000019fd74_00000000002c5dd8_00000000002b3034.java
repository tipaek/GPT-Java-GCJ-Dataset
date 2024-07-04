import java.util.*;
class Solution {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int t=1;t<=T;t++) {
            int n  = s.nextInt();
            String ans = s.next();
            while(n-->1) {
                String next = s.next();
                StringBuilder tans = new StringBuilder();
                int i = 0, ti=0;
                int j=0, tj=0;
                boolean p = false;
                boolean aa = false, an=false,pa=false,pn=false;
                while(i<ans.length()&&j<next.length()) {
                    while(i<ans.length()&&ans.charAt(i)!='*') {
                        i++;
                    }
                    while(j<next.length() && next.charAt(j)!='*') {
                        j++;
                    }
                    if(i<ans.length()&&ans.charAt(i)=='*') {
                        aa=true;
                    } else {
                        aa=false;
                    }
                    if(j<next.length() && next.charAt(j)=='*') {
                        an = true;
                    } else {
                        an=false;
                    }
                    p=false;
                    if(ti==i||tj==j) {
                        tans.append(ti==i ? next.substring(tj,j) : ans.substring(ti,i));
                        pa=aa;
                        pn=an;
                        i++;ti=i;
                        j++;tj=j;
                        continue;
                    }
                    if(ans.substring(ti,i).length() <=
                    next.substring(tj,j).length()) {
                        if(aa) {
                            for(int k=tj+1;k<=j;k++) {
                                if(ans.substring(ti,i).equals(
                                next.substring(tj,k))) {
                                    p=true;
                                    break;
                                }
                            }
                        }
                        if(pa) {
                            for(int k=tj;k<=j;k++) {
                                if(ans.substring(ti,i).equals(
                                next.substring(k,j))) {
                                    p=true;
                                    break;
                                }
                            }
                        }
                        if(p) {
                            tans.append(next.substring(tj,j));
                        }
                    } else {
                        if(an) {
                            for(int k=ti+1;k<=i;k++) {
                                if(next.substring(tj,j).equals(
                                ans.substring(ti, k))) {
                                    p=true;
                                    break;
                                }
                            }
                        }
                        if(pn) {
                            for(int k=ti;k<=i;k++) {
                                if(next.substring(tj,j).equals(
                                ans.substring(k, j))) {
                                    p=true;
                                    break;
                                }
                            }
                        }
                        if(p) {
                            tans.append(ans.substring(ti,i));
                        }
                    }
                    if(!p) {
                        tans = new StringBuilder();
                        tans.append("*");
                        break;
                    }
                    ti=i;
                    tj=j;
                    pa=aa;
                    pn=an;
                }
                ans = tans.toString();
            }
            if(ans.length()>9999) {
                ans="*";
            }
            System.out.println("Case #" + t + ": " + (ans.equals("*") ? ans : ans.replace("*","")));
        }
    }
}