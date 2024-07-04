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
            boolean flag=false;
            for(int i=0;i<c.size();i++){
                Integer[] temp=c.get(i);
                if(a[0]<=temp[0]&&a[1]<=temp[0]) continue;
                else if(a[0]>=temp[1]) continue;
                else{
                    flag=true;
                    break;
                }

            }
            if(!flag){
                c.add(a.clone());
                result.append("C");
                continue;
            }
            flag=false;
            for(int i=0;i<j.size();i++){
                Integer[] temp=j.get(i);
                if(a[0]<=temp[0]&&a[1]<=temp[0]) continue;
                else if(a[0]>=temp[1]) continue;
                else{
                    flag=true;
                    break;
                }

            }
            if(!flag){
                j.add(a.clone());
                result.append("J");
                continue;
            }else
                return "IMPOSSIBLE";
        }

        return result.toString();
    }
}
