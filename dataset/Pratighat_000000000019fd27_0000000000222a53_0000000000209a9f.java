import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

class Solution
{

    public static void main(String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i= 0;i<t;i++)
        {
            count++;

            String str =  br.readLine();
            
           ArrayList<Integer> strary = new ArrayList<>();
           for(int j = 0;j<str.length();j++)
           {
               strary.add(Character.getNumericValue(str.charAt(j)));
           }
           int max = 0;

           for (Integer integer : strary) {
               if(integer==1)
               {
                    max = 1;
                   break;
               }
           }
           String newString = "";

           if(max ==1)
           {
               for(int j = 0;j<strary.size();j++)
               {
                    if(strary.get(j)==0)
                    {
                      newString =  newString.concat("0");
                    }
                    if(strary.get(j)==1)
                    {
                      newString=  newString.concat("(");
                            HashSet<Integer> setu = new HashSet<>();
                            setu.add(1);
                            
                         for1:  for(int k = j+1;k<strary.size();k++)
                           {
                               if(!setu.add(strary.get(k)))
                               {
                                   j++;
                                  newString =  newString.concat("1");
                               }else{
                                 newString =  newString.concat("1");
                                 newString = newString.concat(")");
                                   break for1;
                               }
                           }
                    }
               }


               if(strary.get(strary.size()-1)==1)
               {
                   newString = newString.concat("1)");
               }

               System.out.println("case #"+count+": "+newString);

           }else
           {
            System.out.println("case #"+count+": "+str);
           }
        }
        
    }
}