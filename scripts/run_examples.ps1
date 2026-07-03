$valid = Get-ChildItem examples/valid/*.psx
$invalid = Get-ChildItem examples/invalid/*.psx

Write-Host "Running valid examples..."
foreach ($file in $valid) {
    Write-Host "`nVALID:" $file.Name
    mvn "exec:java" "-Dexec.mainClass=org.promptsyntax.Main" "-Dexec.args=$($file.FullName)"
}

Write-Host "`nRunning invalid examples..."
foreach ($file in $invalid) {
    Write-Host "`nINVALID:" $file.Name
    mvn "exec:java" "-Dexec.mainClass=org.promptsyntax.Main" "-Dexec.args=$($file.FullName)"
}