import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int c=0;
        while(c<t){
            c++;
            int n=sc.nextInt();
            StringBuilder ans=new StringBuilder();
            int[][] arr=new int[n][2];
            boolean flag=true;
            for(int i=0;i<n;i++){
                arr[i][0]=sc.nextInt();
                arr[i][1]=sc.nextInt();
            }
            boolean[] C=new boolean[1442];
            boolean[] J=new boolean[1442];
            for(int i=0;i<n;i++){
                flag=true;
                int start=arr[i][0];
                int end=arr[i][1];
                for(int j=start;j<end;j++){
                    if(C[j]==false)
                    continue;
                    flag=false;
                    break;
                }
                if(flag==true){
                    ans.append("C");
                    for(int j=start;j<end;j++){
                        C[j]=true;
                    }
                }
                else{
                    flag=true;
                    for(int j=start;j<end;j++){
                        if(J[j]==false)
                        continue;
                        flag=false;
                        break;
                    }
                    if(flag==true){
                        ans.append("J");
                        for(int j=start;j<end;j++){
                            J[j]=true;
                        }
                    }
                    else{
                        ans=null;
                        break;
                    }   
                }
            }
            if(ans==null)
            System.out.println("Case #"+c+": IMPOSSIBLE");
            else
            System.out.println("Case #"+c+": "+ans.toString());
        }
    }
}