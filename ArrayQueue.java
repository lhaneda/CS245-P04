
public class ArrayQueue implements Queue {
	private Object[] arr = new Object[600];
	private int head = 0, tail = 0;
	
	public Object dequeue() {
		if(empty()) {
			return null;
		}
		Object item = arr[head];
		head++;
		if(head == arr.length) {
			head = 0;
		}
		return item;
	}
	
	public void enqueue(Object item) {
		if(full()) {
			growQueue();
		}
		arr[tail++] = item;
		tail = tail % arr.length;
	}
	
	public boolean empty() {
		if(head == tail) {
			return true;
		}
		return false;
	}
	
	private boolean full() {
		if((head + 1) % arr.length == head) {
			return true;
		}
		return false;
	}
	
	private void growQueue() {
		Object[] newArray = new Object[arr.length * 2];
		for(int i = head, j = 0; i != tail; i++, j++) {
			newArray[j] = arr[i];
			i = (i + 1) % arr.length;
		}
		arr = newArray;
	}
}
