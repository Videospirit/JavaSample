
/**
 *
 * @author elmii
 */
public class MyDate {
 private int day,month,year;
 public String[]months = new String[]{"January","February","March","April","May","June","July","August","September","October","November","Dece,ber"};
 

 public MyDate(int d, int m ,int y){
    this.day=d;
    this.month=m;
    this.year=y;        
 }
 public int getDay(){
    return day;
 }
 public void setDay(int day){
    this.day=day;
 }

 public String getMonthShortForm(){
     String s=months[month-1].substring(0,3);
     return s;
 }
 public int getMonth(){
    return month;    
 }
 public void setMonth(int month){
    this.month=month;
 }
 public void setYear(int year){
    this.year=year;
 }
 public int getYear(){
    return year;
 }

 @Override
 public String toString(){
     return "MyDate{"+
             "day="+day+
             ",month="+month+
             ",year="+year+
             '}';
 }
}
