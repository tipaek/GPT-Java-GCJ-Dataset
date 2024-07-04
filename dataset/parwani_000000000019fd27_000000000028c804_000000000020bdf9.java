import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static void main(String args[]) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int test = Integer.parseInt(br.readLine());
            for(int t=0;t<test;t++) {

                int n = Integer.parseInt(br.readLine());
                ArrayList<Pair> pairs = new ArrayList<>();
                for(int i=0;i<n;i++) {
                    String line[] = br.readLine().trim().split("\\s+");
                    Pair pair = new Pair(Integer.parseInt(line[0]),Integer.parseInt(line[1]),i);
                    pairs.add(pair);
                }
                Collections.sort(pairs, new Comparator<Pair>() {
                    @Override
                    public int compare(Pair o, Pair t1) {
                        if(o.b > t1.b) {
                            return 1;
                        } else if (o.b < t1.b){
                            return -1;
                        } else {
                            if(o.a > t1.a) {
                                return 1;
                            } else {
                                return -1;
                            }
                        }
                    }
                });
                System.out.println("Case #"+(t+1)+": "+divideActivities(pairs,n));
            }
        }
        catch (Exception e){

        }
    }
    public static String divideActivities(ArrayList<Pair> pairs , int n) {
        Map<String , Pair> map = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<n;i++) {

            Pair j= map.get("J");
            Pair c= map.get("C");

            if(j==null && c==null) {
                map.put("J",pairs.get(i));
                sb.append("J");
            }
            else if (j==null) {
                map.put("J",pairs.get(i));
                sb.append("J");
            }
            else if(c==null) {
                map.put("C",pairs.get(i));
                sb.append("C");
            }
            else {
                Pair temp =  pairs.get(i);
                if(temp.a >= j.b) {
                    map.replace("J",pairs.get(i));
                    sb.append("J");
                }
                else if(temp.a >= c.b) {
                    map.replace("C" , pairs.get(i));
                    sb.append("C");
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }
        String arr[] = new String[pairs.size()];
        for(int i=0;i<pairs.size();i++) {
            int position =  pairs.get(i).pos;
            arr[position] = String.valueOf(sb.charAt(i));
        }
        String result = "";
        for(int i=0;i<arr.length;i++) {
            result+=arr[i];
        }

        return result;
    }

}
class Pair{
    int a;
    int b;
    int pos;
    Pair(int a,int b,int pos) {
        this.a=a;
        this.b=b;
        this.pos=pos;
    }
}