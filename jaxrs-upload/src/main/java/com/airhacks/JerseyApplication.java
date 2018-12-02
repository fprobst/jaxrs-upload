package com.airhacks;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.airhacks.ping.boundary.PingResource;
import com.airhacks.upload.boundary.UploadResource;

@ApplicationPath("/rest")
public class JerseyApplication extends ResourceConfig {

	public JerseyApplication() {
		super(PingResource.class, UploadResource.class, MultiPartFeature.class);
	}
}
