/*
 * Copyright (c) 2023. Made by theDevJade or contributors.
 */

plugins {
  `java-library`
  alias(libs.plugins.kotlin)
  alias(libs.plugins.paperweight)
}



group = "com.encoral.template.api"
version = "1.0.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  paperweight.paperDevBundle("1.20.2-R0.1-SNAPSHOT")
}
