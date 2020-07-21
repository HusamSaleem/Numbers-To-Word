import java.util.Scanner;

// Will turn a number from 0 - 999 into a string

public class NumberToWord {
	Scanner scan = new Scanner(System.in);
	
	final String[] SINGLE_DIGIT_WORDS = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	final String[] SPECIAL_CASE_WORDS = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	final String[] DOUBLE_DIGIT_WORDS = {"Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	final String TRIPLE_DIGIT_KEY = "Hundred";
	
	public NumberToWord() {
		getInput();
	}
	
	public static void main(String[] args) {
		NumberToWord app = new NumberToWord();
	}
	
	private void getInput() {
		System.out.println("Enter a number to convert to words");
		int num = 0;
		num = Integer.parseInt(scan.next());
		
		System.out.println(convertToWords(num));
		//
		getInput();
	}
	
	private String convertToWords(int num) {
		if (num <= 9) {
			return printSingleDigits(num);
		} else if (num <= 99) {
			return printDoubleDigits(num);
		} else if (num <= 999) {
			return printTripleDigits(num);
		}

		
		return null;
	}
	
	private String printSingleDigits(int num) {
		return SINGLE_DIGIT_WORDS[num];
	}
	
	private String printDoubleDigits(int num) {
		if (num < 20) {
			return SPECIAL_CASE_WORDS[num - 10];
		}
		
		String numAsWord = null;
		if (num % 10 == 0) {
			numAsWord = DOUBLE_DIGIT_WORDS[getFirstDigit(num) - 2];
		} else {
			numAsWord = DOUBLE_DIGIT_WORDS[getFirstDigit(num) - 2] + "-" + SINGLE_DIGIT_WORDS[num % 10];
		}
			
		return numAsWord;
	}
	
	private String printTripleDigits(int num) {
		String numAsWord = null;
		if (num % 100 == 0) {
			numAsWord = printSingleDigits(getFirstDigit(num)) + " " + TRIPLE_DIGIT_KEY + " ";
		} else if (num % 100 < 9) {
		numAsWord = printSingleDigits(getFirstDigit(num)) + " " + TRIPLE_DIGIT_KEY + " " + printSingleDigits(num % 100);
		} else {
			numAsWord = printSingleDigits(getFirstDigit(num)) + " " + TRIPLE_DIGIT_KEY + " " + printDoubleDigits(num % 100);
		}
		
		return numAsWord;
	}
	 
	private int getFirstDigit(int num) {
		int firstDigit = Integer.parseInt(Integer.toString(num).substring(0, 1));
		return firstDigit;
	}
}
