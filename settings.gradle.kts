rootProject.name = "metaborg-tiger"

pluginManagement {
  repositories {
    maven("https://artifacts.metaborg.org/content/groups/public/")
  }
}

include("org.metaborg.eqclac")
include("org.metaborg.lang.tiger")
include("org.metaborg.lang.tiger.statix")
include("tiger")
include("tiger.spoofax")
include("tiger.eclipse.externaldeps")
include("tiger.eclipse")
