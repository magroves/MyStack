package stacks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InfixExpressionEvaluator extends BalanceChecker{


	public static void main(String[] args) throws FileNotFoundException {

//		if (args.length == 0) {
//			throw new FileNotFoundException();
//		}
//
//		File file = new File(args[0]);
		
		Scanner in = new Scanner(System.in);
		String infix = in.nextLine();
		String var = in.nextLine();

		in.close();

		String i = variables(infix,var);
		// checkBalance(i);
		double result = evaluateInfix(i);

		System.out.print(result);
		// output : 61
	}

	public static String variables(String a, String b) {
		//		char[] line1 = a.toCharArray();
		//		char[] line2 = b.toCharArray();

		String result = "";

		for (int i = 0; i < a.length(); i++) {

			if (Character.isLetter(a.charAt(i))) {
				int j = b.indexOf(a.charAt(i));
				result += b.charAt(j+2);
			}

			else if (Character.isDigit(a.charAt(i))) {
				result += a.charAt(i);	
			}

			else {
				result += a.charAt(i);
			}
		}
		return result;
	}

	public static double evaluateInfix(String infix) {

		MyStack<Character> operatorStack = new MyStack<Character>();
		MyStack<Double> valueStack = new MyStack<Double>();

		char topOperator;

		//loops through each token and pushes to designated stack
		for(int i = 0; i < infix.length(); i++) {

			char nextCharacter = infix.charAt(i);

			if (Character.isDigit(nextCharacter)) { 
				valueStack.push((double)Character.getNumericValue(nextCharacter));
			}

			else if (nextCharacter == '^') {
				operatorStack.push (nextCharacter);
			}

			else if (nextCharacter == '+' || nextCharacter == '-' || nextCharacter == '*' || nextCharacter == '/' ) {

				while (!operatorStack.isEmpty () && (getPrecedence (nextCharacter) <= getPrecedence (operatorStack.peek())))
				{
					topOperator = operatorStack.peek ();

					char topOp = operatorStack.pop();
					double operandTwo = valueStack.pop();
					double operandOne = valueStack.pop();
					double result = apply(topOp, operandOne, operandTwo);
					valueStack.push(result);
				}
				operatorStack.push (nextCharacter);
			} 

			else if (nextCharacter == '(')
				operatorStack.push (nextCharacter);

			else if (nextCharacter == ')') { // stack is not empty if infix expression is valid
				//try {
				double b = valueStack.pop();
				char operator = operatorStack.pop();
				double a = valueStack.pop();
				double result = 0;

				if(operator == '*')
					result = a*b;
				else if(operator == '/')
					result = a/b;
				else if(operator == '+')
					result = a+b;
				else if(operator == '-')
					result = a-b;
				else if(operator == '^')
					result = Math.pow(a, b);
				valueStack.push(result);
				operatorStack.pop();
			} 
		}// end for

		double result = 0;

		while (!operatorStack.isEmpty()) {
		topOperator = operatorStack.pop();
		double operandTwo = valueStack.pop();
		double operandOne = valueStack.pop();
		result = apply(topOperator, operandOne, operandTwo);
		valueStack.push(result);
		
		}
		try {
			result = valueStack.pop();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	} // end EvalInfix()


	public static double apply(char operator, double a, double b){

		double result = 0;

		if (operator == '+') 
			result =  a + b;


		else if (operator == '-') 
			result =  a - b;


		else if (operator == '*') 
			result =  a * b;


		else if (operator == '/') 

			if (b == 0)  
				throw new UnsupportedOperationException("Cannot divide by zero");

			else 
				result =  a / b;



		else if (operator == '^') {

			if (b == 0) { result =  1; }
			else if (b == 1) { result =  a; }
			else { result = Math.pow(a, b); }
		}

		return result;
	}		

	private static int getPrecedence (char operator)
	{
		if (operator == '^') 
			return 1;
		else if(operator == '*' || operator == '/')
			return 2;
		else if(operator == '+' || operator == '-')
			return 3;
		else
			return 0;
	} // end getPrecedence

} // end InfixEval
