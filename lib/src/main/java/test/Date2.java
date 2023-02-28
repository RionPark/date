package test;

public class Date2 implements IDate {
	private int year;
	private int month;
	private int day;
	private int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private final int LeapMonth = 1;

	public Date2(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;

		if (isLeapYear()) {
			daysInMonth[LeapMonth] = 29;
		}
	}

	@Override
	public String toString() {
		return year + "/" + String.format("%02d", month) + "/" + String.format("%02d", day);
	}

	@Override
	public void addDays(int days) {
		calDate(days);
	}

	@Override
	public void addWeeks(int weeks) {
		calDate(weeks * 7);
	}

	@Override
	public int daysTo(IDate other) {
		return Math.abs(abstractDate(this) - abstractDate(other));
	}

	@Override
	public int getDay() {
		return day;
	}

	@Override
	public int getMonth() {
		return month;
	}

	@Override
	public int getYear() {
		return year;
	}

	@Override
	public boolean isLeapYear() {
		return (this.year % 4 == 0 && this.year % 100 != 0) || this.year % 400 == 0;
	}

	// 차이 계산
	private int abstractDate(IDate date) {
		int leapCount = date.getYear() / 4;
		leapCount -= date.getYear() / 100;
		leapCount += date.getYear() / 400;
		int days = leapCount * 366;
		days += (date.getYear() - leapCount) * 365;
		
		int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (date.isLeapYear()) {
			daysInMonth[LeapMonth] = 29;
		}
		for (int i = 0; i < date.getMonth()-1; i++) {
			days += daysInMonth[i];
		}
		days += date.getDay();
		return days;
	}

	public static void main(String[] args) {

		Date2 date1 = new Date2(100, 1, 1);
		System.out.println(date1.abstractDate(date1));
		Date2 date2 = new Date2(200, 1, 1);
		System.out.println(date1.abstractDate(date2));

	}

	// 현재 연도 기준 남은 day
	private int leftDate() {
		int day = 0;
		int year = isLeapYear() ? 366 : 365;

		if (this.month == 1) {
			day += this.day;
		} else {
			for (int j = 1; j < this.month; j++) {
				day += daysInMonth[j - 1];
			}
			day += this.day;
		}
		return year - day;
	}

	private void calDate(int date) {
		int leftDay = leftDate();
		int totalDay = date - leftDay;

		this.year++;
		this.month = 1;
		this.day = 0;

		for (int j = 0; j < totalDay; j++) {
			day++;
			int lastDay = daysInMonth[month - 1];
			if (day > lastDay) {
				month++;
				day = 1;
			}
			if (month > daysInMonth.length) {
				daysInMonth[LeapMonth] = 28;
				if (isLeapYear()) {
					daysInMonth[LeapMonth] = 29;
				}
				year++;
				month = 1;
			}
		}
	}
}