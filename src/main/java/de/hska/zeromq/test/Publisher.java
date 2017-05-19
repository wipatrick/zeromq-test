package de.hska.zeromq.test;

import org.zeromq.ZMQ;

/**
 * Created by patrickwiener on 19.05.17.
 */
public class Publisher {

    public static void main (String [] args) throws InterruptedException {
        final ZMQ.Context ctx = ZMQ.context(1);
        final ZMQ.Socket pub = ctx.socket(ZMQ.PUB);
        pub.bind("tcp://*:6001");

        int counter = 0;

        while (true) {
            System.out.println("Publishing");
            pub.send("Test message " + counter);
            counter++;
            Thread.sleep(1000);
        }
    }
}
