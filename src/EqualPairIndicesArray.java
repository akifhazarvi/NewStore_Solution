import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EqualPairIndicesArray {
    public static void main(String[] args) {
        EqualPairIndicesArray equalPairIndicesArray = new EqualPairIndicesArray();
        int[] array = {3, 5, 6, 3, 3, 5};
        System.out.println(equalPairIndicesArray.solution(array));
    }
    public int solution(int[] A) {
//        int mapkey = 0;
//        Map<Integer, Integer> mapofPairs = new HashMap<>();
//        for (int outer = 0; outer < A.length; outer++) {
//            for (int inner = outer+1; inner < A.length; inner++) {
//                if(A[inner]==A[outer]) {
//                    mapkey++;
//                    mapofPairs.put(mapkey, "(" + outer + ", " + inner + ")");
//                }
//            }
//        }
//        for (int i = 0; i < A.length; i++) {
//            mapofPairs.put(i, A[i]);
//        }

        int pairLength = 0;
        Map<Integer, Integer> pairsMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if(pairsMap.containsKey(A[i])) {
                int count = pairsMap.get(A[i]);
                pairsMap.put(A[i], ++count);
            } else {
                pairsMap.put(A[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : pairsMap.entrySet()) {
            Integer value = entry.getValue();
            pairLength += (value * (value-1))/2;
        }
        return pairLength;
    }
}