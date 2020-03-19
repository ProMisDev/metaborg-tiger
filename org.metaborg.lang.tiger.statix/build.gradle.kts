plugins {
  id("org.metaborg.spoofax.gradle.langspec")
  id("de.set.ecj") // Use ECJ to speed up compilation of Stratego's generated Java files.
  `maven-publish`
}

dependencies {
  implementation(project(":org.metaborg.eqclac"))
}

spoofax {
  createPublication = true
}

ecj {
  toolVersion = "3.20.0"
}

// Copy JAR of project 'org.metaborg.eqclac' into './target/deps', so that it can be loaded along with the Stratego code.
val copyDeps = configurations.create("copyDeps") {
  isTransitive = false
}
dependencies {
  copyDeps(project(":org.metaborg.eqclac"))
}
val copyJarTask = tasks.register<Copy>("copyEqclacJar") {
  from(copyDeps)
  into("target/deps")
  rename("(.*)-[a-zA-Z0-9\\.-_]+\\..*\\.jar", "$1.jar")
}
tasks.named("compileJava") {
  dependsOn(copyJarTask)
}
