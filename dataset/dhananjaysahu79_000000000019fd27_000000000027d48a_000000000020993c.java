import java.util.*;
class matrixsquare{
    public static void main(String args[]){
        try{
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int v=t;
        while(t-->0){
            int n=s.nextInt();
            int matrix[][]=new int[n][n];
            int row_counter=0;
            int column_counter=0;
            for(int i=0;i<n;i++){
               for(int j=0;j<n;j++){
                   matrix[i][j]=s.nextInt();
               }
               
            }
            //row checking
            for(int i=0;i<n;i++){
                List<Integer> visited=new ArrayList<Integer>();
                visited.add(matrix[i][0]);
               for(int j=1;j<n;j++){
                   if(visited.contains(matrix[i][j])){
                     row_counter++;
                     break;
                   }
                    else{
                       visited.add(matrix[i][j]);
                   }
               }
            }
            //column checking
            for(int i=0;i<n;i++){
                List<Integer> visited=new ArrayList<Integer>();
                visited.add(matrix[0][i]);
               for(int j=1;j<n;j++){
                   if(visited.contains(matrix[j][i])){
                     column_counter++;
                     break;
                   }
                    else{
                       visited.add(matrix[i][j]);
                   }
               }
            }
            //diagonal checking
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=matrix[i][i];
            }
            System.out.println("Case #"+(v-t)+": "+sum+" "+row_counter+" "+column_counter);
        }
        }catch(Exception e){
            
        }
    }
}