import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.print("Case #" + i + ": ");
            int n = in.nextInt();
            String[] p = new String[n];
            for(int j=0; j<n; j++) {
                p[j] = in.next();
            }
            testCase(n, p);
        }
    }
    private static void testCase(int n, String[] p) {
        List<String> mids = new ArrayList<>();
        String longestHead = "";
        String longestTail = "";
        for(int i=0; i<n; i++) {
            int firstIndex = p[i].indexOf("*");
            String head = p[i].substring(0, firstIndex);
            if(head.length() > longestHead.length()) {
                if(head.startsWith(longestHead)) {
                    longestHead = head;
                }
                else {
                    System.out.println("*");
                    return;
                }
            }
            else if(!longestHead.startsWith(head)) {
                System.out.println("*");
                return;
            }
            
            int lastIndex = p[i].lastIndexOf("*");
            if(lastIndex<p[i].length()) {
                String tail = p[i].substring(lastIndex+1);
                if(tail.length() > longestTail.length()) {
                    if(tail.endsWith(longestTail)) {
                        longestTail = tail;
                    }
                    else {
                        System.out.println("*");
                        return;
                    }
                }
                else if(!longestTail.endsWith(tail)) {
                    System.out.println("*");
                    return;
                }
            }
            
            if(firstIndex<lastIndex) {
                String mid = p[i].substring(firstIndex+1, lastIndex);
                String[] midArray = mid.split("\\*");
                for(int j=0; j<midArray.length; j++) {
                    if(!midArray[j].isEmpty()) {
                        mids.add(midArray[i]);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(longestHead);
        for(int i=0; i<mids.size(); i++) {
            sb.append(mids.get(i));
        }
        sb.append(longestTail);
        System.out.println(sb.toString());
    }
}