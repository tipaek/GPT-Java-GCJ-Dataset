import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          int sch[][]= new int[n][3]; // Read Start, End , Index
            for (int nn =0 ; nn < n ; ++nn) 
            {
                sch[nn][0] = in.nextInt();
                sch[nn][1] = in.nextInt();
                sch[nn][2] = nn;
            }
          quickSort(sch,0,n-1);
          String result="";
          int cEnd=0,jEnd=0;
//           for (int nn =0 ; nn < n ; ++nn) 
//            {
//               result+="I"; //default unselected activity 
//            }
            char res[] = new char[n];
            
            // Assign Activities
            for(int nn =0 ; nn < n ; ++nn)
            {
                int maxEnd=-1;
                char selectedPartner=' ';
                int minEnd=-1;
                char unselectedPartner=' ';
                // Start by selecting the partner who finish last
                if (cEnd>=jEnd)
                {
                    maxEnd=cEnd;
                    selectedPartner='C';
                    minEnd=jEnd;
                    unselectedPartner='J';
                }
                else
                {
                    maxEnd=jEnd;
                    selectedPartner='J';
                    minEnd=cEnd;
                    unselectedPartner='C';
                }
                if (sch[nn][0]>=maxEnd) 
                {
                  
                  // Do Nothing
                }else
                    if(sch[nn][0]>=minEnd)
                    {
                          if(selectedPartner=='C')
                           {
                              selectedPartner='J';
                               
                           }
                           else
                           {
                               selectedPartner='C'; 
                           }
                   
                    }
                    else
                        {
                            String s = "IMPOSSIBLE"; 
                            res = s.toCharArray(); 
                            break;
                        }
                    res[sch[nn][2]]=selectedPartner;
                //  res.setCharAt(sch[nn][2], selectedPartner);
                 if(selectedPartner=='C')
                   {
                       cEnd=sch[nn][1];
                       
                   }
                   else
                   {
                        jEnd=sch[nn][1];
                   }
            }
          //System.out.println("Case #" + i + ": " + res.toString()+" ");
           System.out.println("Case #" + i + ": " + new String(res)+" ");
        }
        
      
              }
                public static void quickSort(int arr[][], int begin, int end) {
            if (begin < end) {
                int partitionIndex = partition(arr, begin, end);
         
                quickSort(arr, begin, partitionIndex-1);
                quickSort(arr, partitionIndex+1, end);
            }
        }
        private static int partition(int arr[][], int begin, int end) {
                int pivot = arr[end][1];
                int i = (begin-1);
             
                for (int j = begin; j < end; j++) {
                    if (arr[j][1] <= pivot) {
                        i++;
             
                        int swapTemp[] = copyArray(arr[i]);
                        copyValues( arr[j],arr[i]);
                         copyValues( swapTemp,arr[j]);
                      
                    }
                }
             
                int swapTemp[] = copyArray(arr[i+1]);
                copyValues( arr[end],arr[i+1]);
                copyValues( swapTemp, arr[end]);
                      
               
             
                return i+1;
            }
            private static int[] copyArray(int src[])
            {
                 int b[] = new int[src.length]; 
  
             
                for (int i=0; i<src.length; i++) 
                    b[i] = src[i]; 
                
                return b;
            
            }
            private static void copyValues(int src[],int dst[])
            {
       
  
             
                for (int i=0; i<src.length; i++) 
                    dst[i] = src[i]; 
                
          
            
            }
    }