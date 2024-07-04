import java.util.*;
import java.io.*;

class Solution{
    public static void main(String args[]) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int lin=1;
        String str="";
        while(lin++<=t){
            str="";
            int n=Integer.parseInt(br.readLine());
            int arr[][]=new int[n][n];
            int trace=0;
            int col_dup=0;
            int row_dup=0;

            for(int i=0;i<n;i++){
                String str[]=br.readLine().split(" ");
                HashSet<String> st=new HashSet<String>(Arrays.asList(str));
                if(st.size()!=n)
                row_dup++;

                for(int j=0;j<n;j++){
                    arr[i][j]=Integer.parseInt(str[j]);
                    if(i==j){
                        trace+=arr[i][j];
                    }
                }

            }
                            for(int m=0;m<n;m++){
			                    HashSet<Integer> st1=new HashSet<Integer>();
			                    for(int o=0;o<n;o++){
			                        st1.add(arr[o][m]);
			                    }
			                    if(st1.size()!=n)
			                    col_dup++;
                }
            str+="\nCase #"+t+": "+trace+" "+row_dup+" "+col_dup;
        }
        System.out.print(str);
        
    }
    

}