/***************************************************************************
 * COPYRIGHT (C) 2018, Munish Bhatia.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Munish Bhatia.
 **************************************************************************/

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/unique-bsts/0
 */
public class BSTCount
{
   private static int[] DP;
   private static void countBSTs(int Max){
      DP = new int[Max+1];
      DP[0] = 1; DP[1] = 1;
      for(int i=2; i<=Max; ++i){
         DP[i] = DP[i-1];
         for(int j=1; j<=i-1; ++j){
            DP[i] += DP[j-1] * DP[i-j];
         }
      }
   }
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt(), max = 11;
      countBSTs(max);
      while (tests-- > 0)
         System.out.println(DP[in.nextInt()]);
   }
}
