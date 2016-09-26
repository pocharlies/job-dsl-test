String firstJob = "1-configuration/web-hello-world-build"
String viewName = "webHelloWorld"

buildPipelineView(viewName) {
    filterBuildQueue()
    filterExecutors()
    title("Project  CI Pipeline Web Hello World")
    displayedBuilds(5)
    selectedJob(firstJob)
    alwaysAllowManualTrigger()
    showPipelineParameters()
    refreshFrequency(60)
}