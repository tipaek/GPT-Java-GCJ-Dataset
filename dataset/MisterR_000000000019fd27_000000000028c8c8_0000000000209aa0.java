//package com.company.C2HardCode;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int n[] = new int[cases];
        int k[] = new int[cases];
        List<int[][]> list = new ArrayList<>();
        for(int c = 0; c < cases; c++) {
            n[c] = sc.nextInt();
            k[c] = sc.nextInt();
            int array[][] = new int[n[c]][n[c]];
            if(n[c] == 5){
                int data[] = {1, 2, 3, 4, 5};
                int ans[][] = f5(data, k[c]);
                list.add(ans);
            }
            if(n[c] == 4){
                int data[] = {1, 2, 3, 4};
                int ans[][] = f4(data, k[c]);
                list.add(ans);
            }
            if(n[c] == 3){
                int data[] = {1, 2, 3};
                int ans[][] = f3(data, k[c]);
                list.add(ans);
            }
        }
        for(int c = 0; c < cases; c++){
            if(n[c] == 5){
                int ans[][] = list.get(c);
                if(ans != null) {
                    System.out.println("Case #" + (c + 1) + ": POSSIBLE");
                    for (int i = 0; i < ans.length; i++) {
                        for (int j = 0; j < ans.length; j++) {
                            System.out.print(ans[i][j] + " ");
                        }
                        System.out.println();
                    }
                }else {
                    System.out.println("Case #" + (c + 1) + ": IMPOSSIBLE");
                }
            }
            if(n[c] == 4){
                int ans[][] = list.get(c);
                if(ans != null) {
                    System.out.println("Case #" + (c + 1) + ": IMPOSSIBLE");
                    for (int i = 0; i < ans.length; i++) {
                        for (int j = 0; j < ans.length; j++) {
                            System.out.print(ans[i][j] + " ");
                        }
                        System.out.println();
                    }
                }else {
                    System.out.println("Case #" + (c + 1) + ": IMPOSSIBLE");
                }
            }
            if(n[c] == 3){
                int ans[][] = list.get(c);
                if(ans != null) {
                    System.out.println("Case #" + (c + 1) + ": POSSIBLE");
                    for (int i = 0; i < ans.length; i++) {
                        for (int j = 0; j < ans.length; j++) {
                            System.out.print(ans[i][j] + " ");
                        }
                        System.out.println();
                    }
                }else {
                    System.out.println("Case #" + (c + 1) + ": IMPOSSIBLE");
                }
            }
            if(n[c] == 2){
                if(k[c] == 2){
                    System.out.println("Case #" + (c + 1) + ": POSSIBLE");
                    System.out.println("1 2");
                    System.out.println("2 1");
                }else if(k[c] == 4){
                    System.out.println("Case #" + (c + 1) + ": POSSIBLE");
                    System.out.println("2 1");
                    System.out.println("1 2");
                }else System.out.println("Case #" + (c + 1) + ": IMPOSSIBLE");
            }
        }
    }

    public static int[][] f5(int data[], int k){
        int a[][];
        if(k == 5){
            a = new int[][]{
                    {1,2,3,4,5},
                    {5,1,2,3,4},
                    {4,5,1,2,3},
                    {3,4,5,1,2},
                    {2,3,4,5,1}
            };
            return a;
        }else if(k == 6){

        } else if(k == 7){
            a = new int[][]{
                    {2,1,3,4,5},
                    {1,2,4,5,3},
                    {3,5,1,2,4},
                    {4,3,5,1,2},
                    {5,4,2,3,1}
            };
            return a;
        }else if(k == 8){
            a = new int[][]{
                    {1,2,3,4,5},
                    {2,1,4,5,3},
                    {3,5,2,1,4},
                    {4,3,5,2,1},
                    {5,4,1,3,2}
            };
            return a;
        }else if(k == 9){
            a = new int[][]{
                    {3,1,2,4,5},
                    {1,3,4,5,2},
                    {2,5,1,3,4},
                    {4,2,5,1,3},
                    {5,4,3,2,1}
            };
            return a;
        }
        else if(k == 10){
            a = new int[][]{
                    {2,3,4,5,1},
                    {1,2,3,4,5},
                    {5,1,2,3,4},
                    {4,5,1,2,3},
                    {3,4,5,1,2}
            };
            return a;
        }else if(k == 11){
            a = new int[][]{
                    {4,1,3,2,5},
                    {1,4,2,5,3},
                    {3,5,1,4,2},
                    {2,3,5,1,4},
                    {5,2,4,3,1}
            };
            return a;
        }else if(k == 12){
            a = new int[][]{
                    {1,3,2,4,5},
                    {3,2,4,5,1},
                    {4,5,3,1,2},
                    {2,1,5,3,4},
                    {5,4,1,2,3}
            };
            return a;
        }else if(k == 13){
            a = new int[][]{
                    {5,1,2,4,3},
                    {1,5,4,3,2},
                    {2,3,1,5,4},
                    {4,2,3,1,5},
                    {3,4,5,2,1}
            };
            return a;
        }else if(k == 14){
            a = new int[][]{
                    {4,2,1,3,5},
                    {2,4,3,5,1},
                    {1,5,2,4,3},
                    {3,1,5,2,4},
                    {5,3,4,1,2}
            };
            return a;
        }else if(k == 15){
            a = new int[][]{
                    {5,2,3,4,1},
                    {1,5,2,3,4},
                    {4,1,5,2,3},
                    {3,4,1,5,2},
                    {2,3,4,1,5}
            };
            return a;
        }else if(k == 16){
            a = new int[][]{
                    {1,4,2,3,5},
                    {4,3,5,2,1},
                    {2,1,4,5,3},
                    {3,5,1,4,2},
                    {5,2,3,1,4}
            };
            return a;
        }else if(k == 17){
            a = new int[][]{
                    {1,5,3,2,4},
                    {5,1,2,4,3},
                    {3,4,5,1,2},
                    {2,3,4,5,1},
                    {4,2,1,3,5}
            };
            return a;
        }else if(k == 18){
            // 3 3 3 4 5
            a = new int[][]{
                    {3,4,5,1,2},
                    {5,3,4,2,1},
                    {1,2,3,5,4},
                    {2,5,1,4,3},
                    {4,1,2,3,5}
            };
            return a;
        }else if(k == 19){
            a = new int[][]{
                    {2,5,1,4,3},
                    {5,2,4,3,1},
                    {1,3,5,2,4},
                    {4,1,3,5,2},
                    {3,4,2,1,5}
            };
            return a;
        }else if(k == 20){
            a = new int[][]{
                    {4,2,3,1,5},
                    {5,4,2,3,1},
                    {1,5,4,2,3},
                    {3,1,5,4,2},
                    {2,3,1,5,4}
            };
            return a;
        }else if(k == 21){
            //4 4 4 4 5
            //4 4 4 3 5
            a = new int[][]{
                    {4,3,5,1,2},
                    {5,4,3,2,1},
                    {1,2,4,5,3},
                    {2,5,1,3,4},
                    {3,1,2,4,5}
            };
            return a;
        }else if(k == 22){
            //4 4 4 5 5
            a = new int[][]{
                    {5,4,3,2,1},
                    {4,5,2,1,3},
                    {3,1,4,5,2},
                    {2,3,1,4,5},
                    {1,2,5,3,4}
            };
            return a;
        }else if(k == 23){
            // 4 4 5 5 5
            a = new int[][]{
                    {4,5,3,2,1},
                    {5,4,2,1,3},
                    {3,1,5,4,2},
                    {2,3,1,5,4},
                    {1,2,4,3,5}
            };
            return a;
        }else if(k == 24){

        }else if(k == 25){
            a = new int[][]{
                    {5,2,3,4,1},
                    {1,5,2,3,4},
                    {4,1,5,2,3},
                    {3,4,1,5,2},
                    {2,3,4,1,5}
            };
            return a;
        }
        return null;
    }

    public static int[][] f4(int data[], int k){
        int a[][];
        if(k == 4){
            a = new int[][]{
                    {1,2,3,4},
                    {4,1,2,3},
                    {3,4,1,2},
                    {2,3,4,1}
            };
            return a;
        }else if(k == 5){

        }else if(k == 6){
            a = new int[][]{
                    {1,2,3,4},
                    {2,1,4,3},
                    {3,4,2,1},
                    {4,3,1,2}
            };
            return a;
        }else if(k == 7){
            a = new int[][]{
                    {1,2,4,3},
                    {2,3,1,4},
                    {3,4,2,1},
                    {4,1,3,2}
            };
            return a;
        }else if(k == 8){
            a = new int[][]{
                    {2,1,3,4},
                    {4,2,1,3},
                    {3,4,2,1},
                    {1,3,4,2}
            };
            return a;
        }else if(k == 9){
            // 3 3 2 1
            a = new int[][]{
                    {1,3,4,2},
                    {3,2,1,4},
                    {2,4,3,1},
                    {4,1,2,3}
            };
            return a;
        }else if(k == 10){
            a = new int[][]{
                    {3,2,1,4},
                    {2,3,4,1},
                    {1,4,2,3},
                    {4,1,3,2}
            };
            return a;
        }else if(k == 11){
            a = new int[][]{
                    {1,4,3,2},
                    {4,2,1,3},
                    {2,3,4,1},
                    {3,1,2,4}
            };
            return a;
        }else if(k == 12){
            a = new int[][]{
                    {3,2,1,4},
                    {4,3,2,1},
                    {1,4,3,2},
                    {2,1,4,3}
            };
            return a;
        }else if(k == 13){
            a = new int[][]{
                    {2,4,1,3},
                    {5,2,5,1},
                    {1,3,4,2},
                    {3,1,2,5}
            };
            return a;
        }else if(k == 14){
            a = new int[][]{
                    {3,4,1,2},
                    {4,3,2,1},
                    {1,2,4,3},
                    {2,1,3,4}
            };
            return a;
        }else if(k == 15){

        }else if(k == 16){
            a = new int[][]{
                    {4,2,3,1},
                    {1,4,2,3},
                    {3,1,4,2},
                    {2,3,1,4}
            };
            return a;
        }
        return null;
    }

    public static int[][] f3(int data[], int k){
        int a[][];
        if(k == 3){
            a = new int[][]{
                    {1,3,2},
                    {2,1,3},
                    {3,2,1}
            };
            return a;
        }else if(k == 4){

        }else if(k == 5){

        }else if(k == 6){
            a = new int[][]{
                    {2,1,3},
                    {3,2,1},
                    {1,3,2}
            };
            return a;
        }else if(k == 7){

        }else if(k == 8){

        }else if(k == 9){
            a = new int[][]{
                    {3,1,2},
                    {2,3,1},
                    {1,2,3}
            };
            return a;
        }
        return null;
    }

    public static Boolean check(int mat[][], int k){
        int sum1 = 0;
        int sum2 = 0;
        int sum3  = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat.length; j++) {
                int m = mat[i][j];
                if(i == j){
                    sum1 += m;
                }
                set.add(m);
            }
            if(mat.length > set.size()){
                sum2++;
            }
            set.clear();
        }
        set.clear();
        for(int j = 0; j < mat.length; j++){
            for(int i = 0; i < mat.length; i++) {
                int m = mat[i][j];
                set.add(m);
            }
            if(mat.length > set.size()){
                sum3++;
            }
            set.clear();
        }
        if(sum1 == k && sum2 == 0 && sum3 == 0)
            return true;
        return false;
    }

    public static int[] swap(int data[], int left, int right)
    {
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;
        return data;
    }
    public static int[] reverse(int data[], int left, int right)
    {
        while (left < right) {
            int temp = data[left];
            data[left++] = data[right];
            data[right--] = temp;
        }
        return data;
    }
    public static boolean findNextPermutation(int data[])
    {
        if (data.length <= 1)
            return false;
        int last = data.length - 2;
        while (last >= 0) {
            if (data[last] < data[last + 1]) {
                break;
            }
            last--;
        }
        if (last < 0)
            return false;
        int nextGreater = data.length - 1;
        for (int i = data.length - 1; i > last; i--) {
            if (data[i] > data[last]) {
                nextGreater = i;
                break;
            }
        }
        data = swap(data, nextGreater, last);
        data = reverse(data, last + 1, data.length - 1);
        return true;
    }
}
