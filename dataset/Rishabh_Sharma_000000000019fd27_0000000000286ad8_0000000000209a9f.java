import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = rint(br.readLine());
        int ca=1;
        while (t-- > 0) {
         int arr[]=rintArr(br.readLine());
         StringBuilder ans=new StringBuilder();
         for(int i:arr){
             String add="";
             for(int j=0;j<i;j++){
                 add=add+"(";
             }
             add=add+i;
             for(int j=0;j<i;j++){
                 add=add+")";
             }
             ans.append(add);
         }
         Deque<String > ff=new ArrayDeque<>();
         for(String dd:ans.toString().split("")){
             ff.addLast(dd);
             if(ff.size()>=2){
                 String aaa=ff.pollLast();
                 String ccc=ff.pollLast();
                 if(aaa.equals("(")&&ccc.equals(")")){
                     continue;
                 }
                 else{
                     ff.addLast(ccc);
                     ff.addLast(aaa);
                 }

             }
         }
            String pr="";
            for(String df:ff){
                pr=pr+df;
            }
            System.out.println("Case #"+ca++ +": "+pr);



        }
    }


    static int[] rintArr(String st) {//returns whole  String as array
        int[] rett;
        rett = Arrays.stream(st.split("")).mapToInt(Integer::parseInt).toArray();
        return rett;
    }

    static int rint(String gg) {//returns just one integer
        return Integer.parseInt(gg);
    }

    static long rlong(String gg) {
        return Long.parseLong(gg);
    }

    static int rint(String[] vv, int d) {
        return Integer.parseInt(vv[d]);
    }

    static void swap(int oneTwo, int twoOne) {
        int sw = oneTwo;
        oneTwo = twoOne;
        twoOne = sw;
    }

}











