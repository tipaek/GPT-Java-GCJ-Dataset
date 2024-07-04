import java.util.*;
import static java.lang.Math.*;

public class Solution {
    static int x,y;
    static long ans_mask;
    static int ans_arr[];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int cs=1;cs<=t;++cs) {
            System.out.print("Case #"+cs+": ");
            x = scan.nextInt();
            y = scan.nextInt();
            boolean found = false;
            for(int i=1;i<=34;++i) {
                if(check(i-1)) {
                    found = true;
                    break;
                }
            }
            if(!found) {
                System.out.println("IMPOSSIBLE");
                System.out.flush();
            }
        }
    }
    static boolean check(int N) {
        int arr[] = new int[34];
        int ptr = 0;
        if(abs(x) > ((1<<(N+1)) - 1)) {
            return false;
        }
        for(int i=0;i<=N;++i) {
            if((abs(x)&(1<<i))==0) {
                arr[ptr++] = i;
            }
        }
        check1(arr, ptr);
        if(ans_mask!=-1) {
            char ans[] = new char[N+1];
            Arrays.fill(ans, '#');
            for(int i=0;i<=N;++i) {
                if((abs(x)&(1L<<i))!=0) {
                    if(x>0) {
                        ans[i] = 'E';
                    }
                    else {
                        ans[i] = 'W';
                    }
                }
            }
            String y_soln = "";
            int len = N + 1 - Long.bitCount(abs(x));
            for(int i=0;i<len;++i) {
                if((ans_mask&(1L<<i))!=0) {
                    if(y>0) {
                        y_soln+='N';
                    }
                    else {
                        y_soln+='S';
                    }
                }
                else {
                    if(y>0) {
                        y_soln+='S';
                    }
                    else {
                        y_soln+='N';
                    }
                }
            }
            int ptr_ = 0;
            for(int i=0;i<=N;++i) {
                if(ans[i]=='#') {
                    ans[i] = y_soln.charAt(ptr_++);
                }
            }
            for(int i=0;i<=N;++i) {
                System.out.print(ans[i]);
            }
            System.out.println();
            System.out.flush();
            return true;
        }
        return false;
    }

    static void check1(int arr[], int n) {
        int first_half = n/2;
        int second_half = (n - first_half);
        Map<Long, Long> first_half_possibilities = new HashMap<>();
        for(long mask=0;mask<(1L<<first_half);++mask) {
            long ispe = 0;
            for(int i=0;i<first_half;++i) {
                if((mask&(1L<<i))!=0) {
                    ispe+=(1L<<arr[i]);
                }
                else {
                    ispe-=(1L<<arr[i]);
                }
            }
            first_half_possibilities.put(ispe, mask);
        }

        for(int mask=0;mask<(1L<<second_half);++mask) {
            long ispe = 0;
            for(int i=0;i<second_half;++i) {
                if((mask&(1<<i))!=0) {
                    ispe+=(1L<<arr[i+first_half]);
                }
                else {
                    ispe-=(1L<<arr[i+first_half]);
                }
            }
            if(first_half_possibilities.containsKey(abs(y)-ispe)) {
                ans_mask =  (mask << first_half) | (first_half_possibilities.get((abs(y)-ispe)));
                ans_arr = arr;
                return;
            }
        }
        ans_mask = -1;
    }
}