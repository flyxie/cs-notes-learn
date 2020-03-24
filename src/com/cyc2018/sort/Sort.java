package com.cyc2018.sort;

public abstract class Sort<T extends Comparable<T>> {
	public abstract void sort(T[] nums);

	protected boolean less(T v, T w) {
		return v.compareTo(w) < 0;
	}

	protected void swap(T[] arr, int i, int j) {
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}
}
