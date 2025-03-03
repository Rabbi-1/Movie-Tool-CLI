
# 🎬 TMDB CLI Tool

A simple command-line interface (CLI) tool that fetches and displays movie information from **The Movie Database (TMDB)** API. Easily view **popular, top-rated, upcoming, and now-playing** movies directly in your terminal.

## 🚀 Features
- Fetch **Popular**, **Top-Rated**, **Upcoming**, and **Now Playing** movies.
- Use command-line arguments to specify the type of movies to retrieve.
- Handles API failures and network issues gracefully.
- Simple and lightweight, runs directly from the terminal.


## ▶️ Usage
```sh
tmdb-app --type "playing"   # Now Playing Movies
tmdb-app --type "popular"   # Popular Movies
tmdb-app --type "top"       # Top Rated Movies
tmdb-app --type "upcoming"  # Upcoming Movies
```

## 📜 Example Output
```sh
$ tmdb-app --type "popular"
Fetching popular movies...

1. Oppenheimer (2023)
2. Dune: Part Two (2024)
3. Spider-Man: No Way Home (2021)
...
```

## 🛠 Error Handling
- If the API request fails, the tool will display an appropriate error message.
- Handles **invalid input** and **network errors** gracefully.
---