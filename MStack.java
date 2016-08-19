/**
 * 
 */

/**
 * @author atcaciu
 *
 */
	public interface MStack<E> {
		void push(E element);
		E pop();//return & removes an Stack element it
		E peek(); //return element on top of Stack
		boolean empty(); //checks if Stack is empty
	}

