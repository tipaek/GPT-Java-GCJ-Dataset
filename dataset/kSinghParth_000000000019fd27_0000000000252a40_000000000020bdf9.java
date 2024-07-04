import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {
    static int st[];
    static int end[];
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        outer:
        for (int k=1;k<=t;k++) {
            int n=sc.nextInt();
            int arr[] = new int[24*60+1];
            st=new int[n];
            end=new int[n];
            for(int i=0;i<n;i++){
                st[i]=sc.nextInt();
                end[i] = sc.nextInt();
                arr[st[i]]++;
                arr[end[i]]--;
            }
            if(arr[0]>2){
                System.out.println("Case #"+k+": IMPOSSIBLE");
                continue outer;
            }
            for(int i=1;i<=24*60;i++){
                arr[i]+=arr[i-1];
                if(arr[i]>2){
                    System.out.println("Case #"+k+": IMPOSSIBLE");
                    continue outer;
                }
            }
            StringBuilder sp = new StringBuilder();
            // System.out.println("AFCS");
            arr= new int[24*60+1];
            outer2:
            for(int i=0;i<n;i++){
                for(int j=st[i];j<end[i];j++){
                    if(arr[j]==1){
                        sp.append("J");
                        for(int kt=st[i];kt<j;kt++)
                            arr[kt]--;
                        continue outer2;
                    }
                    arr[j]++;
                }
                sp.append("C");
            }
            System.out.println("Case #"+k+": "+sp);
            //process(r,b,c);
        }
    }
    
}
