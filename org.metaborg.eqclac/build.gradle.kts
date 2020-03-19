plugins {
  id("org.metaborg.gradle.config.java-library")
  id("org.metaborg.gradle.config.junit-testing")
}

sourceSets {
  main {
    java {
      srcDirs("src/main")
    }
  }
  test {
    java {
      srcDirs("src/test")
    }
  }
}

dependencies {
  api("org.metaborg:org.metaborg.spoofax.core:2.6.0-SNAPSHOT")
}

// Copy test resources into classes directory, to make them accessible as classloader resources at runtime.
val copyTestResourcesTask = tasks.create<Copy>("copyTestResources") {
  from("$projectDir/src/test/resources")
  into("$buildDir/classes/java/test")
}
tasks.getByName("processTestResources").dependsOn(copyTestResourcesTask)
