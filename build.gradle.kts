/*
 * Copyright (c) 2023. Made by theDevJade or contributors.
 */
plugins {
  `java-library`
  alias(libs.plugins.kotlin)
  alias(libs.plugins.paperweight)
  alias(libs.plugins.runpaper)
  alias(libs.plugins.shadow)
}


val jdkVersion = 17
val projectName = "encoral-template"
group = "com.encoral.template"
version = "1.0.0-SNAPSHOT"
description = "Encoral template for development"




dependencies {
  implementation(project(":api"))
  implementation(project(":community-util"))
  paperweight.paperDevBundle("1.20.2-R0.1-SNAPSHOT")
}




allprojects {
  afterEvaluate {
    dependencies {
      implementation(libs.bundles.paperweight)

      implementation(libs.bundles.database)
      implementation(libs.bundles.server)
    }
    repositories {
      repositories {
        mavenCentral()
        maven("https://repo.dmulloy2.net/repository/public/")
      }
    }
    sourceSets {
      main {
        java {
          srcDir("src/main/kotlin")
        }
        resources {
          srcDir("src/main/resources")
        }
      }
    }
  }
}

java {
  toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks {
  // Configure reobfJar to run when invoking the build task
  assemble {
    dependsOn(reobfJar)
  }

  compileJava {
    options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything
    options.release.set(jdkVersion)
  }
  javadoc {
    options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything
  }
  processResources {
    filteringCharset = Charsets.UTF_8.name() // We want UTF-8 for everything
    val props = mapOf(
      "name" to project.name,
      "version" to project.version,
      "description" to project.description,
      "apiVersion" to "1.20"
    )
    inputs.properties(props)
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
    filesMatching("paper-plugin.yml") {
      expand(props)
    }
  }

  reobfJar {
    outputJar.set(layout.buildDirectory.file("libs/$projectName-${project.version}.jar"))
  }
}
