package de.msg.vertxsimple;


import io.vertx.core.Vertx;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;


/**
 * create main method shortcut -> psvm 
 * 
 * deploy simple verticle with no result
 * 
 * deploy simple verticle stringAsyncResult
 * 
 * use future in socond verticle to give back future fail
 *  
 */

public class VertxSimple {
    
    public static void main(String[] args) {
        
        Logger logger = LoggerFactory.getLogger(VertxSimple.class);

        Vertx vertxOne = Vertx.vertx();
        
        //Vertx vertxOne = Vertx.vertx(new VertxOptions().setClustered(false));
        
        vertxOne.deployVerticle(new VerticleOne(), stringAsyncResult -> {

            if (stringAsyncResult.succeeded()) {
                logger.info("Verticle one deployed");
            } else {
                logger.info("Verticle one error");
            }
        });
        
        
        Vertx vertxTwo = Vertx.vertx();
        vertxTwo.deployVerticle(new VerticleTwo(), stringAsyncResult -> {
            if (stringAsyncResult.succeeded()) {
                logger.info("Verticle two deployed");
            } else {
                logger.info("Verticle two error");
            }
        });
    }
}
