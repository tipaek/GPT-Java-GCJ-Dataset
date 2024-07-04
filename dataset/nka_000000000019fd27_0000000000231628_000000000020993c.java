import java.util.Scanner;

public class Solution {

    public static void main(String args[])  {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        //String output="";
        int x=1;
        //FileWriter fw=new FileWriter(new File("src/output.txt"));

        while(T>0){
            int n=sc.nextInt();
            int trace=0;
            int rowCount=0;
            int columnCount=0;
            int[][] nums=new int[n][n];
            for(int i=0;i<n;i++){
                int[] duplicateCount=new int[n+1];
                boolean flag=true;
                for(int j=0;j<n;j++){
                    nums[i][j]=sc.nextInt();
                    if(i==j){
                        trace+=nums[i][j];
                    }
                    if(flag && duplicateCount[nums[i][j]]!=0){
                        rowCount+=1;
                        flag=false;
                    }
                    duplicateCount[nums[i][j]]+=1;
                }
            }
            for(int i=0;i<n;i++){
                int[] duplicateCount=new int[n+1];
                for(int j=0;j<n;j++){
                    if(duplicateCount[nums[j][i]]!=0){
                        columnCount+=1;
                        break;
                    }
                    duplicateCount[nums[j][i]]+=1;
                }
            }
            int sqrtTrance=(int)Math.sqrt(trace);
            if(sqrtTrance*sqrtTrance!=trace){
                trace=0;
            }
            System.out.println("Case #"+x+": "+trace+" "+rowCount+" "+columnCount);
            //output="case #"+x+":"+trace+" "+rowCount+" "+columnCount+"\n";
            x++;
            T--;
        }
        //fw.write(output);
        //fw.close();
        sc.close();
    }
}