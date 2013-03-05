package com.googlecode.pongo;

import java.io.File;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.emfatic.core.generator.ecore.EcoreGenerator;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.emc.emf.EmfModel;

public class PongoGenerator {
	
	public static void main(String[] args) throws Exception {
		
		if (args.length != 1) {
			System.out.println("Use: PongoGenerator foo.emf or PongoGenerator foo.ecore");
			return;
		}
		
		PongoGenerator pg = new PongoGenerator();
		pg.generate(new File(args[0]));
		
	}
	
	protected File outputDirectory = null;
	
	public void generate(File inputFile) throws Exception {
		
		if (inputFile.getName().endsWith(".ecore")) {
			EmfModel model = new EmfModel();
			model.setName("Ecore");
			EPackage.Registry.INSTANCE.put(EcorePackage.eINSTANCE.getNsURI(), EcorePackage.eINSTANCE);
			model.setMetamodelUri(EcorePackage.eINSTANCE.getNsURI());
			model.setModelFile(inputFile.getAbsolutePath());
			model.load();
			generate(model, inputFile.getParentFile());

			model.disposeModel(); 
		}
		else if (inputFile.getName().endsWith(".emf")){
			EcoreGenerator ecoreGenerator = new EcoreGenerator();
			ecoreGenerator.generate(inputFile, true);
			generate(new File(inputFile.getAbsolutePath().replaceAll("\\.emf$", ".ecore")));
		}
	}
	
	protected void generate(EmfModel model, File directory) throws Exception {
		
		
		EglFileGeneratingTemplateFactory templateFactory = new EglFileGeneratingTemplateFactory();
		templateFactory.setOutputRoot(directory.getAbsolutePath());
		EgxModule module = new EgxModule(templateFactory);
		
		module.parse(PongoGenerator.class.getResource("pongo.egx").toURI());
		module.getContext().getModelRepository().addModel(model);
		module.execute();
		
	}
	
}
