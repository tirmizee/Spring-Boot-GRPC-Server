package com.tirmizee.service;

import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tirmizee.grpc.HelloWorldServiceGrpc;
import com.tirmizee.grpc.Message;
import com.tirmizee.grpc.Person;
import com.tirmizee.intercepter.LogGrpcInterceptor;

import io.grpc.stub.StreamObserver;

@GRpcService(interceptors = {LogGrpcInterceptor.class})
public class HelloServiceImpl extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloServiceImpl.class);

	@Override
	public void sayHello(Person request, StreamObserver<Message> responseObserver) {
		LOGGER.info("server received {}", request);

	    Message message = Message.newBuilder()
	    	.setCode("SM001")
	    	.setMessage("Success")
	    .build();
	    
	    LOGGER.info("server responded {}", message);

	    responseObserver.onNext(message);
	    responseObserver.onCompleted();
	}

}
