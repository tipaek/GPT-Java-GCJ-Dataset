
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            int n=Integer.parseInt(in.readLine());
            int arr[][]=new int[n][n];
            int row=0;
            boolean flag=false;
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<n;i++){
                StringTokenizer st=new StringTokenizer(in.readLine()," ");
                map=new HashMap<>();
                flag=false;
                for(int j=0;j<n;j++){
                    arr[i][j]=Integer.parseInt(st.nextToken());
                    if(map.containsKey(arr[i][j])  && !flag) {
                        row++;
                        flag=true;
                    }
                    else
                        map.put(arr[i][j],0);
                }
            }
            flag=false;
            int col=0;
            for(int i=0;i<n;i++) {
                flag=false;
                map=new HashMap<>();
                for (int j = 0; j < n; j++) {
                    if(map.containsKey(arr[j][i]) && !flag) {
                        col++;
                        flag=true;
                    }
                    else
                        map.put(arr[j][i],0);
                }
            }
            int sum=0;
            for(int i=0;i<n;i++)
                sum+=arr[i][i];
            System.out.println("Case #"+(t+1)+": "+sum+" "+row+" "+col);
        }
    }
}
