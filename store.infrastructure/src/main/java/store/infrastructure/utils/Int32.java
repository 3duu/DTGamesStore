package store.infrastructure.utils;

public final class Int32 extends Number implements Comparable<Integer>  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5528508404531342852L;
	
	private Integer value;
	
	public static final int MIN_VALUE = -2147483648;
    public static final int MAX_VALUE = 2147483647;

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return 0;
	}


	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public int compareTo(Integer o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
