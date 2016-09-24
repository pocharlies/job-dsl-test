String basePath = "2-10jobslimitspace"

folder(basePath) {
    description 'King test CI folder of jobslsimitspace'
}

def generateBulkDataJobs = {
    job("$basePath/generate-bulk-data-${it}") {
        label('slave')
        steps {
            shell('head -c 100MB </dev/urandom >bulkdata.raw')
        }
    }
}
1.upto(10, generateBulkDataJobs)
