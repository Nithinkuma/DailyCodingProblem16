/**You run an e-commerce website and want to record the last N order ids in a log.
 *  Implement a data structure to accomplish this, with the following API:

 record(order_id): adds the order_id to the log
 get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.

 You should be as efficient with time and space as possible.
 **/

import java.util.ArrayList;
import java.util.List;

public class LogOfLastNOrdersAPI {
    int N;
    List<String> orderIds;
    /**
     * list orderIds contains the orderIDs,
     * if we have a class for order like this
     public class Order{
        String orderID;
        String orderName;
        String typeOfPayment;
        //setter methods or constructor
        public String getOrderId(){
            return this.orderID;
         }
     }
     then use "HashMap<String,Order>" where string is Order_ID
     get the orderID using get_last(int i) method and search the order in hashmap 
     * **/
    LogOfLastNOrdersAPI(int N){
        this.N = N;
        orderIds=new ArrayList<>(this.N);
    }

    public void record(String order_iD){
        if (orderIds.size()!=N)
            orderIds.add(order_iD);
        else{
            orderIds.remove(0);
            orderIds.add(order_iD);
        }
    }

    public String get_last(int i){
        return orderIds.get(orderIds.size()-i);
    }

    public static void main(String[] args) {
        LogOfLastNOrdersAPI logs = new LogOfLastNOrdersAPI(3);
        logs.record("abcde1");
        logs.record("abcde2");
        logs.record("abcde3");
        System.out.println(logs.get_last(3));
        System.out.println(logs.get_last(2));
        System.out.println(logs.get_last(1));

        logs.record("abcde4");
        logs.record("abcde5");
        System.out.println("\n----after update----\n");
        System.out.println(logs.get_last(3));
        System.out.println(logs.get_last(2));
        System.out.println(logs.get_last(1));
    }
}
