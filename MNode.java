/**
 * Node class implementation for linked list using java generics. 
 */

/**
 * @author atcaciu
 *
 */




public class MNode<E>
{
	private E data;
	private MNode<E> next;
	public MNode(E data, MNode<E> next)
	{
		this.data = data;
		this.next = next;
	}
	public E getData(MNode<E> data)
	{
		return data.data;
	}
	public MNode<E> getNext(MNode<E> data)
	{
		return data.next;
	}
}