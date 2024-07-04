import java.util.Scanner;
import java.util.Arrays;
class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int l=0;l<t;l++){
            int n=sc.nextInt();
            int jamie[]=new int[1440];
            int cameron[]=new int[1440];
            Arrays.fill(jamie,0);
            Arrays.fill(cameron,0);
            String str="";
            for(int i=0;i<n;i++){
                int s=sc.nextInt();
                int e=sc.nextInt();
                if(str.equals("IMPOSSIBLE"))continue;
                boolean flag=true;
                for(int j=s;j<e;j++){
                    if(jamie[j]==1){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    for(int j=s;j<e;j++)
                        jamie[j]=1;
                    str=str+"J";
                }
                else{
                    flag=true;
                    for(int j=s;j<e;j++){
                        if(cameron[j]==1){
                            flag=false;
                            break;
                        }
                    }
                    if(flag){
                        for(int j=s;j<e;j++)
                            cameron[j]=1;
                        str=str+"C";
                    }
                    else{
                        str="IMPOSSIBLE";
                    }
                }
            }
            System.out.println("Case #"+(l+1)+": "+str);
        }
    }
}