/*
score: 9 + 0(extra credit)
comments: if you want to do the code review or want to know the answer for extra credits, come to find me on campus
*/
package Assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rose on 1/27/17.
 * Assignment for your lecture 3. Please finish all the questions under
 * 'Assignment'. Please try to think the extra credit questions. The deadline
 * of this assignment is 02/04/2017 23:59 PST. Please feel free to contact me
 * for any questions. Please write your comments about this assignment in the
 * end.
 */


public class Assignment3 {

	/**
     *  Given an array, reverse the elements within this array and print the result
     *  eg, given{1,2,3,4}, print{4,3,2,1}
     */
    public void reverseArray(int[] nums) {         //correct
    	int left=0;
    	int right=nums.length-1;
    	while (left<right){
    		int temp=nums[left];
    		nums[left]=nums[right];
    		nums[right]=temp;
    		left++;
    		right--;
    	}
    	for(int y : nums){
    		System.out.print(y);	
    	}
    }

    /**
     *  Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
     *  Assume the integer do not contain any leading zero, except the number 0 itself.
     *  The digits are stored such that the most significant digit is at the head of the array.
     *  eg, given {1,2,9}, reutrn{1,3,0}.
     */
    public int[] plusOne(int[] digits) {                //correct
    	if(digits==null||digits.length==0)
    		return new int[0];
    	int temp=1;
    	for(int i=digits.length-1;i>=0;i--){
    		int sum=digits[i]+temp;
    		if(sum>=10){
    			temp=1;
    		}else{
    			temp=0;
    		}
    		digits[i]=sum%10;
    	}
    	if (temp==1){
    		int[]result=new int[digits.length+1];
    		System.arraycopy(digits, 0, result, 1, digits.length);
    		result[0]=1;
    		return result;
    	}else{
    		return digits;
    	}
    }

    /**
     *  Write a program that takes an integer as input and returns all the primes between 1 and that integer(inclusive).
     *  eg, input is 18, you should return{2,3,5,7,11,13,17}
     */
   public int[] generatePrimes(int n) {              //miss one corner case: if n is 2, your output is an empty array. But you should reutrn {2};
    	List<Integer> x = new ArrayList<>();  
    	
    	for (int j=0; j<n; j++){
    		if (isPrime(j)){
    			x.add(j);
    		}
    	}
    	int array[]= new int[x.size()];
    	for (int j=0; j<array.length; j++){
    		array[j] = x.get(j);
    	}
    	return array;

   }
    public boolean isPrime(int n) {
    	if (n<=1){
    		return false;
    	}
    	if (n==2){
    		return true;
    		
    	}
    	for(int i=2; i<n; i++){
	    	if (n%i==0){
	        	return false;
	        }
    	}
    	return true;
    }
   

    /**
     *  Assume you have a method isSubstring which checks if one word is a substring of another.
     *  Given two strings, s1 and s2, write a program to check if s2 is a rotation of s1, using only one call
     *  to isSubstring
     *  eg, "pineapple" is a rotation of "neapplepi"
     */
    public boolean isRotation(String s1, String s2) {        //correct
    	if (s1.length()!=s2.length()){
    		return false;
    	}
    	String n=s1+s1;
    	return isSubstring(n, s2);
    }
    
    public static boolean isSubstring(String s1, String s2) {
        if (s2 == null || s2.length() == 0) return true;
        if (s1 == null || s1.length() == 0) return false;
        for (int i = 0; i <= s1.length() - s2.length(); i++) {
            if (s1.charAt(i) == s2.charAt(0)) {
                if (s1.substring(i, i + s2.length()).equals(s2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *  Given two strings, write a method to decide if one is a permutation of the other
     *  hint: the comparison is case sensitive and whitespace is significant
     */
    public boolean isPermutation(String s1, String s2) {            //correct, but remember, try not to use Arrays.sort() because its time complexity is hgih
        if (s1.length()!=s2.length())
        	return false;
        char[]a=s1.toCharArray();
        char[]b=s2.toCharArray();
        
        Arrays.sort(a);
        Arrays.sort(b);
        
        return Arrays.equals(a, b);
    }

    /**
     *  Write a program to implement encoding and decoding string. The rule is simple: encode successive
     *  repeated characters by the repetition count and the character. For example, the input of encoding()
     *  is "aaaabcccaa", you should return "4a1b3c2a". The decoding of "3e4f2e" returns "eeeffffee". Assume
     *  the string to be encoded consists of letters of the alphabet, with no digits, and the string to be
     *  decoded is a valid encoding.
     */
    public static String encoding(String s) {                //correct
    	int count=1;
    	StringBuilder x=new StringBuilder();
    	for (int i=1;i<=s.length();++i){
    		if (i==s.length()||s.charAt(i)!=s.charAt(i-1)){
    			x.append(count);
    			x.append(s.charAt(i-1));
    			count=1;
    		}else{
    			++count;
    		}
    	}    	
    	
    	return x.toString();
        	
 
    }
    public static String decoding(String s) {
    	StringBuilder output= new StringBuilder(); 
    	int count=0;
    	for (int i=0; i<s.length();i++){
    		char c=s.charAt(i);
    		if (Character.isDigit(c)){
    			count=count*10+c-'0';
    		}else{
    			while(count>0){
    				output.append(c);
    				count--;
    			}
    		}
    	}
    	return output.toString();
    }

    //Extra Credit
    /**
     *Given an m x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
     * For exmaple, given 1 2 3  , return 7 4 1
     *                    4 5,6           8 5 2
     *                    7,8,9           9 6 3
     *tip: image could be a square or a rectangle.
     */
    public void rotate(int[][] matrix) {                  //wrong, one thing, you could not print 2D matrix like this; another thing, for the given example, your output is wrong
        int x=matrix.length;
        for (int i=0; i<x/2; i++){
        	for (int j=0; j<Math.ceil(((double)x)/2.);j++){
        		int temp=matrix[i][j];
        		matrix[i][j]=matrix[x-1-j][i];
        		matrix[x-1-j][i]=matrix[x-1-j][x-1-j];
        		matrix[x-1-i][x-1-j]=matrix[j][x-1-i];
        		matrix[j][x-1-i]=temp;
        	}
        }
        System.out.println(matrix);
    }

     /**
     *Given a string containing just the characters '(', ')', return the count of valid parentheses. If the
     * intput is not valid, return -1. A valid parentheses is "()". For example, given "(())", return 2;
     * given "(()))", return -1.
     * you do not need to do it in-place. Please print out the result 2D matrix in the method. 
     * You don't have to return the result matrix. 
     */
     public int countValidParentheses(String s) {
         return 0;
     }

    /**
     * Write anything you think about this assignment here. Easy? Difficult? Too many questions? Less fun?
     * You could write any comments here
     */
    
}
    	 	
