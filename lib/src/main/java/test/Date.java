package test;

public class Date implements IDate {
	private int year;
	private int month;
	private int day;
	private int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
		if (isLeapYear()) {
			daysInMonth[1] = 29;
		}
	}

	@Override
	public void addDays(int days) {
		for (int i = 1; i <= days; i++) {
			day++; // 1
			int lastDay = daysInMonth[month - 1];
			if (day > lastDay) {
				day = 1;
				month++;
			}
			if (month > 12) {
				month = 1;
				year++;
				daysInMonth[1] = 28;
				if (isLeapYear()) {
					daysInMonth[1] = 29;
				}
			}
		}
	}

	@Override
	public void addWeeks(int weeks) {
		addDays(weeks * 7);
	}

	private int getDay(IDate date) {
		int days = 0;
		for (int i = 1; i <= date.getYear(); i++) {
			if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
				days++;
			}
			days += 365;
		}
		int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (date.isLeapYear()) {
			daysInMonth[1] = 29;
		}
		for (int j = 0; j < date.getMonth()-1; j++) {
			days += daysInMonth[j];
		}
		days += date.getDay();
		return days;
	}

	@Override
	public int daysTo(IDate other) {
		return Math.abs(getDay(this) - getDay(other));
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
		return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
	}

	@Override
	public String toString() {
		return String.format("%04d/%02d/%02d", year, month, day);
	}

}
