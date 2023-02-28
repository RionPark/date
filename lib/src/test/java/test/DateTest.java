package test;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class DateTest{

    @Test
    public void testString() {
        IDate date = new Date2(2008, 2, 6);
        assertEquals("February 6, 2008", "2008/02/06", date.toString());
    }
    
    @Test
    public void testStringTwo() {
        IDate date = new Date2(2011, 10, 31);
        assertEquals("October 31, 2011", "2011/10/31", date.toString());
    }

    @Test
    public void testYear() {
        IDate date = new Date2(2008, 2, 6);
        assertEquals("February 6, 2008", 2008, date.getYear());
    }

    @Test
    public void testMonth() {
        IDate date = new Date2(2008, 2, 6);
        assertEquals("February 6, 2008", 2, date.getMonth());
    }

    @Test
    public void testDay() {
        IDate date = new Date2(2008, 2, 6);
        assertEquals("February 6, 2008", 6, date.getDay());
    }

    @Test
    public void testAddDays() {
        IDate date = new Date2(1912, 6, 23);
        date.addDays(60000);
        assertEquals("June 23, 1912: Add 60000 days", "2076/09/30", date.toString());

    }
    
    @Test
    public void testAddDays2() {
        IDate date = new Date2(1938, 1, 10);//Donald Knuth
        date.addDays(100000);
        assertEquals("June 23, 1912: Add 60000 days", "2211/10/26", date.toString());

    }

    @Test
    public void testAddWeeks() {
        IDate date = new Date2(1903, 12, 28);//Von Neumann
        date.addWeeks(200);
        assertEquals("December 28, 1903:  Add 200 weeks", "1907/10/28", date.toString());
    }

    @Test
    public void testIsLeapYearBasic() {
        IDate date = new Date2(1995, 5, 5);
        IDate date2 = new Date2(2008, 2, 6);
        assertEquals("leap test 1995", false, date.isLeapYear());
        assertEquals("leap test 2008", true, date2.isLeapYear());
    }

    @Test
    public void testLeapYearCenturies() {
        IDate date = new Date2(2000, 5, 5);
        IDate date2 = new Date2(1800, 4, 3);
        assertEquals("leap test 2000", true, date.isLeapYear());
        assertEquals("leap test 1800", false, date2.isLeapYear());
    }
    @Test
    public void testDaysTo(){
        IDate date1 = new Date2(1879, 3, 14);
        IDate date2 = new Date2(1942, 1, 8);
        assertEquals("Distance between Einstein and Hawkings Birthday",22945,date2.daysTo(date1));
    }
    @Test
    public void testDaysToTwo(){
        IDate date1 = new Date2(1879, 3, 14);
        IDate date2 = new Date2(1879, 3, 14);
        assertEquals("Distance between Einstein and Hawkings Birthday",0,date2.daysTo(date1));
    }
//    
    @Test
    public void testDaysToThree(){
        IDate date2 = new Date2(1879, 3, 14);
        IDate date1 = new Date2(1942, 1, 8);
        assertEquals("Distance between Einstein and Hawkings Birthday",22945,date2.daysTo(date1));
    }

}
