package com.example.config;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.example.persister.MessagePersister;
import com.example.persister.RedisMessagePersister;
import com.example.resources.MyMessageResource;
import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;


public class JerseyModule extends ServletModule{

	@Override
	protected void configureServlets() {
		//TODO: Add bindings here...
		bind(MyMessageResource.class);
        bind(MessagePersister.class).to(RedisMessagePersister.class);
		
		serve("/*").with(GuiceContainer.class);
	}
	
	@Provides
	JedisPool getJedisPool(){
	    return new JedisPool(new JedisPoolConfig(), "localhost");	    
	}
}
