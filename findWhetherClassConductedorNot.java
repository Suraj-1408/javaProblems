import java.util.ArrayList;
import java.util.List;

public class findWhetherClassConductedorNot
{
    public static String angryProfessor(int k, List<Integer> a) {
        // Write your code here
        int onTimeCount = 0;
        for(int i = 0;i < a.size();i++){
            if(a.get(i) <= 0){
                onTimeCount = onTimeCount + 1;
            }
        }
        
        if(onTimeCount >= k){
            return "NO";
        }
        return "YES";
    }
	public static void main(String[] args) {
		//System.out.println("Hello World");
		List<Integer> a = new ArrayList();
// 		a.add(-1);
// 		a.add(-3);
// 		a.add(4);
// 		a.add(2);

        a.add(0);
		a.add(-1);
		a.add(2);
		a.add(1);		
		String res = angryProfessor(2,a);
		System.out.println("Class Cancelled:"+res);
	}
}
