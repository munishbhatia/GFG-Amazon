/***************************************************************************
 * COPYRIGHT (C) 2018, Rapid7 LLC, Boston, MA, USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Rapid7.
 **************************************************************************/

package easy;

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0/?ref=self
 */
public class SubarrayWithGivenSum
{
   private static void findSubarrayWithSum(int[] arr, int sum){
      int size = arr.length, currsum = 0, start = 0;
      for(int i=0; i<size; ++i){
         currsum += arr[i];
         while (currsum > sum)
            currsum -= arr[start++];
         if(currsum == sum){
            System.out.println(start+1 + " " + (i+1));
            return;
         }
      }
      System.out.println(-1);
   }
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while(tests-- > 0){
         int size = in.nextInt(), sum = in.nextInt();
         int[] arr = new int[size];
         for(int i=0; i< size; ++i)
            arr[i] = in.nextInt();
         findSubarrayWithSum(arr, sum);
      }
   }
}
