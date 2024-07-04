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
                if(!check(listList.get(i).get(j), max[i])){
                    max[i] = "*";
                    break;
                }
            }
            if(max[i].length() > 1) max[i] = max[i].substring(1);
            System.out.println("Case #" + (i + 1) + ": " + max[i]);
        }
    }

    public static boolean check(String a, String max){
        boolean c = true;
        int j = max.length() - 1;
        for(int i = a.length() - 1; i > 0; i--, j--){
            if(max.charAt(j) != a.charAt(i)) {
                c = false;
                break;
            }
        }
        return c;
    }
}
