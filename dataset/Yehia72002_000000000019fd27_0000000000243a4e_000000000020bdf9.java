import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
static boolean ifEmpty(int arr[] , int from , int to){
		for(int  i = from ; i < to ; i++){
			if(arr[i]!=0)
				return false;
			else continue;
		}
		return true;
	}
	static void fill(int arr[] , int from , int to ){
		for(int  i = from ; i < to ; i++){
			arr[i]= i;
		}
	}
	static boolean contains(char []arr){
		for(int i = 0 ; i < arr.length ; i++){
			if(arr[i]=='I')
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases=in.nextInt();
		String ans= "";
		int counter=0;
		LinkedList<Character> l = new LinkedList<Character>(); 
		while(cases-->0){
			counter++;
			int act = in.nextInt();
			int c[] = new int[1441];
			int j[] = new int[1441];
			char answercase[] = new char[act] ;
			for(int i = 0 ; i < act ; i++){
				int from = in.nextInt();
				int to = in.nextInt();
				if(counter==1){
					if(ifEmpty(c , from ,to)){
						answercase[i]='C';
						fill(c,from,to);}
					else if(ifEmpty(j , from ,to)){
						answercase[i]='J';
						fill(j,from,to);}
					else {
						answercase[i]='I';
				}}
				if(counter>1){
				if(l.getLast()=='J'){
					if(ifEmpty(c , from ,to)){
						answercase[i]='C';
						fill(c,from,to);}
					else if(ifEmpty(j , from ,to)){
						answercase[i]='J';
						fill(j,from,to);}
					else {
						answercase[i]='I';
				}}
				
				else{
					if(ifEmpty(j , from ,to)){
						answercase[i]='J';
						fill(j,from,to);}
					else if(ifEmpty(c , from ,to)){
						answercase[i]='C';
						fill(c,from,to);}
					else {
						answercase[i]='I';
				}
				}}
				
			}
			ans+="Case #"+counter+": ";
			if(contains(answercase)){
				ans+="IMPOSSIBLE";
			}
			else{
				for(int i = 0 ; i < answercase.length ; i++){
					ans+=answercase[i];
					l.add(answercase[i]);
				}
			}
			if(act-1>1)
			ans+="\n";
		}
		
		System.out.print(ans);
		
	}

}
