import java.util.*;
import java.lang.Math;

class Solution {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(int i=1; i<=t; i++){
      int U = in.nextInt();
      int Q[] = new int[10000];
      String R[] = new String[10000];
      int[][] freq = new int[10][26];
      int[] alphabet = new int[26];

      for(int j=0; j<10000; j++){
        Q[j] = in.nextInt();
        R[j] = in.next();
        for(char c: R[j].toCharArray()){
          alphabet[c-'A']++;
        }
        int firstDigit = Integer.parseInt(Integer.toString(Q[j]).substring(0, 1));
        freq[firstDigit][R[j].charAt(0)-'A']++;
      }
      System.out.println("Case #"+i+": "+solve(freq, alphabet));
    }
  }

    private static String solve(int[][] freq, int[] alphabet){
      String res = "";
      HashMap<Integer,String> alphabetMap = new HashMap<>(26);
      for(int i=0; i<26; i++){
        alphabetMap.put(alphabet[i], String.valueOf((char) ('A'+i)));
        System.out.println(String.valueOf((char) ('A'+i)));
      }
      Arrays.sort(alphabet);
      for(int i=17; i<26; i++)
        res += alphabetMap.get(alphabet[i]);

      StringBuilder str = new StringBuilder();
      str.append(res);
      str.reverse();
      return alphabetMap.get(alphabet[16])+str.toString();

        // System.out.println(alphabet[i]+" "+String.valueOf((char) alphabetMap.get(alphabet[i])));
      // for(int i=0; i<=10; i++)
      //   res += alphabetMap.get(alphabet[25-i]);

    }
    //   String res = "";
    //   int[] answer = new int[10];
    //   for(int i=1; i<10; i++){
    //     int max = 0;
    //     char letter = 'a';
    //     int offset = -1;
    //     for(int j=0; j<26;j++){
    //       if(freq[i][j] > max){
    //         max = freq[i][j];
    //         offset = j;
    //       }
    //     }
    //     letter =(char) ('A' + offset);
    //     for(int k=0; k<10; k++)
    //         freq[k][offset] = 0;
    //     res += letter;
    //   }
    //   return res;
    // }
}
