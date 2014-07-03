package com.feinno.test;

import java.util.Random;

/**
 * 希尔排序
 * @author renzhaolong
 *
 */
public class ShellSort extends SortBase {

	public ShellSort(){
		super("ShellSort");
	}
	
	@Override
	protected void sort(int[] arr) {
		int step = arr.length / 2;
		while (step > 0){
			for (int i = 0; i < step; i++){
				insertSort(arr, i, step);
			}
			step = (int)((double)step / 2);
		}
	}
	
	private void insertSort(int[] arr, int startNo, int step){
		for (int i = startNo + step; i < arr.length; i += step){
			for (int j = i; j > 0; j -= step){
				if (j - step < 0){
					break;
				}
				if (smaller(arr[j], arr[j - step])){
					swap(arr, j, j - step);
				}
				else{
					break;
				}
			}
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = new int[100];
		Random r = new Random();
		for (int i =0; i < arr.length; i++){
			arr[i] = r.nextInt(1000);
		}
		SortBase sort = new ShellSort();
		sort.beginSort(arr);

		if (sort.checkedResult()){
			System.out.println(sort.getResult());
		}
		else{
			System.out.println("wrong order");
		}
	}
}
