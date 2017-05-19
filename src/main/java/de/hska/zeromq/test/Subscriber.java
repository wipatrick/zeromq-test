package de.hska.zeromq.test;

import org.zeromq.ZMQ;

/**
 * Created by patrickwiener on 19.05.17.
 */
public class Subscriber {

    public static void main (String[] args) {
        final ZMQ.Context ctx = ZMQ.context(1);
        final ZMQ.Socket sub = ctx.socket(ZMQ.SUB);
        final String host;

        if ( args.length == 0 ){
            host = "localhost";
        }
        else {
            host = args[0];
        }

        sub.connect("tcp://" + host + ":6001");
        sub.subscribe("".getBytes());

        while (true) {
            String msg = sub.recvStr();
            System.out.println(msg);
        }
    }
}
