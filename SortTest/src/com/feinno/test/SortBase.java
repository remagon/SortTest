package com.feinno.test;

/**
 * 排序基类，提供统计数据
 * @author renzhaolong
 *
 */
public abstract class SortBase {
	protected String sortType;
	protected int swapCount;
	protected int compareCount;
	protected int[] sortedArr;
	
	public SortBase(String type){
		sortType = type;
	}
	
	public void beginSort(int[] arr){
		swapCount = 0;
		compareCount = 0;
		sortedArr = arr.clone();
		sort(sortedArr);
	}
	
	protected abstract void sort(int[] arr);
	
	public void swap(int[] arr, int a, int b){
		if (arr.length > a && arr.length > b){
			swapCount++;
			int temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;
		}
	}
	
	public boolean bigger(int a, int b){
		compareCount++;
		return a > b;
	}
	
	public boolean smaller(int a, int b){
		compareCount++;
		return a < b;
	}
	
	public int getSwapCount(){
		return swapCount;
	}
	
	public int getCompareCount(){
		return compareCount;
	}
	
	public int[] getSortedArr(){
		return sortedArr;
	}
	
	public boolean checkedResult(){
		if (sortedArr == null)
			return false;
		
		for (int i = 0; i < sortedArr.length - 1; i++){
			if (sortedArr[i] > sortedArr[i + 1]){
				return false;
			}
		}
		return true;
	}
	
	public String getSortType(){
		return sortType;
	}
	
	public String getResult(){
		return sortType + ":\r\n swapCount:" + swapCount + "\r\n" + " compareCount:" + compareCount + "\r\n";
	}
}
