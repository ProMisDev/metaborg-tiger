package org.metaborg.lang.tiger.refactoring.strategies;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import org.apache.commons.vfs2.FileObject;
import org.metaborg.core.context.IContext;
import org.metaborg.core.resource.IResourceService;
import org.spoofax.interpreter.core.Tools;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;
import org.strategoxt.lang.Context;
import org.strategoxt.lang.Strategy;

public class read_config_file_0_0 extends Strategy {

	public static read_config_file_0_0 instance = new read_config_file_0_0();

	@Override
	public IStrategoTerm invoke(Context context, IStrategoTerm current) {
		ITermFactory factory = context.getFactory();
		String propertyFilePath = Tools.asJavaString(current.getSubterm(0));
		String propertyKey = Tools.asJavaString(current.getSubterm(1));
		FileObject propertyFileObject = getPropertyFileObject(context, propertyFilePath);
		String property = readProperty(propertyFileObject, propertyKey);
		IStrategoTerm propertyTerm = factory.makeString(property);
		return propertyTerm;
	}

	private FileObject getPropertyFileObject(Context context, String propertyFilePath) {
		URI propertyFileUri;
		try {
			propertyFileUri = new URI(propertyFilePath);
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException("Invalid porperty file URI: " + propertyFilePath);
		}
		IContext contextObject = (IContext) context.contextObject();
		IResourceService resourceService = contextObject.injector().getInstance(IResourceService.class);
		FileObject fileObject = resourceService.resolve(propertyFileUri);
		return fileObject;
	}

	private String readProperty(FileObject fileObject, String propertyKey) {
		try (InputStream input = fileObject.getContent().getInputStream()) {
			Properties prop = new Properties();
			prop.load(input);
		    String property = prop.getProperty(propertyKey);
		    if (property == null || property.isEmpty()) {
		    	throw new IllegalArgumentException("Property is not defined: " + propertyKey);
		    }
			return property;

		} catch (IOException ex) {
			throw new IllegalArgumentException("Invalid porperty file URI: " + fileObject.getPublicURIString());
		}
	}
}