# Project:

The test is supposed to:
- Login to Gmail
- Compose an email with unique subject and body
- Label email as "Social"
- Send the email to the same account which was used to login (from and to addresses would be the same)
- Wait for the email to arrive in the Inbox
- Mark email as starred
- Open the received email
- Verify email came under proper Label i.e. "Social"
- Verify the subject and body of the received email
- Generate test execution report at the end

# Notes
- Update the test.properties file to replace dummy credentials before you run the tests.
- Please enable "Social" label for your gmail account using following steps:
	-Go to Settings of your gmail account
	-Click on "Labels" tab and click on "Show" for "Social" label under Categories
	-Click on "Inbox" tab and mark the checkbox for "Social" and "Primary" under Categories so that "Social" and "Primary" tabs appears on the main page of your gmail account

# Prerequisites:
- ChromeDriver, JDK 8+
- Any IDE

# Development Environment:
- Modify ChromeDriver's path on your system
- On any terminal, move to the project's root folder and execute the following command:
    - ./gradlew clean test
