//Sample input
//s = aba
//t = aba
//k = 7


//Sample output-
//Yes

//Explaination - 
// We perform 4 delete operations to reduce string s to the empty string. Recall that though 
// the string will be empty after 3 deletions, we can still perform a delete operation on an 
// empty string to get the empty string. Next, we perform 3 append operations (i.e., a, b, and a). 
// Because we were able to convert s to t by performing exactly k = 7 operations, we return Yes.
public class deleteAppendOperationOnGivenString
{
    public static String appendAndDelete(String s, String t, int k) {
        // Write your code here
        
        int comlen = 0;
        for(int p = 0, q = 0;p < s.length() && q < t.length();p++, q++){
            if(s.charAt(p) != t.charAt(q)){
                break;
            }   
            comlen++;
        }
        
        int sdiff = s.length() - comlen;
        int tdiff = t.length() - comlen;
        
        int minOps = sdiff + tdiff;
        if(k < minOps){
            return "No";
        }
        
        if(k >= s.length() + t.length()){
            return "Yes";
        }
        if((k - minOps)%2 == 0){
            return "Yes";
        }
        
        return "No";
    }
	public static void main(String[] args) {
		System.out.println("");

		String s = "ashley";
		String t = "ash";
		String res = appendAndDelete(s, t, 2);
		System.out.println(res);
	}
}
