import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-library`
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.jmh)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform(libs.kotlin.bom))

    jmh(libs.jmh.core)
    jmh(libs.jmh.generator.annprocess)
}

jmh {
    jmhVersion.set(libs.versions.jmh.asProvider().get())
}
