package test;
public interface IDate{
    /*This Interface is for Kamiak High School's AP CS A course
     * 2020 - Mr. Binz
     * This is for the programming project 8.2 in Building Java Programs
     * 
     * Since this is the first interface you will use, a couple of notes:
     * 1)  Do not edit this document.  Any changes will be done and then re-uploaded
     * 2)  In additon to implementing all of the following methods you need a detailed Constructor
     *      public Date(int year, int month, int day){...Implementation not shown...};
     * 3)  The following needs to be added to your header:  implements IDate
     *      public class Date implements IDate{
     * 4)  There will be a tester file for this project.  Write it to specifications, or it will not work!
     * 5)  You will need to store 3 integers representing day, month and year
     *      I also stored an int array that stores the days of the month!
     */
    
    //Moves this IDate forward in time by the given number of days
    //This one is tough.  Make a plan!!!
    public void addDays(int days);
    //Moves this IDate forward in time by the given number of weeks
    //This one is easy once you have done addDays!
    public void addWeeks(int weeks);
    //Returns the number of days that this Date must be adjusted to make it equal to the given other IDate
    //This one is tough!  Make a plan!!!
    public int daysTo(IDate other);
    //returns the day value for this IDate
    public int getDay();
    //returns the month value for this IDate;
    public int getMonth();
    //returns the year value for this IDate;
    public int getYear();
    //returns true if this IDate falls on a leap year, false if not
    //A year is a leap year if:
    //the year is divisible by 4, but not 100...but 400 is ok!
    //the above statement can be translated to a boolean, and returned!
    public boolean isLeapYear();
    //Overrides the toString method to display the IDate as "YYYY/MM/DD"
    public String toString();
    //the above doesn't need to be in the interface because it is 
    //already defined in the Object class.  I am including it here
    //to indicate you must override it!
}
