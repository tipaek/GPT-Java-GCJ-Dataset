import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

        public static void main(String[] args) {
                Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
                String T = in.nextLine();
                int t = Integer.parseInt(T);
                for (int i = 1; i <= t; i++) {
                        String nextCase = in.nextLine();
                        int N = Integer.parseInt(nextCase.split(" ")[0]);
                        int K = Integer.parseInt(nextCase.split(" ")[1]);
                        
                        Boolean impossible = false;
                        
                        int[][] generatedMatrix = new int[N][N];
                        
                        if(N == 2) {
                                generatedMatrix = generateTwoMatrix(K);
                        } else if(N == 3) {
                                generatedMatrix = generateThreeMatrix(K);
                        } else if(N == 4) {
                                if(K % N == 0) {
                                        generatedMatrix = generateFourMatrix(K/N);
                                } else {
                                        int maxRepeat = 2;
                                        int repeatedElement = N;
                                        int edgeElement = 1;
                                        while(repeatedElement > 0) {
                                                if(K <= repeatedElement*maxRepeat) {
                                                        repeatedElement--;
                                                } else {
                                                        int remainder = K - (repeatedElement*maxRepeat);
                                                        if(remainder % 2 == 0) {
                                                                edgeElement = Math.max(remainder / 2, 1);
                                                                break;
                                                        }
                                                        repeatedElement--;
                                                }
                                        }
                                        
                                        if(repeatedElement == 0) {
                                                impossible = true;
                                        } else {
                                                generatedMatrix = generateFourMatrix(repeatedElement, edgeElement);
                                        }
                                }
                        } else if(N == 5) {
                                if(K % N == 0) {
                                        // Generate same diagonal matrix
                                        generatedMatrix = generateFiveMatrix(K/N);
                                } else {
                                        int maxRepeat = 3;
                                        int repeatedElement = N;
                                        int edgeElement = 1;
                                        while(repeatedElement > 0) {
                                                if(K <= repeatedElement*maxRepeat) {
                                                        repeatedElement--;
                                                } else {
                                                        int remainder = K - (repeatedElement*maxRepeat);
                                                        if(remainder % 2 == 0) {
                                                                edgeElement = Math.max(remainder / 2, 1);;
                                                                break;
                                                        }
                                                        repeatedElement--;
                                                }
                                        }
                                        
                                        if(repeatedElement == 0) {
                                                 impossible = true;
                                        } else {
                                                generatedMatrix = generateFiveMatrix(repeatedElement, edgeElement);
                                        }
                                }
                        }
                        
                        if(impossible || generatedMatrix == null) {
                                System.out.println("Case #" + i + ": IMPOSSIBLE");
                        } else {
                                String toPrint = "POSSIBLE";
                                for(int j = 0; j < N; j++) {
                                        String row = "\n";
                                        for(int k = 0; k < N; k++) {
                                                row = row + String.valueOf(generatedMatrix[j][k]);
                                        }
                                        toPrint = toPrint + row;
                                }
                                System.out.println("Case #" + i + ": " + toPrint);
                        }
                }
                in.close();
        }
        
        private static int[][] generateTwoMatrix(int k) {
                int[][] returnMatrix = new int[2][2];
                
                if(k == 2) {
                        returnMatrix[0][0] = 1;
                        returnMatrix[0][1] = 2;
                        returnMatrix[1][0] = 2;
                        returnMatrix[1][1] = 1;
                } else if(k == 4) {
                        returnMatrix[0][0] = 2;
                        returnMatrix[0][1] = 1;
                        returnMatrix[1][0] = 1;
                        returnMatrix[1][1] = 2;
                } else {
                        return null;
                }
                
                return returnMatrix;
        }
        
        private static int[][] generateThreeMatrix(int k) {
                int[][] returnMatrix = new int[3][3];
                
                if(k == 6) {
                        returnMatrix[0][0] = 1;
                        returnMatrix[0][1] = 3;
                        returnMatrix[0][2] = 2;
                        returnMatrix[1][0] = 3;
                        returnMatrix[1][1] = 2;
                        returnMatrix[1][2] = 1;
                        returnMatrix[2][0] = 2;
                        returnMatrix[2][1] = 1;
                        returnMatrix[2][2] = 3;
                } else if(k == 3) {
                        returnMatrix[0][0] = 1;
                        returnMatrix[0][1] = 2;
                        returnMatrix[0][2] = 3;
                        returnMatrix[1][0] = 3;
                        returnMatrix[1][1] = 1;
                        returnMatrix[1][2] = 2;
                        returnMatrix[2][0] = 2;
                        returnMatrix[2][1] = 3;
                        returnMatrix[2][2] = 1;
                }
                else if(k == 9) {
                        returnMatrix[0][0] = 3;
                        returnMatrix[0][1] = 1;
                        returnMatrix[0][2] = 2;
                        returnMatrix[1][0] = 2;
                        returnMatrix[1][1] = 3;
                        returnMatrix[1][2] = 1;
                        returnMatrix[2][0] = 1;
                        returnMatrix[2][1] = 2;
                        returnMatrix[2][2] = 3;
                } else {
                        return null;
                }
                
                return returnMatrix;
        }
        
        private static int[][] generateFourMatrix(int repeatedElement, int edgeElement) {
                int[][] returnMatrix = new int[4][4];
                
                returnMatrix[0][0] = edgeElement;
                returnMatrix[3][3] = edgeElement;
                returnMatrix[1][2] = edgeElement;
                returnMatrix[2][1] = edgeElement;
                returnMatrix[1][1] = repeatedElement;
                returnMatrix[2][2] = repeatedElement;
                returnMatrix[0][3] = repeatedElement;
                returnMatrix[3][0] = repeatedElement;
                
                int toFill = edgeElement + 1; 
                if(toFill == 5) {
                        toFill = 1;
                }
                while(toFill == edgeElement || toFill == repeatedElement) {
                        toFill++;
                        if(toFill == 5) {
                                toFill = 1;
                        }
                }
                returnMatrix[0][1] = toFill;
                returnMatrix[1][0] = toFill;
                returnMatrix[2][3] = toFill;
                returnMatrix[3][2] = toFill;
                
                toFill++;
                while(toFill == edgeElement || toFill == repeatedElement) {
                        toFill++;
                        if(toFill == 5) {
                                toFill = 1;
                        }
                }
                returnMatrix[0][2] = toFill;
                returnMatrix[2][0] = toFill;
                returnMatrix[3][1] = toFill;
                returnMatrix[1][3] = toFill;
                
                return returnMatrix;
        }
        
        private static int[][] generateFourMatrix(int repeatedElement) {
                int[][] returnMatrix = new int[4][4];
                
                for(int i = 0; i < 4; i++) {
                        returnMatrix[i][i] = repeatedElement;
                }
                
                int toFill = repeatedElement + 1;
                if(toFill == 5) {
                        toFill = 1;
                }
                returnMatrix[0][1] = toFill;
                returnMatrix[1][0] = toFill;
                returnMatrix[2][3] = toFill;
                returnMatrix[3][2] = toFill;
                
                toFill++;
                if(toFill == 5) {
                        toFill = 1;
                }
                returnMatrix[0][2] = toFill;
                returnMatrix[2][0] = toFill;
                returnMatrix[1][3] = toFill;
                returnMatrix[3][1] = toFill;
                
                toFill++;
                if(toFill == 5) {
                        toFill = 1;
                }
                returnMatrix[0][3] = toFill;
                returnMatrix[1][2] = toFill;
                returnMatrix[2][1] = toFill;
                returnMatrix[3][0] = toFill;
                
                return returnMatrix;
        }
        
        private static int[][] generateFiveMatrix(int repeatedElement, int edgeElement) {
                int[][] returnMatrix = new int[5][5];
                
               for(int i = 1; i < 4; i++) {
                        returnMatrix[i][i] = repeatedElement;
                }
               returnMatrix[0][4] = repeatedElement;
               returnMatrix[4][0] = repeatedElement;
              
               returnMatrix[0][0] = edgeElement;
               returnMatrix[4][4] = edgeElement;
               returnMatrix[1][2] = edgeElement;
               returnMatrix[2][3] = edgeElement;
               returnMatrix[3][1] = edgeElement;
               
               int toFill = edgeElement + 1; 
               if(toFill == 6) {
                       toFill = 1;
               }
               while(toFill == edgeElement || toFill == repeatedElement) {
                       toFill++;
                       if(toFill == 6) {
                               toFill = 1;
                       }
               }
               
               for(int i = 1; i < 4; i++) {
                       if(!(returnMatrix[0][i] > 0)) {
                               returnMatrix[0][i] = toFill;
                               toFill++;
                               if(toFill == 6) {
                                       toFill = 1;
                               }
                               while(toFill == edgeElement || toFill == repeatedElement) {
                                       toFill++;
                                       if(toFill == 6) {
                                               toFill = 1;
                                       }
                               }
                       }
               }
               
               toFill = edgeElement + 1; 
               if(toFill == 6) {
                       toFill = 1;
               }
               while(toFill == edgeElement || toFill == repeatedElement) {
                       toFill++;
                       if(toFill == 6) {
                               toFill = 1;
                       }
               }
               for(int i = 0; i < 5; i++) {
                       if(!(returnMatrix[1][i] > 0)) {
                               returnMatrix[1][i] = toFill;
                               toFill++;
                               if(toFill == 6) {
                                       toFill = 1;
                               }
                               while(toFill == edgeElement || toFill == repeatedElement) {
                                       toFill++;
                                       if(toFill == 6) {
                                               toFill = 1;
                                       }
                               }
                       }
               }
               
               toFill = returnMatrix[1][0] + 1;
               if(toFill == 6) {
                       toFill = 1;
               }
               while(toFill == edgeElement || toFill == repeatedElement) {
                       toFill++;
                       if(toFill == 6) {
                               toFill = 1;
                       }
               }
               for(int i = 0; i < 5; i++) {
                       if(!(returnMatrix[2][i] > 0)) {
                               returnMatrix[2][i] = toFill;
                               toFill++;
                               if(toFill == 6) {
                                       toFill = 1;
                               }
                               while(toFill == edgeElement || toFill == repeatedElement) {
                                       toFill++;
                                       if(toFill == 6) {
                                               toFill = 1;
                                       }
                               }
                       }
               }
               
               toFill = returnMatrix[2][0] + 1;
               if(toFill == 6) {
                       toFill = 1;
               }
               while(toFill == edgeElement || toFill == repeatedElement) {
                       toFill++;
                       if(toFill == 6) {
                               toFill = 1;
                       }
               }
               for(int i = 0; i < 5; i++) {
                       if(!(returnMatrix[3][i] > 0)) {
                               returnMatrix[3][i] = toFill;
                               toFill++;
                               if(toFill == 6) {
                                       toFill = 1;
                               }
                               while(toFill == edgeElement || toFill == repeatedElement) {
                                       toFill++;
                                       if(toFill == 6) {
                                               toFill = 1;
                                       }
                               }
                       }
               }
               
               int sum = 0;
               for(int i = 0; i < 4; i++) {
                       sum += returnMatrix[i][1];
               }
               toFill = 15 - sum;
               returnMatrix[4][1] = toFill;
               
               sum = 0;
               for(int i = 0; i < 4; i++) {
                       sum += returnMatrix[i][2];
               }
               toFill = 15 - sum;
               returnMatrix[4][2] = toFill;
               
               sum = 0;
               for(int i = 0; i < 4; i++) {
                       sum += returnMatrix[i][3];
               }
               toFill = 15 - sum;
               returnMatrix[4][3] = toFill;
                
                return returnMatrix;
        }
        
        private static int[][] generateFiveMatrix(int repeatedElement) {
                int[][] returnMatrix = new int[5][5];
                
                for(int i = 0; i < 5; i++) {
                        returnMatrix[i][i] = repeatedElement;
                }
                
                int toFill = repeatedElement + 1;
                if(toFill == 6) {
                        toFill = 1;
                }
                returnMatrix[0][1] = toFill;
                returnMatrix[1][2] = toFill;
                returnMatrix[2][3] = toFill;
                returnMatrix[3][4] = toFill;
                
                toFill++;
                if(toFill == 6) {
                        toFill = 1;
                }
                returnMatrix[0][2] = toFill;
                returnMatrix[1][3] = toFill;
                returnMatrix[2][4] = toFill;
                
                toFill++;
                if(toFill == 6) {
                        toFill = 1;
                }
                returnMatrix[0][3] = toFill;
                returnMatrix[1][4] = toFill;
                
                toFill++;
                if(toFill == 6) {
                        toFill = 1;
                }
                returnMatrix[0][4] = toFill;
                
                toFill = repeatedElement + 1;
                if(toFill == 6) {
                        toFill = 1;
                }
                returnMatrix[4][0] = toFill;
                
                toFill++;
                if(toFill == 6) {
                        toFill = 1;
                }
                returnMatrix[4][1] = toFill;
                returnMatrix[3][0] = toFill;
                
                toFill++;
                if(toFill == 6) {
                        toFill = 1;
                }
                returnMatrix[4][2] = toFill;
                returnMatrix[3][1] = toFill;
                returnMatrix[2][0] = toFill;
                
                toFill++;
                if(toFill == 6) {
                        toFill = 1;
                }
                returnMatrix[4][3] = toFill;
                returnMatrix[3][2] = toFill;
                returnMatrix[2][1] = toFill;
                returnMatrix[1][0] = toFill;
                
                return returnMatrix;
        }
}
