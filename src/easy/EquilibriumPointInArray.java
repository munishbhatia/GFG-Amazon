/***************************************************************************
 * COPYRIGHT (C) 2018, Rapid7 LLC, Boston, MA, USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Rapid7.
 **************************************************************************/

package easy;

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/equilibrium-point/0/?ref=self
 */
public class EquilibriumPointInArray
{
   //O(2N) time, O(1) space
   private static int getEquilibriumPoint(int[] arr){
      int len = arr.length, totalSum = 0, currSum = 0;
      if(len == 1)
         return 1;
      for(int curr:arr)
         totalSum+=curr;
      currSum+=arr[0];
      for (int i=1; i<len-1; ++i){
         if(currSum == totalSum-currSum-arr[i])
            return i+1;
         currSum+=arr[i];
      }
      return -1;
   }
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while (tests-- > 0){
         int len = in.nextInt();
         int[] arr = new int[len];
         for(int i=0; i<len; ++i)
            arr[i] = in.nextInt();
         System.out.println(getEquilibriumPoint(arr));
      }
   }
}
