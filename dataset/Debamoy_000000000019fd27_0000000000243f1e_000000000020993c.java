import java.util.*;
class Demo{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int test=0; 
        test=sc.nextInt();
        for(int t=1;t<=test;t++){
            boolean found=false;
            int value=0;
            int trace=0;
            int size=0;
            int rowcount=0,colcount=0;
            String[] inps;
            String[] row;
            String[] col;
            String[][]matrix;
            size=sc.nextInt();
            sc.nextLine();
            matrix=new String[size][size];
            //Arrays.fill(matrix,"0");
            for(int j=0;j<size;j++){
                //System.out.println("input "+j);
                inps=(sc.nextLine().split(" "));
                matrix[j]=inps;
            }
           for(int k=0;k<size;k++){
               trace+=Integer.parseInt(matrix[k][k]);
           }
           for(String[] rows:matrix) {
               for(String s:rows)
                   if(Collections.frequency(Arrays.asList(rows),s)>1) {
                       rowcount++;
                       break;
                   }
           }
           col=new String[size];
           for(int k=0;k<size;k++){
               for(int l=0;l<size;l++){
                   col[l]=matrix[l][k];
               }
               for(String s:col){
                   if(Collections.frequency(Arrays.asList(col),s)>1){
                       colcount++;
                       break;
                   }
               }
           }
           System.out.println("Case #"+t+": "+trace+" "+rowcount+" "+colcount);
        }
    }
}