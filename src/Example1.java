import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mosharrofrubel on 6/8/17.
 */
public class Example1 {

    public static void main(String[] args){

        int[] _data = {2,5,6,8,12,15,18,28,30};
        do_clustering(2,12,30, _data);


    }

    static void do_clustering(double k1, double k2, double k3, int[] my_data){

        List c1 = new ArrayList<>();
        List c2 = new ArrayList<>();
        List c3 = new ArrayList<>();

        for(int i=0; i < my_data.length; i++){
            double val1 = Math.abs(k1-my_data[i]);
            double val2 = Math.abs(k2-my_data[i]);
            double val3 = Math.abs(k3-my_data[i]);

            if(val2>val1){
                c1.add(my_data[i]);
            } else if(val3>val2) {
                c2.add(my_data[i]);
            } else {
                c3.add(my_data[i]);
            }

        }

        System.out.println("Cluster 1: "+ Arrays.toString(c1.toArray()));
        System.out.println("Cluster 2: "+ Arrays.toString(c2.toArray()));
        System.out.println("Cluster 3: "+ Arrays.toString(c3.toArray()));

        // find the mean of clusters

        double mn1 = get_mean(c1);
        double mn2 = get_mean(c2);
        double mn3 = get_mean(c3);

        System.out.println("Mean 1 is: "+mn1);
        System.out.println("Mean 2 is: "+mn2);
        System.out.println("Mean 3 is: "+mn3);



       // do_clustering(mn1,mn2, mn3, my_data);


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
