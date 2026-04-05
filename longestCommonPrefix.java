
public class longestCommonPrefix
{
	public static int lcommonprefix(String str){
	   // int count = str.length();
    //     System.out.println("Original String:"+str+" & its length:"+count);
    //     String sub = str.substring(1,str.length());
    //     System.out.println("Sub string:"+sub+" & its length:"+sub.length());
        
    //     int i = 0;
    //     int subIndex = 1;
    //     String sub1 = str.substring(subIndex,str.length());
    //     int j = 0;
        
    //     int sum = 0;
    //     sum = sum + count;
    //     int subcount = 0;
    //     while(i < str.length() && j < sub1.length()){
    //         if(str.charAt(i) != sub1.charAt(j)){
    //             sub1 = str.substring(subIndex++,str.length());
    //             sum = sum + subcount;
    //             subcount = 0;
    //             i = j = 0;
    //             break;
    //         }
    //         subcount++;
    //         i++;
    //         j++;
    //     }
        int sum = 0;
        int match = 0;
        int n = str.length();
        for(int i = 0; i < n;i++){
            for(int j = 0; j < n - i;j++){
                if(str.charAt(j) == str.charAt(i+j)){
                    match++;
                }else{
                    break;
                }
            }
            sum = sum + match;
            match = 0;
        }
        return sum;
	}
	public static void main(String[] args) {
		//System.out.println("Hello World");
		
		int res = lcommonprefix("ababaa");
		System.out.println(res);
	}
}
