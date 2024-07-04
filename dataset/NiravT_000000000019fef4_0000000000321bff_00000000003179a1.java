/**
 * Author: Nirav Talaviya
 */

import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = readInt();
        for(int tt=1;tt<=t;tt++){
            HashSet<Character> []set= new HashSet[10];
            for(int i=0;i<10;i++){
                set[i]=new HashSet<>();
            }
            Set<Character> temp = new HashSet<>();
            int u = readInt();
            int len =100_00;
            String a[][] = new String[len][2];
            for(int i=0;i<len;i++){
                String []r=br.readLine().split(" ");
                a[i][0] = r[0];
                a[i][1] = r[1];
                for(int j=0;j<a[i][1].length();j++){
                    temp.add(a[i][1].charAt(j));
                }
            }
//            Arrays.sort(a, new Comparator<String[]>() {
//                @Override
//                public int compare(String[] o1, String[] o2) {
//                    return o1[1].length()-o2[1].length();
//                }
//            });
            for(int i=0;i<10;i++){
                for (Iterator<Character> it = temp.iterator(); it.hasNext(); ) {
                    Character c = it.next();
                    set[i].add(c);
                }
            }
            for(int i=0;i<len;i++){
                set[0].remove(a[i][1].charAt(0));
            }

            set=correct(set);

            for(int i=0;i<len;i++){
                if(a[i][0].length()==a[i][1].length()){
                    for(int j=a[i][0].charAt(0)-'0'+1;j<=9;j++){
                        if(set[j].contains(a[i][1].charAt(0))){
                            set[j].remove(a[i][1].charAt(0));
                        }
                    }
                }
                flag = false;
                while(!flag){
                    flag=true;
                    set=correct(set);
                }
            }
            System.out.print("Case #"+tt+": ");
            for(int i=0;i<10;i++){
                System.out.print(set[i].iterator().next());
            }
            System.out.println();
//            for(int i=0;i<10;i++){
//                for (Iterator<Character> it = set[i].iterator(); it.hasNext(); ) {
//                    Character c = it.next();
//                    System.out.print(c);
//                }
//                System.out.print(" ");
//            }

        }
    }
    static HashSet[] correct(HashSet[] set){
        HashSet[] temp= new HashSet[10];
        for(int i=0;i<10;i++){
            temp[i]= new HashSet<Integer>();
        }
        HashMap<Character,Integer> pos= new HashMap<>();
        for(int i=0;i<10;i++){
            if(set[i].size()==1){
                pos.put((Character) set[i].iterator().next(),i);
            }
        }
        for(int i=0;i<10;i++){
            for (Iterator<Character> it = set[i].iterator(); it.hasNext(); ) {
                Character c = it.next();
                if(pos.containsKey(c)) {
                    if (pos.get(c) == i){
                        temp[i].add(c);
                    }
                }else{
                    temp[i].add(c);
                }
            }
            if(set[i].size()!=temp[i].size()){
                flag= false;
            }
        }
        return temp;
    }

    static int readInt() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    static long readLong() throws IOException {
        return Long.parseLong(br.readLine());
    }

    static int[] readintarr() throws IOException {
        String[] ___str___ = br.readLine().split(" ");
        int[] ___arr___ = new int[___str___.length];
        for (int i = 0; i < ___str___.length; i++) {
            ___arr___[i] = Integer.parseInt(___str___[i]);
        }
        return ___arr___;
    }

    static long[] readlongarr() throws IOException {
        String[] ___str___ = br.readLine().split(" ");
        long[] ___arr___ = new long[___str___.length];
        for (int i = 0; i < ___str___.length; i++) {
            ___arr___[i] = Long.parseLong(___str___[i]);
        }
        return ___arr___;
    }
}

    
    
    