package list.arraylist.implementation;

public class ArrayList {
	private int size = 0;
	private Object[] elementData = new Object[100];	// 내부적으로 사용할 용도

	public boolean add(int index, Object element) {
	    // 엘리먼트 중간에 데이터를 추가하기 위해서는 끝의 엘리먼트부터 index의 노드까지 뒤로 한칸씩 이동시켜야 합니다.
	    for (int i = size - 1; i >= index; i--) {
	        elementData[i + 1] = elementData[i];
	    }
	    // index에 노드를 추가합니다.
	    elementData[index] = element;
	    // 엘리먼트의 숫자를 1 증가 시킵니다.
	    size++;
	    return true;
	}
	
	public boolean addLast(Object element) {
	    elementData[size] = element;
	    size++;
	    return true;
	}
	
	public int size() {
		return size;
	}
	
	public ListIterator listIterator() {
		return new ListIterator();
		
	}
	
	class ListIterator{
		private int nextIndex=0;
		
		public boolean hasNext() {
			return nextIndex < size();
		}
		
		public Object next() {
			return elementData[nextIndex++];
		}
	}
}
