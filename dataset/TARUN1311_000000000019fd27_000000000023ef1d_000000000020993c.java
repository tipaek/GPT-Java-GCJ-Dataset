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
            boolean[] row = new boolean[n];
            boolean[] col = new boolean[n];
            int rowcnt=0,colcnt=0;
            boolean r=false,c=false;
            for(int i=0;i<n;i++){
                r=false;
                c=false;
                for(int j=0;j<n;j++){
                    if(r==false){
                        if(row[arr[i][j]-1]==false)
                            row[arr[i][j]-1]=true;
                        else{
                            rowcnt++;
                            r=true;
                        }
                    }
                    if(c==false){
                        if(col[arr[j][i]-1]==false)
                            col[arr[j][i]-1]=true;
                        else{
                            colcnt++;
                            c=true;
                        }
                    }
                    if(r==true && c==true)
                        break;
                }
                row=new boolean[n];
                col=new boolean[n];
            }
            System.out.println("Case #"+test+": "+res+" "+rowcnt+" "+colcnt);
        }
    }
}