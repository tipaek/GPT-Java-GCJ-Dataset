import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.parseInt(in.nextLine());
        ArrayList<String> answers = new ArrayList<>();
        for(int m=1; m<cases+1; m++) {
            int count = Integer.parseInt(in.nextLine());
            //System.out.println("Count: " + count);
            ArrayList<String> rules = new ArrayList<>();
            for(int i=0; i<count; i++) {
                String temp = in.nextLine();
                rules.add(temp);
                //System.out.println("Added " + temp);
            }
            String answer = "";
            while(!rules.isEmpty()) {
                ArrayList<String> finish = new ArrayList<>();
                for (int i = 0; i < rules.size(); i++) {
                    String rule = rules.get(i);
                    if (!rule.contains("*")) {
                        finish.add(rule);
                        rules.remove(i);
                        i -= 1;
                        continue;
                    } else if (rule.charAt(0) != '*') {
                        finish.add(rule.substring(0, rule.indexOf('*')));
                        rule = rule.substring(rule.indexOf("*"));
                        rules.remove(i);
                        rules.add(i, rule);
                        continue;
                    } else {
                        while (rule.charAt(0) == '*') {
                            if (rule.length() > 1) {
                                rule = rule.substring(1);
                            } else {
                                if (rule.equals("*")) {
                                    rule = null;
                                    break;
                                }
                            }
                        }
                        if(rule == null) {
                            rules.remove(i);
                            i -= 1;
                            continue;
                        } else {
                            rules.remove(i);
                            rules.add(i, rule);
                            continue;
                        }
                    }
                }
                boolean end = false;
                while (!finish.isEmpty()) {
                    if (finish.size() == 1) {
                        if(answer.lastIndexOf(finish.get(0)) == answer.length()-finish.get(0).length()) {
                            finish.clear();
                            break;
                        }
                        answer += finish.get(0);
                        finish.clear();
                        break;
                    }
                    String s1 = finish.get(0);
                    String s2 = finish.get(1);
                    if (s1.contains(s2)) {
                        finish.remove(1);
                    } else if (s2.contains(s1)) {
                        finish.remove(0);
                    } else {
                        end = true;
                        break;
                    }
                }
                if (end) {
                    answer = "*";
                    break;
                }
            }
            answers.add("Case #" + m + ": " + answer);
        }
        for(String a : answers) {
            System.out.println(a);
        }
    }
}
