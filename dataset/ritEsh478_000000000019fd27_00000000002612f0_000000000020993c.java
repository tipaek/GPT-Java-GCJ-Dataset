import java.util.*;
import java.io.*;

class Sol{
    public static void main(String args[]){
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int lin=1;
        while(lin<=t){
            int n=Integer.parseInt(br.readLine());
            int arr[][]=new int[n][n];
            int trace=0;
            int col_dup=0;
            int row_dup=0;
            
            for(int i=0;i<n;i++){
                String str[]=br.readLine().splt(" ");
                TreeSet<String> st=new TreeSet<>(str);    
                if(st.size()!=n)
                row_dup++;
                
                for(int j=0;j<n;j++){
                    arr[i][j]=Integer.parseInt(str[j]);
                    if(i==j){
                        s+=arr[i][j];
                    }
                }
                
                for(int i=0;i<n;i++){
                    TreeSet<Integer> st=new TreeSet<>();
                    for(int j=0;j<n;j++){
                        st.add(arr[j][i]);
                    }
                    if(st.size()!=n)
                    col_dup++;
                }
            }
            System.out.print("Case #"+t+" "+trace+" "+row_dup+" "+col_dup);
        }
    }

}