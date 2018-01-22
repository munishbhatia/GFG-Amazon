/***************************************************************************
 * COPYRIGHT (C) 2018, Munish Bhatia.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Munish Bhatia.
 **************************************************************************/

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0/?ref=self
 */
public class Kadane
{
   private static int getMaxContiguousSum(int[] arr){
      int size = arr.length, currSum = 0, currStart = 0, maxSum = Integer.MIN_VALUE, maxStart, maxEnd;

      for(int i=0; i<size; ++i){
         currSum+= arr[i];
         if(currSum > maxSum){
            maxSum = currSum; maxStart = currStart; maxEnd = i;
         }
         if(currSum <= 0){
            currStart = i+1;
            currSum = 0;
         }
      }
      return maxSum;
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while(tests-- > 0){
         int size = in.nextInt();
         int[] arr = new int[size];
         for(int i=0; i<size; ++i)
            arr[i] = in.nextInt();
         System.out.println(getMaxContiguousSum(arr));
      }
   }
}
