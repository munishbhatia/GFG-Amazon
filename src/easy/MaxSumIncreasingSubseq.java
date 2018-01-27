/***************************************************************************
 * COPYRIGHT (C) 2018, Rapid7 LLC, Boston, MA, USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Rapid7.
 **************************************************************************/

package easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence/0/?ref=self
 */
public class MaxSumIncreasingSubseq
{
   private static int maxSumOfIncreasingSubseq(int[] arr){
      int len = arr.length, maxSum = arr[0];
      int[] DP = Arrays.copyOf(arr, len);

      for(int i=1; i<len; ++i){
         for(int j=0; j<i; ++j){
            if(arr[j] < arr[i])
               DP[i] = Math.max(DP[i], DP[j]+arr[i]);
         }
         if(maxSum < DP[i])
            maxSum = DP[i];
      }
      return maxSum;
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while (tests-- > 0){
         int N = in.nextInt();
         int[] arr = new int[N];
         for(int i=0; i<N; ++i)
            arr[i] = in.nextInt();
         System.out.println(maxSumOfIncreasingSubseq(arr));
      }
   }
}
