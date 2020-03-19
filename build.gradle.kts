import mb.spoofax.compiler.spoofaxcore.Shared

plugins {
  id("org.metaborg.gradle.config.root-project") version "0.3.20"
  id("org.metaborg.gitonium") version "0.1.2"
  id("org.metaborg.spoofax.compiler.gradle.spoofaxcore.root") /* No version: plugin must be in composite build. */

  // Set versions for plugins to use, only applying them in subprojects (apply false here).
  id("org.metaborg.spoofax.gradle.langspec") version "0.2.1" apply false
  id("de.set.ecj") version "1.4.1" apply false
  id("org.metaborg.coronium.bundle") version "0.2.1" apply false
  id("org.metaborg.coronium.embedding") version "0.2.1" apply false
  id("biz.aQute.bnd.builder") version "4.3.1" apply false
  id("org.jetbrains.intellij") version "0.4.15" apply false
}

subprojects {
  metaborg {
    configureSubProject()
  }
}

allprojects {
  version = "0.1.0-SNAPSHOT" // Override version from Git, as this repo uses a different versioning scheme.
}

gitonium {
  // Disable snapshot dependency checks for releases, until we depend on a stable version of MetaBorg artifacts.
  checkSnapshotDependenciesInRelease = false
}

spoofaxCompiler {
  sharedSettings.set(Shared.builder()
    .name("Tiger")
    .defaultBasePackageId("mb.tiger")
  )
}
