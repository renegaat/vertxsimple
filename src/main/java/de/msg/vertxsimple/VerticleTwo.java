package de.msg.vertxsimple;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class VerticleTwo extends AbstractVerticle {

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        // ich tue etwas langes was schiefgehen kann
        
        //startFuture.fail("it failed");
        startFuture.complete();
    }
}
