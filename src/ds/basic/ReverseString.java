package ds.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class StackR{
	private int maxLength;
	private char[] stackArray;
	private int top;
	
	public StackR(int max) {
		maxLength = max;
		stackArray = new char[maxLength];
		top = -1;
	}
	
	public void push(char c) {
		stackArray[++top] = c;
	}

	public char pop() {
		return stackArray[top--];
	}
	
	public char peek() {
		return stackArray[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
}


class Reverser{
	private String input;
	private String output;
	public Reverser(String in) {
		input = in;
	}
	
	public String doReverse() {
		int strLength = input.length();
		StackR stackR=new StackR(strLength);
		for(int i=0; i< strLength; i++)
			stackR.push(input.charAt(i));
		output =" ";
		while(!stackR.isEmpty())
			output += stackR.pop();
		return output;
	}
	
}
public class ReverseString{
	public static void main(String[] args) throws IOException {
		System.out.println(" reversed string "+new Reverser(new BufferedReader(new InputStreamReader(System.in)).readLine()).doReverse());
		
	}
	}
	
