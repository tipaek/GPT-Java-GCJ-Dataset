import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args)throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.valueOf(br.readLine());

        for(int t=1;t<=T;t++){

            int n=Integer.valueOf(br.readLine());
            Integer[][] arr=new Integer[n][2];
            for(int i=0;i<n;i++){
                String[] temp=br.readLine().split(" ");
                int index=0;
                for(String s:temp)
                    arr[i][index++]=Integer.valueOf(s);
            }
            String result=getResult(arr);
            System.out.format("Case #%d: %s\n",t,result);
        }
        br.close();
    }
    public static String getResult(Integer[][] arr){
        StringBuilder result=new StringBuilder();
        ArrayList<Integer[]> c=new ArrayList<>();
        ArrayList<Integer[]> j=new ArrayList<>();

        for(Integer [] a:arr){

            if(check(c,a[0],a[1])){
                result.append('C');
            }else if(check(j,a[0],a[1])){
                result.append('J');
            }else
                return "IMPOSSIBLE";
        }

        return result.toString();
    }

    public static boolean check(ArrayList<Integer[]> list, int start, int end){
        for(int i=0;i<list.size();i++){
            Integer[] temp=list.get(i);
            if(start<=temp[0] && end<=temp[0]){
                continue;
            }else if(start>=temp[1]){
                continue;
            }else {
                return false;
            }
        }

        list.add(new Integer[]{start,end});
        return true;
    }
}
