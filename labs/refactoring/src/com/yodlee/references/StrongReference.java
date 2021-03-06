package com.yodlee.references;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class StrongReference {
	static class Animal {
		private char[] memoryChunk = new char[1024];
		private String name = "";

		public Animal(String name) {
			this.name = name;
		}

		protected void finalize() {
			System.out.println("Rest in Peace!" + name);
		}
	}

	public static void main(String[] args) {
//		List<SoftReference<Animal>> animalList = new ArrayList<>();
		List<WeakReference<Animal>> animalList = new ArrayList<>();
		int maxObj = 0;
		try {
			for (int i = 0; i < 1000000; i++) {
				Animal a = new Animal("Animal " + i);
				animalList.add(new WeakReference<>(a));
				maxObj = i;
				
				Thread.sleep(10);
			}

		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.out.println("Reference complete" + maxObj);
		
		for (WeakReference<Animal> a : animalList) {
			System.out.println((a.get() != null) ? a.get().name : null);
		}
	}
}
