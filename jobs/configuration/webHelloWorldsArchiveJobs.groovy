String home = "/tmp"
String basePath = '1-configuration'
GString customWorkspacePath = "${home}/workspaces/${basePath}"

folder(basePath) {
    description 'CI folder of web-hello-world'
}

job("$basePath/web-hello-world-archive") {
    customWorkspace(customWorkspacePath.toString())
    label('slave')
    publishers {
        archiveArtifacts('build/libs/*.war')
    }
}