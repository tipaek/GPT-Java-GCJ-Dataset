import java.io.*; 
import java.util.*;
class Solution {
    static int timSao(String str) {
        for (int i = 0; i < str.length(); ++i) {
            if(str.charAt(i) == '*') return i;
        }
        return -1;
    }
    static String merge(String str1, String str2) {
        String res = "";
        int indexSao1 = timSao(str1);
        int indexSao2 = timSao(str2);
        
        String strPre1 = "";
        String strPre2 = "";
        for (int i = 0; i < indexSao1; ++i) {
            strPre1 += str1.charAt(i);
        }
        for (int i = 0; i < indexSao2; ++i) {
            strPre2 += str2.charAt(i);
        }

        String strPos1 = "";
        String strPos2 = "";
        for (int i = str1.length()-1; i > indexSao1; --i) {
            strPos1 += str1.charAt(i);
        }
        for (int i = str2.length()-1; i > indexSao2; --i) {
            strPos2 += str2.charAt(i);
        }

        int minPre = 0;
        if (strPre1.length() > strPre2.length()) {
            minPre = strPre2.length();
            res += strPre1;
        } else {
            minPre = strPre1.length();
            res += strPre2;
        }
        for (int i = 0; i < minPre; ++i) {
            if (strPre1.charAt(i) != strPre2.charAt(i)) {
                return "";
            }
        }
        res += '*';

        int minPos = 0;
        if (strPos1.length() > strPos2.length()) {
            minPos = strPos2.length();
            for (int i = strPos1.length()-1; i >= 0; --i) {
                res += strPos1.charAt(i);
            }
        } else {
            minPos = strPos1.length();
            for (int i = strPos2.length()-1; i >= 0; --i) {
                res += strPos2.charAt(i);
            }
        }
        for (int i = 0; i < minPos; ++i) {
            if (strPos1.charAt(i) != strPos2.charAt(i)) {
                return "";
            }
        }
        
        return res;
    }
    public static void main(String[] args)throws Exception 
    { 
      Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    //   Scanner sc = new Scanner(new FileReader(new File("test.txt")));
      
      int n = sc.nextInt();
      for (int index = 1; index <= n; index++) {
          int len = sc.nextInt();
        String[] strArr = new String[len];
        for (int i = 0; i < len; ++i) {
            strArr[i] = sc.next();
        }

        String curPatt = merge(strArr[0], strArr[1]);
        for (int i = 2; i < len; ++i) {
            curPatt = merge(curPatt, strArr[i]);
            if (curPatt.equals("")) break;
        }
        StringBuilder sb = new StringBuilder(curPatt);
        for (int i = 0; i < curPatt.length(); ++i) {
            if (curPatt.charAt(i) == '*') {
                sb.setCharAt(i, 'A');
                break;
            }
        }

        curPatt = sb.toString();

        if (curPatt.equals("")) {
            System.out.println("Case #" + index + ": *");

        } else {
            System.out.println("Case #" + index + ": " + curPatt);
        }


      }
    }
}