
public class ArrayStack implements Stack {
	private Object[] arr = new Object[600];
	private int top;
	
	public void push(Object item) {
		if(top >= arr.length) {
			growStack();
		}
		arr[top] = item;
		top++;
	}
	
	public Object pop() {
		if(empty()) {
			return null;
		}
		top--;
		Object item = arr[top];
		arr[top] = null;
		return item;
	}
	
	public boolean empty() {
		if(top == 0) {
			return true;
		}
		return false;
	}
	
	public Object peek() {
		if(empty()) {
			return null;
		}
		return arr[top - 1];
	}
	
	private void growStack() {
		Object[] newArray = new Object[arr.length * 2];
		//System.arraycopy(arr, 0, newArray, 0, arr.length);
		for(int i = 0; i < arr.length; i++) {
			newArray[i] = arr[i];
		}
		arr = newArray;
	}
}
