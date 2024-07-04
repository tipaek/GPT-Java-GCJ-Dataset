import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class solution {
	public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine().trim());
        for(int t=1;t<=test;t++){
            int size=Integer.parseInt(br.readLine().trim());
            int[][] array=new int[size][size];
            for(int i=0;i<size;i++){
                String[] mark=br.readLine().split(" ");
                for(int j=0;j<size;j++) {
                	array[i][j]=Integer.parseInt(mark[j]);
                }
            }
            
            int k=0;
            for(int i=0;i<size;i++){
                k+=array[i][i];
            }
            int r=0;
            for(int i=0;i<size;i++){
                int[] type= new int[size];
                boolean ok=false;
                type[0]=array[i][0];              
                int pt=1;
                
                for(int j=1;j<size;j++){
                   for(int x=0;x<pt;x++) {
                	   if(array[i][j]==type[x]) {
                		   ok=true;
                		   r++;               		 
                		   break;
                	   }else if(x==pt-1){
                		   type[pt]=array[i][j];
                		   pt++;
                		   break;
                	   }
                   }
                   if(ok) break;
                }
            }
            int c=0;
            for(int i=0;i<size;i++){
                int[] type= new int[size];
                boolean ok=false;
                type[0]=array[0][i];              
                int pt=1;
                
                for(int j=1;j<size;j++){
                   for(int x=0;x<pt;x++) {
                	   if(array[j][i]==type[x]) {
                		   ok=true;
                		   c++;               		 
                		   break;
                	   }else if(x==pt-1){
                		   type[pt]=array[j][i];
                		   pt++;
                		   break;
                	   }
                   }
                   if(ok) break;
                }
            }    
            System.out.println("Case #"+t+": "+k+" "+r+" "+c);
        }
    }
}