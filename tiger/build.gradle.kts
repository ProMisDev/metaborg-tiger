import mb.spoofax.compiler.spoofaxcore.ConstraintAnalyzerCompiler
import mb.spoofax.compiler.spoofaxcore.LanguageProjectCompiler
import mb.spoofax.compiler.spoofaxcore.ParserCompiler
import mb.spoofax.compiler.spoofaxcore.StrategoRuntimeCompiler
import mb.spoofax.compiler.spoofaxcore.StylerCompiler
import mb.spoofax.compiler.spoofaxcore.CompleterCompiler
import mb.spoofax.compiler.util.GradleDependency

plugins {
  id("org.metaborg.spoofax.compiler.gradle.spoofaxcore.language")
  id("org.metaborg.gradle.config.junit-testing")
  id("de.set.ecj") // Use ECJ to speed up compilation of Stratego's generated Java files.
}

dependencies {
  api(platform("org.metaborg:spoofax.depconstraints:$version"))
  implementation(project(":org.metaborg.eqclac"))
  testImplementation("org.metaborg:log.backend.slf4j")
  testImplementation("org.slf4j:slf4j-simple:1.7.30")
  testCompileOnly("org.checkerframework:checker-qual-android")
}

languageProjectCompiler {
  settings.set(mb.spoofax.compiler.gradle.spoofaxcore.LanguageProjectCompilerSettings(
    parser = ParserCompiler.LanguageProjectInput.builder()
      .startSymbol("Module"),
    styler = StylerCompiler.LanguageProjectInput.builder(),
    completer = CompleterCompiler.LanguageProjectInput.builder(),
    strategoRuntime = StrategoRuntimeCompiler.LanguageProjectInput.builder()
      .addInteropRegisterersByReflection("org.metaborg.lang.tiger.statix.strategies.InteropRegisterer")
      .enableNaBL2(false)
      .enableStatix(true)
      .copyCTree(true)
      .copyClasses(false)
      .copyJavaStrategyClasses(true),
    constraintAnalyzer = ConstraintAnalyzerCompiler.LanguageProjectInput.builder(),
    compiler = LanguageProjectCompiler.Input.builder()
      .languageSpecificationDependency(GradleDependency.project(":org.metaborg.lang.tiger.statix"))
  ))
}

ecj {
  toolVersion = "3.20.0"
}
