/***************************************************************************
 * COPYRIGHT (C) 2018, Munish Bhatia.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Munish Bhatia.
 **************************************************************************/

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/minimum-cost-to-fill-given-weight-in-a-bag/0/?ref=self
 */
public class MinCostToFillBag
{
   private static int getMinCost(int[] prices, int weight){
      int size = prices.length;
      int[] solution = new int[weight+1];
      solution[0] = 0; solution[1] = prices[0]==-1?Integer.MAX_VALUE:prices[0];
      for(int i=2; i<=weight; ++i){
         if(i-1 < size)
            solution[i] = prices[i-1]==-1?Integer.MAX_VALUE:prices[i-1];
         else
            solution[i] = Integer.MAX_VALUE;
         for(int j=1; j<=i/2; ++j){
            if(j-1<size && prices[j-1]!=-1)
               solution[i] = Math.min(solution[i], prices[j-1]+solution[i-j]);
         }
      }
      return solution[weight]==Integer.MAX_VALUE?-1:solution[weight];
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while (tests-- > 0){
         int size = in.nextInt(), weight = in.nextInt();
         int[] prices = new int[size];
         for(int i=0; i<size; ++i)
            prices[i] = in.nextInt();
         System.out.println(getMinCost(prices, weight));
      }
   }
}
