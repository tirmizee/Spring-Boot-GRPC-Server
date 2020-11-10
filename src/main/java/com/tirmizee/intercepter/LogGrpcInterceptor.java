package com.tirmizee.intercepter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;

public class LogGrpcInterceptor implements ServerInterceptor {

	private static final Logger log = LoggerFactory.getLogger(LogGrpcInterceptor.class);
	
	@Override
	public <ReqT, RespT> Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers,
			ServerCallHandler<ReqT, RespT> next) {
	    log.info(call.getMethodDescriptor().getFullMethodName());
	    return next.startCall(call, headers);
	}

}
