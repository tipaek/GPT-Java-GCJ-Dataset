/* package codechef; // don't place package name! */

import java.util.*;
//import java.lang.*;
//import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
    static class work{
        int start;
        int end;
        public work(int start,int end){
            this.start = start;
            this.end = end;
        }
        int getStart(){
            return start;
        }
        int getEnd(){
            return end;
        }
    }
    static class resu{
        char ch;
        work wr;
        public resu(char ch,work wr){
            this.ch = ch;
            this.wr = wr;
        }
        work getWork(){
            return wr;
        }
        char getChar(){
            return ch;
        }
    }
	public static void main (String[] args) //throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0){
		    int N = sc.nextInt();
		    ArrayList<work> list = new ArrayList<work>();
		    ArrayList<work> list2 = new ArrayList<work>();
		    //int[][] arr = new int[N][2];
		    for(int i = 0;i<N;i++){
		        //arr[i][0] = sc.nextInt();
		        //arr[i][1] = sc.nextInt();
		        list.add(new work(sc.nextInt(),sc.nextInt()));
		    }
		    list2 = (ArrayList)list.clone();
		    list.sort(Comparator.comparing(work::getStart));
		  //  for(int i = 0;i<list.size();i++){
		  //      System.out.println(list.get(i).getStart()+" - "+list.get(i).getEnd());
		  //  }
		    HashMap<Character,Integer> test = new HashMap<>();
		    //HashMap<Integer, Character> result = new HashMap<>();
		    ArrayList<resu> result = new ArrayList<resu>();
		    int flag = 0;
		    boolean C = true;
		    boolean J = true;
		   // System.out.println(list.size());
		    for(int i = 0;i<list.size();i++){
		       // System.out.println("i : "+i);
		        if(C == false && list.get(i).getStart()>=test.get('C')){
		            C = true;
		            test.remove('C');
		        }
		        if(J == false && list.get(i).getStart()>=test.get('J')){
		            J = true;
		            test.remove('J');
		        }
		        if(C == true){
		            C = false;
		            result.add(new resu('C',new work(list.get(i).getStart(),list.get(i).getEnd())));
		            //result.put(list.get(i).getStart(),'C');
		            test.put('C',list.get(i).getEnd());
		        }
		        else if(J == true){
		            J = false;
		            result.add(new resu('J',new work(list.get(i).getStart(),list.get(i).getEnd())));
		            //result.put(list.get(i).getStart(),'J');
		            test.put('J',list.get(i).getEnd());
		        }
		        else{
		            flag = 1;
		            System.out.print("IMPOSSIBLE");
		            break;
		        }
		      //  for(int j = 0;j<test.size();j++){
		      //      System.out.println(result);
		      //      System.out.println(" -- >"+test);
		      //  }
		    }
		    if(flag != 1){
                for(int i = 0;i<list2.size();i++){
                    for(int j = 0;j<result.size();j++){
                        if(result.get(j).getWork().getStart() == list2.get(i).getStart() && result.get(j).getWork().getEnd() == list2.get(i).getEnd()){
                          //  System.out.print("--");
                            System.out.print(result.get(j).getChar());
                            break;
                        }
                    }
                    //list2.get(i) 
                    //System.out.print(result.get(arr[i][0]));
                }
            }
            System.out.println();
		  //  for(int i = 0;i<N;i++){
		  //      System.out.println(list.get(i).getStart()+" - "+list.get(i).getEnd());
		  //  }
		}
		return;
	}
}
