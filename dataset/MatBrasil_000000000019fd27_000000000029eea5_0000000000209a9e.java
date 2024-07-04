/*
estrategia:

dada a sequencia b_1....b_n (n max = 100):

	- Para cada 10 queries antes de mudar:
		- le 5 bits de cada lado
		- Classifica cada bit do lado esquerdo em R1 ou R2
		- cria subgrafo de implicacao para os 5 bits lidos e os coloca no grupo R1 e R2
		(Gasto max: 100 queries)
	- Para cada grupo de regra, seleciona um bit de cada subgrafo (havera no maximo 10 subgrafos):
		- Descobre a regra de implicacao entre cada par de bits, unindo os subgrafos
		- No fim, havera apenas um grafo conexo para R1 e para R2
		(Gasto max: 20 queries)
	- Para cada grafo:
		- le um bit qualquer
		- Aplica regras de implicacao e descobre os valores de todos os outros
		- Envia o resultado final
		(Gasto max: 2 queries)
	(Gasto total max: 122 queries)
	
	
Regra R1: bit b_i = b_(n-i+1).
Regra R2: bit b_i = !b_(n-i+1)

Opcoes de implicacao: dado dois bits quaisquer b_i e b_j
	- Se b_i e b_j seguem a mesma regra:
		- Se b_i = b_j, entao constroi implicacao b_i -> b_j (b_i sempre sera igual ao b_j, nao importando operacao que ocorra)
		- Se b_i = !b_j, entao constroi implicacao b_i -> !b_j
	- Se seguem regras diferentes, nao eh possivel construir implicacoes
	 
 */


import java.util.*;
    import java.io.*;
    public class Solution {
    	public static final int EQUAL = 1,INVERSE = -1,NONE = 0,R1 = 1, R2 = 2;
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        int b = in.nextInt();
        for (int testCase = 1; testCase <= t; ++testCase) {
          int[][] implication = new int[b+1][b+1];
          int[] ruleBit = new int[b+1];
          
          int[] readVals = new int[b+1];
          
          //1st part: read bits and mirrored bits and estabilish the implications
          for(int bit=1;bit<=b/2;bit++)
          {
        	  int opositeBit = b-bit+1;
        	  System.out.println(bit);
        	  readVals[bit] = in.nextInt();
        	  System.out.println(opositeBit);
        	  readVals[opositeBit] = in.nextInt();
        	  if(readVals[bit] == readVals[opositeBit])
        	  {
        		  implication[bit][opositeBit] = EQUAL;
        		  implication[opositeBit][bit] = EQUAL;
        		  ruleBit[bit] = R1;
        	  }
        	  else 
        	  {
        		  implication[bit][opositeBit] = INVERSE;
        		  implication[opositeBit][bit] = INVERSE;
        		  ruleBit[bit] = R2;
        	  }
        	  
          }
          
          //2nd part: estabilish the implications between each group of 5 bits based on the rules and values read
          for(int bit=1;bit<=b/2;bit+=5)
          {
        	  for(int i=bit;i<bit+4;i++)for(int j=i+1;j<bit+5;j++)if(ruleBit[i]==ruleBit[j])
        	  {
        		  if(readVals[i] == readVals[j])
        		  {
        			  implication[i][j] = EQUAL;
        			  implication[j][i] = EQUAL;
        		  }
        		  else
        		  {
        			  implication[i][j] = INVERSE;
        			  implication[j][i] = INVERSE;
        		  }	  
        	  }
          }
          
          //3rd part: locate isolated groups of the same rule and estabilish the relationships
          int[] subgroupRepresetantBitR1 = new int[b/10+1];
          int[] subgroupRepresetantBitR2 = new int[b/10+1];
          for(int bit=1;bit<=b/2;bit++)
          {
        	  if(ruleBit[bit] == R1 && subgroupRepresetantBitR1[(bit-1)/5] == NONE)subgroupRepresetantBitR1[(bit-1)/5] = bit;
        	  if(ruleBit[bit] == R2 && subgroupRepresetantBitR2[(bit-1)/5] == NONE)subgroupRepresetantBitR2[(bit-1)/5] = bit;
          }
          
          int i=0;
          for(i=0;i<subgroupRepresetantBitR1.length && subgroupRepresetantBitR1[i]==NONE;i++);
          if(i<subgroupRepresetantBitR1.length)
          {
        	  System.out.println(subgroupRepresetantBitR1[i]);
        	  int valBit1 = in.nextInt();
        	  for(int j=i+1;j<subgroupRepresetantBitR1.length;j++)
        	  {
        		  if(subgroupRepresetantBitR1[j]==NONE)continue;
        		  System.out.println(subgroupRepresetantBitR1[j]);
        		  int valBit2 = in.nextInt();
        		  if(valBit1 == valBit2)
        		  {
        			  implication[subgroupRepresetantBitR1[j]][subgroupRepresetantBitR1[i]] = EQUAL;
        			  implication[subgroupRepresetantBitR1[i]][subgroupRepresetantBitR1[j]] = EQUAL;
        		  }
        		  else
        		  {
        			  implication[subgroupRepresetantBitR1[j]][subgroupRepresetantBitR1[i]] = INVERSE;
        			  implication[subgroupRepresetantBitR1[i]][subgroupRepresetantBitR1[j]] = INVERSE;
        		  }
        	  }
          }
          
          i=0;
          for(i=0;i<subgroupRepresetantBitR2.length && subgroupRepresetantBitR2[i]==NONE;i++);
          if(i < subgroupRepresetantBitR2.length)
          {
	          System.out.println(subgroupRepresetantBitR2[i]);
	          int valBit1 = in.nextInt();
	          for(int j=i+1;j<subgroupRepresetantBitR2.length;j++)
        	  {
        		  if(subgroupRepresetantBitR2[j]==NONE)continue;
        		  System.out.println(subgroupRepresetantBitR2[j]);
        		  int valBit2 = in.nextInt();
        		  if(valBit1 == valBit2)
        		  {
        			  implication[subgroupRepresetantBitR2[j]][subgroupRepresetantBitR2[i]] = EQUAL;
        			  implication[subgroupRepresetantBitR2[i]][subgroupRepresetantBitR2[j]] = EQUAL;
        		  }
        		  else
        		  {
        			  implication[subgroupRepresetantBitR2[j]][subgroupRepresetantBitR2[i]] = INVERSE;
        			  implication[subgroupRepresetantBitR2[i]][subgroupRepresetantBitR2[j]] = INVERSE;
        		  }
        	  }
	      }
          
          //4rd part: read two values of representants of the two rules and visit all nodes.
          boolean[] visited = new boolean[b+1];
          int[] finalValue = new int[b+1];
          for(int j=0;j<finalValue.length;j++)finalValue[j] = -1;
          for(i=0;i<subgroupRepresetantBitR1.length && subgroupRepresetantBitR1[i]==NONE;i++);
          if(i< subgroupRepresetantBitR1.length)
          {
        	  System.out.println(subgroupRepresetantBitR1[i]);
        	  finalValue[subgroupRepresetantBitR1[i]] = in.nextInt();
        	  visit(subgroupRepresetantBitR1[i],visited,finalValue,implication);
          }
          for(i=0;i<subgroupRepresetantBitR2.length && subgroupRepresetantBitR2[i]==NONE;i++);
          if(i< subgroupRepresetantBitR2.length)
          {
        	  System.out.println(subgroupRepresetantBitR2[i]);
        	  finalValue[subgroupRepresetantBitR2[i]] = in.nextInt();
        	  visit(subgroupRepresetantBitR2[i],visited,finalValue,implication);
          }
          
          System.out.println(getString(finalValue));
          in.nextLine();
          if(in.nextLine().equals("N"))return;
          
          
        }
      }
      
      public static void visit(int bit, boolean[] visited, int[] finalValue, int[][] implication)
      {
    	  visited[bit] = true;
    	  for(int i=0;i<visited.length;i++)
    	  {
    		  if(implication[bit][i] == NONE || visited[i])continue;
    		  if(implication[bit][i] == EQUAL)finalValue[i] = finalValue[bit];
    		  else finalValue[i] = (finalValue[bit]+1)%2;
    		  visit(i,visited,finalValue,implication);
    	  }
      }
      
      public static String getString(int[] finalValue)
      {
    	  StringBuilder sb = new StringBuilder();
    	  for(int i=1;i<finalValue.length;i++)sb.append(finalValue[i]);
    	  return sb.toString();
      }
     
      
    }
    
    