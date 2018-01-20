/***************************************************************************
 * COPYRIGHT (C) 2018, Munish Bhatia.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Munish Bhatia.
 **************************************************************************/

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/number-of-ways/0
 */
public class NumberOfWaysToTile
{
   private static int NumWaysToTile(int N){
      int[] DP = new int[N+1];
      if(N<4)
         return 1;
      DP[0] = DP[1] = DP[2] = DP[3] = 1;
      for(int i=4; i<=N; ++i)
         DP[i] = DP[i-1] + DP[i-4];
      return DP[N];
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while(tests-- > 0){
         int N = in.nextInt();
         System.out.println(NumWaysToTile(N));
      }
   }
}
