package module10;

import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("rawtypes")
public class MyStack<E> implements Iterable {
	protected E[] data = null;
	protected int stack_pointer = 0;

	@SuppressWarnings("unchecked")
	public MyStack(int capacity) {
		data = (E[]) new Object[capacity];
	}

	public void push(E element) throws MyStackException {
		if (stack_pointer == data.length)
			throw new MyStackException("Stack overflow.");
		data[stack_pointer++] = element;
	}

	public boolean isEmpty() {
		return stack_pointer == 0;
	}

	public int size() {
		return stack_pointer;
	}

	public E pop() throws MyStackException {
		if (stack_pointer == 0)
			throw new MyStackException("Stack underflow.");
		E e = data[--stack_pointer];
		data[stack_pointer] = null;
		return e;
	}

	@Override
	public Iterator iterator() {

		return new Iterator<E>() {

			private int i = 0;

			@Override
			public E next() {
				if (i > stack_pointer - 1)
					throw new NoSuchElementException("No element to retrieve.");
				return data[i++];
			}

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

		};

	}

}
