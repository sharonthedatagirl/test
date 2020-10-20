/*
private Service baseService = null;
public RetryProxy(Service baseService) { this.baseService = baseService;
}
public Picture getPicture(String subject, int index) { Picture picture = baseService.getPicture(subject, index); int attempt = 1;
while (!picture.isValid() && attempt<=maxAttempts) {
picture = baseService.getPicture(subject, index); ++attempt;
}
  return picture;
}
 */

// IPPO Assignment 1, Version 20.3, 14/10/2020
package ippo.assignment1.proxy;

import ippo.assignment1.library.Picture;
import ippo.assignment1.library.service.Service;
import ippo.assignment1.library.service.ServiceFromProperties;

/**
 * A skeleton cache proxy service for the PictureViewer application.
 * The skeleton does no implement any caching!
 * 
 * @author  Paul Anderson &lt;dcspaul@ed.ac.uk&gt;
 * @version 20.3, 14/10/2020
 */
public class CacheProxy2 implements Service {

	private Service baseService = null;

	/**
	 * Return a textual name for the service.
	 *
	 * @return the name of the base service
	 */
	public String serviceName() {
		return baseService.serviceName();
	}

	/**
	 * Create a proxy service based on the service specified in the
	 * <code>proxy.cache.service</code> resource.
	 */
	public CacheProxy2() {
		baseService = new ServiceFromProperties("proxy.cache.service");
	}

	/**
	 * Create a proxy service based on the specified service.
	 *
	 * @param baseService the base service
	 */
	public CacheProxy2(Service baseService) {
		this.baseService = baseService;
	}

	/**
	 * Return a picture from the base service. 
	 *
    * @param subject the free-text subject string
    * @param index the index of the matching picture to return
    * @return the requested picture
    */
	public Picture getPicture(String subject, int index) {	
		return baseService.getPicture(subject, index);
    }
}
