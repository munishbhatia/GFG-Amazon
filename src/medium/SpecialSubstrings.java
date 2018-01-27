package medium; /***************************************************************************
 * COPYRIGHT (C) 2018, Munish Bhatia.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Munish Bhatia.
 **************************************************************************/

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/binary-string/0
 */
public class SpecialSubstrings
{
   private static int getSubstringsEndingWith1(int length, String input){
      int oneCount = 0;
      for(int i=0; i<length; ++i)
         if(input.charAt(i) == '1')
            ++oneCount;
      return ((oneCount-1)*(oneCount))/2;
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while(tests-- > 0){
         int size = in.nextInt();
         String input = in.next();
         System.out.println(getSubstringsEndingWith1(size, input));
      }
   }
}
