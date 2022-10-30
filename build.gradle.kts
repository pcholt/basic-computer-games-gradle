plugins {
    kotlin("jvm") version "1.6.0"
    id("application")
}

version = "unspecified"

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation(kotlin("stdlib"))
}


subprojects {
    apply(plugin = "application")
    apply(plugin = "kotlin")
    apply(plugin = "java")
    repositories {
        mavenCentral()
    }
    dependencies {
        testImplementation("junit:junit:4.13.2")
        testImplementation("com.github.stefanbirkner:system-rules:1.19.0")
        testImplementation("com.google.truth:truth:1.1.3")
    }
    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }
    task<Copy>("copyBin") {
        from("${projectDir}/build/install/${projectDir.name}/bin")
        into("../build/distrib/bin/")
        dependsOn("installDist")
        eachFile {
            if (isDirectory)
                exclude()
            else {
                path = relativePath.segments.last().replace("^build_".toRegex(), "")
            }
        }
    }
    task<Copy>("copyLib") {
        from("${projectDir}/build/install/${projectDir.name}/lib")
        into("../build/distrib/lib/")
        dependsOn("installDist")
        eachFile {
            path = relativePath.segments.last()
        }
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
    }
    task("commonDistribution") {
        dependsOn("copyBin","copyLib")
    }
}