import java.util.Scanner;
import java.util.Arrays;
class Solution{
    public static void main(String arsgs[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int l=0;l<t;l++){
            int n=sc.nextInt();
            int jamie[][]=new int[n][2];
            int cameron[][]=new int[n][2];
            int j=0,c=0;
            int arr[][]=new int[n][2];
            String str="";
            for(int i=0;i<n;i++){
                arr[i][0]=sc.nextInt();
                arr[i][1]=sc.nextInt();
            }
            jamie[0][0]=arr[0][0];
            jamie[0][1]=arr[0][1];
            j++;
            str=str+"J";
            str=evaluate(jamie,cameron,n,1,arr,str,j,c);
            System.out.println("Case #"+(l+1)+": "+str);
        }
    }

    static String evaluate(int jamie[][],int cameron[][],int n,int start,int arr[][],String str,int ja,int ca){
        outer:
        for(int i=start;i<n;i++){
            int s=arr[i][0];
            int e=arr[i][1];
            boolean fj=available(jamie,s,e,ja),fc=available(cameron,s,e,ca);
            if(fj&&!fc){
                jamie[ja][0]=s;
                jamie[ja++][1]=e;
                str=str+"J";
            }
            else if(fc&&!fj){
                cameron[ca][0]=s;
                cameron[ca++][1]=e;
                str=str+"C";
            }
            else if(fj&&fc){
                jamie[ja][0]=s;
                jamie[ja++][1]=e;
                String str1=str+"J";
                str1=evaluate(jamie,cameron,n,i+1,arr,str1,ja,ca);
                cameron[ca][0]=s;
                cameron[ca++][1]=e;
                jamie[--ja][0]=0;
                jamie[ja][1]=0;
                String str2=str+"C";
                str2=evaluate(jamie,cameron,n,i+1,arr,str2,ja,ca);
                if(str1.equals("IMPOSSIBLE")){
                    if(str2.equals("IMPOSSIBLE"))
                        str=str1;
                    else 
                        str=str2;
                }
                else str=str1;
                break outer;
            }
            else{
                str="IMPOSSIBLE";break outer;
            }
        }
        return str;
    }

    static boolean available(int arr[][],int s,int e,int n){
        for(int i=0;i<n;i++){
            if(s<=arr[i][0]&&e>arr[i][0])return false;
            if(s>=arr[i][0]&&e<arr[i][1])return false;
            if(s<arr[i][1]&&e>=arr[i][1])return false;
        }
        return true;
    }

}