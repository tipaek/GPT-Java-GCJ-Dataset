import java.util.*;
import java.lang.*;
import java.io.*;

class MyEntry { 
    String foo;
    int number;
    
    public void setData(int c,String d){
       this.number=c;
       this.foo=d;
     }
}

class Solution{
	
	public static void main (String[] args) throws java.lang.Exception{
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 1;t<=test;t++){
		    int U = sc.nextInt();
		    MyEntry[] array = new MyEntry[10000];
		    for(int i = 0;i<10000;i++){
		        int i_int = sc.nextInt();
		        String i_str = sc.nextLine();
		        i_str = i_str.substring(1);
		        array[i].setData(i_int, i_str);
		    }
		    char [] map = new char[10];
		    for(int i = 1;i<10;i++){
		        for(int j = 0;j<10000;j++){
		            if(array[j].number == i){
		                boolean exists = false;
		                String cu = array[j].foo;
		                c = cu.toChar();
		                for(int k = 1;k<i;j++){
		                    if(map[k] == c){
		                        exists = true;
		                        break;
		                    }
		                }
		                if(exists == false){
		                    map[i] = c;
		                    break;
		                }
		            }
		        }
		    }
		    for(int i = 0;i<10000;i++){
		        String cu = array[i].foo;
		        boolean set = false;
		        for(int j = 1;j<cu.length();j++){
		            char c = cu.charAt(j);
		            boolean exists = false;
		            for(int k = 0;k<10;k++){
		                if(map[k] == c){
		                    exists = true;
		                    break;
		                }
		            }
		            if(!exists){
		                map[0] = c;
		                set = true;
		                break;
		            }
		        }
		        if(set){
		            break;
		        }
		    }
		    System.out.println("Case #"+ t + ": " + map.toString());
		}
	}
}
