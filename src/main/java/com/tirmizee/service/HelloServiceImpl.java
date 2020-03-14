package com.tirmizee.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tirmizee.grpc.Greeting;
import com.tirmizee.grpc.HelloWorldServiceGrpc;
import com.tirmizee.grpc.Person;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloServiceImpl extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloServiceImpl.class);
	
	@Override
	public void sayHello(Person request, StreamObserver<Greeting> responseObserver) {
		LOGGER.info("server received {}", request);
		String message = "Hello " + request.getFirstName() + " "
			        + request.getLastName() + "!";
			    Greeting greeting =
			        Greeting.newBuilder().setMessage(message).build();
			    LOGGER.info("server responded {}", greeting);

	    responseObserver.onNext(greeting);
	    responseObserver.onCompleted();
	}

}
