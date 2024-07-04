import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Parenting {
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
            String result=getResult(arr,new ArrayList<>(),new ArrayList<>(),0,"");
            if(result.length()!=arr.length)
                result="IMPOSSIBLE";
            System.out.format("Case #%d: %s",t,result);
            if(t<T) System.out.println();
        }
        br.close();
    }


    public static String getResult(Integer[][] arr, ArrayList<Integer[]>c,ArrayList<Integer[]>j, int index,String result){
        if(index==arr.length){
            return result;
        }

        if(check(c,arr[index])){
            ArrayList<Integer[]> tempC=new ArrayList<>();
            copy(c,tempC);
            tempC.add(new Integer[]{arr[index][0],arr[index][1]});
            String s=getResult(arr, tempC,j,index+1,result+'C');
            if(s.length()==arr.length) return s;
        }


        if(check(j,arr[index])){
            ArrayList<Integer[]> tempJ=new ArrayList<>();
            copy(j,tempJ);
            tempJ.add(new Integer[]{arr[index][0],arr[index][1]});
            String s=getResult(arr, c,tempJ,index+1,result+'J');
            if(s.length()==arr.length) return s;
        }

        return "";

    }
    public static void copy(ArrayList<Integer[]> from, ArrayList<Integer[]> to){
        for(Integer[] k:from)
            to.add(k.clone());
    }

    public static boolean check(ArrayList<Integer[]> list, Integer [] row){
        int start=row[0];
        int end=row[1];

        for(int i=0;i<list.size();i++){
            Integer[] temp=list.get(i);
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
