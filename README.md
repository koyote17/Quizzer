# Quizzer

A simple Android quiz app that offers multiple categories and tracks the user's score across quizzes. Choose a category, answer a series of questions, and view results at the end.

## Technologies
- Java
- Android SDK (AndroidX)
- XML
- Gradle
- Android Studio (project tested with Android Studio Otter)
- Optional: local JSON or Room for question storage

## Data flow
1. `MainActivity` displays categories and starts the quiz by sending an `Intent` extra `CATEGORY`.
2. `QuizActivity` receives the category, loads corresponding questions (from bundled resources, local database, or JSON), presents questions to the user and updates the score as answers are chosen.
3. After the quiz, a `ResultsActivity` (or equivalent screen) shows the final score and optionally persists results for later viewing.

## Run locally (Windows)
Prerequisites: JDK (11+), Android Studio, Android SDK, connected device or emulator.

1. Clone the repository:
   `git clone <repo-url>`
2. Open the project in Android Studio and let Gradle sync.
3. Build and run from Android Studio, or use Gradle from the project root:
   - Build: `.\gradlew assembleDebug`
   - Install on connected device: `.\gradlew installDebug`
4. Launch the app on an emulator or device.

## Configuration / Notes
- Ensure SDK and build-tools versions in `build.gradle` match your installed Android SDK.
- If questions are stored in a resource file (JSON / XML) or database, check the corresponding folder (`res/raw`, assets, or database helpers) to modify content.

## Screenshots

<div align="center">
  <table>
    <tr>
      <td><img src="https://github.com/user-attachments/assets/27165dee-6864-42d9-9595-e49625ae3ae6" width="250"></td>
      <td><img src="https://github.com/user-attachments/assets/5da16c0a-b1ea-490f-8fc2-fbc27e68de49" width="250"></td>
    </tr>
  </table>
</div>


