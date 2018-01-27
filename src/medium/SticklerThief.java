package medium; /***************************************************************************
 * COPYRIGHT (C) 2018, Munish Bhatia.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Munish Bhatia.
 **************************************************************************/

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/stickler-theif/0/?ref=self
 */
public class SticklerThief
{
   private static long findMaxLoot(int[] amounts){
      int size = amounts.length;
      if(size==1)
         return amounts[0];
      long[] maxLoot = new long[size];
      maxLoot[size-1] = amounts[size-1];
      maxLoot[size-2] = Math.max(amounts[size-2], amounts[size-1]);
      for(int i=size-3; i>=0; --i)
         maxLoot[i] = Math.max(amounts[i]+maxLoot[i+2], maxLoot[i+1]);
      return maxLoot[0];
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while(tests-- > 0){
         int size = in.nextInt();
         int[] input = new int[size];
         for(int i=0; i<size; ++i){
            input[i] = in.nextInt();
         }
         System.out.println(findMaxLoot(input));
      }
   }
}
