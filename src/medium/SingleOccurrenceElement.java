package medium; /***************************************************************************
 * COPYRIGHT (C) 2018, Munish Bhatia.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Munish Bhatia.
 **************************************************************************/

import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/?p=24769
 * https://practice.geeksforgeeks.org/problems/alone-in-couple/0
 */
//TODO: REVISIT - Couldn't Solve W/O Reference
public class SingleOccurrenceElement
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while(tests-- > 0){
         int size = in.nextInt();
         int ones = 0, twos = 0, notThrees;
         for(int i=0; i<size; ++i){
            int curr = in.nextInt();
            twos |= ones & curr;
            ones ^= curr;
            notThrees = ~(ones&twos);
            ones &= notThrees;
            twos &= notThrees;
         }
         System.out.println(ones);
      }
   }
}
