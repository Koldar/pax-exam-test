package com.massimobono.microsi.examples.bundleexample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;

import com.massimobono.microsi.examples.bundleexample.BundleExample;
import com.massimobono.microsi.examples.bundleexample.impl.BundleExampleImpl;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;
import junit.framework.TestCase;
import org.ops4j.pax.exam.CoreOptions;
import javax.inject.Inject;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;
import org.ops4j.pax.exam.spi.reactors.PerMethod;
import org.ops4j.pax.exam.util.Filter;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
public class TestBundleExampleImpl {
	
	@Inject
	private BundleExample bundleExample;
	
	@Configuration
	public Option[] config(){
	    return CoreOptions.options(
	    		CoreOptions.cleanCaches(true),
	    		CoreOptions.mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.scr").version("2.0.8"),
	    		CoreOptions.mavenBundle().groupId("com.massimobono.microsi.examples").artifactId("bundle-example-impl").version("0.0.1-SNAPSHOT"),
	            CoreOptions.junitBundles()
	    );
	}
	
	
	@Test
    public void simpleGreetingImplCheck()
    {
		String testValue = this.bundleExample.getGreeting();
        assertThat(testValue, is("Hello World!"));
    }

	@Test
	public void test() {
		assertThat(true, is(true));
	}
}
