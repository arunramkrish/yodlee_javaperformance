package com.yodlee.oldio;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Date;

public class OldIo {

	public static void main(String[] args) throws FileNotFoundException {
		Long startTime = System.currentTimeMillis();
		PrintStream outStream = new PrintStream("oldio.csv");
		for (int i = 0; i < 1000000; i++) {
			outStream.println(new TransactionLog(new Date(), String.valueOf(i), (i % 3 == 0) ? "CREDIT" : "DEBIT",
					i * Math.random() * 100, "txn " + i));

			if ((i % 100) == 0) {
				outStream.flush();
			}
		}
		outStream.close();
		System.out.println("Time taken " + 
		((System.currentTimeMillis() - startTime) / 1000) + " seconds");
	}

}
