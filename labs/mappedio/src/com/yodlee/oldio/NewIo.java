package com.yodlee.oldio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;

public class NewIo {

public static void main(String[] args) throws FileNotFoundException {
		Long startTime = System.currentTimeMillis();

		MappedByteBuffer out;
		try {
			RandomAccessFile randomAccessFile = new RandomAccessFile("newiotest.csv", "rw");
			FileChannel channel = randomAccessFile.getChannel();
			out = channel.map(FileChannel.MapMode.READ_WRITE, 0,
					1024 * 1024 * 72);
			
			for (int i = 0; i < 1000000; i++) {
				out.put((new TransactionLog(new Date(), String.valueOf(i), (i % 3 == 0) ? "CREDIT" : "DEBIT",
						i * Math.random() * 100, "txn " + i).toString() + "\n").getBytes());
			}
			out.force();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Time taken " + ((System.currentTimeMillis() - startTime) / 1000) + " seconds");
	}

}
