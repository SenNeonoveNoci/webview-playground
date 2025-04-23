# WebView Playground

A simple Android app for testing how web pages behave inside a `WebView`.

## 🧪 How to Use

To test a specific web page inside the app's `WebView`, follow these steps:

1. Open the file: 
```
app/src/main/java/com/senneonovenoci/webviewplayground/MainActivity.kt
```

2. Locate the following line in `onCreate`:
```kotlin
webView.loadUrl("https://www.example.com")
```

3.	Replace the URL with the one you’d like to test. For example:
```kotlin
webView.loadUrl("https://your-website.com")
```

4.	Build and run the app on your device or emulator.
