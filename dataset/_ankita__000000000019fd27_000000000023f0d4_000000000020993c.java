import java.util.*;
class A{
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] tr=new int[n];
        int [] r=new int[n];
        int [] c=new int[n];
        for(int i=0;i<n;i++){
            tr[i]=0;
            r[i]=0;
            c[i]=0;
            int n2=0;
            n2=s.nextInt();
            int arr[][]=new int[n2][n2];
            for(int k=0;k<n2;k++){
                for(int j=0;j<n2;j++){
                    arr[k][j]=s.nextInt();
                    if(k==j){
                        tr[i]=tr[i]+a[k][j];
                    }
                }
            }
            for(int g=0;g<n2;g++){
                int flag=0;
                for(int q=0;q<n2;q++){
                    int k=arr[g][q];
                    for(int p=q+1;p<n2;p++){
                        if(k==arr[g][p]){
                          flag=1;
                          r[i]=r[i]+1;
                          break;
                        }
                    }
                      if(flag==1){
                          break;
                      }  
                    
                }
                
            }
            for(int g=0;g<n2;g++){
                int flag=0;
                for(int q=0;q<n2;q++){
                    int k=arr[q][g];
                    for(int p=q+1;p<n2;p++){
                        if(k==arr[p][g]){
                          flag=1;
                          c[i]=c[i]+1;
                          break;
                        }
                    }
                      if(flag==1){
                          break;
                      }  
                    
                }
                
            }
            
        }
        for(int i=0;i<n;i++){
            System.out.println( "Case #"+(i+1)+":"+" "+tr[i]+" "+r[i]+" "+c[i]);
        }
    }
}