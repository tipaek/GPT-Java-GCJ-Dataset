//package com.example.myapplication.test;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        new Solution();
    }


    class A {
        int s, e, idx;
        char c;
        public A(int s, int e, int idx) {
            this.s = s;
            this.e = e;
            this.idx = idx;
        }
    }

    public Solution() throws FileNotFoundException {
//        System.setIn(new FileInputStream("test.txt"));
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = sc.nextInt();
        int tc = 1;

        while (T-- > 0) {
            int N = sc.nextInt();
            List<A> items = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                items.add(new A(start, end, i));
            }
            items.sort((o1, o2) -> o1.s - o2.s);
            A a = items.get(0);
            a.c = 'C';
            int idx = 0;
            while((idx = bs(idx + 1, items.size() - 1, items.get(idx).e, items)) != -1) {
                items.get(idx).c = 'C';
            }
            int j = -1;
            boolean isOk = true;
            items.sort(((o1, o2) -> o1.e - o2.e));
            for(A aa: items) {
                if (aa.c != 'C') {
                    if (aa.e >= j) {
                        j = aa.e;
                    } else {
                        isOk = false;
                        break;
                    }
                }
            }
            if (isOk) {
                StringBuilder sb = new StringBuilder();
                items.sort((o1, o2) -> o1.idx - o2.idx);
                items.forEach(item -> sb.append(item.c));
                System.out.printf("Case #%d: %s\n", tc++, sb.toString());
            } else {
                System.out.printf("Case #%d: %s\n", tc++, "IMPOSSIBLE");
            }
        }
    }

    int bs(int i, int j, int val, List<A> items) {
        int ans = -1;
        while(i <= j) {
            int mid = i + j >> 1;
            if (items.get(mid).s >= val) {
                ans = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return ans;
    }

}

