import java.util.Scanner;
 
class Solution{  
    static Scanner scan = new Scanner(System.in);
    public static void main(final String args[]) {
        int T = scan.nextInt();
        String[] line = new String[T];
        
        for(int x=0; x<T; x++){
            line[x] = scan.next();
        }

        boolean open=false;
        for(int x=0; x<T; x++){
            open=false;
            System.out.print("Case #"+(x+1)+": "); 
            for(int i=0; i<line[x].length(); i++){
                char z=line[x].charAt(i);
                if(open==false && z=='1'){
                    open=true;
                    System.out.print("("+line[x].charAt(i));

                    if(i==line[x].length()-1)
                    System.out.print(")");
                }else if(open==true && line[x].charAt(i)=='0' ){
                    open=false;

                    System.out.print(")"+line[x].charAt(i));
                }else if( open==true && i==line[x].length()-1){
                    open=false;
                    System.out.print(line[x].charAt(i)+")");
                }
                // else if(close==true){

                // }
                else System.out.print(line[x].charAt(i));
            }
            System.out.print("\n");
        }
    }
}