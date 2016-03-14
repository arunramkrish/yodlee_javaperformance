package com.yodlee.refactoring;

public class Bird {

	private static final int EUROPEAN = 0;
	private static final int AFRICAN = 1;
	private static final int NORWEGIAN_BLUE = 2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private int type;
	private int numberOfCoconuts;
	private Object voltage;
	private boolean isNailed;

	double getSpeed() {
		switch (type) {
		case EUROPEAN:
			return getBaseSpeed();
		case AFRICAN:
			return getBaseSpeed() - getLoadFactor() * numberOfCoconuts;
		case NORWEGIAN_BLUE:
			return (isNailed) ? 0 : getBaseSpeed(voltage);
		}
		throw new RuntimeException("Should be unreachable");
	}

	private int getLoadFactor() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getBaseSpeed(Object voltage2) {
		assert (voltage2 != null);
		
		
		// TODO Auto-generated method stub
		return 0;
	}

	private double getBaseSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}
}
