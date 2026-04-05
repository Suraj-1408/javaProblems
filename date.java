public class date
{
    public static String timeConversion(String s){
        char ch = s.charAt(s.length() -2);
        
        char first = s.charAt(0);
        char second = s.charAt(1);
        
        String hour = ""+first+second;
        int value = Integer.parseInt(hour);
        System.out.println("Hour Value:"+value);
        
        if(value == 12 && ch == 'A'){
            StringBuilder sb = new StringBuilder(s);
            sb.setCharAt(0,'0');
            sb.setCharAt(1,'0');
            
            String res = sb.toString().substring(0,s.length() - 2);
            return res;
        } 
        else if(value < 12 && ch == 'P'){
            int hrs = value+12;
            String hr = ""+hrs;     //converted to string
            char ch1 = hr.charAt(0);
            char ch2 = hr.charAt(1);
            StringBuilder sb = new StringBuilder(s);
            sb.setCharAt(0,ch1);
            sb.setCharAt(1,ch2);
            
            String res = sb.toString().substring(0,s.length()-2);
            return res;
        }
        return s.substring(0,s.length()-2);
    }
	public static void main(String[] args) {
		//System.out.println("Hello World");
	   // char ch = date("12:00:00AM");
	   // System.out.println("Second last character:"+ch);
	    String res = timeConversion("06:40:03AM");
	    System.out.println("String:"+res);
	}
}
