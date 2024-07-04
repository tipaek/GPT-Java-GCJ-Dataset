import java.util.Scanner;
// import java.io.*;

class Solution{
   	public static void main (String[] ar) throws Exception{
	  	//FileInputStream fi =new FileInputStream(ar[0]);
      	Scanner sc=new Scanner(System.in);
      	int T=sc.nextInt();
        sc.nextLine();
		for(int i=1;i<=T;i++){
			System.out.println("Case #"+i+": "+ans(sc.nextLine()));
		}
 	}

	static String ans(String line){
        String str = "";
        String[] arr = line.split("");
        int N = arr.length;
        int prev = 0;
        int curr = 0;
        for(int i =0 ; i< N ; i++){
             curr = Integer.parseInt(arr[i]);
             if(prev > curr){
                 str += paramFactory(')', prev-curr);
             } else if ( prev < curr ){
                 str += paramFactory('(', curr - prev);
             }
             str += curr;
             prev = curr;
        }
        str += paramFactory(')', prev);
        return str;
	}
    
    static String paramFactory(char type, int count){
        String str="";
        for(int i = 0 ; i< count ; i ++){
            str +=type;
        }
        return str;
    }
}