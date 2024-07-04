import java.util.*;
class A{
    public static void main(String[] arg){
        
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int l=1;
        while(t-->0){
            int n=sc.nextInt();
            int[][] mat=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    mat[i][j]=sc.nextInt();
                }
            }
            int k=0;
            for(int i=0;i<n;i++){
                k=k+mat[i][i];
            }
            int rcount=0;
            int flag=0;
            
            for(int i=0;i<n-1;i++){
                
                for(int j=0;j<n-1;j++){
                    for(int ko=j+1;ko<n;ko++){
                        if(mat[i][j]==mat[i][ko]){
                            rcount++;
                            flag=1;
                            break;
                        }
                    }
                    if(flag==1){
                        flag=0;
                        break;
                    }
                }
                    
            }
            
            flag=0;
            int ccount=0;
            for(int i=0;i<n-1;i++){
                for(int j=0;j<n-1;j++){
                    for(int ko=j+1;ko<n;ko++){
                        if(mat[j][i]==mat[ko][j]){
                            ccount++;
                            flag=1;
                            break;
                        }
                    }
                    if(flag==1){
                        flag=0;
                        break;
                    }
                }
            }
            
            System.out.println("Case #"+l+": "+k+" "+rcount+" "+ccount);
            l++;            
        }
        
    }
        
        
    }

