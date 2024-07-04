import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Solution{
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
            String result=getResult(arr,new HashSet<>(),new HashSet<>(),0,"");
            if(result.length()!=arr.length)
                result="IMPOSSIBLE";
            System.out.format("Case #%d: %s",t,result);
            if(t<T) System.out.println();
        }
        br.close();
    }


    public static String getResult(Integer[][] arr, HashSet<Integer[]> c, HashSet<Integer[]> j, int index, String result){
        if(index==arr.length){
            return result;
        }

        if(check(c,arr[index])){
            Integer[] temp=new Integer[]{arr[index][0],arr[index][1]};
            c.add(temp);
            String s=getResult(arr, c,j,index+1,result+'C');
            c.remove(temp);
            if(s.length()==arr.length) return s;
        }


        if(check(j,arr[index])){
            Integer[] temp=new Integer[]{arr[index][0],arr[index][1]};
            j.add(temp);
            String s=getResult(arr, c,j,index+1,result+'J');
            j.remove(temp);
            if(s.length()==arr.length) return s;
        }

        return "";

    }

    public static boolean check(HashSet<Integer[]> list, Integer [] row){
        int start=row[0];
        int end=row[1];

        for(Integer[] temp:list){
            if(start<=temp[0] && end<=temp[0]){
                continue;
            }else if(start>=temp[1]){
                continue;
            }else
                return false;

        }

        return true;
    }
}
