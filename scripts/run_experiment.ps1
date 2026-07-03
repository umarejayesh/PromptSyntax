$resultsDir = "results"
$csvFile = "$resultsDir\experiment_results.csv"

if (!(Test-Path $resultsDir)) {
    mkdir $resultsDir | Out-Null
}

"category,file,status,expected,result,message" | Out-File $csvFile -Encoding utf8

function Run-Case($category, $file, $expected) {
    Write-Host "`n[$category] Running $($file.Name)"

    $output = mvn "exec:java" "-Dexec.mainClass=org.promptsyntax.Main" "-Dexec.args=$($file.FullName)" 2>&1
    $text = $output -join " "

    if ($LASTEXITCODE -eq 0) {
        $status = "success"
    } else {
        $status = "failure"
    }

    if ($status -eq $expected) {
        $result = "pass"
    } else {
        $result = "fail"
    }

    $message = $text.Replace('"', "'").Replace(",", ";")

    "$category,$($file.Name),$status,$expected,$result,""$message""" | Add-Content $csvFile -Encoding utf8

    Write-Host "Expected: $expected | Actual: $status | Result: $result"
}

Get-ChildItem examples\valid\*.psx | ForEach-Object {
    Run-Case "valid" $_ "success"
}

Get-ChildItem examples\invalid\*.psx | ForEach-Object {
    Run-Case "invalid" $_ "failure"
}

Write-Host "`nExperiment completed."
Write-Host "Results saved to $csvFile"