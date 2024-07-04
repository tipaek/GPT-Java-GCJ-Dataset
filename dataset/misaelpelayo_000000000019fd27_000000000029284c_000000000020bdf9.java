import java.util.Scanner;

public class Solution {
    

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int l=0;l<t;l++){
            System.out.print("Case #"+(l+1)+": ");
            int N=s.nextInt();
            int[][] in=new int [N][2];
            int[] per=new int[N];
            int[] letras= new int [N];
            for(int i=0;i<N;i++){
                in[i][0]=s.nextInt();
                in[i][1]=s.nextInt();
            }
            int min,indmin;
            for(int i=0;i<N;i++){
                min=in[i][0];
                indmin=i;
                for(int j=0;j<N;j++){
                    if(in[j][0]<min){
                        indmin=j;
                        min=in[j][0];
                    }
                }
                in[indmin][0]=in[indmin][0]+24*60;
                per[i]=indmin;
            }
            for(int i=0;i<N;i++){
                    in[i][0]=in[i][0]%(24*60);
            }
            boolean b=true;
            for(int i=0;i<N-2;i++){
                if((in[per[i]][1]>in[per[i+2]][0]) &&(in[per[i+1]][1]>in[per[i+2]][0])){
                    b=false;
                    break;
                }
            }
            if(b==false){
                System.out.print("IMPOSSIBLE");
            }
            else{
                for(int i=0;i<N-1;i++){
                    if(letras[i]==0) letras[i]=1;
                    for(int j=i+1;j<N;j++){
                        if(in[per[i]][1]>in[per[j]][0]){
                            if(letras[i]==1) letras[j]=2;
                            else letras[j]=1;
                        }
                    }    
                }
            
                for(int i=0;i<N;i++){
                    if(letras[i]==1) System.out.print("J");
                    else System.out.print("C");
                }
               
            }
                System.out.println();
                
        }
        
    }
    
}

