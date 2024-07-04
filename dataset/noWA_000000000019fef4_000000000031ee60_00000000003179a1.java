import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int case_=1;case_<=t;++case_) {
            int u = scan.nextInt();
            int n = 10000;
            String arr[] = new String[n];
            long m[] = new long[n];
            HashSet<Character> possibilities[] = new HashSet[10];
            for(int i=0;i<10;++i) {
                possibilities[i] = new HashSet<>();
            }
            for(int i=0;i<n;++i) {
                m[i] = scan.nextLong();
                arr[i] = scan.next();
                for(int j=0;j<arr[i].length();j++) {
                    for(int k=0;k<10;++k) {
                        possibilities[k].add(arr[i].charAt(j));
                    }
                }
            }
            HashSet<Integer> leq_set = new HashSet<>();
            for(int i=0;i<n;++i) {
                if(Long.toString(m[i]).length() == arr[i].length()) {
                    char c = arr[i].charAt(0);
                    possibilities[0].remove(c);
                    int leq = Long.toString(m[i]).charAt(0) - '0';
                    leq_set.add(leq);
                    //System.out.println("Was Equal "+c+" "+leq+" "+m[i]);
                    for(int j=leq+1;j<10;j++) {
                        possibilities[j].remove(c);
                    }
                }
            }

            char ans[] = new char[10];
            for(char c : possibilities[0]) {
                ans[0] = c;
                for(int i=1;i<10;++i) {
                    possibilities[i].remove(c);
                }
                break;
            }

            for(int i=9;i>0;--i) {
                for(char c : possibilities[i]) {
                    ans[i] = c;
                    for(int j=i-1;j>=0;--j) {
                        possibilities[j].remove(c);
                    }
                    break;
                }
            }

            System.out.print("Case #"+case_+": ");

            for(char c : ans) {
                System.out.print(c);
            }
            System.out.println();

        }
    }
}
