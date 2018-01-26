/***************************************************************************
 * COPYRIGHT (C) 2018, Munish Bhatia.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Munish Bhatia.
 **************************************************************************/

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/string-formation-from-substring/0
 */
public class StringFromSubstring
{
   private static boolean isBaseSubstring(String prefix, int prefixLen, String actual){
      if(!(actual.startsWith(prefix)))
         return false;
      if(!(actual.endsWith(prefix)))
         return false;
      if(actual.length() == 2*prefixLen)
         return true; //Residual String is Empty String
      if(actual.length() == 3*prefixLen)
         return actual.substring(prefixLen, actual.length()-prefixLen).contains(prefix);
      return isBaseSubstring(prefix, prefixLen, actual.substring(prefixLen, actual.length()-prefixLen));
   }

   private static boolean isStringFormableUsingSubstring(String input){
      int len = input.length();
      if(len <= 1)
         return false;
      if(len == 2)
         return input.charAt(0) == input.charAt(1);
      for (int i=1; i<=len/2; ++i){
         if(isBaseSubstring(input.substring(0, i), i, input) == true)
            return true;
      }
      return false;
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while(tests-- > 0)
         System.out.println(isStringFormableUsingSubstring(in.next())?"True":"False");
   }
}
