import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mosharrofrubel on 6/13/17.
 */
public class Example3 {

    public static void  main(String[] args){

        // this example is for 2 dimensional data points

        //calc_distance(23.7877419, 90.397014,23.8316797,90.4083941);

        double[] data = {
                23.7877419,90.1970142,
                23.8316797,90.2083941,
                23.1877419,90.3970145,
                23.2316797,90.4083941,
                23.3877419,90.5970146,
                23.4316797,90.6083941,
                23.5877419,90.7970147,
                23.6316797,90.8083941,
                23.7877419,90.9970149,
                23.8316797,90.1083941,
                23.9877419,90.2970142,
                23.1016797,90.3083941,
                23.1177419,90.4970147,
                23.1216797,90.5083941,
                23.1377419,90.1297014,
                23.1416797,90.1483941
        };

        double[] data2 = {
                2.3,5.6,
                9.8,2.7,
                8.2,4.6,
                9.1,1.2,
                7.2,10.1,
                3.8,2.0,
                6.9,9.3,
                4.1,3.0
        };


        double[] data3 = {
                2,3,
                5,6,
                9,9,
                1,8,
                3,8,
                8,4,
                2,9,
                1,5,
                1,1,
                2,2,
                4,5,
                3,3,
                4,4,
                7,4,
                5,0
        };

    //    do_clus(23.7877419, 90.397014,23.8316797,90.4083941, data);
        do_clus(9,9, 4,4, data3);


    }

    static double calc_distance(double x1, double y1, double x2, double y2){

        //  Distance = √(x2−x1)2+(y2−y1)2

        double result = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));

        return Math.abs(result);

    }

    static void do_clus(double k1_1, double k1_2, double k2_1, double k2_2, double[] my_data){

        List c1 = new ArrayList<>();
        List c2 = new ArrayList<>();

        List mn_k1_1 = new ArrayList<>();
        List mn_k1_2 = new ArrayList<>();

        List mn_k2_1 = new ArrayList<>();
        List mn_k2_2 = new ArrayList<>();

        for(int i=0; i < my_data.length; i+=2){
            double val1 = calc_distance(k1_1,k1_2, my_data[i], my_data[i+1]);
            double val2 = calc_distance(k2_1,k2_2, my_data[i], my_data[i+1]);

            System.out.println("Set: "+my_data[i]+", "+my_data[i+1]);

            if(val2>val1){
                c1.add(my_data[i]);
                c1.add(my_data[i+1]);
            } else {
                c2.add(my_data[i]);
                c2.add(my_data[i+1]);
            }

        }

        System.out.println("Cluster 1: "+ Arrays.toString(c1.toArray()));
        System.out.println("Cluster 2: "+ Arrays.toString(c2.toArray()));

        // find the mean of clusters

        // cluster 1 average
        for(int j=0; j < c1.size(); j+=2){
            mn_k1_1.add(c1.get(j));
            mn_k1_2.add(c1.get(j+1));
        }

        // cluster 2 average
        for(int p=0; p < c2.size(); p+=2){
            mn_k2_1.add(c2.get(p));
        }



        double k1_mn1 = get_mean(mn_k1_1);
        double k1_mn2 = get_mean(mn_k1_2);

        double k2_mn1 = get_mean(mn_k2_1);
        double k2_mn2 = get_mean(mn_k2_2);

        System.out.println("Mean 1 is: "+k1_mn1+", "+k1_mn2);
        System.out.println("Mean 2 is: "+k2_mn1+", "+k2_mn2);


        if(!((k1_1==k1_mn1 && k1_2==k1_mn2) && (k2_1 == k2_mn1 && k2_2 == k2_mn2))) {
            do_clus(k1_mn1, k1_mn2,k2_mn1,k2_mn2, my_data);
        }


    }

    static double get_mean(List <Double> marks) {
        double sum = 0;
        if(!marks.isEmpty()) {
            for (double mark : marks) {
                sum += mark;
            }
            return sum / marks.size();
        }
        return sum;
    }


}
