import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
public class areaReqToHighlightGivenString
{
    public static int designerPdfViewer(List<Integer> h, String word) {
        
        HashMap<Character,Integer> alpha = new HashMap();
        for(char ch = 'a'; ch <= 'z';ch++){
            if(!alpha.containsKey(ch)){
                alpha.put(ch,ch-'a'+1);
            }
        }
        
        //printing map
        // for(Map.Entry<Character,Integer> item: alpha.entrySet()){
        //     System.out.println("Key:"+item.getKey()+" "+item.getValue());
        // }
        
        int max = 0;
        for(int i = 0; i < word.length();i++){
            char ch = word.charAt(i);
            int index  = alpha.get(ch) - 1;
            if(h.get(index) > max){
                max = h.get(index);
            }
        }
        int area = max * word.length();
        return area;
    }
	public static void main(String[] args) {
		//System.out.println("Hello World");
		List<Integer> h = new ArrayList<>();
        // h.add(1);
        // h.add(3);
        // h.add(1);
        // h.add(3);
        // h.add(1);
        // h.add(4);
        // h.add(1);
        // h.add(3);
        // h.add(2);
        // h.add(5);
        // h.add(5);
        // h.add(5);
        // h.add(5);
        // h.add(1);
        // h.add(1);
        // h.add(5);
        // h.add(5);
        // h.add(1);
        // h.add(5);
        // h.add(2);
        // h.add(5);
        // h.add(5);
        // h.add(5);
        // h.add(5);
        // h.add(5);
        // h.add(5);
        
        //test2
        h.add(1);
        h.add(3);
        h.add(1);
        h.add(3);
        h.add(1);
        h.add(4);
        h.add(1);
        h.add(3);
        h.add(2);
        h.add(5);
        h.add(5);
        h.add(5);
        h.add(5);
        h.add(5);
        h.add(5);
        h.add(5);
        h.add(5);
        h.add(5);
        h.add(5);
        h.add(5);
        h.add(5);
        h.add(5);
        h.add(5);
        h.add(5);
        h.add(5);
		int res = designerPdfViewer(h, "abc");
		System.out.println("Area:"+res);
	}
}
