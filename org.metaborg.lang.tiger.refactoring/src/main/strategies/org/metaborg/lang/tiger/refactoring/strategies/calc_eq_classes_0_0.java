package org.metaborg.lang.tiger.refactoring.strategies;

import java.util.List;

import org.spoofax.interpreter.core.Tools;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;
import org.spoofax.terms.StrategoAppl;
import org.strategoxt.lang.Context;
import org.strategoxt.lang.Strategy;
import org.strategoxt.stratego_lib.debug_0_0;

public class calc_eq_classes_0_0 extends Strategy {

	public static calc_eq_classes_0_0 instance = new calc_eq_classes_0_0();

	@Override
	public IStrategoTerm invoke(Context context, IStrategoTerm current) {
		ITermFactory factory = context.getFactory();
		List<IStrategoTerm> resolutionRelation = Tools.asJavaList(current);
		StrategoAppl first = (StrategoAppl) resolutionRelation.get(0).getSubterm(0);
		StrategoAppl second = (StrategoAppl) resolutionRelation.get(0).getSubterm(1);
		IStrategoTerm child = first.getSubterm(1);
		debug(context, child.getClass().getName());
		debug_0_0.instance.invoke(context, first);
		debug_0_0.instance.invoke(context, second);
		
		//return factory.makeList(resolutionRelation);
		return factory.makeString("foo");
	}
	
	private void debug(Context context, String message) {
		ITermFactory factory = context.getFactory();
		String debugMessage = "JAVA DEBUG: " + message;
		IStrategoTerm debugTerm = factory.makeString(debugMessage);
		debug_0_0.instance.invoke(context, debugTerm);
	}

	/*
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
	} */
}