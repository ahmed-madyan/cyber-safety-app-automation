# Cyber-Safety-App-Automation-IE

Browser Stack integration steps

Sample request for uploading the App with custom ID
curl -u "ahmedmadyan_oxTGNa:efFbRGj4yaxcVuPxyJKs" -X POST "https://api-cloud.browserstack.com/app-automate/upload" -F "file=@C:\Users\_VOIS\Documents\Mobile Applications\Android\Tozi.apk" -F "custom_id=ToziAppApk"
Sample response
{"app_url":"bs://cc0a3ffbf7b5126018c2f593bd32f24fe48d386a","custom_id":"ToziAppApk","shareable_id":"ahmedmadyan_oxTGNa/ToziAppApk"}

curl -u "ahmedmadyan_oxTGNa:efFbRGj4yaxcVuPxyJKs" -X POST "https://api-cloud.browserstack.com/app-automate/upload" -F "file=@C:\Users\_VOIS\Documents\Mobile Applications\iOS\Tozi.ipa" -F "custom_id=ToziAppIpa"


Sample request for deleting the App
curl -u "ahmedmadyan_oxTGNa:efFbRGj4yaxcVuPxyJKs" -X DELETE "https://api-cloud.browserstack.com/app-automate/app/delete/1824c7990fe34023bdd4e19715f15873e71ea265"

Browser stack plan
curl -u "ahmedmadyan_oxTGNa:efFbRGj4yaxcVuPxyJKs" https://api.browserstack.com/automate/plan.json

Browser stack available browsers and devices
curl -u "ahmedmadyan_oxTGNa:efFbRGj4yaxcVuPxyJKs" https://api.browserstack.com/automate/browsers.json