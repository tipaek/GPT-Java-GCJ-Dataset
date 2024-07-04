import java.util.Scanner;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testcase=sc.nextInt();
        for(int test=1;test<=testcase;test++){
            int n=sc.nextInt();
            int[][] arr = new int[n][2];
            for(int i=0;i<n;i++){
                arr[i][0]=sc.nextInt();
                arr[i][1]=sc.nextInt();
            }
            int[] a = new int[n];
            for(int i=0;i<n;i++)
                a[i]=i;
            for(int i=0;i<n-1;i++){
                for(int j=i+1;j<n;j++){
                    if(arr[i][0]>arr[j][0]){
                        int temp=arr[i][0];
                        arr[i][0]=arr[j][0];
                        arr[j][0]=temp;
                        temp=arr[i][1];
                        arr[i][1]=arr[j][1];
                        arr[j][1]=temp;
                        temp=a[i];
                        a[i]=a[j];
                        a[j]=temp;
                    }else if(arr[i][0]==arr[j][0]){
                        if(arr[i][1]>arr[j][1]){
                            int temp=arr[i][0];
                            arr[i][0]=arr[j][0];
                            arr[j][0]=temp;
                            temp=arr[i][1];
                            arr[i][1]=arr[j][1];
                            arr[j][1]=temp;
                            temp=a[i];
                            a[i]=a[j];
                            a[j]=temp;
                        }
                    }
                }
            }
            String res="";
            char[] ch=new char[n];
            boolean result=false;
            // boolean j=false;
            int cend=0;
            int jend=0;
            for(int i=0;i<n;i++){
                if(arr[i][0]>=cend){
                    ch[a[i]]='C';
                    cend=arr[i][1];
                }else if(arr[i][0]>=jend){
                    ch[a[i]]='J';
                    jend=arr[i][1];
                }else{
                    result=true;
                    break;
                }
            }
            if(result==true)
                res="IMPOSSIBLE";
            else{
                for(int i=0;i<n;i++)
                    res+=ch[i];
            }
            System.out.println("Case #"+test+" :"+res);
        }
    }
}