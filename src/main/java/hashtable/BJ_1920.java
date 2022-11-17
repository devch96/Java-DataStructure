package hashtable;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BJ_1920 {

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        Set<Integer> A = new HashSet<>();
        for(int i = 0 ; i < N ; i++){
            int n = scanner.nextInt();
            A.add(n);
        }
        StringBuilder result = new StringBuilder();
        int M = scanner.nextInt();
        for (int i = 0; i < M; i++) {
            int m = scanner.nextInt();
            if(A.contains(m)){
                result.append(1 + "\n");
            }else{
                result.append(0 + "\n");
            }
            System.out.println(result);
        }
    }
}
