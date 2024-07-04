//package com.company.TaskA;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int n[] = new int[c];
        List<List<String>> listList = new ArrayList<>();
        String max[] = new String[c];
        for(int i = 0; i < c; i++){
            n[i] = sc.nextInt();
            max[i] = "";
            sc.nextLine();
            List<String> list = new ArrayList<>();
            for(int j = 0; j < n[i]; j++) {
                list.add(sc.nextLine());
                if(list.get(j).length() > max[i].length()){
                    max[i] = list.get(j);
                }
            }
            listList.add(list);
        }
        for(int i = 0; i < c; i++){
            for(int j = 0; j < n[i]; j++){
                String ex = listList.get(i).get(j);
                for (int k = 0; k < ex.length(); k++) {
                    if (ex.charAt(k) == '*') {
                        ex = change(ex, k);
                    }
                }
                String ex2[] = ex.split(" ");
                if(!check(ex2, max[i])){
                    max[i] = "*";
                    break;
                }
            }
            String ans[];
            String ans2 = "";
            if(max[i].length() > 1) {
                for (int j = 0; j < max[i].length(); j++) {
                    if (max[i].charAt(j) == '*') {
                        max[i] = change(max[i], j);
                    }
                }
                ans = max[i].split(" ");
                ans2 = "";
                for(int j = 0; j < ans.length; j++){
                    ans2 += ans[j];
                }
            }else {
                ans2 = "*";
            }
            System.out.println("Case #" + (i + 1) + ": " + ans2);
        }
    }

    public static boolean check(String a[], String max){
        boolean c = true;
        for(int i = 0; i < a.length; i++){
            if(max.lastIndexOf(a[i]) < 0){
                c = false;
                break;
            }
        }
        return c;
    }

    public static String change(String a, int i){
        String b = a.substring(0,i);
        String c = "";
        if(i < a.length() - 1){
            c += a.substring(i + 1);
        }
        return b + " " + c;
    }
}
