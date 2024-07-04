import java.io.*;
import java.util.*;

class Solution{
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new PrintStream(System.out));

        int t=Integer.parseInt(in.readLine());
        for(int test=0;test<t;test++){
            int n=Integer.parseInt(in.readLine());
            int[][]data=new int[n][n];
            for(int i=0;i<n;i++){
                StringTokenizer st=new StringTokenizer(in.readLine());
                for(int j=0;j<n;j++){
                    data[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            int ans=0;
            for(int i=0;i<n;i++){
                ans+=data[i][i];
            }
            int row=0,col=0;
            for(int i=0;i<n;i++){
                boolean worksRow=false;
                boolean worksCol=false;
                for(int j=0;j<n;j++){
                    for(int k=0;k<j;k++){
                        if(data[i][j]==data[i][k]){
                            worksRow=true;
                            break;
                        }
                    }
                    for(int k=0;k<j;k++){
                        if(data[k][i]==data[j][i]){
                            worksCol=true;
                            break;
                        }
                    }
                }
                if(worksRow)row++;
                if(worksCol)col++;

            }
            out.println("Case #"+(test+1)+": "+ans+" "+row+" "+col);

        }


        in.close();
        out.close();
    }
}