package ds.basic;

public class StackAppln {

	public static void main(String[] args) {
		StackX stk = new StackX(10);
		stk.push("madhu");
		stk.push("valeti");
		stk.push("vallli");
		stk.push("nipun");
		stk.push("sudhan");
		stk.push("ruthu");
		stk.push("madhu");
		stk.push("valeti");
		/*stk.push("vallli");
		stk.push("nipun");
		stk.push("sudhan");
		stk.push("ruthu");
*/
		System.out.println(" stack length "+stk.getLength());
		stk.pop();
		stk.pop();
		stk.pop();
		
		System.out.println(" stack length "+stk.getLength());
	}

}
class StackX{
	private String[] strList;
	private int top;
	private int maxLen;
	public StackX(int maxlength) {
		strList = new String[maxlength];
		maxLen = maxlength;
		top = -1;
	}
	
	public void push(String str) {
	
		if(top == maxLen) System.out.println("Stack is full");
		 strList[++top] = str;
	}
	
	public String pop() {
		return strList[top--];
	}
	
	public String peek() {
		return strList[top];
	}
	
	public int getLength() {
		return top+1;
	}
	
	public boolean isEmpty() {
		return (top ==-1);
	}
	
	public boolean isFUll() {
		return (top == maxLen-1);
	}
	
	public void display() {
		
		
	}
	
}
