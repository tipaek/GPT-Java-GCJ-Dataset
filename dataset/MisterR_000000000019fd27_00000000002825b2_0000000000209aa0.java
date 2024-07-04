//package com.company.E;

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
                        System.out.println( " f");
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
        int a[][] = new int[data.length][data.length];
        do {
            for(int i1 = 0; i1 < 5; i1++){
                a[0][i1] = data[i1];
            }
            int data2[] = new int[4];
            int count1 = 0;
            for(int i1 = 0; i1 < 5; i1++){
                if(i1 + 1 == a[0][0]) continue;
                if(count1 >= 4) break;
                data2[count1++] = i1 + 1;
            }
            do {
                for(int i2 = 0; i2 < 4; i2++){
                    a[i2 + 1][0] = data2[i2];
                }
                int data3[] = new int[4];
                int count2 = 0;
                for(int i2 = 0; i2 < 5; i2++){
                    if(i2 + 1 == a[1][0]) continue;
                    if(count2 >= 4) break;
                    data3[count2++] = i2 + 1;
                }
                do {
                    for(int i3 = 0; i3 < 4; i3++){
                        a[1][i3 + 1] = data3[i3];
                    }
                    int data4[] = new int[3];
                    int count3 = 0;
                    for(int i3 = 0; i3 < 5; i3++){
                        if(i3 + 1 == a[1][1]) continue;
                        if(i3 + 1 == a[1][0]) continue;
                        if(count3 >= 3) break;
                        data4[count3++] = i3 + 1;
                    }
                    do {
                        for(int i4 = 0; i4 < 3; i4++){
                            a[i4 + 2][1] = data4[i4];
                        }
                        int data5[] = new int[3];
                        int count4 = 0;
                        for(int i4 = 0; i4 < 5; i4++){
                            if(i4 + 1 == a[0][1]) continue;
                            if(i4 + 1 == a[1][1]) continue;
                            if(count4 >= 3) break;
                            data5[count4++] = i4 + 1;
                        }
                        do {
                            for(int i5 = 0; i5 < 3; i5++){
                                a[2][i5 + 2] = data5[i5];
                            }
                            int data6[] = new int[2];
                            int count5 = 0;
                            for(int i5 = 0; i5 < 5; i5++){
                                if(i5 + 1 == a[2][2]) continue;
                                if(i5 + 1 == a[2][1]) continue;
                                if(i5 + 1 == a[2][0]) continue;
                                if(count5 >= 2) break;
                                data6[count5++] = i5 + 1;
                            }
                            do {
                                for(int i6 = 0; i6 < 2; i6++){
                                    a[i6 + 3][2] = data6[i6];
                                }
                                int data7[] = new int[2];
                                int count6 = 0;
                                for(int i6 = 0; i6 < 5; i6++){
                                    if(i6 + 1 == a[0][2]) continue;
                                    if(i6 + 1 == a[1][2]) continue;
                                    if(i6 + 1 == a[2][2]) continue;
                                    if(count6 >= 2) break;
                                    data7[count6++] = i6 + 1;
                                }
                                do {
                                    for(int i7 = 0; i7 < 2; i7++){
                                        a[3][i7 + 3] = data7[i7];
                                    }
                                    int count7 = 0;
                                    for(int i7 = 0; i7 < 5; i7++){
                                        if(i7 + 1 == a[0][3]) continue;
                                        if(i7 + 1 == a[1][3]) continue;
                                        if(i7 + 1 == a[2][3]) continue;
                                        if(i7 + 1 == a[3][3]) continue;
                                        a[4][3] =  i7 + 1;
                                        break;
                                    }
                                    for(int i7 = 0; i7 < 5; i7++){
                                        if(i7 + 1 == a[4][0]) continue;
                                        if(i7 + 1 == a[4][1]) continue;
                                        if(i7 + 1 == a[4][2]) continue;
                                        if(i7 + 1 == a[4][3]) continue;
                                        a[4][4] =  i7 + 1;
                                        break;
                                    }
                                    if(check(a,k)){
                                        return a;
                                    }
                                }while (findNextPermutation(data7));
                            }while (findNextPermutation(data6));
                        }while (findNextPermutation(data5));
                    }while (findNextPermutation(data4));
                }while (findNextPermutation(data3));
            }while (findNextPermutation(data2));
        }while (findNextPermutation(data));
        return null;
    }

    public static int[][] f4(int data[], int k){
        int a[][] = new int[data.length][data.length];
        do {
            for(int i1 = 0; i1 < 4; i1++){
                a[0][i1] = data[i1];
            }
            int data2[] = new int[3];
            int count1 = 0;
            for(int i1 = 0; i1 < 4; i1++){
                if(i1 + 1 == a[0][0]) continue;
                if(count1 >= 3) break;
                data2[count1++] = i1 + 1;
            }
            do {
                for(int i2 = 0; i2 < 3; i2++){
                    a[i2 + 1][0] = data2[i2];
                }
                int data3[] = new int[3];
                int count2 = 0;
                for(int i2 = 0; i2 < 4; i2++){
                    if(i2 + 1 == a[1][0]) continue;
                    if(count2 >= 3) break;
                    data3[count2++] = i2 + 1;
                }
                do {
                    for(int i3 = 0; i3 < 3; i3++){
                        a[1][i3 + 1] = data3[i3];
                    }
                    int data4[] = new int[2];
                    int count3 = 0;
                    for(int i3 = 0; i3 < 4; i3++){
                        if(i3 + 1 == a[0][1]) continue;
                        if(i3 + 1 == a[1][1]) continue;
                        if(count3 >= 2) break;
                        data4[count3++] = i3 + 1;
                    }
                    do {
                        for(int i4 = 0; i4 < 2; i4++){
                            a[i4 + 2][1] = data4[i4];
                        }
                        int data5[] = new int[2];
                        int count4 = 0;
                        for(int i4 = 0; i4 < 4; i4++){
                            if(i4 + 1 == a[2][0]) continue;
                            if(i4 + 1 == a[2][1]) continue;
                            if(count4 >= 2) break;
                            data5[count4++] = i4 + 1;
                        }
                        do {
                            for(int i5 = 0; i5 < 2; i5++){
                                a[2][i5 + 2] = data5[i5];
                            }
                            for(int i7 = 0; i7 < 5; i7++){
                                if(i7 + 1 == a[0][2]) continue;
                                if(i7 + 1 == a[1][2]) continue;
                                if(i7 + 1 == a[2][2]) continue;
                                a[3][2] =  i7 + 1;
                                break;
                            }
                            for(int i7 = 0; i7 < 5; i7++){
                                if(i7 + 1 == a[3][0]) continue;
                                if(i7 + 1 == a[3][1]) continue;
                                if(i7 + 1 == a[3][2]) continue;
                                a[3][3] =  i7 + 1;
                                break;
                            }
                            if(check(a,k)){
                                return a;
                            }
                        }while (findNextPermutation(data5));
                    }while (findNextPermutation(data4));
                }while (findNextPermutation(data3));
            }while (findNextPermutation(data2));
        } while (findNextPermutation(data));
        return null;
    }

    public static int[][] f3(int data[], int k){
        int a[][] = new int[data.length][data.length];
        do {
            for(int i1 = 0; i1 < 3; i1++){
                a[0][i1] = data[i1];
            }
            int data2[] = new int[2];
            int count1 = 0;
            for(int i1 = 0; i1 < 3; i1++){
                if(i1 + 1 == a[0][0]) continue;
                data2[count1++] = i1 + 1;
            }
            do {
                for(int i2 = 0; i2 < 2; i2++){
                    a[i2 + 1][0] = data2[i2];
                }
                int data3[] = new int[2];
                int count2 = 0;
                for(int i2 = 0; i2 < 3; i2++){
                    if(i2 + 1 == a[1][0]) continue;
                    data3[count2++] = i2 + 1;
                }
                do {
                    for(int i3 = 0; i3 < 2; i3++){
                        a[1][i3 + 1] = data3[i3];
                    }
                    for(int i7 = 0; i7 < 3; i7++){
                        if(i7 + 1 == a[0][1]) continue;
                        if(i7 + 1 == a[1][1]) continue;
                        a[2][1] =  i7 + 1;
                    }
                    for(int i7 = 0; i7 < 3; i7++){
                        if(i7 + 1 == a[2][0]) continue;
                        if(i7 + 1 == a[2][1]) continue;
                        a[2][2] =  i7 + 1;
                    }
                    if(check(a,k)){
                        return a;
                    }
                }while (findNextPermutation(data3));
            }while (findNextPermutation(data2));
        }while (findNextPermutation(data));
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
