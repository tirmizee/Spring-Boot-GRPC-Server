package com.tirmizee.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tirmizee.grpc.HelloWorldServiceGrpc;
import com.tirmizee.grpc.Message;
import com.tirmizee.grpc.Person;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloServiceImpl extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloServiceImpl.class);

	@Override
	public void sayHello(Person request, StreamObserver<Message> responseObserver) {
		super.sayHello(request, responseObserver);
	}

}
