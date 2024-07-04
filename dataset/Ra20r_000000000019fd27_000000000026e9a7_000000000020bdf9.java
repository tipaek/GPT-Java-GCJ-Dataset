
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws IOException{
        process();
    }
    public static void process() throws IOException{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(in.readLine());
        for(int t=0;t<T;t++){
            boolean flag=true;
            int C_b=-1;
            int J_b=-1;
            String ans="";
            int n=Integer.parseInt(in.readLine());
            int arr[]=new int[n];
            char ch[]=new char[n];
            HashMap<Integer,Integer[]> map=new HashMap<>();
            for(int i=0;i<n;i++){
                StringTokenizer st=new StringTokenizer(in.readLine()," ");
                arr[i]=Integer.parseInt(st.nextToken());
                Integer y[]={Integer.parseInt(st.nextToken()),i};
                map.put(arr[i],y);
            }
            Arrays.sort(arr);
            for(int i=0;i<n;i++){
                int start=arr[i];
                Integer y[]=map.get(arr[i]);
                int end=y[0];
                if(!flag)
                    break;
                if(start>=C_b){
                    ch[y[1]]='C';
                    C_b=end;
                }
                else if(start>=J_b){
                    ch[y[1]]='J';
                    J_b=end;
                }
                else{
                    ans="IMPOSSIBLE";
                    flag=false;
                }
            }
            if(flag)
                ans=String.valueOf(ch);
            System.out.println("Case #"+(t+1)+": "+ans);
        }
    }
}
