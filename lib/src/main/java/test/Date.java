package test;

public class Date implements IDate {
	private int year;
	private int month;
	private int day;
	private int[] daysInMonth= {31,28,31,30,31,30,31,31,30,31,30,31};
	public Date(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
		if(isLeapYear()) {
			daysInMonth[1] = 29;
		}
	}

	@Override
	public void addDays(int days) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addWeeks(int weeks) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int daysTo(IDate other) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDay() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMonth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getYear() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isLeapYear() {
		// TODO Auto-generated method stub
		return false;
	}
}
