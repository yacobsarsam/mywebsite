plugins {
	java
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

//java {
//	sourceCompatibility = JavaVersion.VERSION_17
//}
java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(20)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-hateoas")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.postgresql:postgresql")

	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.mysql:mysql-connector-j")
	annotationProcessor("org.projectlombok:lombok")
	implementation ("org.apache.pdfbox:pdfbox:2.0.29")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	testImplementation ("com.h2database:h2")

}
tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
	mainClass.set("com.example.mywebsite.MyWebsiteApplication")  // Define the main class
}
springBoot {
	mainClass = "com.example.mywebsite.MyWebsiteApplication"  // Specify the main class
	//layout = "JAR"  // Package as JAR file (this is the default)
}