
import java.util.*;

class Vestigium{
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int tcase = in.nextInt();
        int loop=0;
        while(tcase!=0)
        {
            loop++;
            int k=0;
            int matorder = in.nextInt();
            int arr[][] = new int[matorder][matorder];
            for(int i=0 ; i<matorder ; i++){
                for(int j=0 ; j<matorder  ; j++){
                 arr[i][j] = in.nextInt();
                 if(i==j)
                 k+=arr[i][j];
                }
            }
            int row=0,col=0;
            for(int a=0 ; a<matorder ; a++){
                int dup1 = 0;
                for(int b=a ; b<matorder ; b++){
                  int num1 = arr[a][b];
                  for(int c=0 ; c<matorder ; c++){
                      for(int d=c ; d<matorder ; d++){
                          if(num1==arr[c][d])
                          dup1++;
                      }
                  }
                  
                }
                if (dup1!=0)
                    row++;
            }
            for(int s=0 ; s<matorder ; s++){
                int dup2 = 0;
                for(int t=s ; t<matorder ; t++){
                  int num2 = arr[t][s];
                  for(int u=0 ; u<matorder ; u++){
                      for(int v=u ; v<matorder ; v++){
                          if(num2==arr[v][u])
                          dup2++;
                      }
                  }
                  
                }
                if (dup2!=0)
                    col++;
            }
            System.out.print("Case #"+loop+": "+k+" "+row+" "+col);
            tcase--;
            }
        in.close();
        }
    }
