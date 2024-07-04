import java.util.Scanner;
class Solution{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int testcase=sc.nextInt();
        for(int test=1;test<=testcase;test++){
            int n=sc.nextInt();
            int[][] arr=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=sc.nextInt();
                }
            }
            int res=0;
            for(int i=0;i<n;i++){
                res+=arr[i][i];
            }
            int[] row = new int[n];
            int[] col = new int[n];
            int rowcnt=0,colcnt=0;
            boolean r=false,c=false;
            for(int i=0;i<n;i++){
                r=false;
                c=false;
                for(int j=0;j<n;j++){
                    if(r==false){
                        if(row[j]==0)
                            row[j]=arr[i][j];
                        else{
                            rowcnt++;
                            row=new int[n];
                            r=true;
                        }
                    }
                    if(c==false){
                        if(col[j]==0)
                            col[j]=arr[j][i];
                        else{
                            colcnt++;
                            col=new int[n];
                            c=true;
                        }
                    }
                    if(r==true && c==true)
                        break;
                }
            }
            System.out.println("Case #"+test+": "+res+" "+rowcnt+" "+colcnt);
        }
    }
}