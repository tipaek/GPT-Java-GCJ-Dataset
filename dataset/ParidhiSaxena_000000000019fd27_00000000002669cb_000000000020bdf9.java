import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public static int overlap(int a, int b, int c, int d){
        if (Math.max(a,c) >= Math.min(b, d))return 0;
        return 1;
    }
    
    public static boolean func(int i, int s[], int e[], ArrayList<Integer> one,
    ArrayList<Integer> two){
        // System.out.println(i+" - "+one.toString()+" "+two.toString());
        if (i == s.length)return true;
        boolean flag = false;
        boolean firstover = false;
        boolean secondover = false;
        int k = 0;
		for (k = 0 ; k < one.size(); k++){
		    if (overlap(s[i], e[i], s[one.get(k)], e[one.get(k)]) == 1)
		        break;
        }
        int l = 0;  
        for ( l = 0; l < two.size(); l++){
            if (overlap(s[i], e[i], s[two.get(l)], e[two.get(l)]) == 1)
    	                break;
        }
        if (k != one.size())
            firstover = true;
        if (l != two.size())
            secondover = true;
        if (firstover && secondover)return false;
        if (firstover && !secondover){
            two.add(i);
            return func(i+1, s, e, one, two);
        }
        if (!firstover && secondover){
            one.add(i);
            return func(i+1, s, e, one, two);
        }
        //dono mein se kisi mein bhi daal sakte hain
        one.add(i);
        boolean la = func(i+1, s, e, one, two);
        if (la)return true;
        int index = one.size()-1;
        while (one.get(index) != i)index--;
        one.remove(index);
        two.add(i);
        boolean ra = func(i+1, s, e, one, two);
        if (ra) return true;
        index = two.size()-1;
        while (two.get(index) != i)index--;
        two.remove(index);
        return false;
    }
	public static void main (String[] args) throws IOException{
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int test = 1; test <= t; test++){
		    int n = Integer.parseInt(br.readLine());
		    int s[] = new int[n];
		    int e[] = new int[n];
		    for (int i =0 ; i < n ; i++){
		        String str[] = br.readLine().split(" ");
		        s[i] = Integer.parseInt(str[0]);
		        e[i] = Integer.parseInt(str[1]);
		    }
		    int person[] = new int[n];
		    person[0] = 1;
		    ArrayList<Integer> one = new ArrayList<>();
		    ArrayList<Integer> two = new ArrayList<>();
		    boolean ans = func(0, s, e, one, two);
		    System.out.print("Case #"+test+": ");
		    if (ans == false)System.out.println("IMPOSSIBLE");
		    else{
		        int i = 0, j =0;
		        while (i < one.size() && j < two.size()){
		            if (one.get(i) < two.get(j)){
		            System.out.print("C");
		            i++;}
		            else {System.out.print("J");j++;}
		        }
		        while (i < one.size()){
		            System.out.print("C");
		            i++;
		        }
		        while (j < two.size()){
		            System.out.print("J");j++;
		        }
		        System.out.println();
		    }
		}
	}
}