plugins {
    alias(libs.plugins.versions)
    java
}

repositories {
    maven(url = "https://jitpack.io")
    mavenCentral()
    google()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    // ouistiti dependencies
    implementation(libs.chimp.utils.jme3)
    implementation(libs.chimp.utils.basics)

    // ouistiti camera manager
    implementation(libs.ouistiti)

    // jme3 libs
    implementation(libs.jme.core)
    implementation(libs.jme.desktop)
    implementation(libs.jme.lwjgl3)
}

tasks.test {
    failOnNoDiscoveredTests = false
}
