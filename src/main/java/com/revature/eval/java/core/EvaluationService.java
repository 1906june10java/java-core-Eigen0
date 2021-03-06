package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		StringBuilder acronym = new StringBuilder(" "); 
		
	
		
		String delimeters = "[^a-zA-Z]+";
		String[] words = phrase.split(delimeters);
		
		for (String word: words)
			acronym.append(word.charAt(0));
		return acronym.substring(1)
				.toString().toUpperCase();
	}

	/**
	 * 2. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		String[] point_Letters= {"AEIOULNRST",
								 "DG",
								 "BCMP",
								 "FHVWY",
								 "K",
								 "JX",
		 						 "QZ"};
		int clusterTracker=0;
		int wordScore=0;
		for(String letterCluster: point_Letters)
		{
			
			for(char letter: string.toUpperCase().toCharArray() )
				if (letterCluster.indexOf(letter)!=-1)
					switch(clusterTracker)
					{
						case 0:
								wordScore+=1;
							break;
						case 1:
								wordScore+=2;
							break;
						case 2:
								wordScore+=3;
							break;
						case 3:
								wordScore+=4;
							break;
						case 4:
								wordScore+=5;
							break;
						case 5:
								wordScore+=8;
							break;
						case 6:
								wordScore+=10;
							break;	
						default:
					}
		clusterTracker++;
		}

		
		return wordScore;
	}

	/**
	 * 3. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) throws IllegalArgumentException  {
		// TODO Write an implementation for this method declaration
		StringBuilder acronym = new StringBuilder(" "); 
		String number=new String();
	
		//String brands = "Orange,Apple,Blackberry";
		String delimeters = "[\\D]+";
		String[] numberChunks = string.trim().split(delimeters);

		for (String numberChunk: numberChunks)
			acronym.append(numberChunk);
		
		number=acronym.substring(1) .toString();
		if(number.length()>11||number.length()<10)
			throw new IllegalArgumentException("too many digits");

		return number;
	}

	/**
	 * 4. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		  Map< String,Integer> wordCountTracker =   new HashMap< String,Integer>();
		  String delimeters = "[^a-z]+";
		  String[] words = string.trim().split(delimeters);
		  for(String word:words)
			  if(wordCountTracker.containsKey(word))
				  wordCountTracker.put(word, (wordCountTracker.get(word))+1); 
			  else
				  wordCountTracker.put(word, new Integer(1)); 
		return wordCountTracker;
	}

	/**
	 * 5. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 6. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		
		int armstrongNo=0;
		String strInput = Integer.toString(input); 
		
		for(int i=0;i< strInput.length();i++)
		{
			armstrongNo += Math.pow(strInput.charAt(i)-48,
					strInput.length());
		}
		if(armstrongNo==input)
			return true;
		else
			return false;
	}

	/**
	 * 7. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		
		List<Long> primeFactors = new ArrayList<>();
		
		for(int i=2; i<=l;i++)
		{
			while(l % i == 0)
            {
				
				primeFactors.add((long)i);
				l=l/i;
            }
			
		}
		return primeFactors;
	}


	/**
	 * 8-9. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		
		/**
		 * Question 8
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			StringBuilder encodedString=new StringBuilder();
			int wordCounter=0;
			
			string =  string.replaceAll("[^a-zA-Z0-9]", "");
			string=string.toLowerCase();
			
			for(int i=0;i< string.length();i++)
			{
				if(wordCounter%5==0)
					encodedString.append(" ");
				
				if(string.charAt(i)>=97&&string.charAt(i)<=122){
					encodedString.append((char)(96+26-(string.charAt(i)-97)));
					wordCounter++;
				}
				else if	(string.charAt(i)>=48&&string.charAt(i)<=57) {
					encodedString.append(string.charAt(i));
					wordCounter++;
				}
				
			}
			return encodedString.substring(1).toString();
		}

		/**
		 * Question 9
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			
			StringBuilder decodedString=new StringBuilder();
			
			string =  string.replaceAll("[^a-zA-Z0-9]", "");
			string=string.toLowerCase();
			
			for(int i=0;i< string.length();i++)
				if(string.charAt(i)>=97&&string.charAt(i)<=122){
					decodedString.append((char)(96+26-(string.charAt(i)-97)));
				}
				else if	(string.charAt(i)>=48&&string.charAt(i)<=57) {
					decodedString.append(string.charAt(i));
				}
			
			return decodedString.toString();
		}
	}

	/**
	 * 10. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		String getDigits=string;
		
		getDigits = string.replaceAll("[a-zA-Z^?]+","");
		String[] digits = getDigits.trim().split("[ ]+"); 

		if(string.contains("plus"))
			return Integer.parseInt(digits[0])+
					Integer.parseInt(digits[1]);
		else if(string.contains("minus"))
			return Integer.parseInt(digits[0])-
					Integer.parseInt(digits[1]);
		else if(string.contains("divide"))
			return Integer.parseInt(digits[0])/
					Integer.parseInt(digits[1]);
		else if(string.contains("multi"))
			return Integer.parseInt(digits[0])*
					Integer.parseInt(digits[1]);
//		 
		return 0;
	}

}
