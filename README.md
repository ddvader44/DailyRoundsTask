# DailyRoundsTask
## Clone this repo
```
git clone https://github.com/ddvader44/DailyRoundsTask.git
```
## Tech stack & Open-source libraries
- [Kotlin](https://kotlinlang.org/) based
- Jetpack
  - ViewModel: Manages UI-related data holder and lifecycle aware. Allows data to survive configuration changes such as screen rotations.
  - Room: Constructs Database by providing an abstraction layer over SQLite to allow fluent database access.
- Architecture
  - MVVM Architecture (Model - View - ViewModel)
  - MVVM maintains a clear separation of UI (View), business logic (ViewModel), and data (Model), improving code maintainability and testability.
- [View Binding](https://developer.android.com/topic/libraries/view-binding): Allows you to more easily write code that interacts with views
