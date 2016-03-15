package com.yodlee.oldio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TxnFileFilter {

	public static void main(String[] args) throws IOException, ParseException {

		Stream<String> fileStream = Files.lines(new File("oldio.csv").toPath());
		Predicate<TransactionLog> txnType = (t) -> {
			return t.getTxnType().trim().equals("DEBIT");
		};
		TxnMapper mapper = (t) -> t.getAmount();

		fileStream.map(line -> line.split(",")).map(fields -> {
			try {
				return TransactionLog.parseFields(fields);
			} catch (Exception e) {
				System.out.println("inside exception");
				return new TransactionLog();
			}
		}).filter(txnType).forEach((e) -> System.out.println(e));
	}

	@FunctionalInterface
	static interface TxnMapper extends Function<TransactionLog, Double> {

	}

}
