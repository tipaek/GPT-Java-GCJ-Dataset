import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class KeyVal{
    String key;
    Integer val;

    public KeyVal(String key, Integer val) {
        this.key = key;
        this.val = val;
    }

    public KeyVal() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "{" +
                "key='" + key + '\'' +
                ", val=" + val +
                '}';
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            String s = in.next();
            String solution = solve(s);

            System.out.printf("Case #%d: %s\n", i,solution);
        }
    }

    private static String solve(String s) {
        List<KeyVal> keyVals = generateKeyVals(s);
//        System.out.println(keyVals);

        String res = recurse(keyVals);
        return res;

    }

    private static String recurse(List<KeyVal> keyVals) {
        String res="";
        List<KeyVal> group = new ArrayList<>();
        for (KeyVal keyVal:keyVals){
            if(keyVal.val==0){
                if(group.isEmpty()){
                    res+=keyVal.key;
                }else{
                    res+="("+recurse(group)+")"+keyVal.key;
                    group=new ArrayList<>();

                }
            }else{
                keyVal.setVal(keyVal.val-1);
                group.add(keyVal);
            }
        }
        if(!group.isEmpty()){
            res+="("+recurse(group)+")";
        }
        return res;
    }

    private static List<KeyVal> generateKeyVals(String s) {

        List<KeyVal> list = new ArrayList<>();
        String key="";
        for (int i=0; i<s.length();i++){
            if(key.isEmpty() || key.charAt(0)==s.charAt(i)){
                key+=s.charAt(i);
            }else{
                KeyVal keyVal = new KeyVal(key,Integer.parseInt(key.charAt(0)+""));
                list.add(keyVal);
                key=s.charAt(i)+"";
            }
        }
        if(!key.isEmpty()){
            KeyVal keyVal = new KeyVal(key,Integer.parseInt(key.charAt(0)+""));
            list.add(keyVal);
        }
        return list;
    }
}
