import java.util.*;
class First{
    public static void vesti(int m[][], int number){
        
        int dia_sum=0;
        int maximum1=0, maximum2=0, ma=0,  mb=0;
        for(int i=0;i<number;i++){
            int c1_a[]=new int[number+1];
            int c2_a[]=new int[number+1];
            for(int j=0;j<number;j++){
                if(i==j){
                    dia_sum+=m[i][j];
                }
                c1_a[m[i][j]]++;
                c2_a[m[j][i]]++;
                if(c1_a[m[i][j]]==2 && ma==maximum1){
                    maximum1++;
                }
                if(c2_a[m[j][i]]==2 && mb==maximum2){
                    maximum2++;
                }
            }
            ma=maximum1; mb=maximum2;
        }
        
        System.out.println(dia_sum+" "+maximum1+" "+maximum2);
    }
    
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int T= sc.nextInt();
        for(int t=1;t<=T;t++){
            int N= sc.nextInt();
            int ma[][]= new int[N][N];
            
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    ma[i][j]=sc.nextInt();
                }
            }
            System.out.print("Case #"+t+": ");
            vesti(ma,N);
            
        }
    }
}