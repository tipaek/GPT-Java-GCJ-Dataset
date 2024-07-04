import java.util.*;
class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int k=0;k<test;k++){
            int n,count=0,sum=0;
            n = sc.nextInt();
            
            int[][] arr = new int[n][n];
            
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i==j){
                        sum+=arr[i][j];
                    }
                }
            }
            list.add(sum);
            
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    int row = arr[i][j];
                    for(int l=j+1;l<n;l++){
                        if(row==arr[i][l]){
                            count++;
                            break;
                        }
                    }
                    break;
                }
            }
            list.add(count);
            
            count=0;
            
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    int col = arr[j][i];
                    for(int l=j+1;l<n;l++){
                        if(col==arr[l][i]){
                            count++;
                            break;
                        }
                    }
                    break;
                }
            }
            if(n%2==0)
                list.add(count);
            else
                list.add(count+1);
        }
        
        int number = 1;
        
        for(int i=0;i<(test*3)-2;i+=3){
            System.out.print("Case #"+number+": "+list.get(i)+" "+list.get(i+1)+" "+list.get(i+2));
            System.out.println("");
            number++;
        }
        
    }
}