package lobster.struct;

import java.util.Arrays;

public class MaxHeap<T extends Comparable<T>> {
	
	private Comparable<T>[] _data;
	private int _size;

	@SuppressWarnings("unchecked")
	public MaxHeap(int n) {
		this._size=0;
		this._data = new Comparable[n];
	}
	
	@SuppressWarnings("unchecked")
	public MaxHeap() {
		this._size=0;
		this._data = new Comparable[16];
	}
	
	public void insert(T t) {
		if(_size == _data.length) {
			_data=Arrays.copyOf(_data, _data.length+1);
		}
		int p = _size;
		this._data[p] = t;
		_size++;
		rebuild4Insert();
	}
	
	@SuppressWarnings("unchecked")
	public T top() {
		if(_size == 0) {
			return null;
		}
		T top = (T) this._data[0];
		this._data[0] = this._data[_size-1];
		this._data[_size-1] = null;
		_size--;
		rebuild4Top();
		return top;
	}
	
	@SuppressWarnings("unchecked")
	private void rebuild4Insert() {
		int _p = this._size-1<0?0:this._size-1;
		while(_p!=0 && this._data[_p].compareTo((T) this._data[_p/2-1+_p%2])>0 ) {
			Comparable<T> tem = this._data[_p];
			this._data[_p] = this._data[_p/2-1+_p%2];
			this._data[_p/2-1+_p%2] = tem;
			_p=_p/2-1+_p%2;
		}
	}
	@SuppressWarnings("unchecked")
	private void rebuild4Top() {
		int _p = 0;
		while(_p<_size) {
			int _l=2*_p+1;
			int _r = 2*_p+2;
			int t = _p;
			Comparable<T> _max = null;
			if(_l<_size) {
				_max = _data[_l];
				t=_l;
			}
			if(_r<_size) {
				if(_data[_r].compareTo((T) _data[_l])>0) {
					_max = _data[_r];
					t=_r;
				}
			}
			if(_max!= null && _data[_p].compareTo((T) _max)<0) {
				swap(_p,t);
				_p=t;
			}else {
				break;
			}
		}
	}
	
	private void swap(int i , int j){
		Comparable<T> tem = _data[i];
		_data[i]=_data[j];
		_data[j]=tem;
	}
	
	public static void main(String[] args) {
		MinHeap<Integer> minHeap = new MinHeap<Integer>(5);
		
		minHeap.insert(1);
		minHeap.insert(0);
		minHeap.insert(5);
		minHeap.insert(2);
		minHeap.insert(7);
		
		System.out.println(minHeap.top());
		System.out.println(minHeap.top());
		System.out.println(minHeap.top());
		System.out.println(minHeap.top());
		System.out.println(minHeap.top());
	}
}
