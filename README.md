# Cyber-Safety-App-Automation-IE

Browser Stack integration steps

Sample request for uploading the App with custom ID
curl -u "ahmedmadyan_oxTGNa:efFbRGj4yaxcVuPxyJKs" -X POST "https://api-cloud.browserstack.com/app-automate/upload" -F "file=@/home/ahmed-madyan/Downloads/CyberBullingApp-Devlopment.ipa" -F "custom_id=ToziAppIpa"
curl -u "ahmedmadyan_oxTGNa:efFbRGj4yaxcVuPxyJKs" -X POST "https://api-cloud.browserstack.com/app-automate/upload" -F "file=@/home/ahmed-madyan/Downloads/app-development-release.apk" -F "custom_id=ToziAppApk"


Sample response
{"app_url":"bs://8c1cb33bd3f967f07504818d83c87b1cacee259e","custom_id":"ToziAppIpa","shareable_id":"ahmedmadyan_oxTGNa/ToziAppIpa"}
{"app_url":"bs://aaa0c7bfd7ffde025861854f1d6a0d60bd445f68","custom_id":"ToziAppApk","shareable_id":"ahmedmadyan_oxTGNa/ToziAppApk"}

Sample request for deleting the App
curl -u "ahmedmadyan_oxTGNa:efFbRGj4yaxcVuPxyJKs" -X DELETE "https://api-cloud.browserstack.com/app-automate/app/delete/1824c7990fe34023bdd4e19715f15873e71ea265"

Browser stack plan
curl -u "ahmedmadyan_oxTGNa:efFbRGj4yaxcVuPxyJKs" https://api.browserstack.com/automate/plan.json

Browser stack available browsers and devices
curl -u "ahmedmadyan_oxTGNa:efFbRGj4yaxcVuPxyJKs" https://api.browserstack.com/automate/browsers.json