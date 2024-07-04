import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new PrintStream(System.out));
        int t=Integer.parseInt(f.readLine());
        t:
        for(int i=0;i<t;i++){
            out.print("Case #"+(i+1)+": ");
            StringTokenizer st=new StringTokenizer(f.readLine());
            int n=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            long[]arr=new long[n];
            st=new StringTokenizer(f.readLine());
            for(int j=0;j<n;j++){
                arr[j]=Long.parseLong(st.nextToken());
            }
            if(d==2){
                for(int j=0;j<n;j++){
                    for(int k=j+1;k<n;k++){
                        if(arr[j]==arr[k]){
                            out.println(0);
                            continue t;
                        }
                    }
                }
                out.println(1);
            }
            else{
                int same=0;
                long max=0;
                long min=99999999999999l;
                long samemin=999999999999999l;
                boolean workfs=false;

                for(int j=0;j<n;j++){
                    min=Math.min(min,arr[j]);
                    max=Math.max(max,arr[j]);
                    for(int k=j+1;k<n;k++){
                        if(arr[j]/2.0==(double)arr[k] || arr[k]/2.0==(double)arr[j]){
                            workfs=true;
                        }
                        if(arr[j]==arr[k]){
                            same++;
                            samemin=Math.min(samemin,arr[j]);
                        }
                        for(int p=k+1;p<n;p++){
                            if(arr[j]==arr[k] && arr[k]==arr[p]){
                                out.println(0);
                                continue t;
                            }
                        }

                    }
                }

//                if((n==2 && max-min<min)){
//                    out.println(3);
//                }
//                else
                if((same>0 && max>samemin) || workfs){
                    out.println(1);
                }
                //n==3, n==1, can always be done in 2,
                else{
                    out.println(2);
                }

            }

        }
        f.close();
        out.close();
    }
}