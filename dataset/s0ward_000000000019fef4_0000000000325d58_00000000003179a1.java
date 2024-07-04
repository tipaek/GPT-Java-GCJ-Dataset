  import java.util.*;
  import java.lang.Math;

  class Solution {
    public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      int t = in.nextInt();
      for(int i=1; i<=t; i++){
        int U = in.nextInt();
        long Q[] = new long[10000];
        String R[] = new String[10000];
        int[] alphabet = new int[26];

        for(int j=0; j<10000; j++){
          Q[j] = in.nextLong();
          R[j] = in.next();
          if(Q[j] != -1){
            for(char c: R[j].toCharArray())
              alphabet[c-'A']++;
          }
        }
        System.out.println("Case #"+i+": "+solve(alphabet));
      }
    }

      private static String solve(int[] alphabet){
        String res = "";
        HashMap<Integer,String> alphabetMap = new HashMap<>(26);
        for(int i=0; i<26; i++){
          alphabetMap.put(alphabet[i], String.valueOf((char) ('A'+i)));
        }
        Arrays.sort(alphabet);
        for(int i=17; i<26; i++)
          res += alphabetMap.get(alphabet[i]);

        StringBuilder str = new StringBuilder();
        str.append(res);
        str.reverse();
        return alphabetMap.get(alphabet[16])+str.toString();
      }
  }
