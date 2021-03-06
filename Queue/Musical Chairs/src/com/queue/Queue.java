package com.queue;

import com.link.*;

public class Queue<E>
{
  private Link<E> front , rear;
  int count;

  public Queue()
  {
    front = null;
    rear = null;
  }

  public int getNum()
  {
    return count;
  }

  public void Enqueue(E e)
  {
	  Link<E> node = new Link<E>(e);
	  if (isEmpty())
	  {
		  front = node;
		  rear = node;
		  rear.setNext(front);
	  }
	  else
	  {
		  rear.setNext(node);
		  rear = node;
		  rear.setNext(front);
	  }
	  ++count;
  }
  
  public E Peek()
  {
	  return front.getData();
  }

  public E Dequeue()
  {
	  if (front == null)
		  return null;
	  if (front.getNext() == null)
	  {
		  E data = front.getData();
		  front = null;
		  --count;
		  return data;
	  }
	  else
	  {
	    	E data = front.getData();
	    	front = front.getNext();
	    	--count;
	    	return data;
	  }
  }
  
  public void rotate()
  {
	  rear.setNext(front);
	  rear = front;
	  front = front.getNext();
  }

  public boolean isEmpty()
  {
    if (front == null)
      return true;
    return false;
  }
}
