# Disney/Star Plus Automation

Project dedicated to study Java/Selenium Web automation, using cucumber, Junit and Selenium. The main focus is so Regression tests on the new Disney+ Streaming service.

## Test Cases

**Test Case ID:** 1
**Test Scenario:** Login in Disney+ Page
**Test Steps:**
1. Click Login Button
2. Enter your email details in the login field and click in Continue
3. Enter your email details in the Password field
4. Click in Continue

**Prerequisites**: A registered Email and a password.
**Browser:** Chrome 
**Expected/Intended Results:** Check if the page changed for Profile pages

---

**Test Case ID:** 2
**Test Scenario:** Enter HomeScreen Disney+ Page
**Test Steps:**
1. Click in the first user Profiel
2. Wait for change to homescreen Page

**Prerequisites**: User is Logged with an account
**Browser:** Chrome 
**Expected/Intended Results:** The homepage is rendered and "Destaques Star" is show in the home screen.

---

**Test Case ID:** 3
**Test Scenario:** Search for an Rated 14y Movie (Rogger Rabbit)
**Test Steps:**
1. Click in the first user Profile
2. Wait for change to homescreen Page
3. Click in Seach Button
4. Enter the name "Rogger Rabbit" in search bar
5. Wait until the Movie appears

**Prerequisites**: User is Logged with an account
**Browser:** Chrome 
**Expected/Intended Results:** The Tittle card for "Uma Cilada para Roger Rabbit" must appears.

---

**Test Case ID:** 4
**Test Scenario:** Create a new User in Junior Mode
**Test Steps:**
1. Click in Edit button
2. Click in Create User button
3. Enter Password and click in Continue
4. Enter the name "Test Child" in profile bar
5. Select an avatar for the user
6. Click in Done

**Prerequisites**: User is Logged with an account
**Browser:** Chrome 
**Expected/Intended Results:** Check if the new Profile is listed in Profile lists.

---

**Test Case ID:** 5
**Test Scenario:** Verify if the Child Profile (Junior Mode) is correct
**Test Steps:**
1. Select the Child Profile
2. Click in Search Button
3. Enter a 14+ Movie in seach bar. eg: "Rogger Rabbit"
4. Wait until the message that movie is not found 
5. Enter a PG Free Movie in seach bar. eg: "Mickey Mouse"
6. Wait until the Movie appears

**Prerequisites**: User is Logged with an account
**Browser:** Chrome 
**Expected/Intended Results:** The Tittle card for "A Casa do Mickey Mouse" must appears.

---

**Test Case ID:** 6
**Test Scenario:** Edit user Profile
**Test Steps:**
1. Click in Edit
2. Select the Child Profile
3. Change the name to "Profile"
4. Change the toogle (in Junior Mode) to off 
5. Enter password and click in Continue
6. Click in Done

**Prerequisites**: User is Logged with an account
**Browser:** Chrome 
**Expected/Intended Results:** The Profile name is changed correct and must be with junior mode off.

---

**Test Case ID:** 7
**Test Scenario:** Verify if the Profile is in Adult Mode
**Test Steps:**
1. Click in the last Profile
2. Click in Search Button
3. Enter a 14+ Movie in seach bar. eg: "Rogger Rabbit"
4.  Wait until the Movie appears

**Prerequisites**: User is Logged with an account
**Browser:** Chrome 
**Expected/Intended Results:** The Tittle card for "Uma Cilada para Roger Rabbit" must appears.

---

**Test Case ID:** 8
**Test Scenario:** Delete Profile
**Test Steps:**
1. Click in Edit Button
2. Click in the last Profile
3. Click in delete user at the bottom of the screen
4.  Wait until the Profile Page appears

**Prerequisites**: User is Logged with an account
**Browser:** Chrome 
**Expected/Intended Results:** The Profile is deleted successful.


## License

[MIT](https://choosealicense.com/licenses/mit/)
