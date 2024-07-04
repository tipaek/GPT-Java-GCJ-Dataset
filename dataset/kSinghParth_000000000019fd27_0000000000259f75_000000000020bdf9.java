import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {
    static class Custom implements Comparable<Custom>{
        int st;
        int end;
        int index;
        char p;
        public Custom(int s, int e, int i){
            st = s;
            end = e;
            index = i;
        }
        public int compareTo(Custom t){
            if(this.st!=t.st)
                return this.st - t.st;
            return this.end - t.end;
        }
    }
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        outer:
        for (int k=1;k<=t;k++) {
            int n=sc.nextInt();
            int arr[] = new int[24*60+1];
            ArrayList<Custom> dp = new ArrayList<>();
            for(int i=0;i<n;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                dp.add(new Custom(a, b, i));
                arr[a]++;
                arr[b]--;
            }
            Collections.sort(dp);
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
            
            int prev = -1;
            for(int i=0;i<n;i++){
                Custom cu = dp.get(i);
                if(cu.st>=prev){
                    cu.p='C';
                    prev = cu.end;
                }
                else{
                    cu.p='J';
                }
            }
            char ch[] = new char[n];
            for(int i=0;i<n;i++){
                Custom cu = dp.get(i);
                ch[cu.index]=cu.p;
            }
            System.out.println("Case #"+k+": "+new String(ch));
        }
    }
    
}
