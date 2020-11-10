package com.tirmizee.intercepter;

import org.lognet.springboot.grpc.GRpcGlobalInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;

@Order(1)
@GRpcGlobalInterceptor
public class LocaleIntercepter implements ServerInterceptor {

	private static final Logger log = LoggerFactory.getLogger(LocaleIntercepter.class);
	
	@Override
	public <ReqT, RespT> Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers,
			ServerCallHandler<ReqT, RespT> next) {
		 log.info("LocaleIntercepter Order 1");
		return next.startCall(call, headers);
	}

}
