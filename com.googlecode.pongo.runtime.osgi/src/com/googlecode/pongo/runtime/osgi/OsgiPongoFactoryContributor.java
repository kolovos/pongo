package com.googlecode.pongo.runtime.osgi;

import java.util.HashMap;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import com.googlecode.pongo.runtime.Pongo;
import com.googlecode.pongo.runtime.PongoFactoryContributor;

public class OsgiPongoFactoryContributor implements PongoFactoryContributor {
	
	public static final String extensionPoint = "com.googlecode.pongo.runtime.osgi";
	protected HashMap<String, IConfigurationElement> cache = null;	
	
	@Override
	public boolean canCreate(String className) {
		if (cache == null) {
			discoverExtensions();
		}
		boolean result = cache.containsKey(className);
		System.err.println("->" + result);
		return result;
	}

	@Override
	public Pongo create(String className) throws Exception {
		IConfigurationElement configurationElement = cache.get(className);
		return (Pongo) configurationElement.createExecutableExtension("name");
	}

	public void discoverExtensions() {
		
		cache = new HashMap<String, IConfigurationElement>();
		
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		if (registry == null) {
			return;
		}

		IExtensionPoint extenstionPoint = registry.getExtensionPoint(extensionPoint);
		
		IConfigurationElement[] configurationElements = extenstionPoint.getConfigurationElements();
		
		for (int i=0;i<configurationElements.length;i++) {
			System.err.println(configurationElements[i].getAttribute("name"));
			cache.put(configurationElements[i].getAttribute("name"), configurationElements[i]);			
		}
	
	}
	
}
