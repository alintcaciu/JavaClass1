/**
 * @author atcaciu
*Implementing Stack (MyStack) using the linked and 
*classes MList and MNode. Used MStack interface and implemented
*methods for this interface 
 */


import java.util.NoSuchElementException;


public class MyStack<E> implements MStack<E> 
{
	MList<E> list = new MList<E>();
		
public void push(E element)
{
	list.addFirst(element);
}

public E pop()

{	if (empty()) throw new NoSuchElementException("Stack underflow");
	return list.removeFirst();
}

public E peek()
{
	if (empty()) throw new NoSuchElementException("Stack underflow");
    return list.getFirst();
}

public boolean empty() 
{
	if (list.getFirst() != null)
		return false;
	else return true;
}

public class MyStackArray<E> implements MStack<E>
{

	@Override
	public void push(E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return false;
	}}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		//Testing using String
		MyStack<String> a = new MyStack<String>();
		a.push("A");
		a.push("B");
		a.push("C");
		
		a.pop(); //should work
		
		a.pop(); //should work
		a.empty(); //should work
		a.peek(); //should work

		
		a.pop();//should work
		//a.empty(); //should fail
		*/
		
		//Testing using Integer
		MyStack<Integer> b = new MyStack<Integer>();
		b.push(1);
		b.push(2);
		b.push(3);
		
		b.pop(); //should work
		
		b.pop(); //should work
		b.empty(); //should work
		b.peek(); //should work

		
		b.pop();//should work
		//b.empty(); //should fail
		
	}

}
