/***************************************************************************
 * COPYRIGHT (C) 2018, Munish Bhatia.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Munish Bhatia.
 **************************************************************************/

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/missing-number-in-array/0/?ref=self
 */
public class MissingArrayElement
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while (tests-- > 0){
         int N = in.nextInt(), currSum = 0, expectedSum = (N*(N+1))/2;
         for(int i=1; i<N; ++i)
            currSum += in.nextInt();
         System.out.println(expectedSum - currSum);
      }
   }
}
