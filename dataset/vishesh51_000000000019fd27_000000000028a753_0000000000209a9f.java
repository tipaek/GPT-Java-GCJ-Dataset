import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int k=0;
        while(t-->0){
            k++;
            String str=sc.next();
            String sol=str;
            char arr[]=str.toCharArray();
            int n=arr.length;
            int count=0;
            int initcount = arr[0]-'0';
            for(int i=0;i<initcount;i++){
                str="("+str;
                count++;
            }
            int i=0;
            for( i=1;i<n;i++){
                int val=arr[i]-'0';
                //System.out.println(val+" "+initcount+" "+count);
                if(val==initcount) continue;
                else if(val>initcount){
                    for(int j=0;j<(val-initcount);j++){
                        str=str.substring(0,count+i)+"("+str.substring(count+i,n+count);
                        //str="("+str;
                        count++;
                    }
                    initcount=val;
                }
                else if(val<initcount){
                    for(int j=0;j<(initcount-val);j++){
                        //str+=")";
                        str=str.substring(0,count+i)+")"+str.substring(count+i,n+count);
                        //str="("+str;
                        count++;
                    }
                    initcount=val;
                }
            }
            if(i==n){
                for(int j=0;j<initcount;j++){
                    str+=")";
                }
            }
            System.out.println("Case #"+k+": "+str);
        }
    }
}