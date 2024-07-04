import java.lang.*;
import java.util.*;
import java.io.*;



public class Parenting{

    public class TMPair{
	public int start;
	public int end;
    }

    public class TMComparator<TMPair>{
	public int compare(TMPair tmp1, TMPair tmp2){
	    int retV = 0;
	    if(tmp1.start<tmp2.start){
		retV = -1;
	    }else if(tmp1.start==tmp2.start){
		if(tmp1.end<tmp2.end){
		    retV = -1;
		}else if(tmp1.end>tmp2.end){
		    retV = 1;
		}
	    }else{
		retV = 1;
	    }
	    return retV;
	}
    }

    
    static Integer[]strToIntArr(String s){
	//	s = s.substring(1,s.length()-1);
	//	String[] sArr = s.split(",");
	String[] sArr = s.split(" ");	
	int len = sArr.length;
	Integer[] retArr = new Integer[len];
	for(int i=0;i<len;i++){
	    retArr[i] = Integer.parseInt(sArr[i]);
	}
	return retArr;
    }



    public static void main(String[]args) throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	String tLn = br.readLine();
	int t = Integer.parseInt(tLn);
    }

}
