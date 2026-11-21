# Haunted Halifax

An Android app that shows famous haunted places around Halifax on an interactive map, providing users with information about each location.

## Overview

CityMap is developed using modern Android technologies and provides an interactive geographical interface for discovering locations of interest.

## Technologies
- Kotlin
- Jetpack Compose
- Mapbox
- Room Database

## Architecture

The application follows a layered MVVM architecture.

- **UI Layer:** Jetpack Compose screens and ViewModels.
- **Data Layer:** Repositories, Room database, DAOs, and entities.
- **Map Layer:** Mapbox integration and geographical markers.
## Features
- Interactive city map
- Location markers
- Location information and descriptions
- Local database integration
- Location filtering and searching
## Getting Started
1. Clone the repository.
2. Open the project in Android Studio.
3. Configure your local Mapbox access token in local.properties.
4. Sync Gradle.
5. Build and run the application.
## Development Workflow
- `main`: Stable application code.
- `develop`: Integration branch.
- `feature/*`: Individual feature development.
- `bugfix/*`: Bug fixes.

## To add a Feature
- Pull the latest `develop` branch
  - `git checkout develop`
  - `git pull origin develop`
- Create new branch called `feature/name-of-feature`
  - `git checkout -b feature/name-of-feature`
- Code, commit, push to your branch
  - `git add .`
  - `git commit -m "commit message here"`
  - `git push -u origin feature/name-of-feature`
- Open pull request to `develop`
  - on Github, create a PR from `feature/name-of-feature` into `develop`
  - describe what you changed and state what needs testing
- I'll review changes before you merge
  - check the code, test it, and either approve it or ask you to change something
  - once approved and all tests pass, merge the PR

All changes must be submitted through pull requests and reviewed before merging.

### Commit message convention
`type of change: description of change`

**For example:**
- `feat: add Mapbox integration`
- `feat: implement location details screen`
- `fix: correct map marker positioning`
- `fix: resolve Room database query issue`
- `refactor: reorganize location repository`
- `docs: update README`
- `test: add location repository tests`

Keeping the convention should make it easier to go through commit history

## Contributors
Dev | Role
--- | ---:
Joey |	Project lead, repository owner
Matt B |	Design, UI, Navigation
Matt D |	Database lead
Alex |	Mapbox Integration
Safaa |	Testing & QA

