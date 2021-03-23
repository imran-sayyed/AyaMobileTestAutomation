# MobileAutomation App
Android and iOS automation scripts for Shaadi mobile projects
Requirements for Android
JDK
Android SDK
Appium Tool 
Eclipse IDE

Appium
Appium is an open source testing tool that allows you to easily write functional tests to automate iOS and Android mobile applications. It is an HTTP server that manages WebDriver sessions and has support for real device testing.

Appium Settings
(Host: Your current IP address/Port: 4723)
Click on Start Server.

Additional findings needs to done for Android
Find Android Device Name : My android device name Is : ZX1B32FFXF. Find your device name.
Find Android Software App Package Name : Package name for my calculator app (Which Is Installed in my android device) is com.android.calculator2. Find your app package name.
Find App Activity Name : Activity name for my calculator app (Which Is Installed in my android device) is com.android.calculator2.Calculator. Find your app activity name.
Find Android OS Version : In your android device, Open settings -> About phone -> Android version. My device's Android version Is : 4.4.2.

Now Open Eclipse and Perform the following operations

Click File > Import > open existing maven project 
Pull Framework from github from below mentioned url:
https://github.com/amaanmemon/peopleinteractivetest

Steps to Install Maven in Eclipse IDE
1) Click on the Help from the top menu in Eclipse and select ‘Install New Software..‘

2) Click on the Add button on the newly opened window.

3) In the Name box, type ‘Maven‘ and in the Location box, type ‘http://download.eclipse.org/technology/m2e/releases/‘

Note: The URL is the location where you can download the Maven for Eclipse.
4) A check-box will appear in the pop window, Check the check-box and click on Next button.

5) Please wait for some time and let the window complete its processing. It will not take long but 2 or 3 minutes.

6) Keep the default settings and click on Next button.

7) Accept the ‘Terms and Conditions‘ and move forward by clicking on Finish button.

8) Wait while it finish the installation.
 
9) Once the installation is finished, it will ask you to restart the Eclipse. Please click on Yes, so that changes can be reflected properly.

Install TestNG in Eclipse
1) Launch the Eclipse IDE and from Help menu, click “Install New Software”.

2) You will see a dialog window, click “Add” button.

3) Type name as you wish, lets take “TestNG” and type “http://dl.bintray.com/testng-team/testng-eclipse-release/” as location. Click OK.

4) You come back to the previous window but this time you must see TestNG option in the available software list. Just Click TestNG and press “Next” button.

5) Click “I accept the terms of the license agreement” then click Finish.

6) You may or may not encounter a Security warning, if in case you do just click OK.

7) Click Next again on the succeeding dialog box until it prompts you to Restart the Eclipse.
8) You are all done now, just Click Yes.

9) Proceed with your workplace.
10) After restart, verify if TestNG was indeed successfully installed. Right click on you project and see if TestNG is displayed in the opened menu.


===========================================
Setup
-----------


1. Install Java
2. Install Node 10
3. Install Eclipse
4. Install appium-doctor globally  `npm i -g appium-doctor`
5. Install Android Studio and SDK
6. Install Maven
7. Set environment variable (example)

- ANDROID_HOME=C:\Users\rajeevb\AppData\Local\Android\Sdk
- JAVA_HOME=C:\Program Files\Java\jdk1.8.0_144
- M2_HOME=D:\softwares\apache-maven-3.6.3
- PATH contains
    - %JAVA_HOME%\bin
    - %M2_HOME%\bin
    - %ANDROID_HOME%\tools
    - %ANDROID_HOME%\platform-tools

8. Run appium-doctor and verify setup is complete
9. Install TestNG plugin for eclipse

------------------
pre-test checkup
-----------------
1. Configure device settings (developer's option - do not use lock screen, USB debugging) 
2. check device is connected
2. Check ADB is working
3. check appium server is started

---------
Run
--------
- on GUI - right click xml and run as - TestNG suite
- on terminal - mvn test -Dsurefire.suiteXmlFiles=*.xml