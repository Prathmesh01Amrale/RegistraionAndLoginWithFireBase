RegistrationAndLoginWithFirebase
This is a Kotlin-based Android application that integrates Firebase Authentication and Realtime Database for user management.

Features:

Sign-Up Page
Users can create an account by providing:
Name
Email
Unique ID
Password
User details are securely stored in Firebase Realtime Database.
After successful registration, the user is redirected to the Sign-In page.
Sign-In Page
Users log in using their unique ID and password.
The app checks Firebase Realtime Database to verify the credentials.
If credentials are valid, the user is redirected to the Welcome Page.
Welcome Page
Displays personalized greetings using the user's name and email retrieved from the database.
Firebase Integration:

Firebase Authentication is used for secure login and account management.
Firebase Realtime Database stores user details and ensures seamless data retrieval during sign-in.
This project serves as a beginner-friendly template for Android apps that require user registration and login functionality.
