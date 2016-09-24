String basePath = "2-10jobslimitspace"

folder(basePath) {
    description 'King test CI folder of jobslsimitspace'
}

job("$basePath/generate-bulk-data") {
    label('slave')
    steps {
        shell('head -c 10MB </dev/urandom >myfile')
    }
}