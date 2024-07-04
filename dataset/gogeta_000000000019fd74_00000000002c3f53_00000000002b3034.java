import java.util.*;
public class Solution {
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
                while(i<ans.length()&&j<next.length()) {
                    while(i<ans.length()&&ans.charAt(i)!='*') {
                        i++;
                    }
                    while(j<next.length() && next.charAt(j)!='*') {
                        j++;
                    }
                    p=false;
                    if(ti==i) {
                        tans.append(next.substring(tj,j));
                        i++;ti=i;
                        tj=j;
                        continue;
                    }
                    if(tj==j) {
                        tans.append(ans.substring(ti,i));
                        j++;tj=j;ti=i;
                        continue;
                    }
                    if(ans.substring(ti,i).length() <=
                    next.substring(tj,j).length()) {
                        for(int k=tj;k<=j;k++) {
                            if(ans.substring(ti,i).equals(
                            next.substring(k,j))) {
                                p=true;
                                break;
                            }
                        }
                        if(p) {
                            tans.append(next.substring(tj,j));
                        }
                    } else {
                        for(int k=ti;k<=i;k++) {
                            if(next.substring(tj,j).equals(
                            ans.substring(k,i))) {
                                p=true;
                                break;
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