public class catAndMouseProblem
{
    // Complete the catAndMouse function below.
	static String catAndMouse(int x, int y, int z) {
	    int catA = Math.abs(z - x);     //important to ignore negative or to get positive version of differences
	    int catB = Math.abs(z - y);
    	   
	    if(catA < catB){
	        return "Cat A";
	    }else if(catA == catB){
	        return "Mouse C";
	    }else{
	        return "Cat B";
	    }
	    
    }
	public static void main(String[] args) {
		//System.out.println("Hello World");
		String value  = catAndMouse(1,3,2);
		System.out.println(value);
	}
}