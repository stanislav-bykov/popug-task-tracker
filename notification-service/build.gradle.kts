dependencies {
    implementation(project(":common"))
}

tasks.bootJar {
    mainClass.set("org.popug.tracker.notification.Application")
}
