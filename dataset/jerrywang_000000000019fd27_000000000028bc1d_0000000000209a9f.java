import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int NC = Integer.parseInt(in.nextLine());
        for(int i = 0; i < NC; i ++){
            String numstring = in.nextLine();
            ArrayList<String> numgroup = new ArrayList<String>(numstring.length());
            ArrayList<Integer> basenum = new ArrayList<Integer>();
            for(int j = 0; j < numstring.length(); j ++) numgroup.add(numstring.substring(j, j+1));
            for(int j = 0; j < numgroup.size(); j ++){
                int temp = Integer.parseInt(numgroup.get(j));
                basenum.add(temp);
                for(int k = j + 1; k < numgroup.size(); k ++){
                    if(temp == Integer.parseInt(numgroup.get(k))){
                        numgroup.set(j, numgroup.get(j)+numgroup.get(k));
                        numgroup.remove(k);
                        k--;
                    } else k = numgroup.size();
                }
            }
            ArrayList<String> finalstr = new ArrayList<String>();
            for(int j = 0; j < basenum.size(); j ++){
                switch(basenum.get(j)){
                    case 0:
                        finalstr.add(numgroup.get(j));
                        break;
                    case 1:
                        for(int k = 0; k < 1; k ++) finalstr.add("(");
                        finalstr.add(numgroup.get(j));
                        for(int k = 0; k < 1; k ++) finalstr.add(")");
                        break;
                    case 2:
                        for(int k = 0; k < 2; k ++) finalstr.add("(");
                        finalstr.add(numgroup.get(j));
                        for(int k = 0; k < 2; k ++) finalstr.add(")");
                        break;
                    case 3:
                        for(int k = 0; k < 3; k ++) finalstr.add("(");
                        finalstr.add(numgroup.get(j));
                        for(int k = 0; k < 3; k ++) finalstr.add(")");
                        break;
                    case 4:
                        for(int k = 0; k < 4; k ++) finalstr.add("(");
                        finalstr.add(numgroup.get(j));
                        for(int k = 0; k < 4; k ++) finalstr.add(")");
                        break;
                    case 5:
                        for(int k = 0; k < 5; k ++) finalstr.add("(");
                        finalstr.add(numgroup.get(j));
                        for(int k = 0; k < 5; k ++) finalstr.add(")");
                        break;
                    case 6:
                        for(int k = 0; k < 6; k ++) finalstr.add("(");
                        finalstr.add(numgroup.get(j));
                        for(int k = 0; k < 6; k ++) finalstr.add(")");
                        break;
                    case 7:
                        for(int k = 0; k < 7; k ++) finalstr.add("(");
                        finalstr.add(numgroup.get(j));
                        for(int k = 0; k < 7; k ++) finalstr.add(")");
                        break;
                    case 8:
                        for(int k = 0; k < 8; k ++) finalstr.add("(");
                        finalstr.add(numgroup.get(j));
                        for(int k = 0; k < 8; k ++) finalstr.add(")");
                        break;
                    case 9:
                        for(int k = 0; k < 9; k ++) finalstr.add("(");
                        finalstr.add(numgroup.get(j));
                        for(int k = 0; k < 9; k ++) finalstr.add(")");
                        break;
                }
            }
            boolean switcher = true;
            while(switcher){
                switcher = false;
                for(int j = 0; j < finalstr.size() - 1; j ++){
                    if(finalstr.get(j).equals(")") && finalstr.get(j+1).equals("(")){
                        switcher = true;
                        finalstr.remove(j);
                        finalstr.remove(j);
                        j --;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (String s : finalstr) sb.append(s);
            System.out.println("Case #" + (i+1) + ": " + sb.toString());
        }
    }
}