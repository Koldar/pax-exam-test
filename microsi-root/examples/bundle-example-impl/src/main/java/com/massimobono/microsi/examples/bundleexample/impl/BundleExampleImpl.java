package com.massimobono.microsi.examples.bundleexample.impl;

import java.util.Hashtable;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import com.massimobono.microsi.examples.bundleexample.BundleExample;

@Component(service={BundleExample.class})
public class BundleExampleImpl implements BundleExample {

	public String getGreeting() {
		return "Hello World!";
	}

	public String getGreeting(String name) {
		return String.format("Hello World %s!", name);
	}
	
	@Activate
	public void activate() {
		System.out.println("bundle example started!");
	}
	
	@Deactivate
	public void deactivate() {
		System.out.println("bundle example stopped!");
	}
}
