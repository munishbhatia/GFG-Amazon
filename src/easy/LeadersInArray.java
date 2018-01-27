/***************************************************************************
 * COPYRIGHT (C) 2018, Rapid7 LLC, Boston, MA, USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Rapid7.
 **************************************************************************/

package easy;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://practice.geeksforgeeks.org/problems/leaders-in-an-array/0/?ref=self
 */
public class LeadersInArray
{
   private static void printArrayLeaders(int[] arr){
      int length = arr.length, currMax = arr[length-1];
      Stack<Integer> leaders = new Stack<>();
      leaders.push(arr[length-1]);

      for(int i=length-2; i>=0; --i){
         if(arr[i] > currMax){
            currMax = arr[i];
            leaders.push(arr[i]);
         }
      }
      while (leaders.empty() == false)
         System.out.print(leaders.pop()+" ");
      System.out.println();
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
         printArrayLeaders(arr);
      }
   }
}
