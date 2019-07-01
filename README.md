# autool

## Feature
1. Run UI automation test case
2. Generate html report
3. Generate screenshot

## Configuration
### config file path
./src/test/resources/conf/main.properties
### config file content
```
#selenium config
webdriver.chrome.driver=src/test/resources/drivers/chromedriver
webdriver.gecko.driver=src/test/resources/drivers/geckodriver

#data config
data.excel.path=src/test/resources/data/data.xls
data.excel.sheet=sheet1

#screen config
screen.folder.path=src/test/screenshot/
```
## Run
### note
if you want to run from command line, you need to setup maven in your environment
```
git clone https://github.com/dtTony/autool

cd autool

mvn clean test
```

## Html report
After run, a html report will be generated in below path:

./target/surefire-report/html/index.html

## Screenshot
you can use screenshot in your task class
```
this.basedriver.screenFullShot(this.screenPath, steps);
```

## Note
### drivers path
./src/resources/drivers/

*you need to choose a matching browser and driver version*
