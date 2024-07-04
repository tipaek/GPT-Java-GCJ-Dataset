import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class PPR {

    public static final PrintStream out = System.out;
   public static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public int numCases;

  //  File file = new File("test.txt");

  //  BufferedReader in;

   // {
  //      try {
   //         in = new BufferedReader(new FileReader(file));
   //     } catch (FileNotFoundException e) {
   //        e.printStackTrace();
  //      }
  //  }


    public static void main(String[] args) throws IOException {
        try {
            new PPR().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() throws Exception {
        numCases = Integer.parseInt(in.readLine().trim());
        for (int i = 1; i <= numCases; i++) {
            doCase(i);
        }
    }

    public void doCase(int caseNumber) throws Exception {
     //  String line = in.readLine();
      // Scanner scan = new Scanner(line);
        long N = Long.parseLong(in.readLine());
   //     System.out.println(N);
        char result [] = new char[(int) N];
        LinkedList<Integer> J = new LinkedList();
        LinkedList<Integer> C = new LinkedList();
        Map m1= new HashMap();
        boolean flag = true;
        for (int i = 0; i <= N-1; i++) {
            flag = true;
            String str1 = in.readLine();
            String []splitArray = str1.split(" ");
         //   System.out.println(str1);
 if(J.size()==0 && C.size() ==0){
     J.add(Integer.valueOf(splitArray[0]));
     J.addLast(Integer.valueOf(splitArray[1]));
     result[i]='J';
 }else if(J.size()==0 && C.size() >0){

     if(C.getLast()<=Integer.valueOf(splitArray[0])){
         C.addLast(Integer.valueOf(splitArray[0]));
         C.addLast(Integer.valueOf(splitArray[1]));
         result[i]='C';
     }
     else if(C.getFirst()>=Integer.valueOf(splitArray[1])){
         C.addFirst(Integer.valueOf(splitArray[1]));
         C.addFirst(Integer.valueOf(splitArray[0]));
         result[i]='C';
     }else{
         J.add(Integer.valueOf(splitArray[0]));
         J.addLast(Integer.valueOf(splitArray[1]));
         result[i]='J';
     }

 }else if(J.size()>0 && C.size() ==0){

     if(J.getLast()<=Integer.valueOf(splitArray[0])){
         J.addLast(Integer.valueOf(splitArray[0]));
         J.addLast(Integer.valueOf(splitArray[1]));
         result[i]='J';
     }
     else if(J.getFirst()>=Integer.valueOf(splitArray[1])){
         J.addFirst(Integer.valueOf(splitArray[1]));
         J.addFirst(Integer.valueOf(splitArray[0]));
         result[i]='J';
     } else {
         C.add(Integer.valueOf(splitArray[0]));
         C.addLast(Integer.valueOf(splitArray[1]));
         result[i]='C';
     }

 }
  else
 if(J.getLast()<=Integer.valueOf(splitArray[0])){
     J.addLast(Integer.valueOf(splitArray[0]));
     J.addLast(Integer.valueOf(splitArray[1]));
     result[i]='J';
 }
 else if(J.getFirst()>=Integer.valueOf(splitArray[1])){
     J.addFirst(Integer.valueOf(splitArray[1]));
     J.addFirst(Integer.valueOf(splitArray[0]));
     result[i]='J';
 } else if(C.getLast()<=Integer.valueOf(splitArray[0])){
                C.addLast(Integer.valueOf(splitArray[0]));
                C.addLast(Integer.valueOf(splitArray[1]));
                result[i]='C';
            }
            else if(C.getFirst()>=Integer.valueOf(splitArray[1])){
                C.addFirst(Integer.valueOf(splitArray[1]));
                C.addFirst(Integer.valueOf(splitArray[0]));
                result[i]='C';
            }
            else{
                flag=false;
     out.print("Case #" + caseNumber + ": ");
     System.out.println("IMPOSSIBLE");
     break;
 }
     //       m1.put();



        }
        if(flag) {
            out.print("Case #" + caseNumber + ": ");
            System.out.println(new String(result));
        }
    }


}
