// This is the build file for the project. It is written in Kotlin and is used to build the project.

// Import system environment variables

val OPENAI_TOKEN: String? = System.getenv("OPENAI_TOKEN")

plugins {
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.serialization") version "1.9.0"
    application
}

group = "me.sval"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.xebia:xef-kotlin:0.0.3")
    implementation("org.fusesource.jansi:jansi:2.4.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("dnd.MainKt")
}

kotlin{
    jvmToolchain(17)
}