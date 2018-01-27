 /***************************************************************************
 * COPYRIGHT (C) 2018, Munish Bhatia.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Munish Bhatia.
 **************************************************************************/

package medium;

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/max-possible-amount/0
 */
public class MaxWinInGame
{
   private static int getMaxWin(int[] amounts){
      int size = amounts.length;
      int[][] DP = new int[size][size];

      for(int i=0; i<size-1; ++i){
         DP[i][i] = amounts[i];
         DP[i][i+1] = Math.max(amounts[i], amounts[i+1]);
      }
      DP[size-1][size-1] = amounts[size-1];

      for(int i=size-3; i>=0; --i){
         for(int j=i+2; j<size; ++j)
            DP[i][j] = Math.max(amounts[i]+Math.min(DP[i+1][j-1], DP[i+2][j]),
                                amounts[j]+Math.min(DP[i][j-2], DP[i+1][j-1]));
      }
      return DP[0][size-1];
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while(tests-- > 0){
         int size = in.nextInt();
         int[] input = new int[size];
         for(int i=0; i<size; ++i)
            input[i] = in.nextInt();
         System.out.println(getMaxWin(input));
      }
   }
}
