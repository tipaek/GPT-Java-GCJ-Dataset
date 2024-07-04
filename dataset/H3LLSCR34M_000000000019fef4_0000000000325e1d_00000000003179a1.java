import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));  
    int t = in.nextInt();
    String[] arr = new String[t];
    for(int w = 0;w<t;w++) {
       int u = in.nextInt();
       List<Integer> list = new ArrayList<>();
       for(int i = 0;i<10;i++) {
         list.add(i);
       }
       char[] result = new char[10];
       Map<Character, List<Integer>> map = new HashMap<>();
       for(int i = 0;i<Math.pow(10, 4);i++) {
         int max = in.nextInt();
         String str = in.nextLine();
         str = str.substring(1);
         for(int j = 0;j<str.length();j++) {
           if(!map.containsKey(str.charAt(j))) {
             map.put(str.charAt(j),new ArrayList<>(list));
           }
         }
         if(max<10) {
           List<Integer> temp = new ArrayList<>();
           temp.add(0);
           for(int j = 9;j>max;j--) {
             temp.add(j);
           }
           map.get(str.charAt(0)).removeAll(temp);
         }
         else {
           if(str.length() == 1) {
             if(map.get(str.charAt(0)).contains(0))
               map.get(str.charAt(0)).remove(0);
           }
           else {
             List<Integer> temp1 = new ArrayList<>();
             temp1.add(0);
             for(Integer j = 9;j>max/10;j--) {
               temp1.add(j);
             }
             map.get(str.charAt(0)).removeAll(temp1);

           }
         }
      }
       for(Character ch:map.keySet()) {
         int size = map.get(ch).size();
         if(size==10) {
           result[0]=ch;
         }
         else
           result[map.get(ch).get(size-1)] = ch;
       }
       String res = "";
       for(int d = 0;d<10;d++) {
         res+=result[d];
       }
       arr[w] = "Case #"+(w+1)+": "+res;
    }
    in.close();
    for(String s:arr)
        System.out.println(s);
  }
}