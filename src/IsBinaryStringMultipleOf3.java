/***************************************************************************
 * COPYRIGHT (C) 2018, Munish Bhatia.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Munish Bhatia.
 **************************************************************************/

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/is-binary-number-multiple-of-3/0/?ref=self
 */
public class IsBinaryStringMultipleOf3
{
   private static boolean isStringMultipleOfThree(String input){
      int oddCount = 0, evenCount = 0, length = input.length(); //oddCount = Set Bits at Odd Positions; evenCount = Set Bits at Even Positions
      boolean result = false;

      if(input.charAt(length-1) == '1')
         ++evenCount;
      for(int i=length-2; i>=0; --i){
         if(input.charAt(i) == '1'){
            if((length-i-1)%2 == 0)
               ++evenCount;
            else
               ++oddCount;
         }
      }

      if(Math.abs(oddCount-evenCount)%3 == 0)
         result = true;
      return result;
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while(tests-- > 0){
         String input = in.next();
         System.out.println(isStringMultipleOfThree(input)?1:0);
      }
   }
}
