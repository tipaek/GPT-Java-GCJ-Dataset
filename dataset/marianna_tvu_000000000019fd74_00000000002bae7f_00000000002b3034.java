
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int testNum = sc.nextInt();
        for (int i = 0; i < testNum; i++) {
            int str = sc.nextInt();
            PriorityQueue<String[]> strs = new PriorityQueue<>(Comparator.comparingInt((String[] s) -> s.length));
            PriorityQueue<String> start = new PriorityQueue<>(Comparator.comparingInt(String::length));
            PriorityQueue<String> end = new PriorityQueue<>(Comparator.comparingInt(String::length));
            for (int j = 0; j < str; j++) {
                String st = sc.next();
                if(st.charAt(0) != '*' || st.charAt(st.length() - 1) != '*') {
                if(st.charAt(0) != '*' && st.charAt(st.length() - 1) != '*') {
                        String[] startArr = st.split("\\*");
                        String stStart = startArr[0];
                        start.add(stStart);

                        String[] strArr = st.split("\\*");
                        String strEnd = strArr[strArr.length - 1];
                        end.add(strEnd);
                        strs.add(st.substring(stStart.length(), st.length() - strEnd.length()).split("\\*"));

                } else {

                    if (st.charAt(0) != '*') {
                        String[] startArr = st.split("\\*");
                        String stStart = startArr[0];
                        start.add(stStart);
                        strs.add(st.substring(stStart.length()).split("\\*"));
                    }
                    if (st.charAt(st.length() - 1) != '*') {
                        String[] strArr = st.split("\\*");
                        String strEnd = strArr[strArr.length - 1];
                        end.add(strEnd);
                        strs.add(st.substring(0, st.length() - strEnd.length()).split("\\*"));
                    }
                }
                } else {
                    strs.add(st.split("\\*"));
                }
            }
            check(i + 1, strs, str, start, end);
        }

    }

    private static void check(int testNum, PriorityQueue<String[]> strs, int len, PriorityQueue<String> start, PriorityQueue<String> end) {
        StringBuilder answ = new StringBuilder();
        String endString = "";
        String startString = "";

        if(start.size() > 0 || end.size() > 0){
            if(start.size() > 0){
                startString = start.poll();
                while (!start.isEmpty()){
                    if(start.peek().startsWith(startString)){
                        startString = start.poll();
                    } else {
                        printAnsw(testNum, "*");
                        return;
                    }
                }
                answ.append(startString);
            }
            if(end.size() > 0){
                while (!end.isEmpty()){
                    if(end.peek().endsWith(endString)){
                        endString = end.poll();
                    } else {
                        printAnsw(testNum, "*");
                        return;
                    }
                }
                if(endString.startsWith(startString)){
                    endString = endString.substring(startString.length());
                }
            }
        }

        int i = 0;
        int pollNum = 0;
        while (!strs.isEmpty()){
            for (String str[] : strs) {
                if (str.length > i) {
                    answ.append(str[i]);
                } else {
                    pollNum++;
                }
            }
            while (pollNum > 0){
                pollNum--;
                strs.poll();
            }
            i++;
        }

        answ.append(endString);

        printAnsw(testNum, answ.toString());
    }

    private static void printAnsw(int testNum, String s) {
        System.out.println("Case #" + testNum + ": " + s);
    }
}
