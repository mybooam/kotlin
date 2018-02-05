apply { plugin("kotlin") }

val depDistProjects = listOf(
    ":kotlin-script-runtime",
    ":kotlin-stdlib",
    ":kotlin-test:kotlin-test-jvm"
)

dependencies {
    testRuntime(intellijDep())
    testCompile(projectTests(":compiler:tests-common"))
    depDistProjects.forEach {
        testCompile(projectDist(it))
    }
}

sourceSets {
    "main" { }
    "test" { projectDefault() }
}

projectTest {
    workingDir = rootDir
}
