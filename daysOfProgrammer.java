public class daysOfProgrammer{
    public static String daysOfProgrammer(int y){
    //  int totaldays =  243;  //total days without a leap year.
    //  int leapyr = totaldays + 1;
    //  int days_1918 = totaldays - 13;
    //  int dd = 0;
     String res = "";
    //  if(y == 1918){
    //     dd = 256 - days_1918;
    //     res = dd+".08."+y;
    //  }
    //  if((y%4) == 0 || (y%400) == 0){
    //     dd = 256 - leapyr;
    //     res = dd+".09."+y;
    //  }
    //  else{
    //      dd = 256 - totaldays;
    //      res = dd+".09."+y;
    //  }
      
    
        if(y == 1918){
            return "26.09.1918";
        }
        
        boolean leapYear;
        if(y < 1918){
            leapYear = (y%4 == 0);
        }
        else{
            leapYear = ((y%400 == 0) || (y%4 == 0 && y%100 != 0));
        }
        
        int daysIn8Months = 31 + (leapYear ? 29:28) + 31 + 30 + 31 + 30 + 31 + 31;
        int remainingDays = 256 - daysIn8Months;
        
        res = remainingDays + ".09."+y;        
        return res;
    }

    //main
    public static void main(String[] args) {
	    String res = daysOfProgrammer(1918);
		System.out.println("In String:"+res);
	}
}