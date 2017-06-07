import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mosharrofrubel on 6/8/17.
 */
public class Example2 {
    public static void main(String[] args){

        // This example is for k=2

        int[] _data = {2,4,10,12,3,20,30,11,25};
        do_clustering(2,3, _data);


    }

    static void do_clustering(double k1, double k2, int[] my_data){

        List c1 = new ArrayList<>();
        List c2 = new ArrayList<>();

        for(int i=0; i < my_data.length; i++){
            double val1 = Math.abs(k1-my_data[i]);
            double val2 = Math.abs(k2-my_data[i]);

            if(val2>val1){
                c1.add(my_data[i]);
            } else {
                c2.add(my_data[i]);
            }

        }

        System.out.println("Cluster 1: "+ Arrays.toString(c1.toArray()));
        System.out.println("Cluster 2: "+ Arrays.toString(c2.toArray()));

        // find the mean of clusters

        double mn1 = get_mean(c1);
        double mn2 = get_mean(c2);

        System.out.println("Mean 1 is: "+mn1);
        System.out.println("Mean 2 is: "+mn2);


        if(!(k1==mn1 && k2==mn2)) {
            do_clustering(mn1, mn2, my_data);
        }




    }

    static double get_mean(List <Integer> marks) {
        Integer sum = 0;
        if(!marks.isEmpty()) {
            for (Integer mark : marks) {
                sum += mark;
            }
            return sum.doubleValue() / marks.size();
        }
        return sum;
    }

}

