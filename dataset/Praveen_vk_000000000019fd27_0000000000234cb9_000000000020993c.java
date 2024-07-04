import java.util.*;
class Main{
    public static void main(String arg[]){
        Scanner k=new Scanner(System.in);
        int tc;
        tc=k.nextInt();
        int ko=1;
        while(tc!=0){
        int rc;
        rc=k.nextInt();
        int t=0,r=0,c=0,ki=0,kk=0;
        int arr[][]=new int[rc][rc];
        for(int i=0;i<rc;i++){
            for(int j=0;j<rc;j++){
                arr[i][j]=k.nextInt();
                if(i==j)
                t=t+arr[i][j];
            }
        }
        for(int i=0;i<rc;i++){
            for(int j=0;j<rc;j++){
                for(int l=0;l<rc;l++){
                    if(arr[i][l]==arr[i][j] && l!=j)
                    kk++;
                }
                if(kk!=0)
                ki=1;
                kk=0;
                
            }
            if(ki==1)
            r++;
ki=0;
        }
        kk=0;
        ki=0;
        for(int i=0;i<rc;i++){
            for(int j=0;j<rc;j++){
                for(int l=0;l<rc;l++){
                    if(arr[l][i]==arr[j][i] && l!=j )
                    kk++;
                }
                if(kk!=0)
                ki=1;
                kk=0;
                
            }
            if(ki==1)
            c++;
	    ki=0;
        }
        System.out.println("Case #"+ko+": "+t+" "+r+" "+c);
        ko++;
	tc--;
        }
        
    }
}