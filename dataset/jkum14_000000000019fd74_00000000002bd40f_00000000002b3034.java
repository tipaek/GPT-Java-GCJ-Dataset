import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        int caseNo = 0;

        while (tests-- > 0) {
            int count = Integer.parseInt(br.readLine());
            List<String> list = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                char[] chars = br.readLine().toCharArray();
                String s ="";
                for(int j = 1; j < chars.length; j++){
                    if(chars[0] == '*' && chars[j] != '*') {
                        s += chars[j];
                    }
                    else if(chars[j] == '*'){

                    }
                }
                list.add(s);
            }
            printCaseOne(list, caseNo);
        }
    }

    private static void printCaseOne(List<String> list, int caseNo){
        Collections.sort(list, new ListComparator());
        boolean flag = false;
        for(int i=0; i<list.size()-1;i++){
            if(isSubstring(list.get(i), list.get(list.size()-1))){
                flag =true;
            }
            else flag=false;
        }
        if(flag){
            System.out.println("Case #"+ ++caseNo+ ": "+list.get(list.size()-1));
        }
        else System.out.println("Case #"+ ++caseNo+ ": "+ "*");
    }

    static boolean isSubstring(String s1, String s2)
    {
        int M = s1.length();
        int N = s2.length();

        /* A loop to slide pat[] one by one */
        for (int i = 0; i <= N - M; i++) {
            int j;

            /* For current index i, check for
            pattern match */
            for (j = 0; j < M; j++)
                if (s2.charAt(i + j) != s1.charAt(j))
                    break;

            if (j == M)
                return true;
        }

        return false;
    }

    static class ListComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            if(o1.length() == o2.length()){
                return 0;
            }
            else return o1.length()>o2.length()?1:-1;
        }
    }
}


