import java.util.*;
class Solution{
    public static void main(String as[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int r=0,c=0,trace=0,dr=0,dc=0,rf=0,cf=0;
            int a[][]=new int[n][n];
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    a[j][k]=sc.nextInt();
                }
            }
            int temp[]=new int[n];
            for(int j=0;j<n*n;j++){
                c=j%n;
                if(j!=0 && c==0){
                    r++;
                    if(rf==1){
                        dr++;
                    }
                    rf=0;
                }
                cf=0;
                
                if(r==c){
                    trace+=a[r][c];
                    if(c!=0 && rf==0){
                        int x=c-1;
                        while(x>=0){
                            if((a[r][c]==a[r][x])){
                                rf=1;
                                break;
                            }
                            x--;
                        }
                        
                    }if(r!=0){
                        int x=r-1;
                        while(x>=0){
                            if((a[r][c]==a[x][c])){
                                cf=1;
                                break;
                            }
                            x--;
                        }
                    }
                }else{
                    if(c!=0 && rf==0){
                        int x=c-1;
                        while(x>=0){
                            if((a[r][c]==a[r][x])){
                                rf=1;
                                break;
                            }
                            x--;
                        }
                        
                    }if(r!=0){
                        int x=r-1;
                        while(x>=0){
                            if((a[r][c]==a[x][c])){
                                cf=1;
                                break;
                            }
                            x--;
                        }
                    }
                }
                if(cf==1){
                    temp[c]=1;
                }
            }
            if(rf==1){
                dr++;
            }
            for(int x:temp){
                dc+=x;
            }
            System.out.println("Case #"+(i+1)+": "+trace+" "+dr+" "+dc);
        }
    }
}