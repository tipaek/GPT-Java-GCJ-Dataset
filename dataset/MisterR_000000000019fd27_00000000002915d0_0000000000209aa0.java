//package com.company.C2HardCode;

import java.util.*;

public class Solution {

    public static Boolean check(int mat[][], int k){
        int sum1 = 0;
        int sum2 = 0;
        int sum3  = 0;
        if(mat == null) return false;
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int n[] = new int[cases];
        int k[] = new int[cases];
        List<int[][]> list = new ArrayList<>();
        list.add(f5(5));
        for(int c = 0; c < cases; c++) {
            n[c] = sc.nextInt();
            k[c] = sc.nextInt();
            if(n[c] == 5){
                int ans[][] = f5(k[c]);
                list.add(ans);
            }else if(n[c] == 4){
                int ans[][] = f4(k[c]);
                list.add(ans);
            }else if(n[c] == 3){
                int ans[][] = f3(k[c]);
                list.add(ans);
            }else if(n[c] == 2){
                list.add(new int[][]{{1},{1}});
            }
        }
        for(int c = 0; c < cases; c++){
            if(n[c] == 5){
                int ans[][] = list.get(c + 1);
                //System.out.println(check(ans, k[c]));
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
                int ans[][] = list.get(c + 1);
                //System.out.println(check(ans, k[c]));
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
            if(n[c] == 3){
                int ans[][] = list.get(c + 1);
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

    public static int[][] f5(int k){
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
                    {3,2,5,4,1},
                    {1,3,2,5,4},
                    {4,1,3,2,5},
                    {5,4,1,3,2},
                    {2,5,4,1,3}
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
            //4 4 3 5 5
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

    public static int[][] f4(int k){
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
                    {3,1,2,4},
                    {2,4,3,1},
                    {4,3,1,2}
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
                    {4,3,2,1},
                    {3,1,4,2},
                    {1,2,3,4}
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

    public static int[][] f3(int k){
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
}
