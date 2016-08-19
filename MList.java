/**
 * Linked list methods implementation using Java generics.
 * head = is a pointer to the first element in the list.
 * empty() method = validates if list is empty
 * MList() constructor = initialize the head with null;
 * getFirst method= getter/setter type of method -checks first to see if the list is empty and then returns the first element.
 * addFirst method = adds the first element in the list and links the head to this pointer
 * removeFirst method = removes the first element in the list by re-creating the pointer to the first element (head).
 */

/**
 * @author atcaciu
 *
 */




import java.util.NoSuchElementException;

public class MList<E> {
	MNode<E> head = null;
	
	public MList()
	{
		head = null;
	} 

	public boolean empty(MList<E> list) 
	{
		if (list.getFirst() != null)
			return false;
		else return true;
	}
	public E getFirst()
	   {
	      if(head == null) throw new NoSuchElementException();

	      return head.getData(head);
	      }
	public void addFirst(E element) {
		head = new MNode<E>(element, head);
	}
	
	public E removeFirst()
	{
		E tmp = getFirst();
		System.out.println(tmp.toString());
		head = head.getNext(head);
		return tmp;
	}
}